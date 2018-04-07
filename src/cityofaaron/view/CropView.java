
package cityofaaron.view;

import cityofaaron.model.*;
import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import cityofaaron.exceptions.*;

/*
 * @author Lucas Nicholes <nic16020@byui.edu>
 */
public class CropView {

    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
     
    // Get reference to the Game object and the Crops object
    private static Game theGame = CityOfAaron.getTheGame();
    private static CropData cropData = theGame.getCropData();
    private static Player thePlayer = theGame.getThePlayer();

    // The buyLandView method
    // Purpose: interface with the user input for buying land
    // Parameters: none
    // Returns: none
    public static void buyLandView()
    {
        // Get the cost of land for this round.
        int price = CropControl.calcLandCost();

        // Prompt the user to enter the number of acres to buy
        System.out.format("\nLand is selling for %d bushels per acre.%n",price);

        //  Get the user’s input and save it.
        int toBuy;
        boolean paramsNotOkay;
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to buy? ");  
            toBuy = keyboard.nextInt();
            try
            {
                // Call the buyLand() method in the control layer to buy the land        
                CropControl.buyLand(price, toBuy, cropData);
            }       
            catch(CropException e)
            {
                System.out.println("I am sorry, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);        
    }
    
    // Kristina Plauche
    // The feedPeopleView method    
    // Purpose: interface with the user input for buying wheat to feed people
    // Parameters: none
    // Returns: wheat left in store
    public static void feedPeopleView(){
        
        // Get the amount of wheat in store
        int wheatStore = cropData.getWheatInStore();

        // Ask the user how many bushels of wheat they want to give to the people?
        System.out.print("\nIt takes 20 bushels of wheat to feed each person.");
        System.out.format("\nYou have " + wheatStore + " bushels of wheat left in store.");
               
        int toGive;
        boolean paramsNotOkay;
        do {
            paramsNotOkay = false;
            System.out.print("\nHow many bushels of wheat do you want to give to the people? ");
            //  Get the user’s input and save it.
            toGive = keyboard.nextInt();
            try 
            {
                // Call the feedPeople() method in the control layer to feed the people        
                CropControl.feedPeople(toGive, cropData);
            }
            catch(CropException e)
            {
                System.out.println("I am sorry, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
    }
    
    // Lucas Nicholes
    // The plantCropsView method
    // Purpose: interface with the user input for planting crops
    // Parameters: none
    // Returns: none
    public static void plantCropsView()
    {
        System.out.print("\nYou can plant 2 acres with one bushel of wheat.");
        int toPlant;        
        boolean paramsNotOkay;
        do {
            paramsNotOkay = false;
            // Prompt the user to enter the amount of wheat to plant
            System.out.print("\nHow many acres of land do you want to plant? ");
            
            //  Get the user’s input and save it.
            toPlant = keyboard.nextInt();
            
            try 
            {
                // Call the buyLand() method in the control layer to buy the land
                CropControl.plantCrops(toPlant, cropData);
            }
            catch(CropException e)
            {
                System.out.println("I am sorry, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
    }
          
    // Susan Peay
    // The sellLandView method
    // Purpose: interface with the user input for Selling Land
    // Parameters: none
    // Returns: none
    public static void sellLandView()
    {
        int owned = cropData.getAcresOwned();
        int landPrice = cropData.getLandPrice();
        
        // Ask the user "how many acres of land do you want to sell?"
        System.out.format("%nYou have " + owned + " acres of land.");

        //  Get the user’s input and save it.
        int toSell;
        boolean paramsNotOkay;
        do
        {
            paramsNotOkay = false;
            System.out.print("\nHow many acres of land do you wish to sell? ");  
            toSell = keyboard.nextInt();
            try
            {
                // Call the sellLand() method in the control layer to buy the land
                CropControl.sellLand(landPrice, toSell, cropData);
            }       
            catch(CropException e)
            {
                System.out.println("I am sorry, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);        
    }
       
    // Lucas Nicholes
    // The showStarvedView method
    // Purpose: To display to the player a report of the number of 
    //   people who have starved.
    public static void showStarvedView() {
        int year = cropData.getYear();
        int pop = cropData.getPopulation();
        
        // Display how many people have starved 
        CropControl.calcStarved(cropData);
        int num = cropData.getNumStarved();
        
        if (num > pop/2) {
            System.out.format("%nIn Year " + year + ", " + num + " people have starved."
             + "%n"
             + "%nDue to your severe negligence, you have been thrown out of office!"
             + "%nGame Over%n");            
             
            MainMenuView mmv = new MainMenuView();
            mmv.displayMenu();        
        }
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
    
    // The runCropsView method()by Lucas Nicholes
    // Purpose: runs the City of Aaron game
    // Parameters: none
    // Returns: none
    public static void runCropsView()
    {
        // display cropReportView() at beginning of game
        cropReportView();
        
        // call the buyLandView() method
        buyLandView();
        
        // call the sellLandView() method
        sellLandView();
        
        // call the  feedPeopleView() method
        feedPeopleView();
         
        // call the plantCropsView() method
        plantCropsView();
        
        // call the harvestCrops() method from the CropControl class
        CropControl.harvestCrops(cropData);
        
        // call the payOfferingsView() method
        payOfferingsView();
        
        // call the calcEatenByRats() method from the CropControl class
        CropControl.calcEatenByRats(cropData);
        
        // call the showStarvedView;
        showStarvedView();
        
        // call the growPopulation() method from the CropControl class
        CropControl.growPopulation(cropData);
        
        // increment year in game
        incrementYearView();
        
        // call the cropReportView() method
        cropReportView();                

        // add calls to the other crop view methods
        // as they are written
    }
    
    /**
     * @author Susan Peay
     * The payOfferingsView 
     * Purpose: to get user input for (offerings) variable
     */
    public static void payOfferingsView() {
        int wheaties = cropData.getHarvest();
        //Ask the user "What percentage of their harvest they want to pay in 
        // tithes and offerings?        
        System.out.format("%nYou have harvested " + wheaties + " bushels of wheat.");
        int toOffer;
        boolean paramsNotOkay;
        do
        {
            paramsNotOkay = false;
            System.out.print("\nWhat percentage of the harvest do you want to pay in tithes and offerings? ");
        
            //Get the user's input
            toOffer = keyboard.nextInt();
            
            try
            {
                //call the setOffering() method in the control layer
                CropControl.payOffering(toOffer, cropData);
            }
            catch(CropException e)
            {
                System.out.println("I am sorry, I cannot do this.");
                System.out.println(e.getMessage());
                paramsNotOkay = true;
            }
        } while(paramsNotOkay);
    }
    
    // Lucas Nicholes
    // The incrementYearView method
    // Purpose: To increment the game one year
    public static void incrementYearView() {
        int year = cropData.getYear();
        int population = cropData.getPopulation();
        String name = thePlayer.getName();
        
        // Display how many people have starved        
        if (year < 10) 
            cropData.setYear(++year);
        
        if (year == 10) {
            
            if (population < 100) {
                System.out.format(
                    "%n***********************************************************%n" +
                    "  Not bad " + name + ".%n" +
                    "* Your term as ruler over the City of Aaron is at an end. *%n" +
                    "* While you have kept most of the city's people alive,    *%n" +
                    "* perhaps you could have exercised better decision making *%n" +
                    "* to encourage the city's growth. Nevertheless, thank you *%n" +
                    "* for your diligent service to the City of Aaron.         *%n" +        
                    "*                                                         *%n" +
                    "*                        GAME OVER!                       *%n" +
                    "***********************************************************%n");
            }
            
            if (population == 100) {
                System.out.format(
                    "%n***********************************************************%n" +
                    "  Well done " + name + "!%n" +
                    "* You have successfully completed your term as ruler over *%n" +
                    "* the City of Aaron. Like Joseph in Egypt, you have ruled *%n" +
                    "* in wisdom and faith and have kept the city's people fed *%n" +
                    "* over the past 10 years. The City of Aaron thanks you!!! *%n" +
                    "*                                                         *%n" +
                    "*                        GAME OVER!                       *%n" +
                    "***********************************************************%n");
            }
            
            if (population > 100) {
                System.out.format(
                    "%n***********************************************************%n" +
                    "  Congratulations " + name + "!!!%n" +
                    "* You have successfully completed your term as ruler over *%n" +
                    "* the City of Aaron. Like Joseph in Egypt, you have ruled *%n" +
                    "* in wisdom and faith and have kept the city's people fed *%n" +
                    "* over the past 10 years. Additionally, you have gone the *%n" +
                    "* extra mile and encouraged the city to grow and flourish *%n" +
                    "* during your reign. Your name will forever be remembered *%n" +
                    "* and loved by the people of the City of Aaron. Bravo!!!  *%n" +
                    "*                                                         *%n" +
                    "*                        GAME OVER!                       *%n" +
                    "***********************************************************%n");
            }            
            
            System.out.format(
                "%nFinal Statistics for the City of Aaron:%n");
                    
                // The year number 
            year = cropData.getYear();
            System.out.format("Current Year: " + year + "\n");

            // How many people starved 
            int starved = cropData.getNumStarved();
            System.out.format("Starved : " + starved + "\n");

            // How many people came to the city
            int movedIn = cropData.getNewPeople();
            System.out.format("New People: " + movedIn + "\n");

            // The current population 
            population = cropData.getPopulation();
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
            
            MainMenuView mmv = new MainMenuView();
            mmv.displayMenu();        
        }
    }
}
