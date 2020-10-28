package Repository;

import domain.Toppings;

public interface TopsRepo extends TopFactory {
    Iterable<Toppings> findAllTops() throws NoCupcake;
    Toppings findTop(int id) throws NoCupcake;
    Toppings createTop(String navn,double pris);
}
