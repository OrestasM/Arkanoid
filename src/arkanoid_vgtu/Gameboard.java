package arkanoid_vgtu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameboard extends JPanel implements KeyListener, ActionListener {

    private final Brick brick;
    private final Ball ball;
    private final Panel panel;
    private final Figure panelFigure;
    private final Figure ballFigure;
    private final int row = 4;
    private final int column = 5;
    private final int panelX = 200;
    private final int panelY = 425;
    private final int scoreToWin = 100;
    private final double ballX = 245;
    private final double ballY = 400;
    private final double directionX = -1;
    private final double directionY = -1;
    private int moves = 0;
    private final boolean won = false;
    private final Timer timer;
    private final int delay = 10;

    public Gameboard() {
        setFocusable(true);
        requestFocusInWindow();
        timer = new Timer(delay, this);
        timer.start();
        ball = new Ball(ballX, ballY, directionX, directionY);
        panel = new Panel(panelX, panelY);
        brick = new Brick(row, column, ball);
        panelFigure = panel;
        ballFigure = ball;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 500);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        if (ball.returnGame()) {

            panel.paint(g);
            ball.paint(g);
            brick.paint((Graphics2D) g);
            g.setColor(Color.white);
            g.drawString("Score: " + brick.getScore(), 0, 470);

            if (moves != 0) {
                ball.moveBall(panelX, panelY);
                brick.brickPahntom();
            }

        }
        if (!ball.returnGame() && !won) {
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 170, 250);
            g.drawString("Score: " + brick.getScore(), 170, 270);
        }
        if (brick.getScore() >= scoreToWin) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 500, 500);
            g.setColor(Color.RED);
            g.drawString("YOU WON!", 170, 250);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            panel.right();
            moves++;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            panel.left();
            moves++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (moves != 0) {
            ball.moveBall((int) panelFigure.getX(), (int) panelFigure.getY());
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
