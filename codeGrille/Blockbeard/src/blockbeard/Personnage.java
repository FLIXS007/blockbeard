/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbeard;

import blockbeard.armes.Arme;
import blockbeard.armes.Epee;

/**
 *
 * @author daryl, yanis
 */
public class Personnage {
    private Arme armeEquipee ;
    private int abscisse, ordonnee ;
    private Direction direction ;

    
    
    public Personnage() {
        this.armeEquipee = new Epee();
        this.abscisse = 0;
        this.ordonnee = 0;
        this.direction = Direction.droite ;
    }

    public Arme getArmeEquipee() {
        return armeEquipee;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public Direction getDirection() {
        return direction;
    }

    
    
    
    
    
    
    
    
    
    
    
    public void setArmeEquipee(Arme armeEquipee) {
        this.armeEquipee = armeEquipee;
    }
    
    
    
    
    
    
    
    
    public void seDeplacer(){
        
    }
    
    
}
