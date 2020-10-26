package api;

import domain.*;

public class cupcake {
    private static String ver = "0.0";
    private final TopsRepo topList;
    private final ButRepo butList;

    public cupcake(TopsRepo topList, ButRepo butList) {
        this.topList = topList;
        this.butList = butList;
    }

    public static String getVer() {
        return ver;
    }

    public Toppings createToppingsList(String name, Double pris) {
        return topList.createToppings(name, pris);
    }

    public Buttoms createButtomsList(String name, double pris) {
        return butList.CreateBut(name, pris);
    }

    public Iterable<Toppings> findAllTop() throws NoCupcake {
        return topList.findAllTops();
    }

    public Iterable<Buttoms> findAllBut() throws NoCupcake {
        return butList.findALlbuttoms();
    }


}
