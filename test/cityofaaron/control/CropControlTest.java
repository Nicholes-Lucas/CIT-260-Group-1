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

    /**
     * Test of feedPeople method, of class CropControl.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople Test 1");
        int wheatToFeed = 100;
        CropData theFood = new CropData();
        theFood.setWheatInStore(3000);
        int expResult = 2900;
        int result = CropControl.feedPeople(wheatToFeed, theFood);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Test 2 - Invalid
        System.out.println("feedPeople Test 2");
        wheatToFeed = -5;       
        theFood.setWheatInStore(3000);
        expResult = -1;
        result = CropControl.feedPeople(wheatToFeed, theFood);
        assertEquals(expResult, result);
        
        //Test 3 - Invalid
        System.out.println("feedPeople Test 3");
        wheatToFeed = 3500;       
        theFood.setWheatInStore(3000);
        expResult = -1;
        result = CropControl.feedPeople(wheatToFeed, theFood);
        assertEquals(expResult, result);
        
        //Test 4 - Boundary
        System.out.println("feedPeople Test 4");
        wheatToFeed = 3000;       
        theFood.setWheatInStore(3000);
        expResult = 0;
        result = CropControl.feedPeople(wheatToFeed, theFood);
        assertEquals(expResult, result);
        
        //Test 5 - Boundary
        System.out.println("feedPeople Test 5");
        wheatToFeed = 0;       
        theFood.setWheatInStore(3000);
        expResult = 3000;
        result = CropControl.feedPeople(wheatToFeed, theFood);
        assertEquals(expResult, result);
    }
    
   
    
    
}