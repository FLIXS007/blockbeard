/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbeard;

import blockbeard.armes.Arme;

/**
 *
 * @author ddjol
 */
public class PorteMonnaiePiece {
    private int soldePiece ;

    
    public PorteMonnaiePiece() {
        this.soldePiece = 0;
    }

    
    
    public int getSoldePiece() {
        return soldePiece;
    }

    public void setSoldePiece(int soldePiece) {
        this.soldePiece = soldePiece;
    }
    

    
    public void ajouterPieceSelonScore(EnvironnementJeu jeu){
        this.soldePiece += jeu.getPieceGagnee() ;
        
    }
    
    
    
    public boolean depenserPiece(int montant){
        if (this.soldePiece - montant <0 ){
            System.err.println("Erreur, solde de pièces insuffisant !");
            return false ;
        }
        else{
            this.soldePiece -= montant ;
            return true ;
        }
    }
    
    
 
    
    public void acheterArme(Arme armeAchetee){
        if (armeAchetee.isEquipee() || !armeAchetee.isDebloque() ||!depenserPiece(armeAchetee.getPrixPiece())) {   
            System.out.println("Achat échoué !");
        }
        else{
            armeAchetee.setEquipee(true);
        }
    }

    
    
    
    
    
    
    
    
    
}
