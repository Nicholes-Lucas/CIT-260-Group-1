
package cityofaaron.view;

import cityofaaron.control.*;
import java.util.Scanner;
import cityofaaron.CityOfAaron;

/**
 *
 * @author Susan Peay
 */

public class GameMenuView extends MenuView {
 
    
    // The GameMenuView constructor
    // Purpose: Initialize the menu data
    // Parameters: none
    // Returns: none
    // ===================================
    
       public GameMenuView(){   
    
        super("\n" +
                       "**********************************\n" +
                       "* CITY OF AARON: GAME MENU VIEW  *\n" +
                       "**********************************\n" +
                       " 1 - View the map\n" +
                       " 2 - View/Print a list\n" +
                       " 3 - Move to a new location\n" +
                       " 4 - manage the Crops\n" +
                       " 5 - Return to the Main menu\n",
        5);
  } 
       
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================  
         @Override public void doAction(int option){
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
       ListMenuView lmv = new ListMenuView();
       lmv.displayMenu();
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
        CropView.runCropsView();

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
