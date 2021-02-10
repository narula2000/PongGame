import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createDatabase {

    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection("jdbc:sqlite:winners.db");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("DROP TABLE IF EXISTS winners");
            statement.executeUpdate("CREATE TABLE winners (player_name TEXT, score INTEGER )");
            //we can utilize this to reset the scoreboard
            statement.executeUpdate("INSERT INTO winners VALUES('A','"+0+"')"); // Reset score to 0
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }
        finally{
            try{
                if(connection != null)
                    connection.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
