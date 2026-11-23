/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbeard.mouvementPersonnage;

import blockbeard.Bloc;
import blockbeard.Direction;
import blockbeard.EnvironnementJeu;
import blockbeard.Personnage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/*
------------------NOTES IMPORTANTES-------------------
Il reste la vue à implémenter. Quand la vue sera implémentée,
elle ne devra pas avoir accès aux données du modèle.

*/

/**
 *
 * @author yanis
 */
public class controleurPersonnage implements KeyListener{

    
    EnvironnementJeu environnement;

    public controleurPersonnage(EnvironnementJeu environnement) {
        this.environnement = environnement;
    }
    
    private void sautPersonnage(Personnage personnage){
        Direction directionPersonnage = personnage.getDirection();
        
        int ordonnee = personnage.getOrdonnee();
        int abscisse = personnage.getAbscisse();
        int abscisseBloc = -1;
        int nouvelleOrdonnee = ordonnee-1;
        
        if (nouvelleOrdonnee >= 0) {
            if (directionPersonnage == Direction.droite && abscisse < environnement.getNbColonnes() - 1) {
                abscisseBloc = abscisse + 1;
            } else if (directionPersonnage == Direction.gauche && abscisse > 0) {
                abscisseBloc = abscisse - 1;
            }

            if (abscisseBloc != -1) {
                Bloc bloc = environnement.getCase(abscisseBloc, ordonnee);
                ordonnee--;

                if (bloc != null && environnement.getCase(abscisseBloc, ordonnee) == null) {
                    personnage.setAbscisse(abscisseBloc);
                    personnage.setOrdonnee(ordonnee);
                }
            }
        }
        
        
        
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Personnage personnageJoueur = this.environnement.getPersonnageJoueur();
        
        int abscisse = personnageJoueur.getAbscisse();
        int ordonnee = personnageJoueur.getOrdonnee();
        switch(e.getKeyCode()){
            
            case KeyEvent.VK_SPACE:
                sautPersonnage(personnageJoueur);
                break;
                
            case KeyEvent.VK_LEFT:
                if(abscisse != 0 && environnement.getCase(abscisse-1, ordonnee) == null){
                    abscisse--;
                    personnageJoueur.setAbscisse(abscisse);
                }
                personnageJoueur.setDirection(Direction.gauche);
                break;
                
            case KeyEvent.VK_RIGHT:
                if(abscisse != environnement.getNbColonnes()-1 && environnement.getCase(abscisse+1, ordonnee) == null){
                    abscisse++;
                    personnageJoueur.setAbscisse(abscisse);
                }
                personnageJoueur.setDirection(Direction.droite);
                break ;
                
            case KeyEvent.VK_E :
                if(personnageJoueur.getDirection()== Direction.droite && personnageJoueur.getAbscisse()+1 < environnement.getNbColonnes()) {
                    personnageJoueur.getArmeEquipee().attaquer(environnement.grille[personnageJoueur.getOrdonnee()][personnageJoueur.getAbscisse()+1], environnement);
                }
                else if (personnageJoueur.getDirection()== Direction.gauche && personnageJoueur.getAbscisse()-1 >= 0 ){
                    personnageJoueur.getArmeEquipee().attaquer(environnement.grille[personnageJoueur.getOrdonnee()][personnageJoueur.getAbscisse()-1], environnement);
                }
       
                 
        }
        
        if(ordonnee != environnement.getNbLignes()-1 && environnement.getCase(abscisse, ordonnee+1) == null){
            int ordonneeDessous = ordonnee+1;
            while(ordonneeDessous != environnement.getNbLignes() && environnement.getCase(abscisse, ordonneeDessous) == null){
                ordonnee++;
                ordonneeDessous++;
            }
            personnageJoueur.setOrdonnee(ordonnee);
            //System.out.println(environnement);
        }
        
        System.out.println(environnement);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
