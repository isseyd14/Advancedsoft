import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class AdminDAO {

    private static final String URL = "jdbc:mysql://advancedsoftwareserver.mysql.database.azure.com:3306/bank?useSSL=false";
    private static final String USERNAME = "advancedsoftware";
    private static final String PASSWORD = "Welcome1!";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                // Handle the exception according to your application's needs
            }
        }
        return connection;
    }

}