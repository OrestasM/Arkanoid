package arkanoid_vgtu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {

    private int width;
    private int height;
    private int bricks[][];
    private int rows;
    private int cols;
    private int score;
    private int brickCount;
    private int brickskWidth = 490;
    private int bricksHeight = 150;

    Ball ball;

    public Brick(int row, int col, Ball ball) {
        bricks = new int[row][col];
        this.rows = row;
        this.cols = col;
        this.ball = ball;
        this.score = 0;
        this.brickCount = row * col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                bricks[i][j] = 1;
            }
        }

        this.width = brickskWidth / col;
        this.height = bricksHeight / row;
    }

    public int getWidth() {
        return width;
    }

    public int getBrickskWidth() {
        return brickskWidth;
    }

    public void setBrickskWidth(int brickskWidth) {
        this.brickskWidth = brickskWidth;
    }

    public int getBricksHeight() {
        return bricksHeight;
    }

    public void setBricksHeight(int bricksHeight) {
        this.bricksHeight = bricksHeight;
    }

    public int getBrickCount() {
        return brickCount;
    }

    public void setBrickCount(int brickCount) {
        this.brickCount = brickCount;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getBricks() {
        return bricks;
    }

    public void hit(int i, int j) {
        bricks[i][j] = 0;
        setScore(getScore() + 5);
        setBrickCount(getBrickCount() - 1);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void paint(Graphics2D g) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if (bricks[i][j] > 0) {
                    g.setColor(Color.red);
                    g.fillRect((j - 1) * width + width, (i - 1) * height + height, width, height);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect((j - 1) * width + width, (i - 1) * height + height, width, height);
                }
            }
        }
    }

    public void brickPahntom() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (getBricks()[i][j] > 0) {

                    Rectangle brickPhantom = new Rectangle((j - 1) * getWidth() + getWidth(), (i - 1) * getHeight() + getHeight(), getWidth(), getHeight());
                    Rectangle ballPhantom = new Rectangle((int) ball.getX(), (int) ball.getY(), 20, 20);

                    if (brickPhantom.intersects(ballPhantom)) {
                        setBrickCount(getBrickCount());
                        hit(i, j);

                        if (ball.getX() + 20 <= brickPhantom.x || ball.getX() + 2 >= brickPhantom.x + brickPhantom.width) {
                            ball.changeDirectionX();
                        } else {
                            ball.changeDirectionY();
                        }

                        i = rows;
                        j = cols;
                    }
                }
            }
        }
    }

}
