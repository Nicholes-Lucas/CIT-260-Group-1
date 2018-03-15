/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.control;
import java.util.ArrayList;
import cityofaaron.CityOfAaron;
import cityofaaron.view.*;
import java.util.Scanner;
import cityofaaron.model.*;
/**
 *
 * @author kristinaplauche
 */
public class GameControl {
       // size of the Locations array
   private static final int MAX_ROW = 5;
    private static final int MAX_COL = 5;
    
    // reference to a Game object
    private static Game theGame;
    
    
    public void startNewGame()
    {        
       // Show banner page
        System.out.println(
            "\n********************************************************\n" +
            "* Welcome to the City of Aaron. You have been summoned *\n" +
            "* by the High Priest to assume your role as ruler of   *\n" +
            "* the city. Your responsibility is to buy land, sell   *\n" +
            "* land, determine how much wheat to plant each year,   *\n" +
            "* and how much to set aside to feed the people. You     *\n" +
            "* will also be required to pay an annual tithe on the  *\n" +
            "* that is harvested. If you fail to provide      *\n" +
            "* enough wheat for the people to eat, people will die  *\n" +
            "* and your workforce will be diminished. Plan very     *\n" +
            "* carefully or you may find yourself in trouble with   *\n" +
            "* the people. And oh, watch out for plagues and rats!  *\n" +
            "********************************************************\n");  
          
// Get player name, create player object, and save it in the Game
        String name;
        System.out.println("\nPlease type in your first name: ");
        name = keyboard.next();
                    
        // welcome message
        System.out.println("\nWelcome " + name + ", have fun playing.");
        
        // call the createNewGame( ) method. Pass the name as a parameter
         GameControl.createNewGame(name);
        
        //show the game menu
        GameMenuView gmv = new GameMenuView();
        gmv.displayMenu();
}
    public static void createNewGame(String pName)
{
        //Create the Game object, save it in the main driver file
 theGame = new Game();
 CityOfAaron.setTheGame(theGame);
        
        // create the player object. Save it in the game object
         Player thePlayer = new Player();
        thePlayer.setName(pName);
        theGame.setThePlayer(thePlayer); 

        // create the CropData object
        
        // create the list of animals
        // create the list of tools
        //create the list of provisions
        
        // create the Locations and the Map object 
    
    }
    
    // method prologue ….
    public static void createCropDataObject()
    {
        CropData theCrops = new CropData();
        
        theCrops.setYear(0);
        theCrops.setPopulation(100);
        theCrops.setNewPeople(5);
        theCrops.setCropYield(3);
        theCrops.setNumberWhoDied(0);
        theCrops.setOffering(10);
        theCrops.setWheatInStore(2700);
        theCrops.setAcresOwned(1000);
        theCrops.setAcresPlanted(1000);
        theCrops.setHarvest(3000);
        theCrops.setOfferingBushels(300);
        theCrops.setAcresPlanted(1000); 
        
        theGame.setCropData(theCrops);         
    }
      public static void createAnimalList()
    {
        ArrayList<ListItem> animals = new ArrayList<ListItem>();
        
        animals.add(new ListItem("cows", 12));
        animals.add(new ListItem("horses", 3));
        animals.add(new ListItem("pigs", 7));
        animals.add(new ListItem("goats", 4));
       
        theGame.setAnimals(animals);
    }
         public static void createToolList()
    {
        ArrayList<ListItem> tools = new ArrayList<ListItem>();
        
        tools.add(new ListItem("hammer", 6));
        tools.add(new ListItem("shovel", 8));
        tools.add(new ListItem("rake", 9));
        tools.add(new ListItem("hoe", 12));
       
        theGame.setTools(tools);
    }
              public static void createProvisionList()
    {
        ArrayList<ListItem> provisions = new ArrayList<ListItem>();
        
        provisions.add(new ListItem("sugar", 10000));
        provisions.add(new ListItem("salted pork", 100));
        provisions.add(new ListItem("beef jerky", 1000));
        provisions.add(new ListItem("coconut cream pie", 200));
       
        theGame.setProvisions(provisions);
    }
              // The createMap method
    // Purpose: creates the location objects and the map
    // Parameters: none
    // Returns: none
    public static void createMap()   
    {
        // create the Map object, it is 5 x 5
        // refer to the Map constructor
        Map theMap = new Map(MAX_ROW, MAX_COL);
         // create a string that will go in the Location objects
// that contain the river
String river = "\nYou are on the River. The river is the source" +
                      "\nof life for our city. The river marks the eastern " +
                      "\nboundary of the city - it is wilderness to the East.";

// create a new Location object
Location loc = new Location();

// use setters in the Location class to set the description and symbol
loc.setDescription(river);
loc.setSymbol("~~~");  

// set this location object in each cell of the array in column 4      
for(int i = 0; i < MAX_ROW; i++)
 {
        theMap.setLocation(i, 4, loc);
 }
 // define the string for a farm land location
 String farmland = "\nYou are on the fertile banks of the River." +
 "\nIn the springthis low farmland floods and is covered with rich" +
 "\nnew soil. Wheat is planted as far as you can see."; 

 // set a farmland location with a hint
 loc = new Location();
 loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
 loc.setSymbol("!!!");
 theMap.setLocation(0, 2, loc);
 theGame.setTheMap(theMap);
}
     
}
