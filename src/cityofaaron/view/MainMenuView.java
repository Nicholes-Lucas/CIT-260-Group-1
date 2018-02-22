/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;
// The MainMenuView class - part of the view layer
// Object of this class manage the main menu
// Author: Lucas Nicholes, Susan Peay, Kristina Plauche
// Date last modified: February 2018
//-------------------------------------------------------------
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import cityofaaron.model.Player;
import cityofaaron.model.Game;



/**
 *
 * @author kristinaplauche
 */
public class MainMenuView{
    
    Scanner keyboard = new Scanner(System.in);
    private String theMenu;
    private int max; 
    
// The MainMenuView constructor
// Purpose: Initialize the menu data
// Parameters: none
// Returns: none
// ===================================
public MainMenuView(){
    
    
    
    theMenu = "\n" +
                   "**********************************\n" +
                   "* CITY OF AARON: MAIN GAME MENU  *\n" +
                   "**********************************\n" +
                   " 1 - Start new game\n" +
                   " 2 - Get and start a saved game\n" +
                   " 3 - Get help on playing the game\n" +
                   " 4 - Save game\n" +
                   " 5 - Quit\n";
        
        max = 5;
}

    
    // The displayMenuView method
    // Purpose: displays the menu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    public void displayMenuView()
    {
        int menuOption;
        do {
// Display the menu
   System.out.println(theMenu);
// Prompt the user and get the user’s input
menuOption = getMenuOption();
// Perform the desired action
doAction(menuOption);
// Determine and display the next view
        } while (menuOption != max);

    }
// The getMenuOption method
    // Purpose: gets the user's input
    // Parameters: none
    // Returns: integer - the option selected
    // ===================================       
    public int getMenuOption()
    {
        // declare a variable to hold user’s input
        int userInput;

        // begin loop
        do
        {
            // get user input from the keyboard
             userInput = keyboard.nextInt();
            // if it is not a valid value, output an error message
              // if it is not a valid value, output an error message
            if(userInput < 1 || userInput > max)
            {
                System.out.println("\noption must be between 1 and " + max);
            }
        // loop back to the top if input was not valid
        }  while(userInput < 1 || userInput > max);
        // return the value input by the user
        return userInput; }
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    public void doAction(int option)
    {
        switch(option)
        {
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
 public void startNewGame()
 {
     //Create a new Game object.
     Game theGame = new Game();
    // Save a reference to it in the GameProject class.
     CityOfAaron.setTheGame(theGame);
    // Display the Banner Page.
     System.out.println("\nWelcome to the city of Aaron.");
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

     
 }  
  // The startSavedGame method
 // Purpose: starts saved game
 // Parameters: none
 // Returns: none
 // ===================================     
 public void startSavedGame()
 {
     System.out.println("\nStart saved game option selected.");
 }  
  // The displayHelpMenuView method
 // Purpose: displays help menu
 // Parameters: none
 // Returns: none
 // ===================================     
 public void displayHelpMenuView()
 {
     System.out.println("\nDisplay help menu option selected.");
 }  
  // The displaySavedGameView method
 // Purpose: displays saved game
 // Parameters: none
 // Returns: none
 // ===================================     
 public void displaySavedGameView()
 {
     System.out.println("\nDisplay saved game option selected.");
 }  
        
    }
    
    
    

