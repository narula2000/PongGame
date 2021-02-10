import javax.swing.*;
import java.util.zip.Deflater;

/**
 * The type Pong frame.
 */
class PongFrame {
    /**
     * The Height.
     */
    static final int HEIGHT = 600;
    /**
     * The Width.
     */
    static final int WIDTH = 800;

    public PongFrame() {
        JFrame frame = new JFrame("Pong");
        frame.setSize(WIDTH, HEIGHT);
        PongPanel panel = new PongPanel();
        frame.add(panel);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        if (panel.Life == 0) frame.setVisible(false);
    }
}

