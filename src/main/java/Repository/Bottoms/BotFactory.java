package Repository.Bottoms;

import Repository.Cupcakes.NoCupcake;
import domain.Bottoms.Bottoms;

import java.sql.SQLException;

public interface BotFactory {
    Bottoms deleteBut(int id) throws NoCupcake, SQLException;
}
