/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import cityofaaron.model.CropData;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas Nicholes <nic16020@byui.edu>
 */
public class CropControlTest {
    
    public CropControlTest() {
    }

    /**
     * Test of calcEatenByRats method, of class CropControl.
     */
    @Test
    public void testCalcEatenByRats() {
        System.out.println("calcEatenByRats");
        System.out.println("Cannot provide correct expResult due to random number");
        CropData theRats = new CropData();
        theRats.setWheatInStore(200);
        theRats.setOffering(10);
        int expResult = 6;
        int result = CropControl.calcEatenByRats(theRats);
        assertEquals(expResult, result);
    }
    
}