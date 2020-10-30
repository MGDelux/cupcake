package Repository.Bottoms;

import Repository.Cupcakes.NoCupcake;
import domain.Bottoms.Bottoms;

public interface BotRepo extends BotFactory {
    Iterable<Bottoms> findALlbuttoms() throws NoCupcake;
    Bottoms findBut(int id) throws NoCupcake;
    Bottoms findBot(String navn) throws NoCupcake;
    Bottoms CreateBut(String navn, double pris);

}
