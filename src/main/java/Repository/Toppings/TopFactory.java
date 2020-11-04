package Repository.Toppings;

import Repository.Cupcakes.NoCupcake;
import domain.Toppings.Toppings;

public interface TopFactory {
    Toppings deleteTop(int id) throws NoCupcake;
}
