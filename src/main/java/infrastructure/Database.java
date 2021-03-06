package infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String URL = "jdbc:mysql://localhost/cupcake?serverTimezone=CET";
    private final String USER = "cupcake";
    private final String PASS = "pass";
    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
    public void closeConnection() throws SQLException{
        DriverManager.getConnection(URL, USER, PASS).close();
    }
}
