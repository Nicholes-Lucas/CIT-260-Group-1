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
        System.out.println("calcEatenByRats #1");
        CropData theRats = new CropData();
        theRats.setWheatInStore(200);
        theRats.setOffering(10);
        int noRats = 0;
        int minExpResult = 6;
        int maxExpResult = 14;
        int result = CropControl.calcEatenByRats(theRats);
        if (result == noRats){
           assertEquals(0, result);
           System.out.println("  Randomized # >= 30; No wheat eaten");
        }
        else {
           assertTrue(minExpResult <= result && result <= maxExpResult);
        }
        
        System.out.println("calcEatenByRats 2");
        theRats.setWheatInStore(200);
        theRats.setOffering(-5);
        noRats = 0;
        int expResult = -1;
        result = CropControl.calcEatenByRats(theRats);
        if (result == noRats){
           assertEquals(0, result);
           System.out.println("  Randomized # >= 30; No wheat eaten");
        }
        else {
           assertEquals(expResult, result);
        } 
        
        System.out.println("calcEatenByRats 3");
        theRats.setWheatInStore(-1);
        theRats.setOffering(14);
        noRats = 0;
        expResult = -1;
        result = CropControl.calcEatenByRats(theRats);
        if (result == noRats){
           assertEquals(0, result);
           System.out.println("  Randomized # >= 30; No wheat eaten");
        }
        else {
           assertEquals(expResult, result);
        }
        
        System.out.println("calcEatenByRats #4");
        theRats.setWheatInStore(200);
        theRats.setOffering(100);
        noRats = 0;
        minExpResult = 6;
        maxExpResult = 10;
        result = CropControl.calcEatenByRats(theRats);
        if (result == noRats){
           assertEquals(0, result);
           System.out.println("  Randomized # >= 30; No wheat eaten");
        }
        else {
           assertTrue(minExpResult <= result && result <= maxExpResult);
        }
        
        System.out.println("calcEatenByRats #5");
        theRats.setWheatInStore(200);
        theRats.setOffering(0);
        noRats = 0;
        minExpResult = 12;
        maxExpResult = 20;
        result = CropControl.calcEatenByRats(theRats);
        if (result == noRats){
           assertEquals(0, result);
           System.out.println("  Randomized # >= 30; No wheat eaten");
        }
        else {
           assertTrue(minExpResult <= result && result <= maxExpResult);
        }
    } 

    /**
     * Test of feedPeople method, of class CropControl.
     */
    @Test
    public void testFeedPeople() {
        System.out.println("feedPeople");
        int wheatToFeed = 100;
        CropData theFood = new CropData();
        theFood.setWheatInStore(3000);
        int expResult = 2900;
        int result = CropControl.feedPeople(wheatToFeed, theFood);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of plantCrops method, of class CropControl.
     */
    @Test
    public void testPlantCrops() {
        System.out.println("testPlantCrops #1");
        CropData toPlant = new CropData();
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        int acresToPlant = 12;
        int expResult = 24;
        int result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);

        System.out.println("testPlantCrops #2");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = -10;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        System.out.println("testPlantCrops #3");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = 30;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        System.out.println("testPlantCrops #4");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(8);
        acresToPlant = 18;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        System.out.println("testPlantCrops #5");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = 0;
        expResult = 30;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        System.out.println("testPlantCrops #6");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = 20;
        expResult = 20;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        System.out.println("testPlantCrops #7");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(9);
        acresToPlant = 18;
        expResult = 0;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of sellLand method, of class CropControl.
     */
    @Test
    public void testSellLand() {
        System.out.println("sellLand #1");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        int landPrice = 20;
        int acresToSell = 10;
        int expResult = 2790;
        int result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("sellLand #2");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        landPrice = 20;
        acresToSell = -5;
        expResult = -1;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("sellLand #3");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        landPrice = 20;
        acresToSell = 3000;
        expResult = -1;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("sellLand #4");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2000);
        landPrice = 10;
        acresToSell = 2000;
        expResult = 0;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        System.out.println("sellLand #5");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2000);
        landPrice = 10;
        acresToSell = 0;
        expResult = 2000;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
    }
}