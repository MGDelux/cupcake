package Repository;

import domain.Buttoms;
import domain.Toppings;

public interface ButRepo extends ButFactory{
    Iterable<Buttoms> findALlbuttoms() throws NoCupcake;
    Buttoms findBut(int id) throws NoCupcake;
    Buttoms CreateBut(String navn, double pris);

}
