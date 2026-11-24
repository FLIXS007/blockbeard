package fr.iutlyon1.krakenbyte.blockbeard_backend.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"PartieModeArcade\"")
public class PartieModeArcade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"idPartieModeArcade\"")
    private Long idPartieModeArcade;

    @Column(name = "\"score\"", nullable = false)
    private Long score;

    @Column(name = "\"datePartie\"")
    private OffsetDateTime datePartie;

    @ManyToMany
    @JoinTable(
            name = "\"A_joue\"",
            joinColumns = @JoinColumn(name = "\"idPartieArcade\""),
            inverseJoinColumns = @JoinColumn(name = "\"idJoueur\"")
    )
    private List<Joueur> joueurs = new ArrayList<>();

    public PartieModeArcade() {
    }

    public PartieModeArcade(Long score) {
        this.score = score;
        this.datePartie = OffsetDateTime.now();
    }

    public Long getIdPartieModeArcade() {
        return idPartieModeArcade;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public OffsetDateTime getDatePartie() {
        return datePartie;
    }

    public void setDatePartie(OffsetDateTime datePartie) {
        this.datePartie = datePartie;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
