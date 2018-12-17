package arkanoid_vgtu;

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Figure {

    private double directionX, directionY;
    private boolean game;

    public Ball(double x, double y, double directionX, double directionY) {
        this.x = x;
        this.y = y;
        this.directionX = directionX;
        this.directionY = directionY;
    }

    public void moveBall(int panelX, int panelY) {
        if ((x >= panelX - 10 && x <= panelX + 100) && y + 15 == panelY) {
            if (Math.random() > 0.50) {
                directionX = directionX * -1;
            }
            directionY = directionY * -1;
        }

        if (directionY > 0) {
            if (directionX < 0 && x - 1 <= 0) {
                directionX = 1;
            }

            if (directionX > 0 && x + 1 >= 465) {
                directionX = -1;
            }

        }

        if (directionY < 0) {
            if (x - 1 <= 0) {
                directionX = 1;
            }

            if (x + 1 >= 465) {
                directionX = -1;
            }

            if (y - 1 <= 0) {
                directionY = directionY * -1;
            }
        }

        x += directionX;
        y += directionY;

    }

    public void changeDirectionX() {
        directionX *= -1;
    }

    public void changeDirectionY() {
        directionY *= -1;
    }
    
    public double getDirectionX() {
        return directionX;
    }

    public double getDirectionY() {
        return directionY;
    }

    public boolean returnGame() {
        if (y > 500) {
            game = false;
        } else {
            game = true;
        }
        return game;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) x, (int) y, 20, 20);
    }
}
