package Repository.Toppings;

import Repository.Cupcakes.NoCupcake;
import domain.Toppings.Toppings;

public interface TopsRepo extends TopFactory {
    Iterable<Toppings> findAllTops() throws NoCupcake;
    Toppings findTop(String id) throws NoCupcake;
    Toppings findtopByiD(int id) throws NoCupcake;
    Toppings createTop(String navn,double pris);
}
