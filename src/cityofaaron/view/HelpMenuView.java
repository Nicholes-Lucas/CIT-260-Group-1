
package cityofaaron.view;

/**
 *
 * @author kristinaplauche
 */
import java.util.Scanner;
import cityofaaron.CityOfAaron;
import cityofaaron.model.*;
import cityofaaron.view.MainMenuView;

public class HelpMenuView extends MenuView {
 
    // The HelpMenuView constructor
    // Purpose: Initialize the help menu data
    // Parameters: none
    // Returns: none
    // ===================================
    public HelpMenuView(){   
    
        super("\n" +
                       "**********************************\n" +
                       "* CITY OF AARON: HELP GAME MENU  *\n" +
                       "**********************************\n" +
                       " 1 - What are the goals of the game?\n" +
                       " 2 - Where is the city of Aaron?\n" +
                       " 3 - How do I view the map?\n" +
                       " 4 - How do I move to another location?\n" +
                       " 5 - How do I display a list of animals, provisions and tools in the city storehouse?\n" +
                       " 6 - Back to the Main Menu\n",
                6);
    }
       
    // The doAction method
    // Purpose: performs the selected action
    // Parameters: none
    // Returns: none
    // ===================================       
     @Override public void doAction(int option){
        switch(option) {
            case 1: // What are the goals of the game?
                viewGoals();
                break;
            case 2: // Where is the city of Aaron?
                viewLocation();
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
       System.out.println("\nThe goal of the game is to survive 10 years as ruler.\n" +
                          "You have to decide how much land to buy, how much land\n" +
                          "to sell, how much wheat to feed your people, and how\n" +
                          "much wheat to plant for the year.\n\n" +
                          "If too many people starve, you will be impeached.\n"
       );       
   } 
    public void viewLocation() {
        // Display the Location Text for #2 Where is the city of Aaron?.
        System.out.println("\nAccording to The Book of Mormon, the city of Aaron was\n" +
                           "located near Nephihah, though constructed earlier. Prior \n" +
                           "to the construction of Nephihah, its nearest known \n" +
                           "neighbor was Moroni.\n"
        );       
   } 
  
   public void viewMapHelp() {
        // Display the Map Help Text for #3 How do I view the map?.
        System.out.println("\nThe game menu provides an option for displaying the map."
        );
   }   
   
   public void viewMoveHelp() {
       // Display the Move Help Text for #4 how do I move to another locatiion?
       System.out.println("\nThe game menu provides an option for moving to another location."
       );
   } 
   
   public void viewListHelp() {
       // Display the List Help Text for #5 How do I display a list of animals, etc...?
       System.out.println("\nThe game menu provides an option for displaying the list\n" +
                           "of animals in the city, the list tools in the storehouse, the\n" +
                           "of other provisions in the storehouse, and the names of the\n" +
                           "developers of the game.\n"
       );
   } 
   
   public void viewMainMenu() {
       //#6 display main menu
       System.out.println("\nBack to Main Menu. ");
   }
}


