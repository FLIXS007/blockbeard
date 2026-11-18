/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package blockbeard.armes;

import blockbeard.Bloc;
import blockbeard.Direction;
import blockbeard.EnvironnementJeu;

/**
 *  Patron de conception Stratégie, cette interface sera implementée par toutes les classes des armes du jeu
 * qui redéfiniront la méthode attaquer()
 * @author ddjol
 */
public interface Arme {
    /*Prend en paramètre la position du joueur*/
    public void attaquer(Bloc blocADetruire, EnvironnementJeu jeu ) ;
    
}
