package api;

import Repository.Cart.CartRepo;
/**
 * CREATED BY mathi @ 30-10-2020 - 09:08
 **/
public class Cart {
    private final CartRepo shopCart;

    public Cart(CartRepo shopCart) {
        this.shopCart = shopCart;
    }

public AddItemToCart(String topping, String Buttom){
        return shopCart.addToppingToFactory(topping, Buttom);
}
}
