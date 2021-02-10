import javax.swing.*;

public class Datapanel extends JFrame {
    ShowData data = new ShowData();

    public void adds() throws ClassNotFoundException {
        setVisible(false);
        mainMenu scorechange = new mainMenu();
        scorechange.score = data.show(0); // Change display of the score
        setVisible(false);
    }
}