package domain.Order;

import domain.Cart.Item_cart;
import domain.User.User;

import java.util.List;

/**
 * CREATED BY mathi @ 04-11-2020 - 18:21
 **/
public class CreateOrders {
    String orderId;
    List<Item_cart> cart;

    public CreateOrders(String orderId, List<Item_cart> cart) {
        this.orderId = orderId;
        this.cart = cart;
    }
    public List<Item_cart> getCart() {
        return cart;
    }

    public void setCart(List<Item_cart> cart) {
        this.cart = cart;
    }
}
