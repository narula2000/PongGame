import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * This is the content pane of my JFrame.
 */
class PongPanel extends JPanel implements ActionListener, KeyListener {
    private Ball b;
    private Paddle paddle;
    private boolean[] ARROWkeys;
    private int RIGHT_UP = 0;
    private int RIGHT_DOWN = 1;
    private int RIGHT_RIGHT = 2;
    private int RIGHT_LEFT = 3;
    public int Life = 3;
    private int timeCounter = 0;
    public int Point = 0;
    /**
     * Instantiates a new Pong panel.
     */
    PongPanel() {
        setBackground(Color.BLACK);
        b = new Ball();
        paddle = new Paddle("right");
        addKeyListener(this);
        setFocusable(true);
        int DELAY = 10;
        Timer timer = new Timer(DELAY, this);// Declare the time per tick in the game.
        timer.start();
        setDoubleBuffered(true);
        ARROWkeys = new boolean[]{false, false, false, false};
    }

    /*
    Moving the code for moving paddles into actionPerformed make
    the paddle movement super smooth.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        b.move();
        checkCollision();
        if (ARROWkeys[RIGHT_DOWN]) paddle.moveDown();
        if (ARROWkeys[RIGHT_UP]) paddle.moveUp();
        if (ARROWkeys[RIGHT_LEFT]) paddle.movePadLeft();
        if (ARROWkeys[RIGHT_RIGHT]) paddle.movePadRight();
        repaint();
    }

    private void checkCollision() {
        if (b.getX_pos() <= (paddle.getWidth()) && b.getX_pos() >= paddle.getX_pos()) { // Left
            if (b.getX_pos() < paddle.getX_pos()) {
                b.setX_pos(PongFrame.WIDTH / 2);
                b.setY_pos(PongFrame.HEIGHT / 2);
                Life--;
            }
            checkPaddleFace();
        } else if (b.getX_pos() >= (PongFrame.WIDTH - paddle.getWidth()) - 25 && (b.getX_pos() <= paddle.getX_pos())) { // make it look better -25 (Right)
            if (b.getX_pos() > paddle.getX_pos()) {
                b.setX_pos(PongFrame.WIDTH / 2);
                b.setY_pos(PongFrame.HEIGHT / 2);
                Life--;
            }
            checkPaddleFace();

        } else if (b.getY_pos() <= (paddle.getWidth())) {
            b.revVelocityY();
        } else if (b.getY_pos() >= (PongFrame.HEIGHT - paddle.getWidth()) - 35) {// to make it look better -35
            b.revVelocityY();
        } else if(b.getX_pos() > PongFrame.WIDTH- paddle.getWidth() || b.getX_pos() < paddle.getWidth()){
            b.setX_pos(PongFrame.WIDTH / 2);
            b.setY_pos(PongFrame.HEIGHT / 2);
            Life--;
        }
    }

    private void checkPaddleFace() {
        if ((b.getY_pos() > paddle.getY_pos()) && (b.getY_pos() < (paddle.getY_pos() + paddle.getHeight()))){Point=Point+5;
            b.revVelocityX();}

        else {
            b.setX_pos(PongFrame.WIDTH / 2);
            b.setY_pos(PongFrame.HEIGHT / 2);
            Life--;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBall(g);
        drawPaddles(g);
        timeCounter ++;
        g.setFont(new Font("Hack",2,25));
        g.drawString("<3<3<3=={ - "+Life+" -}==<3<3<3",(PongFrame.WIDTH/2)-145,25); // Display Life
        g.drawString("Score=="+Point+"==",(PongFrame.WIDTH/2)-75,PongFrame.HEIGHT-50); // Display Point
        if (timeCounter%100 == 0){
            Point++;
        }
        if (Life==0)
        {
            try {
                setVisible(false);
                new SaveData().save("A",Point);
                new Datapanel().adds();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawPaddles(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(paddle.getX_pos(), paddle.getY_pos(), paddle.getWidth(), paddle.getHeight());
        Toolkit.getDefaultToolkit().sync(); // Smooth the ball and the paddles
    }

    private void drawBall(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(b.getX_pos(), b.getY_pos(), b.getDiameter(), b.getDiameter());
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        /*
        Controls for paddle.
         */
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ARROWkeys[RIGHT_UP] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ARROWkeys[RIGHT_DOWN] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ARROWkeys[RIGHT_LEFT] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ARROWkeys[RIGHT_RIGHT] = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ARROWkeys[RIGHT_UP] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ARROWkeys[RIGHT_DOWN] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            ARROWkeys[RIGHT_LEFT] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            ARROWkeys[RIGHT_RIGHT] = false;
        }
    }
}

