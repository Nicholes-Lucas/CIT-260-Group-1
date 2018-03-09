/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityofaaron.view;

/**
 *
 * @author kristinaplauche
 */
public interface ViewInterface
{
    public void displayMenu();
    public int getMenuOption();
    public void doAction(int option);
}
