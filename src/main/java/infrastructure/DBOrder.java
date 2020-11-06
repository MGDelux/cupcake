package infrastructure;

import domain.Cart.Item_cart;
import domain.Order.CreateOrders;
import domain.Order.GetOrderContent;
import domain.Order.GetOrders;
import domain.User.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * CREATED BY mathi @ 03-11-2020 - 12:10
 **/
public class DBOrder {
    private final Database db;

    public DBOrder(Database db) {
        this.db = db;
    }

    public void createOrder(String orderId, User user, CreateOrders createOrders, double pris)  {

        System.out.println("CREATING ORDER: \n ID:" + orderId + " User: " + user.getId() + " Items: " + createOrders.getCart() + "\n pris: " + pris);
        opretOrder(orderId, user, pris);
        enterOrderContent(orderId, createOrders.getCart());
    }


    public void opretOrder(String orderId, User user, double pris) {
        try (Connection conn = db.connect()) {
            String SQLQ = "INSERT INTO Orders (orderId,UserId,OrderPrice) VALUES (?,?,?)";
            var smt = conn.prepareStatement(SQLQ);
            smt.setString(1, orderId);
            smt.setInt(2, user.getId());
            smt.setDouble(3, pris);
            smt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void enterOrderContent(String orderID, List<Item_cart> cartList) {
        try (Connection conn = db.connect()) {
            for (Item_cart c : cartList) {
                String SQLQ = "INSERT INTO ordercontent (OrderId,Top,Bottom,Cupcake) VALUES (?,?,?,?);";
                var smt = conn.prepareStatement(SQLQ);
                smt.setString(1, orderID);
                smt.setString(2, c.getToppings().getNavn());
                smt.setString(3, c.getBottoms().getNavn());
                smt.setInt(4, c.getCartItem());
                smt.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<String> getAllOrders() throws SQLException {
        ArrayList<String> users = new ArrayList<>();
        try (Connection conn = db.connect()) {
            String SQLQ = "SELECT orderId FROM orders;";
            var smt = conn.prepareStatement(SQLQ);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            while (set.next()) {
                users.add(set.getString("orders.Orderid"));
            }
        }
        return users;
    }

    public List<String> getuserOrdersId(int userId) throws SQLException {
        ArrayList<String> createOrders = new ArrayList<>();
        try (Connection conn = db.connect()) {
            String SQLQ = "SELECT * FROM orders WHERE UserId = ?;";
            var smt = conn.prepareStatement(SQLQ);
            smt.setInt(1, userId);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            while (set.next()) {
                createOrders.add(set.getString("Orders.OrderId"));
            }
        }
        return createOrders;
    }

    public ArrayList<GetOrderContent> getOrderContent(String orderId) {
        ArrayList<GetOrderContent> orders = new ArrayList<>();
        try (Connection conn = db.connect()) {
            String SQLQ = "SELECT * FROM orderContent WHERE OrderId = ?;";
            var smt = conn.prepareStatement(SQLQ);
            smt.setString(1, orderId);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            while (set.next()) {
                orders.add(GetOrderContent(set));
            }
            return orders;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public GetOrders getAllUserOrders() {
        try (Connection conn = db.connect()) {
            String SQLQ = "SELECT * FROM orders;";
            var smt = conn.prepareStatement(SQLQ);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            while (set.next()) {
                return (GetOrders(set));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void removeOrder(String orderId) {
        try (Connection conn = db.connect()) {
            String sql = "DELETE FROM orders WHERE OrderId = ?;";
            var smt = conn.prepareStatement(sql);
            smt.setString(1,orderId);
            smt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeOrderContent(String orderId) {
        try (Connection conn = db.connect()) {
            String sql = "DELETE FROM ordercontent WHERE OrderId = ?;";
            var smt = conn.prepareStatement(sql);
            smt.setString(1,orderId);
            smt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public GetOrders loadUserOrders(String orderId) {
        try (Connection conn = db.connect()) {
            String SQLQ = "SELECT * FROM orders WHERE OrderId = ?;";
            var smt = conn.prepareStatement(SQLQ);
            smt.setString(1, orderId);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            while (set.next()) {
                return (GetOrders(set));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private GetOrders GetOrders(ResultSet set) throws SQLException {
        return new GetOrders(
                set.getString("orders.OrderId"),
                set.getInt("orders.UserId"),
                set.getDouble("orders.OrderPrice"),
                set.getTimestamp("orders.OrderDate"));
    }

    private GetOrderContent GetOrderContent(ResultSet set) throws SQLException {
        return new GetOrderContent(
                set.getString("orderContent.Top"),
                set.getString("orderContent.Bottom"),
                set.getInt("orderContent.cupcake"));
    }


}




