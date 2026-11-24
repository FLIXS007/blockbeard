package fr.iutlyon1.krakenbyte.blockbeard_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"Équipements\"")
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idEquipement\"")
    private Long idEquipement;

    @Column(name = "\"typeEquipement\"", nullable = false)
    private String typeEquipement;

    @Column(name = "\"prixEquipementPiece\"")
    private Long prixEquipementPiece = 0L;

    @Column(name = "\"prixEquipementGemmes\"")
    private Long prixEquipementGemmes = 0L;

    @Column(name = "\"nomEquipement\"")
    private String nomEquipement;

    @Column(name = "\"descriptionEquipement\"")
    private String descriptionEquipement;

    public Equipement() {
    }

    public Equipement(String typeEquipement, Long prixEquipementPiece, Long prixEquipementGemmes, String nomEquipement, String descriptionEquipement) {
        this.typeEquipement = typeEquipement;
        this.prixEquipementPiece = prixEquipementPiece;
        this.prixEquipementGemmes = prixEquipementGemmes;
        this.nomEquipement = nomEquipement;
        this.descriptionEquipement = descriptionEquipement;
    }

    public Long getIdEquipement() {
        return idEquipement;
    }

    public String getTypeEquipement() {
        return typeEquipement;
    }

    public void setTypeEquipement(String typeEquipement) {
        this.typeEquipement = typeEquipement;
    }

    public Long getPrixEquipementPiece() {
        return prixEquipementPiece;
    }

    public void setPrixEquipementPiece(Long prixEquipementPiece) {
        this.prixEquipementPiece = prixEquipementPiece;
    }

    public Long getPrixEquipementGemmes() {
        return prixEquipementGemmes;
    }

    public void setPrixEquipementGemmes(Long prixEquipementGemmes) {
        this.prixEquipementGemmes = prixEquipementGemmes;
    }

    public String getNomEquipement() {
        return nomEquipement;
    }

    public void setNomEquipement(String nomEquipement) {
        this.nomEquipement = nomEquipement;
    }

    public String getDescriptionEquipement() {
        return descriptionEquipement;
    }

    public void setDescriptionEquipement(String descriptionEquipement) {
        this.descriptionEquipement = descriptionEquipement;
    }
}
