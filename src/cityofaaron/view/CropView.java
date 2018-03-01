
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
    public static void feedPeopleView(){    {
        
    }
        // Get the cost of land for this round.
        int wheatStore = CropControl.feedPeople();

        // Ask the user how many bushels of wheat they want to give to the people?
        System.out.format("You have" + wheatStore + "wheat left in store.");
        System.out.print("\nHow many bushels of wheat do you want to give to the people? ");
       

        //  Get the user’s input and save it.
        int toGive;
        toGive = keyboard.nextInt();

        // Call the feedPeople() method in the control layer to feed the people
        
        CropControl.feedPeople(wheatStore, cropData);
    }
    
    // The plantCropsView method
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
    
    // The runCropsView method()
    // Purpose: runs the City of Aaron game
    // Parameters: none
    // Returns: none
    public static void runCropsView()
    {
        // call the buyLandView() method
        buyLandView();

        // add calls to the other crop view methods
        // as they are written
    }


    
}
