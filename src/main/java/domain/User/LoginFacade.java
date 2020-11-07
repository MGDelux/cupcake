package domain.User;

import Repository.User.LoginError;
import infrastructure.DBUser;
import infrastructure.Database;

import java.sql.SQLException;

public class LoginFacade {
    Database db = new Database();

    public User login(String email, String password) throws LoginError, SQLException {
        return new DBUser(db).login(email, password);
    }

    public User createUser(String email, String password, String role, double kredit) throws LoginError, SQLException {
        if (new DBUser(db).checkMail(email)) {
            throw new LoginError("Email is already in use");
        } else {
            byte[] tempSalt = User.genereateSalt();
            User user = new User(0, email, role, tempSalt, User.calculateSecret(tempSalt, password), kredit);
            System.out.println(User.byteArrayToHex(user.getSalt()));
            System.out.println(User.byteArrayToHex(user.getSecret()));
            new DBUser(db).createUser(user);
            return user;
        }
    }

    public double getKredit(int id) throws SQLException {
        return new DBUser(db).getkredit(id);
    }

    public void addKredit(int id, double kredit) throws SQLException {
        new DBUser(db).setKredit(id, kredit);
    }

    public String deleteUser(String email) throws LoginError, SQLException {
        if (new DBUser(db).checkMail(email)) {
            new DBUser(db).DeleteUser(email);
        } else {
            throw new LoginError("Email does not exist");
        }
        return email;
    }

    public Iterable<User> getAllUsers() throws SQLException {
        return new DBUser(db).findAllUsers();
    }

    public void deletekredit(int id, double kredit) throws SQLException {
        double userKredit = getKredit(id);
        kredit = userKredit - kredit;
        new DBUser(db).setKredit(id, kredit);
    }
    public double refreshKredit(int id) throws SQLException {
       return new DBUser(db).getkredit(id);

    }
}
