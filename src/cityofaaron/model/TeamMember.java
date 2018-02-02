/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.model;

/**
 *
 * @author kristinaplauche
 */
public enum TeamMember {
    
    Lucas("Lucas", "theMagnifcent"),
    Susan("Susan", "thePatient"),
    Kristina("Kristina", "I is Smart"); 
    
    
    
    
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
