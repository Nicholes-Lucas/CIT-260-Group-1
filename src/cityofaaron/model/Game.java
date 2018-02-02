/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;
import java.io.Serializable;
/**
 *
 * @author kristinaplauche
 */
public class Game implements Serializable {
    private Map theMap;
    private Player thePlayer;
    private CropData cropData;
    private TeamMember team[];
    private ListItem animals;
    private ListItem tools;
    private ListItem provisions;

    public Game() {
    }

    public Map getTheMap() {
        return theMap;
    }

    public void setTheMap(Map theMap) {
        this.theMap = theMap;
    }

    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }

    public CropData getCropData() {
        return cropData;
    }

    public void setCropData(CropData cropData) {
        this.cropData = cropData;
    }

    public TeamMember[] getTeam() {
        return team;
    }

    public void setTeam(TeamMember[] team) {
        this.team = team;
    }

    public ListItem getAnimals() {
        return animals;
    }

    public void setAnimals(ListItem animals) {
        this.animals = animals;
    }

    public ListItem getTools() {
        return tools;
    }

    public void setTools(ListItem tools) {
        this.tools = tools;
    }

    public ListItem getProvisions() {
        return provisions;
    }

    public void setProvisions(ListItem provisions) {
        this.provisions = provisions;
    }

    
    
    
}
