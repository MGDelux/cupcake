package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import FunctionLayer.UserRepo;
import PresentationLayer.UserExists;
import PresentationLayer.UserNotFound;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

/**
 * The purpose of UserMapper is to...
 *
 * @author kasper
 */
public class UserMapper implements UserRepo {

    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO kunde (email, role, salt,secret) VALUES (?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getRole());
            ps.setBytes(3, user.getSalt());
            ps.setBytes(4, user.getSecret());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM kunde " + "WHERE email=?";
            PreparedStatement ps = con.prepareStatement(SQL);
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
                } else throw new LoginSampleException("PASSWORD OR EMAIL INCORRECT ");
            } else {
                throw new LoginSampleException("ERR0R");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }

    private User loadUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("email"),
                rs.getString("role"),
                rs.getBytes("salt"),
                rs.getBytes("secret"));
    }

    public static boolean resetUser(String email) {
        try {
            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM kunde WHERE email = ?");
            ps.setString(1, email);
            ps.executeQuery();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User findUser(String email) throws NoSuchElementException {
        try {
            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement("select * from kunde WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return loadUser(rs);
            } else {
                throw new NoSuchElementException("ERROR");
            }

        } catch (SQLException throwables) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    @Override
    public Iterable<User> findAllUsers() {
        return null;
    }

    @Override
    public User createUser(String userName, byte[] salt, byte[] secret) throws UserExists {
        return null;
    }

    public static boolean checkMail(String email) {
        try {
            Connection conn = Connector.connection();
            PreparedStatement ps = conn.prepareStatement("select * from kunde WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}