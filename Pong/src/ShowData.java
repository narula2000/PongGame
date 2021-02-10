import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowData {
    private String name;
    private int score = 0;
    private String namea;
    private List<Integer> wname = new ArrayList();

    public String show(int win) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:winners.db");
            name = "None"; // no data at the beginning
            namea = String.format("%s and %d", name, score);

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("SELECT player_name, score FROM winners ORDER BY score DESC");
            //choose the table where we store winner and rearrange it before taking out data

            ResultSet rs = statement.executeQuery("SELECT player_name, score FROM winners ORDER BY score DESC");
            //take out the set of data in descending order by score
                score = rs.getInt("score");
                wname.add(score);


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

        return String.valueOf(wname.get(win));
    }
}