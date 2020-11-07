package domain.Cart;

import domain.Bottoms.Bottoms;
import domain.Toppings.Toppings;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:10
 **/
public class Item_cart {
    private static int counter = 1;
    int cartItem;
    Toppings toppings;
    Bottoms bottoms;

    public Item_cart(Toppings toppings, Bottoms bottoms) {
        this.cartItem = counter++;
        this.toppings = toppings;
        this.bottoms = bottoms;
    }

    public int getCartItem() {
        return cartItem;
    }

    public static int getCounter() {
        return counter;
    }

    public void setCartItem(int cartItem) {
        this.cartItem = cartItem;
    }

    public Toppings getToppings() {
        return toppings;
    }

    public void setToppings(Toppings toppings) {
        this.toppings = toppings;
    }

    public Bottoms getBottoms() {
        return bottoms;
    }

    public void setBottoms(Bottoms bottoms) {
        this.bottoms = bottoms;
    }


    @Override
    public String toString() {
        return cartItem + " " + toppings + " " + bottoms;

    }

}
