/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blockbeard;

import blockbeard.armes.Epee;
import blockbeard.armes.Lance;

/**
 *
 * @author yanis
 */
public class Blockbeard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //TESTS
        
        /*
        EnvironnementJeu jeu = new EnvironnementJeu(4, 4);
        System.out.println(jeu);
        jeu.creerBloc();
        jeu.grille[0][0] = new Bloc(0, 0, TypeBloc.Bleu);
        System.out.println(jeu);
        jeu.chuteBloc(jeu.grille[0][0]);
        jeu.grille[2][0] = new Bloc(0, 2, TypeBloc.Rouge);
        System.out.println(jeu);
        jeu.pousserBloc(jeu.grille[3][0], Direction.droite);
        System.out.println(jeu);
        jeu.pousserBloc(jeu.grille[3][1], Direction.gauche);
        System.out.println(jeu);
        jeu.pousserBloc(jeu.grille[3][0], Direction.gauche);
        System.out.println(jeu);
        
        for(int i = 1; i<4; i++){
            jeu.grille[3][i] = new Bloc(i, 3, TypeBloc.Bleu);
        }
        for(int j = 1; j<3; j++){
            jeu.grille[j][1] = new Bloc(1, j, TypeBloc.Bleu);
        }
        jeu.grille[0][1] = new Bloc(1, 0, TypeBloc.Rouge);
        jeu.grille[1][1] = new Bloc(1, 1, TypeBloc.Rouge);
        System.out.println(jeu);
        jeu.destructionCombo(jeu.grille[3][1]);
        System.out.println(jeu);
        for(int i = 1; i<4; i++){
            jeu.grille[3][i] = new Bloc(i, 3, TypeBloc.Bleu);
        }
        for(int j = 1; j<2; j++){
            jeu.grille[j][1] = new Bloc(1, j, TypeBloc.Bleu);
        }
        System.out.println(jeu);
        
        jeu.destructionCombo(jeu.grille[3][1]);
        System.out.println(jeu);
        
        for(int j = 1; j<2; j++){
            jeu.grille[j][1] = new Bloc(1, j, TypeBloc.Bleu);
        }
        System.out.println(jeu);
        jeu.destructionCombo(jeu.grille[1][1]);
        System.out.println(jeu);
        
        */
        
        /* TEST ARMES */
        
        EnvironnementJeu jeu2 = new EnvironnementJeu(4, 4);
        System.out.println(jeu2);
        
        /*
        jeu2.grille[3][0] = new Bloc(0, 3, TypeBloc.Bleu);
        jeu2.grille[3][1] = new Bloc(1, 3, TypeBloc.Rouge);
        jeu2.grille[2][0] = new Bloc(0, 2, TypeBloc.Rouge);
        jeu2.grille[2][1] = new Bloc(1, 2, TypeBloc.Bleu);
        jeu2.grille[2][1] = new Bloc(1, 2, TypeBloc.Bleu);
        */
        
        
        
        jeu2.grille[0][0] = new Bloc(0, 0, TypeBloc.Bleu);
        jeu2.grille[1][0] = new Bloc(0, 1, TypeBloc.Bleu);
        jeu2.grille[2][0] = new Bloc(0, 2, TypeBloc.Bleu);
        jeu2.grille[3][0] = new Bloc(0, 3, TypeBloc.Bleu);
        jeu2.grille[0][1] = new Bloc(1, 0, TypeBloc.Rouge);
        jeu2.grille[1][1] = new Bloc(1, 1, TypeBloc.Rouge);
        jeu2.grille[2][1] = new Bloc(1, 2, TypeBloc.Rouge);
        jeu2.grille[3][1] = new Bloc(1, 3, TypeBloc.Rouge);
        
       
        Lance lance = new Lance();
        Epee epee = new Epee() ;
        System.out.println(jeu2);
        
        
        lance.attaquer(jeu2.grille[3][1], jeu2);   
        lance.attaquer(jeu2.grille[3][1], jeu2);  
        lance.attaquer(jeu2.grille[3][1], jeu2);  
        lance.attaquer(jeu2.grille[3][1], jeu2);  
        lance.attaquer(jeu2.grille[3][1], jeu2); 
        
        
        
        
        
        /*
        epee.attaquer(jeu2.grille[3][0], jeu2);   
        epee.attaquer(jeu2.grille[3][0], jeu2);  
        epee.attaquer(jeu2.grille[3][0], jeu2);  
        epee.attaquer(jeu2.grille[3][0], jeu2);  
        epee.attaquer(jeu2.grille[3][0], jeu2); */
        System.out.println(jeu2);

        
        
       
        
        
        
        
        
        
    }
    
}
