package domain;

import Repository.LoginError;
import infrastructure.DBCupcake;
import infrastructure.DBUser;
import infrastructure.Database;

import java.sql.SQLException;

public class LoginFacade {
    Database db = new Database();

    public User login(String email, String password) throws LoginError, SQLException {
        return new DBUser(db).login(email, password);
    }

    public User createUser(String email, String password) throws LoginError, SQLException {
        if (new DBUser(db).checkMail(email)) {
            throw new LoginError("Email is already in use");
        } else {
            byte[] tempSalt = User.genereateSalt();
            User user = new User(0, email, "customer", tempSalt, User.calculateSecret(tempSalt, password));
            new DBUser(db).createUser(user);
            return user;
        }
    }

    public String deleteUser(String email) throws LoginError, SQLException {
        if (new DBUser(db).checkMail(email)) {

        } else {
            throw new LoginError("Email does not exist");
        }
        return email;
    }
    public Iterable<User> getAllUsers() throws LoginError, SQLException {
       return new DBUser(db).findAllUsers();
    }
}
