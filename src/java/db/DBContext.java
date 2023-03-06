
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost;databaseName=PCStore;user=sa;password=12345";
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
        return con;
    }
}
