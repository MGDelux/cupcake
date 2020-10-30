package Repository.Bottoms;

import Repository.Cupcakes.NoCupcake;
import domain.Bottoms.Bottoms;

public interface BotFactory {
    Bottoms createButtom(String navn, Double pris);

    Bottoms deleteBut(int id) throws NoCupcake;
}
