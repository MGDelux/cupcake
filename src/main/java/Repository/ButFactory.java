package Repository;

import domain.Buttoms;

public interface ButFactory {
    Buttoms createButtom(String navn, Double pris);
}
