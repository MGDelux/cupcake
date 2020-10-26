package domain;

public interface TopsRepo extends TopFactory {
    Iterable<Toppings> findAllTops() throws NoCupcake;
    Toppings findTop(int id) throws NoCupcake;
}
