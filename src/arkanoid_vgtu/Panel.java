package arkanoid_vgtu;

import java.awt.Color;
import java.awt.Graphics;

public class Panel extends Figure {

    private int panelWidth = 100;
    private int panelHeight = 10;
    private int rightBorder = 390;
    private int leftBorder = 0;
    private int step = 30;

    public Panel(int x, int panelY) {
        this.x = x;
        this.y = panelY;
    }

    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, panelWidth, panelHeight);
    }

    public void right() {
        if (x + step <= rightBorder) {
            x += step;
        } else {
            x = rightBorder;
        }
    }

    public void left() {
        if (x - step >= leftBorder) {
            x -= step;
        } else {
            x = leftBorder;
        }
    }
}
