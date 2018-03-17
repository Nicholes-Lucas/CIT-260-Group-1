
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
                      
        // define the string for a city location
        String city =       "\nYou are in the City of Aaron." +
                            "\nThe city is filled with people and around you are" +
                            "\na number of homes and shops. ";
        
        // define the string for a fallow field location
        String fallow =     "\nYou are in a field, but there is nothing planted" +
                            "\nhere.  These fields are either unowned or need workers" +
                            "\nto tend them.";
        
        // define the string for a farm land location
        String farmland =   "\nYou are on the fertile banks of the River." +
                            "\nIn the spring this low farmland floods and is covered with rich" +
                            "\nnew soil. Wheat is planted as far as you can see."; 
        
        // define the string for a forest location
        String forest =     "\n" +
                            "\nYou are in a forest near the city. These forests" +
                            "\nprovide essential wood for many of the cities buidings" +
                            "\nand provides heat to the city's residents during winter.";
        
        // define the string for the animal pen location
        String pens =       "\nYou are at the animal pens. The pens contain the" +
                            "\nthe city's livestock. You can find a full inventory" +
                            "\nof animals under the List Menu.";

        // create a string that will go in the Location objects
        // that contain the river
        String river =      "\nYou are on the River. The river is the source" +
                            "\nof life for our city. The river marks the eastern " +
                            "\nboundary of the city - it is wilderness to the East.";
        
        // define the string for the storehouse location
        String storage =    "\nYou are at the city's Storehouse. This is where" +
                            "\nharvested grain is saved for either planting new" +
                            "\nfields or for feeding the city's population.";
        
        // define the string for the temple location
        String temple =     "\nYou are at the city's Temple. To enter, you must" +
                            "\npay a full tithe."; 

        // create a new Location object
        Location loc = new Location();

        // use setters in the Location class to set the description and symbol
        loc.setDescription(river);
        loc.setSymbol("~~~");  

        // set this location object in each cell of the array in column 4      
        for(int i = 0; i < MAX_ROW; i++) {
            theMap.setLocation(i, 4, loc);
        }
        
        // set a city location
        loc = new Location();
        loc.setDescription(city);
        loc.setSymbol("[ ]");
        for(int i = 3; i < 5; i++) {
            
            for(int j = 1; j < 3; j++) {
                theMap.setLocation(i, j, loc);
            }
        }

        // set a fallow field location
        loc = new Location();
        loc.setDescription(fallow + "\nOne person can take care of 10 acres.");
        loc.setSymbol("...");
        for(int i = 0; i < 2; i++) {
            theMap.setLocation(2, i, loc);
        }
        theMap.setLocation(3, 0, loc);        

        // set a farmland location with a hint
        loc = new Location();
        loc.setDescription(farmland + "\nOne bushel will plant two acres of wheat.");
        loc.setSymbol("!!!");
        theMap.setLocation(0, 2, loc);
        theMap.setLocation(1, 2, loc);
        for(int i = 0; i < 4; i++) {
            theMap.setLocation(i, 3, loc);
        }        
        
        //set a forest location
        loc = new Location();
        loc.setDescription(forest);
        loc.setSymbol("TTT");
        for(int i = 0; i < 2; i++) {
            
            for(int j = 0; j < 2; j++) {
                theMap.setLocation(i, j, loc);  
            }
        }
        
        // set the animal pen location
        loc = new Location();
        loc.setDescription(pens);
        loc.setSymbol("###");
        theMap.setLocation(4, 3, loc);
        
        // set a storehouse location
        loc = new Location();
        loc.setDescription(storage);
        loc.setSymbol("HHH");
        theMap.setLocation(2, 2, loc);
        
        // set a temple location with a hint
        loc = new Location();
        loc.setDescription(temple + "\nGenerous tithes and offerings can also" +
                                    "\nbenefit the city's crop yield and help" +
                                    "\nkeep the city's wheat safe from rodents.");
        loc.setSymbol("***");
        theMap.setLocation(4, 0, loc);
        
        theGame.setTheMap(theMap);
    }
}
