package api;

import FunctionLayer.LoginSampleException;
import FunctionLayer.UserRepo;
import PresentationLayer.UserNotFound;

public class Cupcake {
    private final UserRepo users;

    public Cupcake(UserRepo users) {
        this.users = users;
    }
public boolean checkMail(String email){
            try {
                users.findUser(email);
                return true;
            }catch (UserNotFound e ){
                return false;
            }
}
}
