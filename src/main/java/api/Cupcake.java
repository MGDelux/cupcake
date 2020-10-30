package api;

import Repository.Bottoms.BotRepo;
import Repository.Cupcakes.NoCupcake;
import Repository.Toppings.TopsRepo;
import domain.Bottoms.Bottoms;
import domain.Toppings.Toppings;

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

    public Toppings createTopsList(String name, double pris) {
        return topList.createTop(name, pris);
    }

    public Toppings removeTopping(int id) throws NoCupcake {
        return topList.deleteTop(id);
    }

    public Bottoms removeButtom(int id) throws NoCupcake {
        return butList.deleteBut(id);
    }

    public Bottoms createButtomsList(String name, double pris) {
        return butList.CreateBut(name, pris);
    }

    public Iterable<Toppings> findAllTop() throws NoCupcake {
        return topList.findAllTops();
    }

    public Iterable<Bottoms> findAllBut() throws NoCupcake {
        return butList.findALlbuttoms();
    }

    @Override
    public String toString() {
        return "cupcake{" +
                "topList=" + topList +
                ", butList=" + butList +
                '}';
    }
}
