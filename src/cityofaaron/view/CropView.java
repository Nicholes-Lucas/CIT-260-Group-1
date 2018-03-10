
package cityofaaron.view;

import cityofaaron.model.*;
import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 *
 * @author Lucas Nicholes <nic16020@byui.edu>
 */
public class CropView {

    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
     
    // Get reference to the Game object and the Crops object
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();

    // The buyLandView method
    // Purpose: interface with the user input for buying land
    // Parameters: none
    // Returns: none
    public static void buyLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();

        // Prompt the user to enter the number of acres to buy
        System.out.format("Land is selling for %d bushels per acre.%n",price);
        System.out.print("\nHow many acres of land do you wish to buy? ");

        //  Get the user’s input and save it.
        int toBuy;
        toBuy = keyboard.nextInt();

        // Call the buyLand() method in the control layer to buy the land
        
        CropControl.buyLand(price, toBuy, cropData);
    }
    
    // The feedPeopleView method
    // Purpose: interface with the user input for buying wheat to feed people
    // Parameters: none
    // Returns: wheat left in store
    public static void feedPeopleView(){
        
        // Get the amount of wheat in store
        int wheatStore = cropData.getWheatInStore();

        // Ask the user how many bushels of wheat they want to give to the people?
        System.out.format("You have" + wheatStore + "wheat left in store.");
        System.out.print("\nHow many bushels of wheat do you want to give to the people? ");
       

        //  Get the user’s input and save it.
        int toGive;
        toGive = keyboard.nextInt();

        // Call the feedPeople() method in the control layer to feed the people
        
        CropControl.feedPeople(toGive, cropData);
    }
    
    // The plantCropsView method by Lucas Nicholes
    // Purpose: interface with the user input for planting crops
    // Parameters: none
    // Returns: none
    public static void plantCropsView()
    {
        // Prompt the user to enter the amount of wheat to plant
        System.out.print("\nYou can plant 2 acres with one bushel of wheat.");
        System.out.print("\nHow many acres of land do you want to plant? ");

        //  Get the user’s input and save it.
        int toPlant;
        toPlant = keyboard.nextInt();

        // Call the buyLand() method in the control layer to buy the land
        CropControl.plantCrops(toPlant, cropData);
    }
    
    // The runCropsView method()by Lucas Nicholes?
    // Purpose: runs the City of Aaron game
    // Parameters: none
    // Returns: none
    public static void runCropsView()
    {
        // call the buyLandView() method
        buyLandView();
        
        //call the  feedPeopleView(); method
         feedPeopleView();
         
         //call the plantCropsView(); method
         plantCropsView();
         
         // call the sellLandView() method
        sellLandView();
        
         // call the cropReportView(); method
         cropReportView();

        // add calls to the other crop view methods
        // as they are written
    }
    
    // Susan Peay
    // The sellLandView method
    // Purpose: interface with the user input for Selling Land
    // Parameters: none
    // Returns: none
    public static void sellLandView()
    {
        int owned = cropData.getAcresOwned();
        
        // Ask the user "how many acres of new land do you want to sell?"
        System.out.format("You have" + owned + "acres of land.");
        System.out.print("\nHow many acres of new land do you want to sell?");

        //  Get the user’s input and save it.
        int toSell;
        toSell = keyboard.nextInt();

        // Call the sellLand() method in the control layer to sell the land
        CropControl.sellLand(owned, toSell, cropData);
    }
       
    
    // Kristina Plauche
    // The cropReport display
    // Purpose: To display to the player a report of the current statistics. 
    

    public static void cropReportView() {
        // The year number 
        int year = cropData.getYear();
        System.out.format("Current Year: " + year + "\n");
                
        // How many people starved 
        int starved = cropData.getNumStarved();
        System.out.format("Starved : " + starved + "\n");
        
        // How many people came to the city
        int movedIn = cropData.getNewPeople();
        System.out.format("New People: " + movedIn + "\n");
        
        // The current population 
        int population = cropData.getPopulation();
        System.out.format("Current Population " + population + "\n");
        
        // The number of acres of crop land owned by the city
        int ownedAcres = cropData.getAcresOwned();
        System.out.format("Acres Owned: " + ownedAcres + "\n");
        
        // The number of bushels per acre in this years harvest
        int yield = cropData.getCropYield();
        System.out.format("Crop Yield: " + yield + "\n");
        
        // The number of bushels of wheat paid in offerings
        int offerings = cropData.getOfferingBushels();
        System.out.format("Offering Bushels: " + offerings + "\n");
        
        // The number of bushels of wheat eaten by rats
        int ratFood = cropData.getEatenByRats();
        System.out.format("Eaten By Rats: " + ratFood + "\n");
        
        // The number of bushels of wheat in store
        int wheatStorage = cropData.getWheatInStore();
        System.out.format("Wheat in Store: " + wheatStorage + "\n");
                
        
}


    
}
