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

    
    
    public Personnage(int abscisse, int ordonnee) {
        this.armeEquipee = new Epee();
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
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

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void setArmeEquipee(Arme armeEquipee) {
        this.armeEquipee = armeEquipee;
    }
}
