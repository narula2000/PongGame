class Ball {
    private int x_pos;
    private int y_pos;

    private int diameter;

    private int x_vel;

    private int y_vel;

    Ball() {
        x_vel = 4;
        y_vel = 4;
        diameter = 15;
        x_pos = PongFrame.WIDTH / 2;
        y_pos = PongFrame.HEIGHT / 2; // Put in the middle

    }

    void move() {
        x_pos += x_vel;
        y_pos += y_vel;
    }

    int getX_pos() {
        return x_pos;
    }

    void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    int getY_pos() {
        return y_pos;
    }

    void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }

    int getDiameter() {
        return diameter;
    }

    void revVelocityX() {
        x_vel = -x_vel;
    }

    void revVelocityY() {
        y_vel = -y_vel;
    }


}
