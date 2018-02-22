/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;

import cityofaaron.model.CropData;
import java.util.Random;

/**
 *
 * @author kristinaplauche
 */

public class CropControl {
    
private static Random random = new Random();
    
// The calcEatenByRats method
// Purpose: To determine wheat eaten by rats
// Parameters: none
// Returns: the number of bushels eaten by rats
// Pre-conditions: wheat in store must be positive
// and the percentage of offering must be positive
public static int calcEatenByRats (CropData cropData) {
    int wheat = cropData.getWheatInStore();
    int offering = cropData.getOffering();
        
    // if wheatInStore < 0, return -1
    if (wheat < 0)
        return -1;
    
    // if offering < 0 , return -1  
    // if offering > 100, return -1
    if (offering < 0 || offering > 100)
      return -1;
 
    // if random number < 30, then calculate: 
    int randomRats = random.nextInt(101);
    int eatenByRats = 0;  
    
    if (randomRats < 30) {     
     
        // if offering is < 8%, multiply wheat * random integer between 6% and 10%
        if (offering < 8) {
            eatenByRats = wheat * (random.nextInt(5)+6)/100;
        }

        // if offering is between < 8% and 12% inclusive, multiply wheat * random value between 3% and 7%.
        if (offering >= 8 && offering <= 12) {
            eatenByRats = wheat * (random.nextInt(5)+3)/100;
        }

        // if offering is > 12%, multiply wheat * random value between 3% and  5%
        if (offering > 12) {
            eatenByRats  = wheat *  (random.nextInt(3)+3)/100;
        }
    }
    
    // wheatInStore = wheatInStore - eatenByRats
    wheat -= eatenByRats;
    cropData.setWheatInStore(wheat);
 
    // return bushels eatenByRats
    return eatenByRats;
}

// The feedPeople method
// Purpose: To feed People
// Parameters: the number of bushels of wheat to feed the people
// Returns: the number of bushels of wheat in storage after feeding the people
// Pre-conditions: number of feeding bushels must be >=0
// and <= the number of bushels of wheat in storage
public static int feedPeople(int wheatToFeed, CropData cropData){
    int wheat2 = cropData.getWheatInStore();
    
 
    // if wheatToFeed < 0, return -1
    if (wheatToFeed < 0) {
    return -1;
    }
    // if wheatToFeed > wheatInStore,  return -1
    if (wheatToFeed > wheat2) {
        return -1;
    }
    // wheatInStore = wheatInStore - wheatToFeed
    wheat2 -= wheatToFeed;

    // wheatToFeed = wheatToFeed
    cropData.setWheatInStore(wheat2);
    // return wheatInStore

    return wheat2;

}

/**
 * @author lucasnicholes
 */

// The plantCrops method
// Purpose: To determine the land desired and wheat needed to plant crops
// Parameters: the number of acres of land to plant
// Returns: the number of bushels of wheat in store after planting 
// Pre-conditions: acres to plant must be positive
// and <= the number of acres owned
// and wheat to plant must be <= wheatInStore
public static int plantCrops(int acresToPlant, CropData cropData) {
    int owned = cropData.getAcresOwned();
    int wheat = cropData.getWheatInStore();
    
    // if acresToPlant < 0, return -1
    if (acresToPlant < 0)
        return -1;
    
    // if acresToPlant > acresOwned,  return -1
    if (acresToPlant > owned)
        return -1;
    
    // wheatToPlant = acresToPlant / 2
    int wheatToPlant = acresToPlant / 2;
    
    // if wheatToPlant > wheatInStore, return -1
    if (wheatToPlant > wheat)
        return -1;
    
    // wheatInStore = wheatInStore - wheatToPlant
    wheat -= wheatToPlant;
    cropData.setWheatInStore(wheat);
    
    // return wheatInStore
    return wheat;
}

// The sellLand method
// Purpose: To sell land
// Parameters: the price of land, the number of acres to sell, and a 
// reference to the Crops object
// Returns: the number of acres owned after the sale
// Pre-conditions: acres to sell must be positive
// and <= acresOwned
public static int sellLand(int landPrice, int acresToSell, CropData cropData) {
    int owned = cropData.getAcresOwned();
    int wheat = cropData.getWheatInStore();
    
    //if acresToSell < 0, return -1
    if(acresToSell < 0)
        return -1;

    //if acresToSell > acresOwned, return -1        
    if(acresToSell > owned)
        return -1;

    //acresOwned = acresOwned - acresToSell
    owned -= acresToSell;
    cropData.setAcresOwned(owned);

    //wheatInStore = wheatInStore + acresToSell * landPrice
    wheat += (acresToSell * landPrice);
    cropData.setWheatInStore(wheat);

    //return acresOwned
    return owned;
}

/*
 * @author Susan Peay
 */

// The buyLand method
// Purpose: to buy land
// Parameters: the price of land, and the number of acres to buy
// Returns: the total number of acres after the purchase
// Pre-conditions: 
// 1. acres to purchase must be positive
// 2. Amount of wheat needed for purchase must be available
//    Amount of wheat >= number of acres * buy price 
// 3. Amount of population must be enough to tend land
//    Population 10 >= for each acre
public static int buyLand(int acresToBuy, CropData cropData){
    int wheat = cropData.getWheatInStore();
    int owned = cropData.getAcresOwned();
    int population = cropData.getPopulation();
    int landPrice = random.nextInt(28)-17; //random landPrice, value 17-27
    
    //if acresToBuy <0, return -1
    if(acresToBuy < 0)
        return -1;

    //if wheatInStore < (acresToBuy * landPrice) return -1
    if((acresToBuy * landPrice) > wheat)
        return -1;

    //if population cannot tend new land, return -1
    if(population < (acresToBuy + owned)/10)
        return -1;

    //acresOwned = acresOwned+acresToBuy
    owned += acresToBuy;
    cropData.setAcresOwned(owned);

    //wheatInStore = wheatInStore - (acresToBuy*landPrice)
    wheat -= (acresToBuy*landPrice);
    cropData.setWheatInStore(wheat);

    //return acresOwned
    return owned;
}
}