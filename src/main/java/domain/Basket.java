package domain;

import api.cupcake;

/**
 * CREATED BY mathi @ 29-10-2020 - 15:34
 **/
public class Basket {
    private String topping, bottom;
    private int antal;
    private double pris;

    public Basket(String topping, String bottom, int antal, double pris) {
        this.topping = topping;
        this.bottom = bottom;
        this.antal = antal;
        this.pris = getPris(antal, topping,bottom);
    }

    private static double getPris(int antal, String topping, String bottom) {
       return 1.0;
    }
}
