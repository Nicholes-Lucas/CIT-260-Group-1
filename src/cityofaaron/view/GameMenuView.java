
package cityofaaron.view;

import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 *
 * @author Susan Peay
 */

public class GameMenuView {
    
    Scanner keyboard = new Scanner(System.in);
    
    private String theMenu;
    private int max; 
    
    // The GameMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================
    
       public GameMenuView(){   
    
        theMenu = "\n" +
                       "**********************************\n" +
                       "* CITY OF AARON: GAME MENU VIEW  *\n" +
                       "**********************************\n" +
                       " 1 - View the map\n" +
                       " 2 - View/Print a list\n" +
                       " 3 - Move to a new location\n" +
                       " 4 - manage the Crops\n" +
                       " 5 - Return to the Main menu\n";

        max = 5;
    } 
       
    // The displayMenuView method
    // Purpose: displays the menu, gets the user's input, and does the 
    //               selected action
    // Parameters: none
    // Returns: none
    // =========================================================    
    public void displayGameMenuView() {
        int menuOption;
        do {
            // Display the menu
            System.out.println(theMenu);
            
            // Prompt the user and get the user’s input
            menuOption = this.getMenuOption();
                
            // Perform the desired action
            doAction(menuOption);
            
            // Determine and display the next view        
        }   while (menuOption != max);
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
            case 1: // View the Map
                viewMap();
                break;
            case 2: // View/Print a list
                viewList();
                break;
            case 3: // Move to a new location
                moveToNewLocation();
                break;
            case 4: // Manage the crops
                manageCrops();
                break;
            case 5: // Return to the Main Menu
                displayMainMenu();
                break;
            }
        }
        
    // The viewMap method
    // Purpose: displays map
    // Parameters: none
    // Returns: none
    // ===================================     
    public void viewMap() {
        System.out.println("\n1 - View the map option selected");
    }
    
    // The viewList method
    // Purpose: displays view/print list menu
    // Parameters: none
    // Returns: none
    // ===================================     
    public void viewList() {
        System.out.println("\n2 - View/Print a list option selected.");
    }
    
    // The moveToNewLocation method
    // Purpose: displays moveToNewLocation
    // Parameters: none
    // Returns: none
    // ===================================     
    public void moveToNewLocation() {
        System.out.println("\n3 - Move to a new location option selected.");
    }
    
    // The manageCrops method
    // Purpose: displays manage Crops
    // Parameters: none
    // Returns: none
    // ===================================     
    public void manageCrops() {
        System.out.println("\n4 - Manage Crops option selected.");
    }
    
    // The displayMainMenu method
    // Purpose: displays Main menu
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displayMainMenu() {
        System.out.println("\n5 - Display Main Menu option selected.");
    } 
        
    
    
}
