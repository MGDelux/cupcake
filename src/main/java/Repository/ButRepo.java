package Repository;

import domain.Buttoms;

public interface ButRepo extends ButFactory{
    Iterable<Buttoms> findALlbuttoms() throws NoCupcake;
    Buttoms findBut(int id) throws NoCupcake;
    Buttoms CreateBut(String navn, double pris);

}
