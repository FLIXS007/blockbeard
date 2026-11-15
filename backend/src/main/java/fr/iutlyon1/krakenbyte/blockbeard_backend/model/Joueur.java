package fr.iutlyon1.krakenbyte.blockbeard_backend.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "\"Joueur\"")

public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idJoueur\"")
    private Long idJoueur;

    @Column(name = "\"nomJoueur\"", nullable = false, unique = true, length = 15)
    private String nomJoueur;

    @Column(name = "\"mailJoueur\"", unique = true)
    private String mailJoueur;

    @Column(name = "\"porteMonnaie\"")
    private Long porteMonnaie;

    @Column(name = "\"recordArcade\"")
    private Long recordArcade;

    @Column(name = "auth_user_id", unique = true)
    private UUID authUserId;

    @Column(name = "\"motDePasse\"")
    private String motDePasse;

    public Joueur(){
    }

    public Joueur(String nomJoueur, String mailJoueur) {
        this.nomJoueur = nomJoueur;
        this.mailJoueur = mailJoueur;
        this.porteMonnaie = 0L;
        this.recordArcade = 0L;
    }

    public Long getIdJoueur() {
        return idJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public String getMailJoueur() {
        return mailJoueur;
    }

    public Long getPorteMonnaie() {
        return porteMonnaie;
    }

    public Long getRecordArcade() {
        return recordArcade;
    }

    public UUID getAuthUserId() {
        return authUserId;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public void setMailJoueur(String mailJoueur) {
        this.mailJoueur = mailJoueur;
    }

    public void setPorteMonnaie(Long porteMonnaie) {
        this.porteMonnaie = porteMonnaie;
    }

    public void setRecordArcade(Long recordArcade) {
        this.recordArcade = recordArcade;
    }

    public void setAuthUserId(UUID authUserId) {
        this.authUserId = authUserId;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
