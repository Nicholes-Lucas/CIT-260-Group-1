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
public enum TeamMember {
    
    Lucas("Lucas Nicholes", "theMagnifcent"),
    Susan("Susan Peay", "thePatient"),
    Kristina("Kristina Plauche", "theIntelligent");     
    
    private String name;
    private String title;

    TeamMember(String name, String title){
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }


    
}
