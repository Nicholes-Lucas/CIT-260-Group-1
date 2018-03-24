
package cityofaaron.control;

import cityofaaron.model.CropData;
import java.util.Random;
import cityofaaron.exceptions.*;

/**
 *
 * @author kristinaplauche
 */

public class CropControl {
    
    // constants
    private static final int LAND_BASE = 17;
    private static final int LAND_RANGE = 10;
    
    private static Random random = new Random();

    // calcLandCost() method
    // Purpose: Calculate a random land cost between 17 and 26 bushels/acre
    // Parameters: none
    // Returns: the land cost
    public static int calcLandCost(){
        int landPrice = random.nextInt(LAND_RANGE) + LAND_BASE;  
        return landPrice;            
    }
    
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
    public static void feedPeople(int wheatToFeed, CropData cropData) throws CropException{
        int wheat2 = cropData.getWheatInStore();


        // if wheatToFeed < 0, return -1
        if (wheatToFeed < 0) {
        throw new CropException("A negative value was input");
        }
        // if wheatToFeed > wheatInStore,  return -1
        if (wheatToFeed > wheat2) {
            throw new CropException("Wheat to feed people must be greater than the wheat in store.");
        }
        // wheatInStore = wheatInStore - wheatToFeed
        wheat2 -= wheatToFeed;

        // wheatToFeed = wheatToFeed
        cropData.setWheatForPeople(wheatToFeed);
        cropData.setWheatInStore(wheat2);
      
    }

    /*
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

        cropData.setAcresPlanted(acresToPlant);

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
    public static void sellLand(int landPrice, int acresToSell, CropData cropData) throws CropException {
        int owned = cropData.getAcresOwned();
        int wheat = cropData.getWheatInStore();

        //if acresToSell < 0, return -1
        if(acresToSell < 0)
           throw new CropException("Please enter a positive number.");

        //if acresToSell > acresOwned, return -1        
        if(acresToSell > owned)
            throw new CropException("You cannot sell more land than you own.");

        //acresOwned = acresOwned - acresToSell
        owned -= acresToSell;
        cropData.setAcresOwned(owned);

        //wheatInStore = wheatInStore + acresToSell * landPrice
        wheat += (acresToSell * landPrice);
        cropData.setWheatInStore(wheat);

        
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
    public static void buyLand(int landPrice, int acresToBuy, CropData cropData)throws CropException {
        int wheat = cropData.getWheatInStore();
        int owned = cropData.getAcresOwned();
        int population = cropData.getPopulation();
        //int landPrice = random.nextInt(28)-17; //random landPrice, value 17-27

        //if acresToBuy <0, return -1
        if(acresToBuy < 0)
            throw new CropException("A negative value was entered.");

        //if wheatInStore < (acresToBuy * landPrice) return -1
        if((acresToBuy * landPrice) > wheat)
            throw new CropException("There is insufficient wheat to buy this much land.");

        //if population cannot tend new land, return -1
        if(population < (acresToBuy + owned)/10)
            throw new CropException("There are not enough people to tend this much land.");

        //acresOwned = acresOwned+acresToBuy
        owned += acresToBuy;
        cropData.setAcresOwned(owned);

        //wheatInStore = wheatInStore - (acresToBuy*landPrice)
        wheat -= (acresToBuy*landPrice);
        cropData.setWheatInStore(wheat);    
        
    }

    /*
     * @author Lucas Nicholes
     */
    
    // The growPopulation method
    // Purpose: To determine how many people now live in the city
    // Parameters: none
    // Returns: the number of newPeople in the city of Aaron
    // Pre-conditions: population must be positive
    public static int growPopulation(CropData cropData) {
        int population = cropData.getPopulation();

        int randomGrowth = random.nextInt(5)+1;
        
        // if population < 0, return -1
        if (population < 0)
            return -1;

        //newPeople = random number * population
        int newPeople = population * randomGrowth/100;
        cropData.setNewPeople(newPeople);

        //population = population + newPeople
        population += newPeople;
        cropData.setPopulation(population);
        
        //return population
        return population;
    }
    
