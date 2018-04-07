
package cityofaaron.view;

import cityofaaron.model.*;
import cityofaaron.CityOfAaron;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Lucas Nicholes 
 */
public class ListView {
    
    // Create a Scanner object
    private static Scanner keyboard = new Scanner(System.in);   
    
    // Get reference to the Game object and the Map object
    private static Game theGame = CityOfAaron.getTheGame();
    private static ArrayList<ListItem> theAnimals = theGame.getAnimals();
    private static ArrayList<ListItem> theTools = theGame.getTools();
    private static ArrayList<ListItem> theProvisions = theGame.getProvisions();
    private static Map theMap = theGame.getTheMap();
    
    public static void listAnimalsView() {
        
        System.out.println("\nList of Animals in Storehouse: ");
        for (int i = 0; i < theAnimals.size(); i++) {
            
            ListItem animal = theAnimals.get(i);
            System.out.println("\n\tItem: " + animal.getName() +
                               "\n\tQuantity: " + animal.getNumber());
        }        
    }
    
    // @author Lucas Nicholes
    public static void printAnimalsList(String outputLocation) {
        try(PrintWriter out = new PrintWriter(outputLocation)) {
            
            out.println("\n\nList of Animals in Storehouse");
            out.printf("%n%-8s%8s","  Item  ","Quantity");
            out.printf("%n%-8s%8s","--------","--------");
            
            for (ListItem animal : theAnimals) {
                out.printf("%n%-8s%8d", animal.getName()
                                      , animal.getNumber());
            }
        }   catch (IOException ex) {
            System.out.println("Error saving animal list to file");
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
     // @author Kristina Plauche
    public static void printProvisionsList(String outputProvisions) {
        try(PrintWriter out = new PrintWriter(outputProvisions)) {
            
            out.println("\n\nList of Provisions");
            out.printf("%n%-18s%8s","  Item  ","Quantity");
            out.printf("%n%-18s%8s","------------------","--------");
            
            for (ListItem provisions : theProvisions) {
                out.printf("%n%-18s%8d", provisions.getName()
                                       , provisions.getNumber());
            }
        }   catch (Exception e) {
            System.out.println("Error saving provision list to file");
        }
    }
    
    public static void listGameAuthors() {
        
        System.out.println("\nThis game has been brought to you by: ");
        TeamMember[] authors = TeamMember.values();
        
        for (TeamMember author : authors) {
            System.out.println("\n\t" + author.getName() + ", " + author.getTitle());
        }
        
    }

    public static void showMapView() {
        
        // show stylized ASCII art map
        System.out.println("\n" +
                                 "****************************\n" +
                                 "*    CITY OF AARON: MAP    *\n" +
                                 "****************************\n" +
                                 "\n" +
                                 "  0    1    2    3    4     \n" +
                                 " +-------------------------+\n" +
                                 "0|TTTTTTTTTT !!!!!!!!! ~~~~|\n" +
                                 " |TTTTTTTTT !!!!!!!!! ~~~~ |\n" +
                                 "1|TTTT TTTT !!!!!!!!! ~~~~ |\n" +
                                 " |TTT   TTT !!!!!!!!!! ~~~~|\n" +
                                 "2|..... .... HHH !!!! ~~~~ |\n" +
                                 " |.......... HHH !!!! ~~~  |\n" +
                                 "3|..... [][][][] !!!!! ~~~ |\n" +
                                 " |..... []    [] !!!! ~~ ~ |\n" +
                                 "4|  *   []    [] #### ~~ ~~|\n" +
                                 " |***** [][][][] #### ~~~ ~|\n" +
                                 " +-------------------------+\n"        
        );
    }
    
    public static void showLocationView() {
        
        // show matrix generated map
        System.out.println("\n" +
                           "****************************\n" +
                           "*    CITY OF AARON: MAP    *\n" +
                           "****************************\n" +
                           "      0   1   2   3   4 \n" +
                           "    ---------------------");
        for (int i = 0; i < theMap.getRowCount(); i++) {
            System.out.print("  " + i + "| ");
            for (int j = 0; j < theMap.getColCount(); j++) {
                Location theLocation = theMap.getLocation(i, j);
                System.out.print(theLocation.getSymbol() + " ");
            }            
            System.out.println();
        }
        System.out.println("    ---------------------\n");
        
        // gather map coordinates to visit
        int row;
        System.out.println("\nPlease enter the row you want to visit(0 - 4): ");
        row = keyboard.nextInt();
        
        int column;
        System.out.println("\nPlease enter the column you want to visit(0 - 4): ");
        column = keyboard.nextInt();
        
        if(row < 0 || row > 4 || column < 0 || column > 4)
            System.out.format("\nError: input value must be between 0 and 4.");
        
        Location theLocation = theMap.getLocation(row, column);
        System.out.println("\nDescription: " + theLocation.getDescription() +
                           "\nSymbol: " + theLocation.getSymbol());
    }
    
    public static void showLegendView() {
        
        //show map legend
        System.out.println("\n" +
                           "[ ] - City Complex\n" + 
                           "### - Animal Pens\n" + 
                           "... - Fallow Fields\n" +
                           "!!! - Farmland\n" +
                           "TTT - Forest\n" +
                           "~~~ - River\n" +
                           "HHH - Storehouse\n" +
                           "*** - Temple\n");
    }
} 
