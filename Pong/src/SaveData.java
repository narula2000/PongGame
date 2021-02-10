import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveData {

    public void save(String s, int score) throws ClassNotFoundException  //need the name of winners
    {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:winners.db"); //connect
            String name = s;
            String update = "INSERT INTO winners VALUES('"+ name +"','"+score+"')"; //statement is written in String
            //add data to database

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate(update); //use the String to execute

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
