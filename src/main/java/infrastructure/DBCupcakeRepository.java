package infrastructure;

import domain.*;

import java.sql.*;
import java.util.ArrayList;

public class DBCupcakeRepository implements TopsRepo,ButRepo  {
    private final Database db;

    public DBCupcakeRepository(Database db) {
        this.db = db;
    }

    @Override
    public Iterable<Toppings> findAllTops() throws NoCupcake {
        ArrayList<Toppings> toppings = new ArrayList<>();
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM toppings";
            var smt = conn.prepareStatement(SQL);
            ResultSet set = smt.getResultSet();
            smt.executeQuery();
            while (set.next()) {
                toppings.add(ParseTops(set));
            }
            return toppings;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }

    @Override
    public Iterable<Buttoms> findALlbuttoms() throws NoCupcake {
        ArrayList<Buttoms> buttoms = new ArrayList<>();
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM buttoms";
            var smt = conn.prepareStatement(SQL);
            ResultSet set = smt.getResultSet();
            smt.executeQuery();
            while (set.next()) {
                buttoms.add(ParseButs(set));
            }
            return buttoms;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }

    @Override
    public Toppings findTop(int id) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM toppings where id = ?";
            var smt = conn.prepareStatement(SQL);
            smt.setInt(1, id);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            if (set.next()) {
                return ParseTops(set);
            } else {
                throw new NoCupcake();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }

    @Override
    public Buttoms findBut(int id) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM buttoms where id = ?";
            var smt = conn.prepareStatement(SQL);
            smt.setInt(1, id);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            if (set.next()) {
                return ParseButs(set);
            } else {
                throw new NoCupcake();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }



    @Override
    public Buttoms CreateBut(String navn, double pris) {
        int newid;
        try (Connection conn = db.connect()) {
            String sql = "INSERT INTO buttoms (navn, pris) VALUES (?, ?)";
            var smt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            smt.setString(1, navn);
            smt.setDouble(2, pris);
            smt.executeUpdate();
            ResultSet set = smt.getGeneratedKeys();
            if (set.next()) {
                newid = set.getInt(1);
            } else {
                throw new RuntimeException("DB ERROR");
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL E ERROR");
        }
        try {
            return findBut(newid);
        } catch (NoCupcake noCupcake) {
            throw new RuntimeException("ARRG DB ERROR");
        }
    }

    private Toppings ParseTops(ResultSet set) throws SQLException { //update til kun en metode
        return new Toppings(
                set.getInt("toppings.id"),
                set.getString("toppings.navn"),
                set.getDouble("toppings.pris"));
    }

    private Buttoms ParseButs(ResultSet set) throws SQLException {  //update til kun en metode
        return new Buttoms(
                set.getInt("buttoms.id"),
                set.getString("buttoms.navn"),
                set.getDouble("buttoms.pris"));
    }

    @Override
    public Buttoms createButtom(String navn, Double pris) {
        return null;
    }

    @Override
    public Toppings createToppings(String navn, Double pris) {
        return null;
    }
    public void createUser(User user) throws LoginError {
        try {
            Connection conn = db.connect();
            String SQL = "INSERT INTO kunde (email, role, salt,secret) VALUES (?, ?, ?,?)";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getRole());
            ps.setBytes(3, user.getSalt());
            ps.setBytes(4, user.getSecret());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException ex) {
            throw new LoginError(ex.getMessage());
        }
    }
    public User login(String email, String password) throws LoginError {
        try {
            Connection conn = db.connect();
            String SQL = "SELECT * FROM kunde " + "WHERE email=?";
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                byte[] salt = rs.getBytes("salt");
                byte[] secret = rs.getBytes("secret");
                User user = new User(email, role, salt, secret);
                user.setId(id);
                if (user.isPasswordCorrect("password")) {
                    return user;
                } else throw new LoginError("PASSWORD OR EMAIL INCORRECT ");
            } else {
                throw new LoginError("login error");
            }
        } catch (SQLException ex) {
            throw new LoginError(ex.getMessage());
        }

    }
}
