package infrastructure;

import domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBCupcakeRepository implements TopsRepo,ButRepo {
    private final Database db;

    public DBCupcakeRepository(Database db) {
        this.db = db;
    }

    @Override
    public Iterable<Toppings> findAllTops() throws NoCupcake {
        ArrayList<Toppings> toppings = new ArrayList<>();
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM toppings";
            var smt = conn.prepareStatement(SQL);
            ResultSet set = smt.getResultSet();
            smt.executeQuery();
            while (set.next()) {
                toppings.add(ParseTops(set));
            }
            return toppings;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }

    @Override
    public Iterable<Buttoms> findALlbuttoms() throws NoCupcake {
        ArrayList<Buttoms> buttoms = new ArrayList<>();
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM buttoms";
            var smt = conn.prepareStatement(SQL);
            ResultSet set = smt.getResultSet();
            smt.executeQuery();
            while (set.next()) {
                buttoms.add(ParseButs(set));
            }
            return buttoms;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }

    @Override
    public Toppings findTop(int id) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM toppings where id = ?";
            var smt = conn.prepareStatement(SQL);
            smt.setInt(1, id);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            if (set.next()) {
                return ParseTops(set);
            } else {
                throw new NoCupcake();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }

    @Override
    public Buttoms findBut(int id) throws NoCupcake {
        try (Connection conn = db.connect()) {
            String SQL = "SELECT * FROM buttoms where id = ?";
            var smt = conn.prepareStatement(SQL);
            smt.setInt(1, id);
            smt.executeQuery();
            ResultSet set = smt.getResultSet();
            if (set.next()) {
                return ParseButs(set);
            } else {
                throw new NoCupcake();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new NoCupcake();
        }
    }



    @Override
    public Buttoms CreateBut(String navn, double pris) {
        int newid;
        try (Connection conn = db.connect()) {
            String sql = "INSERT INTO buttoms (navn, pris) VALUES (?, ?)";
            var smt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            smt.setString(1, navn);
            smt.setDouble(2, pris);
            smt.executeUpdate();
            ResultSet set = smt.getGeneratedKeys();
            if (set.next()) {
                newid = set.getInt(1);
            } else {
                throw new RuntimeException("DB ERROR");
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQL E ERROR");
        }
        try {
            return findBut(newid);
        } catch (NoCupcake noCupcake) {
            throw new RuntimeException("ARRG DB ERROR");
        }
    }

    private Toppings ParseTops(ResultSet set) throws SQLException { //update til kun en metode
        return new Toppings(
                set.getInt("toppings.id"),
                set.getString("toppings.navn"),
                set.getDouble("toppings.pris"));
    }

    private Buttoms ParseButs(ResultSet set) throws SQLException {  //update til kun en metode
        return new Buttoms(
                set.getInt("buttoms.id"),
                set.getString("buttoms.navn"),
                set.getDouble("buttoms.pris"));
    }

    @Override
    public Buttoms createButtom(String navn, Double pris) {
        return null;
    }

    @Override
    public Toppings createToppings(String navn, Double pris) {
        return null;
    }
}
