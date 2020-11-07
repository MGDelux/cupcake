package api;

import Repository.Bottoms.BotRepo;
import Repository.Cupcakes.NoCupcake;
import Repository.Toppings.TopsRepo;
import domain.Bottoms.Bottoms;
import domain.Toppings.Toppings;

import java.sql.SQLException;

public class Cupcake {
    private static String ver = "0.0";
    private final TopsRepo topList;
    private final BotRepo butList;

    public Cupcake(TopsRepo topList, BotRepo butList) {
        this.topList = topList;
        this.butList = butList;
    }

    public static String getVer() {
        return ver;
    }

    public Toppings createTopsList(String name, double pris) throws SQLException, NoCupcake {
        return topList.createTop(name, pris);
    }

    public Toppings removeTopping(int id) throws NoCupcake, SQLException {
        return topList.deleteTop(id);
    }
    public Bottoms removeButtom(int id) throws NoCupcake, SQLException {
        return butList.deleteBut(id);
    }

    public Bottoms createButtomsList(String name, double pris) throws SQLException {
        return butList.CreateBut(name, pris);
    }

    public Iterable<Toppings> findAllTop() throws NoCupcake, SQLException {
        return topList.findAllTops();
    }

    public Iterable<Bottoms> findAllBut() throws NoCupcake, SQLException {
        return butList.findALlbuttoms();
    }

    public Toppings getTopping(String navn) throws NoCupcake, SQLException {
        return topList.findTop(navn);
    }

    public Toppings getToppingById(int id) throws NoCupcake, SQLException {
        return topList.findtopByiD(id);
    }
    public Toppings getBottomById(int id) throws NoCupcake, SQLException {
        return topList.findBotById(id);
    }

    public Bottoms getButtom(String navn) throws NoCupcake, SQLException {
        return butList.findBot(navn);
    }

    @Override
    public String toString() {
        return "cupcake{" +
                "topList=" + topList +
                ", butList=" + butList +
                '}';
    }
}
