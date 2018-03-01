// The City of Aaron Game
// The driver file, contains the main() method
// Author: Lucas Nicholes, Susan Peay, Kristina Plauche
// Date last modified: February 2018
//-------------------------------------------------------------
package cityofaaron;

import cityofaaron.view.MainMenuView;
import cityofaaron.model.Game;

public class CityOfAaron {
    
    // variable for keeping a reference to the Game object
    private static Game theGame = null;
    
    public static Game getTheGame() {
        return theGame;
    }

    public static void setTheGame(Game theGame) {
        CityOfAaron.theGame = theGame;
    }   
    
    // main function - entry point for the program
    // runs the main menu
    public static void main(String[] args) {      
        MainMenuView mmv = new MainMenuView();
        mmv.displayMenuView();       
    }    
}