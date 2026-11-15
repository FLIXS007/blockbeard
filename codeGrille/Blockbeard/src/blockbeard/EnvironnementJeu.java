/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blockbeard;


/*----------------------IMPORTANT-------------------------
Certaines classes présentes ici sont accessibles par l'utilisateur. Cela est TEMPORAIRE.
Il est nécessaire de tester ces fonctions seules.
*/

/*
*Cette classe permet de créer et manipuler la grille utilisée lors d'une partie 
*ainsi que les élements qu'ils la constituent.
*
*@author ADDADI Yanis
*/
public class EnvironnementJeu {
    
    public Bloc[][] grille;
    private double delaiChute; //Cette valeur sera utile pour le mode arcade
    private int scoreActuel ; 
    int blocDetruit = 0  ; 
    
    private final int nbColonnes, nbLignes;

    /*
    *Cette méthode permet de créer la grille qui sera utilisée dans une partie
    *en fonction de nombres de colonnes et de lignes fournis
    *
    *@params nbColonnes le nombre de colonnes de la grille
    *@params nbLignes le nombre de lignes de la grille
    *@author ADDADI Yanis
    */
    public EnvironnementJeu(int nbColonnes, int nbLignes) {
        
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.grille = new Bloc[nbLignes][nbColonnes];
        
        for(int i = 0; i< nbLignes; i++){
            for(int j = 0; j < nbColonnes; j++)
                this.grille[i][j] = null;
        }

        this.delaiChute = 1.0;
        this.scoreActuel =  0;
    }
    
    /*
    *Cette méthode permet de faire tomber plusieurs blocs empilés dans une même 
    *colonne.
    *
    *@params ordonnee indice de la ligne contenant le premier bloc à faire 
    *tomber
    *@@params abscisse indice de la colonne contenant le premier bloc à faire 
    *tomber
    *
    *@author ADDADI Yanis
    */
    private void chutesConsecutives(int ordonnee, int abscisse) {
        int ordonneeCompteur = ordonnee;
        Bloc blocDessus;

        while (ordonneeCompteur >= 0) {
            blocDessus = grille[ordonneeCompteur][abscisse];
            chuteBloc(blocDessus);
            ordonneeCompteur--;
        }
    }
    
    
    /*
    *Cette méthode permet d'insérer un bloc aléatoire dans notre grille. Le bloc
    *sera forcément insérée dans le première ligne.
    *
    *@author ADDADI Yanis
    */
    public void creerBloc(){
        int ligne =  (int) (Math.random() * nbLignes);
        int choixTypeAlea =  (int) (1 + Math.random() * 4);
        TypeBloc typeAleatoire;
        
        switch(choixTypeAlea){
            case 1: typeAleatoire = TypeBloc.Bleu; break;
            case 2: typeAleatoire = TypeBloc.Jaune; break;
            case 3: typeAleatoire = TypeBloc.Rouge; break;
            default: typeAleatoire = TypeBloc.Vert;
        }
        Bloc bloc = new Bloc(ligne, 0, typeAleatoire);
        this.grille[bloc.getOrdonnee()][bloc.getAbscisse()] = bloc;
    }
    
    /*
    *Cette méthode permet de supprimer un bloc de notre grille
    *
    *@params bloc bloc à supprimer
    *
    *@author ADDADI Yanis
    */
    private void destruction(Bloc bloc){
        this.grille[bloc.getOrdonnee()][bloc.getAbscisse()] = null;
    }
    
    /*
    *Cette méthode permet de faire tomber un bloc dans une colonne
    *
    *@params bloc bloc à faire tomber
    *
    *@author ADDADI Yanis
    */
    public void chuteBloc(Bloc bloc) {
        if (bloc != null) {
            int abscisseActuelle = bloc.getAbscisse();
            int ordonneeActuelle = bloc.getOrdonnee();

            while (ordonneeActuelle != nbLignes - 1 && grille[ordonneeActuelle + 1][abscisseActuelle] == null) {
                this.destruction(bloc);
                bloc.setOrdonnee(ordonneeActuelle + 1);
                ordonneeActuelle = bloc.getOrdonnee();
                grille[ordonneeActuelle][abscisseActuelle] = bloc;
            }
        }
    }
    
