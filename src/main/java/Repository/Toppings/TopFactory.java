package Repository.Toppings;

import Repository.Cupcakes.NoCupcake;
import domain.Toppings.Toppings;

import java.sql.SQLException;

public interface TopFactory {
    Toppings deleteTop(int id) throws NoCupcake, SQLException;
}
