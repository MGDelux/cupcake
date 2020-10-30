package Repository.Toppings;

import Repository.Cupcakes.NoCupcake;
import domain.Toppings.Toppings;

public interface TopFactory {
    Toppings createToppings(String navn, Double pris);
    Toppings deleteTop(int id) throws NoCupcake;
}
