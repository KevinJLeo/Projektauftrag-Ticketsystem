import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class Datenbank {
    private static final String URL = "jdbc:mysql://localhost:3306/Ticketsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    private Datenbank() { }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            } catch (ClassNotFoundException e) {
                System.err.println("JDBC Driver not found: " + e.getMessage());
                throw new SQLException("Unable to load JDBC driver.", e);
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close the connection: " + e.getMessage());
            }
        }
    }

    public static boolean authenticate(String benutzername, char[] passwort) {
        String sql = "SELECT passwort FROM users WHERE username = ?";

        try (Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, benutzername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHash = rs.getString("password");
                return BCrypt.checkpw(new String(passwort), storedHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            java.util.Arrays.fill(passwort, '\0');
        }

        return false;
    }
}
