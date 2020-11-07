package infrastructure;

import Repository.User.LoginError;
import domain.User.User;

import java.sql.*;
import java.util.ArrayList;

public class DBUser {
    private final Database db;

    public DBUser(Database db) {
        this.db = db;
    }

    public boolean checkMail(String email) throws SQLException {
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
        }finally {
            db.closeConnection();
        }
    }

    public User login(String email, String password) throws LoginError, SQLException {
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
                double kredit = rs.getDouble("kredit");
                User user = new User(0, email, role, salt, secret, kredit);
                user.setId(id);
                if (user.isPasswordCorrect(password)) {
                    return user;
                } else throw new LoginError("PASSWORD OR EMAIL INCORRECT ");
            } else {
                throw new LoginError("big login error");
            }
        } catch (SQLException e) {
            throw new LoginError("Error: " + e);
        }finally {
            db.closeConnection();
        }
    }

    public void createUser(User user) throws LoginError, SQLException {
        try {
            Connection conn = db.connect();
            String SQL = "INSERT INTO kunde (email, role, salt,secret, kredit) VALUES (?, ?, ?,?,?)";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getRole());
            ps.setBytes(3, user.getSalt());
            ps.setBytes(4, user.getSecret());
            ps.setDouble(5, user.getKredit());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException ex) {
            throw new LoginError(ex.getMessage());
        }finally {
            db.closeConnection();
        }
    }

    public ArrayList<User> findAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        try (Connection conn = db.connect()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM kunde;", Statement.RETURN_GENERATED_KEYS);
            ResultSet get = ps.executeQuery();
            while (get.next()) {
                users.add(loadUser(get));

            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return users;
        }finally {
            db.closeConnection();
        }
    }


    private User loadUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("email"),
                rs.getString("role"),
                rs.getBytes("salt"),
                rs.getBytes("secret"),
                rs.getDouble("kredit"));
    }

    public void setKredit(int id, double kredit) throws SQLException {
        try {
            Connection conn = db.connect();
            String SQL = "UPDATE kunde SET kredit = (?) WHERE id = (?)";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, kredit);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throwables.printStackTrace();
        }finally {
            db.closeConnection();
        }
    }

    public void DeleteUser(String email) throws SQLException {
        try (Connection conn = db.connect()) {
            String SQL = "DELETE FROM kunde WHERE email = ?";
            var smt = conn.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
            smt.setString(1, email);
            smt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeConnection();
        }
    }


    public double getkredit(int id) throws SQLException {
        double kredit = 0;
        Connection conn = db.connect();
        PreparedStatement ps = conn.prepareStatement("select kredit from kunde WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
           kredit = rs.getDouble("kunde.kredit");
        }
        return kredit;
    }
}
