
package cityofaaron.control;

import java.util.ArrayList;
import cityofaaron.CityOfAaron;
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
    
    public static void createNewGame(String pName) {
    
        // Create the Game object, save it in the main driver file
        theGame = new Game();
        CityOfAaron.setTheGame(theGame);
        
        // create the player object. Save it in the game object
        Player thePlayer = new Player();
        thePlayer.setName(pName);
        theGame.setThePlayer(thePlayer);
        
        createCropDataObject( );
        createAnimalList( );
        createToolList( );
        createProvisionList( );
        createMap( );
    }

    // create the CropData object
    public static void createCropDataObject() {
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
    
    // create the list of animals
     public static void createAnimalList() {
        ArrayList<ListItem> animals = new ArrayList<ListItem>();
        
        animals.add(new ListItem("Cows", 12));
        animals.add(new ListItem("Horses", 3));
        animals.add(new ListItem("Pigs", 7));
        animals.add(new ListItem("Goats", 4));
       
        theGame.setAnimals(animals);
    }    
    
    // create the list of tools
    public static void createToolList() {
        ArrayList<ListItem> tools = new ArrayList<ListItem>();
        
        tools.add(new ListItem("Hammer", 146));
        tools.add(new ListItem("Saw", 578));
        tools.add(new ListItem("Axe", 292));
        tools.add(new ListItem("Spade", 309));
       
        theGame.setTools(tools);
    }
     
    //create the list of provisions
    public static void createProvisionList() {
        ArrayList<ListItem> provisions = new ArrayList<ListItem>();
        
        provisions.add(new ListItem("Sugar", 10000));
        provisions.add(new ListItem("Salted Pork", 1000));
        provisions.add(new ListItem("Beef Jerky", 1000));
        provisions.add(new ListItem("Coconut Cream Pie", 200));
       
        theGame.setProvisions(provisions);
    }   
    
    // create the Locations and the Map object 
              
    // The createMap method
    // Purpose: creates the location objects and the map
    // Parameters: none
    // Returns: none
    public static void createMap() {
        
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
        for(int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 4, loc);
        }
 
        // define the string for a farm land location
        String farmland = "\nYou are on the fertile banks of the River." +
                          "\nIn the spring this low farmland floods and is covered with rich" +
                          "\nnew soil. Wheat is planted as far as you can see."; 

        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!!");
        theMap.setLocation(0, 2, loc);
        
        theGame.setTheMap(theMap);
    }
}
