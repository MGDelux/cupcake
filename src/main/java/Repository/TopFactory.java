package Repository;

import domain.Toppings;

public interface TopFactory {
    Toppings createToppings(String navn, Double pris);
}
