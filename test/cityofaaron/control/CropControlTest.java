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
        //Test 1 - Valid
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
        
        //Test 2 - Invalid
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
        
        //Test 3 - Invalid
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
        
        //Test 4 - Boundary
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
        
        //Test 4 - Boundary
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
        //Test 1 - Valid
        System.out.println("feedPeople Test 1");
        int wheatToFeed = 100;
        CropData theFood = new CropData();
        theFood.setWheatInStore(3000);
        int expResult = 2900;
        int result = CropControl.feedPeople(wheatToFeed, theFood);
        assertEquals(expResult, result);
        
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
    
    /**
     * Test of plantCrops method, of class CropControl.
     */
    @Test
    public void testPlantCrops() {
        //Test 1 - Valid
        System.out.println("testPlantCrops #1");
        CropData toPlant = new CropData();
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        int acresToPlant = 12;
        int expResult = 24;
        int result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        //Test 2 - Invalid
        System.out.println("testPlantCrops #2");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = -10;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        //Test 3 - Invalid
        System.out.println("testPlantCrops #3");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = 30;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        //Test 4 - Invalid
        System.out.println("testPlantCrops #4");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(8);
        acresToPlant = 18;
        expResult = -1;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        //Test 5 - Boundary
        System.out.println("testPlantCrops #5");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = 0;
        expResult = 30;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        //Test 6 - Boundary
        System.out.println("testPlantCrops #6");
        toPlant.setAcresOwned(20);
        toPlant.setWheatInStore(30);
        acresToPlant = 20;
        expResult = 20;
        result = CropControl.plantCrops(acresToPlant, toPlant);
        assertEquals(expResult, result);
        
        //Test 7 - Boundary
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
        //Test 1 - Valid
        System.out.println("sellLand #1");
        CropData theCrops = new CropData();
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        int landPrice = 20;
        int acresToSell = 10;
        int expResult = 2790;
        int result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        //Test 2 - Invalid
        System.out.println("sellLand #2");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        landPrice = 20;
        acresToSell = -5;
        expResult = -1;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        //Test 3 - Invalid
        System.out.println("sellLand #3");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2800);
        landPrice = 20;
        acresToSell = 3000;
        expResult = -1;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        //Test 4 - Boundary
        System.out.println("sellLand #4");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2000);
        landPrice = 10;
        acresToSell = 2000;
        expResult = 0;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
        
        //Test 5 - Boundary
        System.out.println("sellLand #5");
        theCrops.setWheatInStore(1000);
        theCrops.setAcresOwned(2000);
        landPrice = 10;
        acresToSell = 0;
        expResult = 2000;
        result = CropControl.sellLand(landPrice, acresToSell, theCrops);
        assertEquals(expResult, result);
    }
    
    /**
    * Test of buyLand method, of class CropControl.
    */
    @Test
    public void testBuyLand() {
        //Test 1 - Valid
        System.out.println("buyLand Test Case #1");
        CropData theAcres = new CropData();
        theAcres.setWheatInStore(2800);
        theAcres.setAcresOwned(0);
        theAcres.setPopulation(1000);
        int acresToBuy = 100;
        int expResult = 100;
        int landPrice = 10;
        int result = CropControl.buyLand(landPrice, acresToBuy, theAcres);
        assertEquals(expResult, result);

        //Test 2 - Invalid 
        System.out.println("buyLand Test Case #2");
        theAcres.setWheatInStore(2800);
        theAcres.setAcresOwned(0);
        theAcres.setPopulation(1000);
        acresToBuy = -5;
        expResult = -1;
        landPrice = 10;
        result = CropControl.buyLand(landPrice, acresToBuy, theAcres);
        assertEquals(expResult, result);

        //Test 3 - Invalid 
        System.out.println("buyLand Test Case #3");
        theAcres.setWheatInStore(2800);
        theAcres.setAcresOwned(0);
        theAcres.setPopulation(1000);
        acresToBuy = 30000;
        expResult = -1;
        landPrice = 10;
        result = CropControl.buyLand(landPrice, acresToBuy, theAcres);;
        assertEquals(expResult, result);

        //Test 4 - Boundary 
        System.out.println("buyLand Test Case #4");
        theAcres.setWheatInStore(2800);
        theAcres.setAcresOwned(0);
        theAcres.setPopulation(1000);
        acresToBuy = 100;
        expResult = 100;
        landPrice = 10;
        result = CropControl.buyLand(landPrice, acresToBuy, theAcres);
        assertEquals(expResult, result);

        //Test 5 - Boundary 
        System.out.println("buyLand Test Case #5");
        theAcres.setWheatInStore(2800);
        theAcres.setAcresOwned(0);
        theAcres.setPopulation(1000);
        acresToBuy = 0;
        expResult = 0;
        landPrice = 10;
        result = CropControl.buyLand(landPrice, acresToBuy, theAcres);
        assertEquals(expResult, result);
     }
    
     /**
     * Test of growPopulation method, of class CropControl.
     */
    @Test
    public void testGrowPopulation () {
        //Test 1 - Valid
        System.out.println("testGrowPopulation #1");
        CropData growPop = new CropData();
        growPop.setPopulation(100);
        int minExpResult = 101;
        int maxExpResult = 105;
        int result = CropControl.growPopulation(growPop);
        assertTrue(minExpResult <= result && result <= maxExpResult);
        
        //Test 2 - Invalid
        System.out.println("testGrowPopulation #2");
        growPop.setPopulation(-100);
        int expResult = -1;
        result = CropControl.growPopulation(growPop);
        assertEquals(expResult, result);
        
        //Test 3 - Boundary
        System.out.println("testGrowPopulation #3");
        growPop.setPopulation(0);
        minExpResult = 0;
        maxExpResult = 0;
        result = CropControl.growPopulation(growPop);
        assertTrue(minExpResult <= result && result <= maxExpResult);
        
        //Test 4 - Boundary
        System.out.println("testGrowPopulation #4");
        growPop.setPopulation(100);
        minExpResult = 101;
        maxExpResult = 105;
        result = CropControl.growPopulation(growPop);
        assertTrue(minExpResult <= result && result <= maxExpResult);
    }
    
    /**
     * Test of numStarved method, of class CropControl.
     */
    @Test
    public void testCalcStarved () {
        //Test 1 - Valid
        System.out.println("testCalcStarved #1");
        CropData decrPop = new CropData();
        decrPop.setWheatForPeople(2000);
        decrPop.setPopulation(105);
        int expResult = 100;
        int result = CropControl.calcStarved(decrPop);
        assertEquals(expResult, result);
        
        //Test 2 - Invalid
        System.out.println("testCalcStarved #2");
        decrPop.setWheatForPeople(-200);
        decrPop.setPopulation(105);
        expResult = -1;
        result = CropControl.calcStarved(decrPop);
        assertEquals(expResult, result);
        
        //Test 3 - Boundary
        System.out.println("testCalcStarved #3");
        decrPop.setWheatForPeople(2200);
        decrPop.setPopulation(105);
        expResult = 105;
        result = CropControl.calcStarved(decrPop);
        assertEquals(expResult, result);
        
        //Test 4 - Boundary
        System.out.println("testCalcStarved #4");
        decrPop.setWheatForPeople(0);
        decrPop.setPopulation(105);
        expResult = 0;
        result = CropControl.calcStarved(decrPop);
        assertEquals(expResult, result);
        
        //Test 5 - Boundary
        System.out.println("testCalcStarved #5");
        decrPop.setWheatForPeople(2100);
        decrPop.setPopulation(105);
        expResult = 105;
        result = CropControl.calcStarved(decrPop);
        assertEquals(expResult, result);        
    }    
}
