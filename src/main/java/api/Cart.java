package api;

import Repository.Bottoms.BotRepo;
import Repository.Cupcakes.NoCupcake;
import Repository.Toppings.TopsRepo;
import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

import java.util.ArrayList;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:08
 **/
public class Cart {
    private final  ArrayList<Item_cart> CartItems = new ArrayList<>();
    private final TopsRepo topList;
    private final BotRepo butList;

    public Cart(TopsRepo topList, BotRepo butList) {
        this.topList = topList;
        this.butList = butList;
    }

    private void addCupCakeToCart(Item_cart itemcart) {
        CartItems.add(itemcart);
        System.out.println(CartItems);
    }

    public ArrayList<Item_cart> getCartItems() {
        return CartItems;
    }

    public void testAdd(String top, String bot) throws NoCupcake {
        int cart = CartItems.size();
        Toppings topping = topList.findTop(top);
        Bottoms bottom = butList.findBot(bot);
        Item_cart itemCart = new Item_cart(cart, topping, bottom);
        addCupCakeToCart(itemCart);

    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartItems=" + CartItems +
                '}';
    }
}
