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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CREATED BY mathi @ 03-11-2020 - 12:10
 **/
public class DBOrder {
    private final Database db;

    public DBOrder(Database db) {
        this.db = db;
    }

    public void createOrder(String orderId, User user, CreateOrders createOrders, double pris) throws SQLException {
        System.out.println("CREATING ORDER: \n ID:" + orderId + " User: " + user.getId() + " Items: " + createOrders.getCart() + "\n pris: " + pris);
        opretOrder(orderId, user, pris);
        enterOrderContent(orderId, createOrders.getCart());
    }


    public void opretOrder(String orderId, User user, double pris) throws SQLException {
        try (Connection conn = db.connect()) {
            String SQLQ = "INSERT INTO orders (orderId,UserId,OrderPrice) VALUES (?,?,?)";
            var smt = conn.prepareStatement(SQLQ);
            smt.setString(1, orderId);
            smt.setInt(2, user.getId());
            smt.setDouble(3, pris);
            smt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeConnection();
        }
    }

    public void enterOrderContent(String orderID, Map<Integer,Item_cart> cartList) throws SQLException {
        try (Connection conn = db.connect()) {
            for (Map.Entry<Integer, Item_cart> entry: cartList.entrySet()) {
                String SQLQ = "INSERT INTO orderContent (OrderId,Top,Bottom,Cupcake) VALUES (?,?,?,?);";
                var smt = conn.prepareStatement(SQLQ);
                smt.setString(1, orderID);
                smt.setString(2, entry.getValue().getToppings().getNavn());
                smt.setString(3, entry.getValue().getBottoms().getNavn());
                smt.setInt(4, entry.getValue().getCartItem());
                smt.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            db.closeConnection();
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
        finally {
            db.closeConnection();
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
        finally {
            db.closeConnection();
        }
        return createOrders;
    }

    public ArrayList<GetOrderContent> getOrderContent(String orderId) throws SQLException {
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
        finally {
            db.closeConnection();
        }
        return null;
    }

    public GetOrders getAllUserOrders() throws SQLException {
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
        finally {
            db.closeConnection();
        }
        return null;
    }

    public void removeOrder(String orderId) throws SQLException {
        try (Connection conn = db.connect()) {
            String sql = "DELETE FROM orders WHERE OrderId = ?;";
            var smt = conn.prepareStatement(sql);
            smt.setString(1,orderId);
            smt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            db.closeConnection();
        }
    }

    public void removeOrderContent(String orderId) throws SQLException {
        try (Connection conn = db.connect()) {
            String sql = "DELETE FROM orderContent WHERE OrderId = ?;";
            var smt = conn.prepareStatement(sql);
            smt.setString(1,orderId);
            smt.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            db.closeConnection();
        }
    }


    public GetOrders loadUserOrders(String orderId) throws SQLException {
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
        }finally {
            db.closeConnection();
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




