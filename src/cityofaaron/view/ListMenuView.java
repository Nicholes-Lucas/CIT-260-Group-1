
package cityofaaron.view;

import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 *
 * @author Lucas Nicholes <nic16020@byui.edu>
 */
public class ListMenuView extends MenuView {
    
    
    public ListMenuView(){   
    
        super("\n" +
                       "**********************************\n" +
                       "* CITY OF AARON: VIEW LIST MENU  *\n" +
                       "**********************************\n" +
                       " 1 - List the animals in the storehouse\n" +
                       " 2 - List the tools in the storehouse\n" +
                       " 3 - List the provisions in the storehouse\n" +
                       " 4 - List the authors of this game\n" +
                       " 5 - Return to the Game menu\n",
                       5);

    }
    
   
     @Override public void doAction(int option){
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
        ListView.listAnimalsView();
    }
    
    // The listTools method
    // Purpose: displays list of tools in the storehouse
    // Parameters: none
    // Returns: none
    // ===================================     
    public void listTools() {
        ListView.listToolsView();
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
