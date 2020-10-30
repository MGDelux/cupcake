package Repository.Cupcakes;

public class NoCupcake extends Exception {
    public NoCupcake(String cupcake) {
        super("Cupcake error " + cupcake);
    }
}
