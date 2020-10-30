package Repository.Cart;

import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:14
 **/
public interface CartRepo extends CartFactory {

    public Item_cart addToppingToFactory(String tops, String bots);

}
