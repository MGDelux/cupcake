package Repository.Bottoms;

import Repository.Cupcakes.NoCupcake;
import domain.Bottoms.Bottoms;

import java.sql.SQLException;

public interface BotRepo extends BotFactory {
    Iterable<Bottoms> findALlbuttoms() throws NoCupcake, SQLException;
    Bottoms findBut(int id) throws NoCupcake, SQLException;
    Bottoms findBot(String navn) throws NoCupcake, SQLException;
    Bottoms CreateBut(String navn, double pris) throws SQLException;

}
