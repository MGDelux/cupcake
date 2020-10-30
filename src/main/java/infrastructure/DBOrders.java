package infrastructure;

import Repository.Cart.CartRepo;
import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

import javax.xml.crypto.Data;

/**
 * CREATED BY mathi @ 29-10-2020 - 14:23
 **/
public class DBOrders implements CartRepo {
    private final Database db;

    public DBOrders(Database db) {
        this.db = db;
    }

    @Override
    public Item_cart GetShoppingCarts(Toppings top, Bottoms bot) {
        return null;
    }
}
