package domain.Cart;

import domain.Bottoms.Bottoms;
import domain.Toppings.Toppings;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:10
 **/
public class Item_cart {
    int cartItem;
    Toppings toppings;
    Bottoms bottoms;
    double sum;

    public Item_cart(int cartItem, Toppings toppings, Bottoms bottoms, double sum) {
        this.cartItem = cartItem;
        this.toppings = toppings;
        this.bottoms = bottoms;
        this.sum = sum;
    }

    public int getCartItem() {
        return cartItem;
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

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Item_cart{" +
                "cartItem=" + cartItem +
                ", toppings=" + toppings +
                ", bottoms=" + bottoms +
                ", sum=" + sum +
                '}';
    }
}
