package Repository.Cart;

import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:14
 **/
public interface CartRepo extends CartFactory {

     Item_cart GetShoppingCarts(Toppings top, Bottoms bot);
    Toppings getTopping(String top);

}
