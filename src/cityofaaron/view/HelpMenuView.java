/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;

/**
 *
 * @author kristinaplauche
 */
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import cityofaaron.model.*;
import cityofaaron.view.MainMenuView;

public class HelpMenuView {
    
   Scanner keyboard = new Scanner(System.in);
    
    private String theHelpMenu;
    private int max; 
    
    // The HelpMenuView constructor
    // Purpose: Initialize the help menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public HelpMenuView(){   
    
        theHelpMenu = "\n" +
                       "**********************************\n" +
                       "* CITY OF AARON: HELP GAME MENU  *\n" +
                       "**********************************\n" +
                       " 1 - What are the goals of the game?\n" +
                       " 2 - Where is the city of Aaron?\n" +
                       " 3 - How do I view the map?\n" +
                       " 4 - How do I move to another location?\n" +
                       " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
                       " 6 - Back to the Main Menu\n";

        max = 6;
    }
    
    
    // The displayMenuView method
    // Purpose: displays the menu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    public void displayHelpMenuView() {
        int menuOption;
        do {
            // Display the menu
            System.out.println(theHelpMenu);
               
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
            if(userInput < 1 || userInput > max)
            {
                System.out.println("\noption must be between 1 and " + max);
            }
            
        // loop back to the top if input was not valid
        }  while(userInput < 1 || userInput > max);
        
        // return the value input by the user
        return userInput; 
    }
    
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
    public void doAction(int option) {
        switch(option) {
            case 1: // What are the goals of the game?
                viewGoals();
                break;
            case 2: // Where is the city of Aaron?
                viewMapHelp();
                break;
            case 3: // How do I view the map?
                viewMapHelp();
                break;
            case 4: // How do I move to another location?
                viewMoveHelp();
                break;
            case 5:// How do I display a list of animals, provisions and tools in the city storehouse?
                viewListHelp();
                break;
            case 6:// Back to the Main Menu.
                viewMainMenu();
                break;
        }
    } 
    
   public void viewGoals() {
       
       // Display the Goals Text for #1 What are the goals of the game?
        System.out.println("\nThe goals for the city of Aaron. "
              );
       
   } 
    public void viewLocation() {
        // Display the Location Text for #2 Where is the city of Aaron?.
        System.out.println("\nMap Help for the city of Aaron. "
               );
       
   } 
  
   public void viewMapHelp() {
        // Display the Map Help Text for #3 How do I view the map?.
        System.out.println("\nMap Help for the city of Aaron. "
               );
       
   } 
   
   
   public void viewMoveHelp() {
       // Display the Move Help Text for #4 how do I move to another locatiion?
       System.out.println("\nMove Help for the city of Aaron. "
               );
   } 
   
   
   public void viewListHelp() {
       // Display the List Help Text for #5 How do I display a list of animals, etc...?
       System.out.println("\nList Help for the city of Aaron. "
               );
   } 
   
   public void viewMainMenu() {
       //#6 display main menu
       System.out.println("\nBack to Main Menu. "
               );
   } 
   
 
   
}


