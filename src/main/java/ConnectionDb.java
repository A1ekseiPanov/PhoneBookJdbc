import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDb {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";


    public static Connection getNewConnection() throws SQLException {
         return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}

