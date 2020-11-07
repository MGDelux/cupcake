package api;

import Repository.Cupcakes.NoCupcake;
import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:08
 **/
public class Cart {
    private static int counter = 0;
    private final HashMap<Integer, Item_cart> itemCarts = new HashMap<>();
    private final Cupcake cupcake;
    private double sum;

    public Cart(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    public HashMap<Integer, Item_cart> getItemCarts() {
        return itemCarts;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public Item_cart getCartItem(int id) {
        return itemCarts.get(id);
    }

    public double getSum() {
        return sum;
    }

    public double deleteSum(Item_cart cart) {
        double pris = 0;
        Double top = cart.getToppings().getPris();
        Double bot = cart.getBottoms().getPris();
        pris = pris + top + bot;
        System.out.println("PRIS OF CUPCAKE TO BE DELETED " + pris);
        System.out.println("CURRENT TOTAL SUM: " + sum);
        sum = sum - pris;
        System.out.println("SUM IS NOW: " + sum + " (" + sum + "-" + pris + ")");
        return pris;

    }

    public void addItemIntoCart(String top, String bot) throws NoCupcake {
        counter++;
        Toppings topping = cupcake.getTopping(top);
        Bottoms bottom = cupcake.getButtom(bot);
        Item_cart itemCart = new Item_cart(topping, bottom);
        itemCarts.put(counter, itemCart);
        sum = calculateSum();
    }

    private double calculateSum() {
        double tempSum = 0;
        for (Map.Entry<Integer, Item_cart> entry : itemCarts.entrySet()) {
            tempSum = tempSum + entry.getValue().getToppings().getPris();
        }
        for (Map.Entry<Integer, Item_cart> entry : itemCarts.entrySet()) {
            tempSum = tempSum + entry.getValue().getBottoms().getPris();
        }
        System.out.print(">" + sum);
        return tempSum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartItems=" + itemCarts +
                '}';
    }
}
