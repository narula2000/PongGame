import javax.swing.*;
import java.awt.*;

/**
 * The type Background ball.
 */
class backgroundBall extends JPanel {
    /**
     * The Width.
     */
// Box height and width
    int width;
    ShowData showData = new ShowData();
    /**
     * The Height.
     */
    int height;

    /**
     * The Radius.
     */
// Ball Size
    float radius = 10;
    /**
     * The Diameter.
     */
    float diameter = radius * 2;// Diameter of the first ball

    /**
     * The X.
     */
// Center of Call
    float X = radius + 50;// x starting Position of the first ball
    /**
     * The Y.
     */
    float Y = radius + 20;// y starting position of the first ball

    /**
     * The Dx.
     */
// Direction
    float dx = 9; // speed of the first ball in x direction
    /**
     * The Dy.
     */
    float dy = 7; // speed of the first ball in y direction
    /**
     * The Widthh.
     */
    int widthh;
    /**
     * The Heightt.
     */
    int heightt;

    /**
     * The Radiuss.
     */
// Ball Size
    float radiuss = 10;
    /**
     * The Diameterr.
     */
    float diameterr = radiuss * 2;

    /**
     * The Xx.
     */
// Center of Call
    float Xx = radiuss + 50;// x starting Position of the second ball
    /**
     * The Yy.
     */
    float Yy = radiuss + 20;// y starting Position of the second ball

    /**
     * The Dxx.
     */
// Direction
    float dxx = 11; // speed of the first ball in x direction
    float dxxx = 20;
    /**
     * The Dyy.
     */
    float dyy = 9;
    float dyyy = 15;
    /**
     * Instantiates a new Background ball.
     */
    public backgroundBall() {


        Thread thread = new Thread(() -> {
            while (true) {

                width = getWidth();
                height = getHeight();

                X = X + dx;
                Y = Y + dy;
                if (X - radius < 0) {
                    dx = -dx;
                    X = radius;
                } else if (X + radius > width) {
                    dx = -dx;
                    X = width - radius;
                }

                if (Y - radius < 0) {
                    dy = -dy;
                    Y = radius;
                } else if (Y + radius > height) {
                    dy = -dy;
                    Y = height - radius;
                }
                repaint();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException ignored) {
                }

            }
        });
        Thread thread1 = new Thread(() -> {
            while (true) {

                widthh = getWidth();
                heightt = getHeight();

                Xx = Xx - dxx;
                Yy = Yy - dyy;
                if (Xx - radiuss < 0) {
                    dxx = -dxx;
                    Xx = radiuss;
                } else if (Xx + radiuss > widthh) {
                    dxx = -dxx;
                    Xx = width - radiuss;
                }

                if (Yy - radiuss < 0) {
                    dyy = -dyy;
                    Yy = radiuss;
                } else if (Yy + radiuss > height) {
                    dyy = -dyy;
                    Yy = height - radiuss;
                }
                repaint();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException ignored) {
                }

            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {

                widthh = getWidth();
                heightt = getHeight();

                Xx = Xx - dxxx * 2;
                Yy = Yy - dyy * 2;
                if (Xx - radiuss < 0) {
                    dxx = -dxx;
                    Xx = radiuss;
                } else if (Xx + radiuss > widthh) {
                    dxx = -dxx;
                    Xx = width - radiuss;
                }

                if (Yy - radiuss < 0) {
                    dyy = -dyy;
                    Yy = radiuss;
                } else if (Yy + radiuss > height) {
                    dyy = -dyy;
                    Yy = height - radiuss;
                }
                repaint();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException ignored) {
                }

            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {

                widthh = getWidth();
                heightt = getHeight();

                Xx = Xx + dxx * 2;
                Yy = Yy + dyyy * 2;
                if (Xx - radiuss < 0) {
                    dxx = -dxx;
                    Xx = radiuss;
                } else if (Xx + radiuss > widthh) {
                    dxx = -dxx;
                    Xx = width - radiuss;
                }

                if (Yy - radiuss < 0) {
                    dyy = -dyy;
                    Yy = radiuss;
                } else if (Yy + radiuss > height) {
                    dyy = -dyy;
                    Yy = height - radiuss;
                }
                repaint();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException ignored) {
                }

            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval((int) (X - radius), (int) (Y - radius), (int) diameter * 3, (int) diameter * 3);
        g.setColor(Color.GREEN);
        g.fillOval((int) (X), (int) (Y ), (int) diameterr * 2, (int) diameterr * 2);
        g.setColor(Color.CYAN);
        g.fillOval((int) (X - radius+80), (int) (Y - radius-200), (int) diameter*4, (int) diameter*4);
        g.setColor(Color.RED);
        g.fillOval((int) (X - radius-75), (int) (Y - radius+150), (int) diameter*5, (int) diameter*5);
        g.setFont(new Font("Hack",2,25));
        try {
            g.drawString("HighScore--!!! "+showData.show(0)+" !!!!",(PongFrame.WIDTH/2)-100,PongFrame.HEIGHT-50);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Toolkit.getDefaultToolkit().sync();
    }
}
