package api;

import Repository.Cupcakes.NoCupcake;
import domain.Bottoms.Bottoms;
import domain.Cart.Item_cart;
import domain.Toppings.Toppings;

import java.util.ArrayList;

/**
 * CREATED BY mathi @ 30-10-2020 - 09:08
 **/
public class Cart {
    private final ArrayList<Item_cart> itemCarts = new ArrayList<>();
    private final Cupcake cupcake;
    private double sum;
    private String orderID = "";

    public Cart(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    private void addCupCakeToCart(Item_cart itemcart) {
        itemCarts.add(itemcart); }

    public ArrayList<Item_cart> getItemCarts() {
        return itemCarts;
    }
    public Item_cart getCartItem (int id){
        return itemCarts.get(id);
    }
    public void ifCartItem(Item_cart c){
        if (itemCarts.contains(c)){
            itemCarts.remove(c);
        }
    }

    public double getSum() {
        return sum;
    }

    public double deleteSum(Item_cart xl) {
       double l = xl.getPris(xl);
        System.out.println("PRIS OF CUPCAKE TO BE DELETED "+ l);
        System.out.println("CURRENT TOTAL SUM: " + sum);
        sum = sum - l;
        System.out.println("SUM IS NOW: " +sum + " ("+sum+"-"+l+")");
       return l;

}

    public void addItemIntoCart(String top, String bot) throws NoCupcake {
        Toppings topping = cupcake.getTopping(top);
        Bottoms bottom = cupcake.getButtom(bot);
        Item_cart itemCart = new Item_cart(topping, bottom);
        addCupCakeToCart(itemCart);
        sum = calculateSum();
    }

    private double calculateSum() {
        double tempSum = 0;
        for (Item_cart cart : itemCarts) {
            tempSum = tempSum + cart.getToppings().getPris();
        }
        for (Item_cart cart : itemCarts) {
            tempSum = tempSum + cart.getBottoms().getPris();
        }
        System.out.print(">" + sum);
        return tempSum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "CartItems=" + itemCarts +
                '}';
    }
}
