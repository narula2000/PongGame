import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type Main menu.
 */
public class mainMenu extends JFrame implements ActionListener {
    public String score;

    /**
     * Instantiates a new Main menu.
     */
    mainMenu() {
        backgroundBall bg = new backgroundBall();
        bg.setLayout(null);
        bg.setBackground(Color.BLACK);
        JButton b1 = new JButton("START");
        b1.setBounds(320, 250, 150, 100);
        bg.add(b1);
        add(bg);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(this);
        setVisible(true);
        setResizable(false);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        new mainMenu();
    }

    public void actionPerformed(ActionEvent event) {
        new PongFrame();
        setVisible(false);
    }
}