    // The calcStarved method
    // Purpose: To determine how many people have starved in the city
    // Parameters: none
    // Returns: the number of numStarved in the city of Aaron
    // Pre-conditions: wheatForPeople must be positive
    // and the numStarved must be positive    
    public static int calcStarved(CropData cropData) {
        int wheat = cropData.getWheatForPeople();
        int population = cropData.getPopulation();
        
        int numStarved = 0;
        
        // if wheatInStore < 0, return -1
        if (wheat < 0)
            return -1;
        
        // if population < 0, return -1
        if (population < 0)
            return -1;
        
        //peopleFed = wheatForPeople / 20
        int peopleFed = wheat/20;
        cropData.setPeopleFed(peopleFed); 
        
        //numStarved = population – peopleFed
        numStarved = population - peopleFed;

        //population = population – numStarved
        if (numStarved > 0) {
           cropData.setNumStarved(numStarved); 
           
           population -= numStarved;
           cropData.setPopulation(population);
        }
        else {
            cropData.setNumStarved(0); 
        }
        
        //return numStarved
        return numStarved;
    }
    
    // The harvestCrops method
    // Purpose: To determine wheat harvested
    // Parameters: None
    // Returns: The number of bushels harvested
    // Pre-conditions: None
    public static int harvestCrops(CropData cropData) {
        int acres = cropData.getAcresPlanted();
        int offering = cropData.getOffering();
        int wheat = cropData.getWheatInStore();
        int harvest = 0;
        int yield = 1;

        // if offering is < 8%, yield between 1 and 3 bushels/acre
        if (offering < 8) {
            yield = (random.nextInt(3)+1);
        }

        // if offering is between < 8% and 12% inclusive, yield between 2 and 4 bushels/acre
        if (offering >= 8 && offering <= 12) {
            yield = (random.nextInt(3)+2);
        }

        // if offering is > 12%, yield between 2 and 5 bushels/acre
        if (offering > 12) {
            yield  = (random.nextInt(4)+2);
        }

        // harvest = acres * yield
        harvest = acres * yield;
        cropData.setHarvest(harvest);

        // wheatInStore = wheatInStore + harvest
        wheat += harvest;
        cropData.setWheatInStore(wheat);
        
        // return bushels eatenByRats
        return harvest;
    }
        
    // The payOffering method
    // Purpose: To pay offerings
    // Parameters: offering
    // Returns: The number of bushels paid as an offering
    // Pre-conditions: offering must be positive
    // and not greater than 100
    public static int payOffering(int offering, CropData cropData) {
        int harvest = cropData.getHarvest();
        int wheat = cropData.getWheatInStore();
    
        // offering must be positive and less than 100
        if (offering < 0 || offering > 100)
            return -1;
        
        // find offering in bushels of wheat
        int bushels = harvest * offering / 100;
        
        // save offering values
        cropData.setOffering(offering);
        cropData.setOfferingBushels(bushels);
        
        // adjust harvest
        harvest -= bushels;
        cropData.setHarvestAfterOffering(harvest);
                
        // adjust wheatInStore
        wheat -= bushels;   
        cropData.setWheatInStore(wheat);
        
        // return bushels offered
        return bushels;
    }

    // author Susan Peay
    // Purpose: store a user inputted value for (offering)
    // Parameters:toOffer2
    // and cropData
    // Pre-conditions: must be positive, and <= 100
    // and return the number the user inputted    
    public static int setOffering(int toOffer2, CropData cropData){
        // If perToOffer <0, return -1        
        if (toOffer2 < 0){
            return -1;
        }
        // if offering > 100, return -1
        if (toOffer2 > 100)  {
            return -1;
        }
        
        //save number into the variable offering
        cropData.setOffering(toOffer2);
          
        // return (offering)
        return toOffer2;
    } 

    public static void sellLand(int toSell, CropData cropData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}