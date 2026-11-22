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
public abstract class Arme {
    protected int degats ;
    protected int prixPiece, prixGemme ;
    protected boolean debloque  ;

    public Arme() {
        this.debloque = false;
    }
    

    /*Prend en paramètre la position du joueur*/
    public abstract void attaquer(Bloc blocADetruire, EnvironnementJeu jeu ) ;
    
    
    public int getPrixPiece() {
        return this.prixPiece;
    }

    public int getPrixGemme() {
        return this.prixGemme;
    }

    public void setDebloque(boolean debloque) {
        this.debloque = debloque;
    }

    
    

    public boolean isDebloque() {
        return debloque;
    }

    @Override
    public String toString() {
        return  "degats : " + degats + "\n debloque : " + debloque  ;
    }
    
    
    
    
    
    
    
    
}
