package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/handle","postgres","root");
        }
        catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}


