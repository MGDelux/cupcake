package Repository.Item_cart;

import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;

/**
 * CREATED BY mathi @ 04-11-2020 - 15:05
 **/
public interface CartRepo  extends CartFactory{
    Iterable<Item_cart> findAllCart();
}
