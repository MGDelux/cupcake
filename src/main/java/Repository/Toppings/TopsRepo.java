package Repository.Toppings;

import Repository.Cupcakes.NoCupcake;
import domain.Toppings.Toppings;

import java.sql.SQLException;

public interface TopsRepo extends TopFactory {
    Iterable<Toppings> findAllTops() throws NoCupcake, SQLException;
    Toppings findTop(String id) throws NoCupcake, SQLException;
    Toppings findtopByiD(int id) throws NoCupcake, SQLException;
    Toppings createTop(String navn,double pris) throws SQLException, NoCupcake;
    Toppings findBotById(int id) throws NoCupcake, SQLException;
}
