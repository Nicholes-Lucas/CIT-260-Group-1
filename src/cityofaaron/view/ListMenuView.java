
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
                       " 5 - Save the animals list to disk\n" +
                       " 6 - Save the provisions list to disk\n" +
                       " 7 - Save the tools list to disk\n" +
                       " 8 - Return to the Game menu\n",
                       8);

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
            printAnimalsList();
        }
         else if (option == 6) {
            printProvisionsList();
        }
         else if (option == 7) {
            printToolsList();
        }
        else if (option == 8) {
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
        ListView.listProvisionsView();
    }
    
    // The listTeam method
    // Purpose: displays list of the game's authors
    // Parameters: none
    // Returns: none
    // ===================================     
    public void listTeam() {
        ListView.listGameAuthors();
    }
    
    // The printAnimalsList method
    // Purpose: prints list of animals to disk
    // Parameters: outputLocation
    // Returns: none
    // ===================================     
    public void printAnimalsList() {
        String outputLocation ;
        
        System.out.println("\n\nEnter the file location to save the list to:");
        keyboard.nextLine();
        outputLocation = keyboard.nextLine();
         
        ListView.printAnimalsList(outputLocation);
    }
    
    // The displayGameMenu method
    // Purpose: returns player back to Game menu
    // Parameters: none
    // Returns: none
    // ===================================     
    public void displayGameMenu() {
        System.out.println("\nGame Menu selected.");
    }   
    
    //author @kristinaplauche
    //The printProvisionsList method
    //Purpose: prints list of provisions to disk
    //Parameters: outputLocation
    //Returns: none
  
    
    public void printProvisionsList() {
        String outputProvisions;
        
        System.out.println("\n\nEnter the file location to save the list to:");
        keyboard.nextLine();
        outputProvisions = keyboard.nextLine();
        
        ListView.printProvisionsList(outputProvisions);
    }
    
    // printToolsList 
    // Purpose: prints list of tools to a file saved on a disk/drive
    // Parameters: outputLocation
    // Returns: none
    // @author Susan Peay   
    public void printToolsList() {
        String outputLocation ;
        
        System.out.println("\n\nEnter the file location to save the list to:");
        keyboard.nextLine();
        outputLocation = keyboard.nextLine();
         
        ListView.printToolsList(outputLocation);
    }
    
    
}
