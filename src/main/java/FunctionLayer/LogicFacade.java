package FunctionLayer;

import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login( email, password );
    }

    public static User createUser( String email, String password ) throws LoginSampleException {
        byte[] tempSalt = User.genereateSalt();
        User user = new User(email, "customer", tempSalt, User.calculateSecret(tempSalt,password));
        UserMapper.createUser( user );
        return user;
    }

}