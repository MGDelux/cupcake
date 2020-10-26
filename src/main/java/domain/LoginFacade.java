package domain;

import com.mysql.cj.xdevapi.DbDocFactory;
import infrastructure.DBCupcakeRepository;
import infrastructure.Database;

public class LoginFacade {
    Database db = new Database();
    public  User login(String email, String password) throws LoginError {
        return new DBCupcakeRepository(db).login(email, password);
    }

    public User createUser( String email, String password ) throws LoginError {

        byte[] tempSalt = User.genereateSalt();
        User user = new User(email, "customer", tempSalt, User.calculateSecret(tempSalt,password));
        new DBCupcakeRepository(db).createUser(user);
        return user;
    }
}
