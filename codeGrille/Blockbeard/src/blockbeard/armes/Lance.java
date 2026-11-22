/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbeard.armes;

import blockbeard.Bloc;
import blockbeard.Direction;
import blockbeard.EnvironnementJeu;
import blockbeard.TypeBloc;

/**
 *La lance inflige des dégats aux 2 prochais blocs dans la direction du joueur
 * @author ddjol
 */
public class Lance extends Arme {
    private Direction dir = Direction.gauche;
    
    public Lance() {
        super();
        degats = 20 ; 
        this.prixPiece = 250 ;
        this.prixGemme = 00 ;
         
    }
    
    

    @Override
    public void attaquer(Bloc blocADetruire, EnvironnementJeu jeu) {
        if (blocADetruire != null) {
            int derriere = 1;    
            if (this.dir == Direction.gauche) {
                derriere = -1;
            }
            int abscisseDerriere = blocADetruire.getAbscisse() + derriere ;
            int ordonneeDerriere = blocADetruire.getOrdonnee() ;
            
            //Les 2 blocs se détruisent L'UN APRES L'AUTRE pas en même temps
            blocADetruire.setPtsVie(blocADetruire.getPtsVie() - this.degats);
            if (blocADetruire.getPtsVie() <= 0) {
                jeu.destructionCombo(blocADetruire ) ;              
            }
            
            //On vérifie que le bloc derrière est bien dans la grille
            if (abscisseDerriere >= 0 && abscisseDerriere < jeu.grille[0].length) {
                Bloc blocDerriere = jeu.grille[ordonneeDerriere][abscisseDerriere];        
                if (blocDerriere != null) {
                    blocDerriere.setPtsVie(blocDerriere.getPtsVie() - this.degats);
                    
                    if (blocDerriere.getPtsVie() <= 0) {
                        jeu.destructionCombo(blocDerriere ) ;
                    }
                }

            }

        }

    }
    

}