    /*
    *Cette méthode permet de pousser un bloc dans une direction (gauche ou 
    *droite).
    *
    *@params bloc bloc à pousser
    *@params direction direction dans laquelle le bloc est poussée
    *
    *@author ADDADI Yanis
    */
    public void pousserBloc(Bloc bloc, Direction direction){
        int abscisseActuelle = bloc.getAbscisse();
        int ordonneeActuelle = bloc.getOrdonnee();
        
        int limite, nouvAbscisse;
        
        if(direction == Direction.droite){
            limite = nbColonnes - 1;
            nouvAbscisse = abscisseActuelle+1;
        }
        else{
            limite = 0;
            nouvAbscisse = abscisseActuelle-1;
        }

        if (abscisseActuelle != limite && grille[ordonneeActuelle][nouvAbscisse] == null) {
            this.destruction(bloc);
            this.chutesConsecutives(bloc.getOrdonnee()-1, bloc.getAbscisse());
            bloc.setAbscisse(nouvAbscisse);
            grille[ordonneeActuelle][nouvAbscisse] = bloc;
            this.chuteBloc(bloc);
        }
    }
    
    
    /*
    *Cette méthode récursive permet de détruire plusieurs blocs adjacents de 
    *même type
    *
    *@params bloc à détruire
    *
    *@author ADDADI Yanis
    */
    public void destructionConsecutive(Bloc bloc){
        int abscisseActuelle = bloc.getAbscisse();
        int ordonneeActuelle = bloc.getOrdonnee();
        TypeBloc blocActuelType = bloc.getType();
        
        this.grille[bloc.getOrdonnee()][bloc.getAbscisse()] = null;
        this.blocDetruit += 1 ;
      
        
        if(ordonneeActuelle != nbLignes-1 && grille[ordonneeActuelle+1][abscisseActuelle] != null && grille[ordonneeActuelle+1][abscisseActuelle].getType() == blocActuelType){
            destructionConsecutive(grille[ordonneeActuelle+1][abscisseActuelle]);
        }
        
        if(abscisseActuelle != 0 && grille[ordonneeActuelle][abscisseActuelle-1] != null && grille[ordonneeActuelle][abscisseActuelle-1].getType() == blocActuelType){
            destructionConsecutive(grille[ordonneeActuelle][abscisseActuelle-1]);
        }
        
        if(abscisseActuelle != nbColonnes-1 && grille[ordonneeActuelle][abscisseActuelle+1] != null && grille[ordonneeActuelle][abscisseActuelle+1].getType() == blocActuelType){
            destructionConsecutive(grille[ordonneeActuelle][abscisseActuelle+1]);
        }
        
        if(ordonneeActuelle != 0 && grille[ordonneeActuelle-1][abscisseActuelle] != null){
            Bloc blocDessus = grille[ordonneeActuelle-1][abscisseActuelle];
            
            if (blocDessus.getType() == blocActuelType)
                destructionConsecutive(blocDessus);
            else{
                chutesConsecutives(blocDessus.getOrdonnee(), abscisseActuelle);
            }
        }
    }
    

    /*
    *Cette méthode calcule et met à jour le score du joueur en fonction du nombre de bloc detruits
    *
    *@author DJOLOLO Daryl
    */
    public void miseAJourScore(){
        int pointsGagnes = 0 ;
        double multiplicateur = 1 ;
        
        if(this.blocDetruit >= 3){
            multiplicateur = this.blocDetruit * 0.5 ;
            scoreActuel += (int) (10  * blocDetruit) * multiplicateur ;
        }
        else {
            scoreActuel += (int) (10  * blocDetruit)  ;
        }
        
        this.blocDetruit = 0 ;
    } 
    
    
    /*
    *Cette méthode va détruire les blocs de même couleur et mettre à jour le score
    *
    *@author DJOLOLO Daryl
    */
    public void destructionCombo(Bloc bloc){
        destructionConsecutive(bloc);
        miseAJourScore(); 
    }
            
    
    
    
    public int getScoreActuel() {
        return scoreActuel;
    }
    
    
    
    /*
    *Cette méthode permet d'afficher la grille :
    *   N signifie que la case de la grille est vide
    *   V signifie que le bloc est de type Vert
    *   B signifie que le bloc est de type Bleu
    *   R signifie que le bloc est de type Rouge
    *   J signifie que le bloc est de type Jaune
    *
    *@author ADDADI Yanis
    */
    @Override
    public String toString(){
        String affichage = "";
        for(int i = 0; i<this.nbLignes; i++){
            for(int j = 0; j<this.nbColonnes; j++){
                if(grille[i][j] != null){ 
                    switch (grille[i][j].getType()) {
                        case Bleu:
                            affichage += "B\t";
                            break;
                        case Jaune:
                            affichage += "J\t"; 
                            break;
                        case Rouge:
                            affichage += "R\t";
                            break;
                        default:
                            affichage += "V\t";        
                    }    
                }
                else
                    affichage += "N\t";
            }
            affichage += "\n";
            
        }
        affichage += "\n";
        affichage += "Score : " + this.scoreActuel + " points !";
        affichage += "\n";
        return affichage;
    }
    
}
