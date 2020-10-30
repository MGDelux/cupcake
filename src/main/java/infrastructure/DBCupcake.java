package infrastructure;

import Repository.Bottoms.BotRepo;
import Repository.Cupcakes.NoCupcake;
import Repository.Toppings.TopsRepo;
import domain.Bottoms.Bottoms;
import domain.Toppings.Toppings;

import java.sql.*;
import java.util.ArrayList;

public class DBCupcake implements TopsRepo, BotRepo {
    private final Database db;

    public DBCupcake(Database db) {
        this.db = db;
    }

    @Override
    public Iterable<Toppings> findAllTops() throws NoCupcake {
        ArrayList<Toppings> toppings = new ArrayList<>();
        try (Connection conn = db.connect()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM toppings;");
            ResultSet get = ps.executeQuery();
            while (get.next()) {
                toppings.add(ParseTops(get));

            }
            return toppings;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return toppings;
        }
    }

    @Override
    public Iterable<Bottoms> findALlbuttoms() throws NoCupcake {
        ArrayList<Bottoms> buttoms = new ArrayList<>();
        try (Connection conn = db.connect()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM buttoms;");
            ResultSet get = ps.executeQuery();
            while (get.next()) {
                buttoms.add(ParseButs(get));

            }
            return buttoms;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return buttoms;
        }
    }

    @Override
    public Toppings findTop(String id) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM toppings where navn = ?";
            var smt = conn.prepareStatement(SQL);
            smt.setString(1, id);
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
    public Toppings findtopByiD(int id) throws NoCupcake {
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
    public Toppings createTop(String navn, double pris) {
        int topid;
        try (Connection conn = db.connect()) {
            String sql = "INSERT INTO toppings (navn, pris) VALUES (?, ?)";
            var smt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            smt.setString(1, navn);
            smt.setDouble(2, pris);
            smt.executeUpdate();
            ResultSet set = smt.getGeneratedKeys();
            if (set.next()) {
                topid = set.getInt(1);
            } else {
                throw new RuntimeException("DB ERROR");
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL E ERROR");
        }
        try {
            return findtopByiD(topid);
        } catch (NoCupcake noCupcake) {
            throw new RuntimeException("ARRG DB ERROR");
        }
    }

    @Override
    public Bottoms findBut(int id) throws NoCupcake {
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
    public Bottoms findBot(String navn) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM buttoms where navn = ?";
            var smt = conn.prepareStatement(SQL);
            smt.setString(1, navn);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            if (set.next()) {
                return ParseButs(set);
            } else {
                throw new NoCupcake();
            }
        } catch (SQLException | NoCupcake e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }

    public boolean checkMail(String email) {
        try {
            Connection conn = db.connect();
            PreparedStatement ps = conn.prepareStatement("select * from kunde WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }


    @Override
    public Bottoms CreateBut(String navn, double pris) {
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

    private Bottoms ParseButs(ResultSet set) throws SQLException {  //update til kun en metode
        return new Bottoms(
                set.getInt("buttoms.id"),
                set.getString("buttoms.navn"),
                set.getDouble("buttoms.pris"));
    }

    @Override
    public Bottoms createButtom(String navn, Double pris) {
        return null;
    }

    @Override
    public Bottoms deleteBut(int id) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "DELETE FROM buttoms WHERE id = ?";
            var smt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            smt.setInt(1, id);
            smt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return findBut(id);
    }


    @Override
    public Toppings deleteTop(int id) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "DELETE FROM toppings WHERE id = ?";
            var smt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            smt.setInt(1, id);
            smt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return findtopByiD(id);
    }

    @Override
    public Toppings createToppings(String navn, Double pris) {
        return null;
    }


}




