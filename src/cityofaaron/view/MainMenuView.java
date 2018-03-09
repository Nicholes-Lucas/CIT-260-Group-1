// The MainMenuView class - part of the view layer
// Object of this class manage the main menu
// Author: Lucas Nicholes, Susan Peay, Kristina Plauche
// Date last modified: February 2018
//-------------------------------------------------------------
package cityofaaron.view;

import java.util.Scanner;
import cityofaaron.CityOfAaron;
import cityofaaron.model.*;

public class MainMenuView extends MenuView{
  
    
    // The MainMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public MainMenuView(){   
    
        super("\n" +
                       "**********************************\n" +
                       "* CITY OF AARON: MAIN GAME MENU  *\n" +
                       "**********************************\n" +
                       " 1 - Start new game\n" +
                       " 2 - Get and start a saved game\n" +
                       " 3 - Get help on playing the game\n" +
                       " 4 - Save game\n" +
                       " 5 - Quit\n",
                5);

   
    }
    
 
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================  
     @Override public void doAction(int option){
        switch(option) {
            case 1: // create and start a new game
                startNewGame();
                break;
            case 2: // get and start a saved game
                startSavedGame();
                break;
            case 3: // get help menu
                displayHelpMenuView();
                break;
            case 4: // save game
                displaySavedGameView();
                break;
            case 5:
                System.out.println("Thanks for playing ... goodbye.");
        }
    } 
      
    // The startNewGame method
    // Purpose: creates game object and starts the game
    // Parameters: none
    // Returns: none
    // ===================================     
    public void startNewGame() {
    
        //Create a new Game object.
        Game theGame = new Game();
        
        // Save a reference to it in the GameProject class.
        CityOfAaron.setTheGame(theGame);
        
        // Display the Banner Page.
        System.out.println("\nWelcome to the city of Aaron. "
                + "\nYou have been summoned here by the High Priest "
                + "to assume your role as ruler of the city. "
                + "\nYour responsibility is to buy and sell land, determine "
                + "how much wheat to plant each year \nand how much to "
                + "set aside to feed your people. In addition, it will "
                + "be your job to pay \nan annual tithe on the wheat that "
                + "is harvested. If you fail to provide enough wheat for "
                + "\nthe people, people will starve,  some people will die, "
                + "and your workforce will be \ndiminished. Plan carefully. "
                + "And Oh, there is always a danger of rats eating your wheat.");
        
        // Create a new Player object
        Player thePlayer = new Player();
        
        // Prompt for and get the user’s name.
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();
    
        // Save the user’s name in the Player object    
        thePlayer.setName(name);
   
        // Save a reference to the player object in the Game object
        theGame.setThePlayer(thePlayer);
        
        // Display a welcome message
         System.out.println("\nWelcome " + name + " have fun.");
         
        // Display the Game menu
        
        // Create the CropData object, 
        // initialize it and save a reference to it in the Game
        CropData theCrops = new CropData();
        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000); 
        
        theGame.setCropData(theCrops);
        
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
    } 
    
    // The startSavedGame method
    // Purpose: starts saved game
    // Parameters: none
    // Returns: none
    // ===================================     
    public void startSavedGame() {
        System.out.println("\nStart saved game option selected.");
    }  
  
    // The displayHelpMenuView method
    // Purpose: displays help menu
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displayHelpMenuView() {
        System.out.println("\nDisplay help menu option selected.");
    }
    
    // The displaySavedGameView method
    // Purpose: displays saved game
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displaySavedGameView() {
        System.out.println("\nDisplay saved game option selected.");
    }
}
    
    
    

