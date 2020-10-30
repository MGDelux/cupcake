package api;

import Repository.Bottoms.BotRepo;
import Repository.Cupcakes.NoCupcake;
import Repository.Toppings.TopsRepo;
import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:08
 **/
public class Cart {
    private final ArrayList<Item_cart> CartItems = new ArrayList<>();
    private final Cupcake cupcake;
    private double sum;
    private int orderID;

    public Cart(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    private void addCupCakeToCart(Item_cart itemcart) {
        CartItems.add(itemcart);
        System.out.println("> " + CartItems);
    }

    public ArrayList<Item_cart> getCartItems() {
        return CartItems;
    }

    public void testAdd(String top, String bot) throws NoCupcake {
        int cart = CartItems.size() + 1;
        Toppings topping = cupcake.getTopping(top);
        Bottoms bottom = cupcake.getButtom(bot);
        Item_cart itemCart = new Item_cart(cart, topping, bottom);
        addCupCakeToCart(itemCart);
        System.out.println("ID " + orderID);

    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartItems=" + CartItems +
                '}';
    }
}
