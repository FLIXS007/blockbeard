/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbeard;

/**
 *
 * @author yanis
 */
public class Bloc {
    
    private int ptsVie, abscisse, ordonnee;
    private TypeBloc type;

    public Bloc(int abscisse, int ordonnee, TypeBloc type) {
        this.ptsVie = 100;
        this.abscisse = abscisse;
        this.ordonnee = ordonnee;
        this.type = type;
    }
       
    public int getPtsVie() {
        return ptsVie;
    }

    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    public TypeBloc getType() {
        return type;
    }

    public void setPtsVie(int ptsVie) {
        this.ptsVie = ptsVie;
    }

    public void setAbscisse(int abscisse) {
        this.abscisse = abscisse;
    }

    public void setOrdonnee(int ordonnee) {
        this.ordonnee = ordonnee;
    }

    public void setType(TypeBloc type) {
        this.type = type;
    }
    
    
    
    
    
    
}
