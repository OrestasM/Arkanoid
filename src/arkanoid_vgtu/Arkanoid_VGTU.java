package arkanoid_vgtu;

import java.awt.Color;
import javax.swing.JFrame;

public class Arkanoid_VGTU {

    public static int height = 500;
    public static int width = 500;

    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Gameboard gameboard = new Gameboard();

        obj.setSize(height, width);
        obj.setTitle("ARKANOID");
        obj.setResizable(false);
        obj.setFocusable(true);
        obj.addKeyListener(gameboard);
        obj.add(gameboard);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.setVisible(true);
    }
}
