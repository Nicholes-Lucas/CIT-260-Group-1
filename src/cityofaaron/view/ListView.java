
package cityofaaron.view;

import cityofaaron.model.*;
import cityofaaron.control.*;
import cityofaaron.CityOfAaron;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Lucas Nicholes <nic16020@byui.edu>
 */
public class ListView {
    
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
    
    // Get reference to the Game object and the Map object
    private static Game theGame = CityOfAaron.getTheGame();
    private static ArrayList<ListItem> theAnimals = theGame.getAnimals();
    
    public static void listAnimalsView() {
        
        System.out.println("\nList of Animals in Storehouse: ");
        for (int i = 0; i < theAnimals.size(); i++) {
            
            ListItem animal = theAnimals.get(i);
            System.out.println("\n\tItem: " + animal.getName() +
                               "\n\tQuantity: " + animal.getNumber());
        }        
    }    
}
