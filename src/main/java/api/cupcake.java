package api;

import Repository.ButRepo;
import Repository.NoCupcake;
import Repository.TopsRepo;
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

  public Toppings createTopsList(String name,double pris){
        return topList.createTop(name, pris);
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

    @Override
    public String toString() {
        return "cupcake{" +
                "topList=" + topList +
                ", butList=" + butList +
                '}';
    }
}
