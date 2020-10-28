package domain;

import infrastructure.DBCupcakeRepository;
import infrastructure.Database;

public class LoginFacade {
    Database db = new Database();

    public User login(String email, String password) throws LoginError {
        return new DBCupcakeRepository(db).login(email, password);
    }

    public User createUser(String email, String password) throws LoginError {
        if (new DBCupcakeRepository(db).checkMail(email)) {
            throw new LoginError("Email is already in use");
        } else {
            byte[] tempSalt = User.genereateSalt();
            User user = new User(0, email, "customer", tempSalt, User.calculateSecret(tempSalt, password));
            new DBCupcakeRepository(db).createUser(user);
            return user;
        }
    }

    public String deleteUser(String email) throws LoginError {
        if (new DBCupcakeRepository(db).checkMail(email)) {

        } else {
            throw new LoginError("Email does not exist");
        }
        return email;
    }
    public Iterable<User> getAllUsers() {
       return new DBCupcakeRepository(db).findAllUsers();
    }
}
