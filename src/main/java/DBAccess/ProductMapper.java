package DBAccess;
import domain.Buttoms;
import domain.Toppings;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static List<Toppings> getAllToppings() {
        List<Toppings> returnTops = new ArrayList<>();
        try {
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM toppings";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Toppings top = new Toppings(rs.getInt("id"), rs.getString("navn"), rs.getDouble("pris"));
               returnTops.add(top);
            }
            return returnTops;

        } catch (SQLException throwables) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
    public Buttoms getAllButtoms() {
        try {
            Connection conn = Connector.connection();
            String SQL = "SELECT * FROM buttoms";
            PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Buttoms(
                        rs.getInt("id"),
                        rs.getString("navn"),
                        rs.getDouble("pris"));
            }

        } catch (SQLException throwables) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return null;
    }
}
