/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoid_vgtu;

import org.junit.Test;
import static org.junit.Assert.*;

public class BrickTest {
    
    @Test
    public void testSetBrickskWidth() {
        System.out.println("Set bricks width test");
        Brick instance = new Brick(4, 5, null);
        int def = instance.getBrickskWidth();
        instance.setBrickskWidth(def+30);
        assertEquals(instance.getBrickskWidth(), def+30);
    } 
}
