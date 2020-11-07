package domain.Order;

import domain.Cart.Item_cart;
import domain.User.User;

import java.util.HashMap;
import java.util.List;

/**
 * CREATED BY mathi @ 04-11-2020 - 18:21
 **/
public class CreateOrders {
    String orderId;
    HashMap<Integer,Item_cart> cart = new HashMap<>();

    public String getOrderId() {
        return orderId;
    }

    public CreateOrders(String orderId, HashMap<Integer, Item_cart> cart) {
        this.orderId = orderId;
        this.cart = cart;
    }

    public HashMap<Integer, Item_cart> getCart() {
        return cart;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCart(HashMap<Integer, Item_cart> cart) {
        this.cart = cart;
    }
}
