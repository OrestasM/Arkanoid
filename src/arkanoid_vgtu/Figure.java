package arkanoid_vgtu;

import java.awt.Color;
import java.awt.Graphics;

public class Figure {

    protected double x, y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
   public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, 10, 10);
    }
}
