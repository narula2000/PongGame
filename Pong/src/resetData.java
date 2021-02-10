import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class resetData {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:winners.db");

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        statement.executeUpdate("DROP TABLE IF EXISTS winners");
        statement.executeUpdate("CREATE TABLE winners (player_name TEXT, score INTEGER )");
        //we can utilize this to reset the scoreboard
        statement.executeUpdate("INSERT INTO winners VALUES('A','"+0+"')");
    }
}
