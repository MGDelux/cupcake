package Repository.Item_cart;

import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;
import domain.User.User;
import web.widget.Navbar;

import java.util.List;

/**
 * CREATED BY mathi @ 04-11-2020 - 15:05
 **/
public interface CartFactory {
    void opretOrder(String orderId, User user, double pris);
    void enterOrderContent(String orderID, List<Item_cart> cartList);
}
