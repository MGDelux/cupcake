package FunctionLayer;

import PresentationLayer.UserNotFound;

public interface UserRepo extends UserFactory {
    User findUser(String name) throws UserNotFound;
    Iterable<User> findAllUsers();

}
