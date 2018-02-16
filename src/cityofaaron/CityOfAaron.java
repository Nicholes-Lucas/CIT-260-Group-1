/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron;

import cityofaaron.model.ListItem;
import cityofaaron.model.Location;
import cityofaaron.model.Map;
import cityofaaron.model.Player;
import cityofaaron.model.TeamMember;
import cityofaaron.model.CropData;


/**
 *
 * @author kristinaplauche
 */
public class CityOfAaron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Player playerOne = new Player();
        playerOne.setName("Bob");
        String playerName = playerOne.getName();
        System.out.println("name" + playerName);
        
        Location locationOne = new Location();
        locationOne.setDescription ("City");
        locationOne.setSymbol ("C");
        String locationDescription = locationOne.getDescription();
        String locationSymbol = locationOne.getSymbol();
        System.out.println("description " + locationDescription + "\n" +  "symbol " + locationSymbol );
        
        Map mapOne = new Map();
        mapOne.setRowCount (2);
        mapOne.setColCount (5);
        int mapRow = mapOne.getRowCount();
        int mapCol = mapOne.getColCount();
        //int mapLocations = mapOne.getLocations(mapRow,mapCol);
        System.out.println("Row " + mapRow + "\n" + "Column " + mapCol + "\n" + "Location " + "mapLocations" );
       
        
        String nameOne = TeamMember.Kristina.getName();
        String titleOne = TeamMember.Kristina.getTitle();
        System.out.println("Name " + nameOne + "\n" + "Title " + titleOne);
        
        CropData cropOne = new CropData();
        cropOne.setCropYield (4);
        int cropCorn = cropOne.getCropYield();
        System.out.println("Crop " + cropCorn);
        
        ListItem itemOne = new ListItem();
        itemOne.setName ("shovel");
        itemOne.setNumber (7);
        String itemName = itemOne.getName();
        int itemNumber = itemOne.getNumber();
        System.out.println("Item name " + itemName +"\n" + "Item number " + itemNumber);
        
   
    
        
        
    }
    
}