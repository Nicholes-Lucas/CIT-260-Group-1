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
}