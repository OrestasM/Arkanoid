/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid_vgtu;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PanelTest {
    
    @Test
    public void testRight() {
        System.out.println("Right test");
        Panel instance = new Panel(20, 20);
        instance.right();
        assertEquals((int)instance.getX(), 50);
    }

    @Test
    public void testLeft() {
        System.out.println("Left test");
        Panel instance = new Panel(20, 20);
        instance.left();
        assertEquals((int)instance.getX(), 0);
    }
}
