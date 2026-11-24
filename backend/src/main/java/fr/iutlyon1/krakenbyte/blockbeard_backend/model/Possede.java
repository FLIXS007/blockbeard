package fr.iutlyon1.krakenbyte.blockbeard_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Possède\"")
public class Possede {

    @EmbeddedId
    private PossedeId id;

    @ManyToOne
    @MapsId("idPossesseur")
    @JoinColumn(name = "\"idPossesseur\"")
    private Joueur joueur;

    @ManyToOne
    @MapsId("idEquipement")
    @JoinColumn(name = "\"idEquipement\"")
    private Equipement equipement;

    @Column(name = "\"estEquipe\"")
    private Boolean estEquipe = false;

    public Possede() {
    }

    public Possede(Joueur joueur, Equipement equipement, Boolean estEquipe) {
        this.id = new PossedeId(joueur.getIdJoueur(), equipement.getIdEquipement());
        this.joueur = joueur;
        this.equipement = equipement;
        this.estEquipe = estEquipe;
    }

    public PossedeId getId() {
        return id;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Boolean getEstEquipe() {
        return estEquipe;
    }

    public void setEstEquipe(Boolean estEquipe) {
        this.estEquipe = estEquipe;
    }
}
