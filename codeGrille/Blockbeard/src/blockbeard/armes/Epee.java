/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbeard.armes;

import blockbeard.Bloc;
import blockbeard.Direction;
import blockbeard.EnvironnementJeu;
import blockbeard.armes.Arme;

/**
 * 
 * @author ddjol
 */
public class Epee implements Arme{
    private final int degats = 20 ;

    @Override
    public void attaquer(Bloc blocADetruire, EnvironnementJeu jeu) {
        if (blocADetruire != null) {
            blocADetruire.setPtsVie(blocADetruire.getPtsVie() - this.degats);
            if(blocADetruire.getPtsVie()<= 0){
                jeu.destructionCombo(blocADetruire) ;
            }
        }      
        
    }

  
}
