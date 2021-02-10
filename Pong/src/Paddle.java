class Paddle {
    private int height;
    private int width;
    private int x_pos;
    private int y_pos;
    private int vel;


    /*
    The string parameter will tell if it is the left paddle
     or the right one.
     */
    Paddle(String s) {
        vel = 10;
        height = 150;
        width = 10;
        y_pos = (PongFrame.HEIGHT / 2) - (height / 2); //Centers the paddle
        if (s.equals("right")) { // putt paddle on the right
            x_pos = PongFrame.WIDTH - 20;
        }
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

    int getX_pos() {
        return x_pos;
    }

    int getY_pos() {
        return y_pos;
    }

    void moveUp() {
        if (y_pos > 0)
            y_pos -= vel;
    }

    void moveDown() {
        if (y_pos < (PongFrame.HEIGHT - height))
            y_pos += vel;
    }

    void movePadLeft() {
        x_pos = 0;
        y_pos = (PongFrame.HEIGHT / 2) - (height / 2);
    }

    void movePadRight() {
        x_pos = PongFrame.WIDTH - width - 9;
        y_pos = (PongFrame.HEIGHT / 2) - (height / 2);
    }
}
