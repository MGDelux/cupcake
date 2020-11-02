package Repository.Cart;

import api.Cart;
import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:14
 **/
public interface CartFactory {
    Item_cart GetShoppingCarts(Toppings tops, Bottoms bots);
    Toppings getTopping(String top);
}
