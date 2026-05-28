import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java_backend",
                "root",
                "your_password"
            );
        } catch (Exception e) {
            System.out.println("DB Connection Error: " + e.getMessage());
        }

        return conn;
    }
}