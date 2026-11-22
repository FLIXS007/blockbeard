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
public class PorteMonnaieGemme {

    private int soldeGemme;

    public PorteMonnaieGemme() {
        soldeGemme = 0;
    }

    public int getSoldeGemme() {
        return soldeGemme;
    }
    

    public boolean depenserGemmes(int montant) {
        if (this.soldeGemme - montant < 0) {
            System.err.println("Erreur, Solde Insufisant !");
            return false;
        } else {
            this.soldeGemme -= montant;
            return true;
        }
    }

    public void setSoldeGemme(int soldeGemme) {
        this.soldeGemme = soldeGemme;
    }

    

    public void ajouterGemmeSelonScore(EnvironnementJeu jeu) {
        this.soldeGemme += (int) jeu.getScoreActuel() * 0.1;
    }

    public void debloquerArme(Arme armeADebloquer) {
        if (armeADebloquer.isDebloque() || !depenserGemmes(armeADebloquer.getPrixGemme())) {
            System.out.println("Achat échoué !");
        }
        else {
            armeADebloquer.setDebloque(true);
        }
    }

}
