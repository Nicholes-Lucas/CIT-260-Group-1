
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
    private static ArrayList<ListItem> theTools = theGame.getTools();
    private static ArrayList<ListItem> theProvisions = theGame.getProvisions();
    
    public static void listAnimalsView() {
        
        System.out.println("\nList of Animals in Storehouse: ");
        for (int i = 0; i < theAnimals.size(); i++) {
            
            ListItem animal = theAnimals.get(i);
            System.out.println("\n\tItem: " + animal.getName() +
                               "\n\tQuantity: " + animal.getNumber());
        }        
    } 
    

    // @author Susan Peay
    public static void listToolsView() {
            
        System.out.println("\nList of Tools in Storehouse: ");
        for (int i = 0; i < theTools.size(); i++) {
            
            ListItem tools = theTools.get(i);
            System.out.println("\n\tItem: " + tools.getName() +
                               "\n\tQuantity: " + tools.getNumber());
        }        
    }
    
    //@author Kristina Plauche
        public static void listProvisionsView() {
            
        System.out.println("\nList of Provisions in Storehouse: ");
        for (int i = 0; i < theProvisions.size(); i++) {
            
            ListItem provisions = theProvisions.get(i);
            System.out.println("\n\tItem: " + provisions.getName() +
                               "\n\tQuantity: " + provisions.getNumber());
        }        
    }
    
}
