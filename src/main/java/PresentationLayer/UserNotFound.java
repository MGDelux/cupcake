package PresentationLayer;

public class UserNotFound extends Exception {
 public UserNotFound(String name){super("User already exists: " + name);}
}
