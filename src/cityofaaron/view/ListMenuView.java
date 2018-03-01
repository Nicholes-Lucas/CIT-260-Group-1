
package cityofaaron.view;

import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 *
 * @author Lucas Nicholes <nic16020@byui.edu>
 */
public class ListMenuView {
    
    Scanner keyboard = new Scanner(System.in);
     
    private String theMenu;
    private int max; 
    
    public ListMenuView(){   
    
        theMenu = "\n" +
                       "**********************************\n" +
                       "* CITY OF AARON: VIEW LIST MENU  *\n" +
                       "**********************************\n" +
                       " 1 - List the animals in the storehouse\n" +
                       " 2 - List the tools in the storehouse\n" +
                       " 3 - List the provisions in the storehouse\n" +
                       " 4 - List the authors of this game\n" +
                       " 5 - Return to the Game menu\n";

        max = 5;
    }
    
    public void displayListMenuView() {
    
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
    
    private int getMenuOption(){
        int userInput;

        // begin loop
        do
        {
            // get user input from the keyboard
            userInput = keyboard.nextInt();
             
            // if it is not a valid value, output error message
            if(userInput < 1 || userInput > max)
            {
                System.out.println("\nSelection must be between 1 and " + max);
            }
            
        // loop back to the top if input was not valid
        }  while(userInput < 1 || userInput > max);
        
        // return the value input by the user
        return userInput; 
    }
    
    public void doAction(int option) {
        if (option == 1) {
            listAnimals();
        }
        else if (option == 2) {
            listTools();
        }
        else if (option == 3) {
            listProvisions();
        }
        else if (option == 4) {
            listTeam();
        }
        else if (option == 5) {
            displayGameMenu();
        }
        else {
            System.out.println("Please choose a valid option from the menu.");
        }
    }    
    
    // The listAnimals method
    // Purpose: displays list of animals in the storehouse
    // Parameters: none
    // Returns: none
    // ===================================     
    public void listAnimals() {
        System.out.println("\nAnimal list selected.");
    }
    
    // The listTools method
    // Purpose: displays list of tools in the storehouse
    // Parameters: none
    // Returns: none
    // ===================================     
    public void listTools() {
        System.out.println("\nTool list selected.");
    }
    
    // The listProvisions method
    // Purpose: displays list of provisions in the storehouse
    // Parameters: none
    // Returns: none
    // ===================================     
    public void listProvisions() {
        System.out.println("\nProvisions list selected.");
    }
    
    // The listTeam method
    // Purpose: displays list of the game's authors
    // Parameters: none
    // Returns: none
    // ===================================     
    public void listTeam() {
        System.out.println("\nList of team members selected.");
    }
    
    // The displayGameMenu method
    // Purpose: returns player back to Game menu
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displayGameMenu() {
        System.out.println("\nGame Menu selected.");
    }    
}
