package infrastructure;

import domain.Cart.Item_cart;
import domain.User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * CREATED BY mathi @ 03-11-2020 - 12:10
 **/
public class DBOrder {
    private final Database db;

    public DBOrder(Database db) {
        this.db = db;
    }

    public void createOrder(int orderId, User user, List<Item_cart> cart, double pris) throws SQLException {
        System.out.println("CREATING ORDER: \n ID:" + orderId + " User: " + user.getId() + " Items: " + cart + "\n pris: " + pris);
        opretOrder(orderId,user, pris);
        orderContent(user, cart);
    }

    public void opretOrder(int orderId,User user, double pris) {
        try (Connection conn = db.connect()) {
            String SQLQ = "INSERT INTO orders (orderId,UserId,OrderPrice) VALUES (?,?,?)";
            var smt = conn.prepareStatement(SQLQ);
            smt.setInt(1,orderId);
            smt.setInt(2, user.getId());
            smt.setDouble(3, pris);
            smt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void orderContent( User user, List<Item_cart> cartList) throws SQLException {
        try (Connection conn = db.connect()) {
            for (Item_cart c : cartList) {
                String SQLQ = "INSERT INTO ordercontent (userId,Top,Bottom,Quantity) VALUES (?,?,?,?)";
                var smt = conn.prepareStatement(SQLQ);
                smt.setInt(1,user.getId());
                smt.setInt(2,c.getToppings().getId());
                smt.setInt(3,c.getBottoms().getId());
                smt.setInt(4,c.getCartItem());
                smt.executeUpdate();
            }
        }

    }
}

