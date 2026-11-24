package fr.iutlyon1.krakenbyte.blockbeard_backend.service;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ClassementResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.PartieArcadeResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ScoreArcadeRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Joueur;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.PartieModeArcade;
import fr.iutlyon1.krakenbyte.blockbeard_backend.repository.JoueurRepository;
import fr.iutlyon1.krakenbyte.blockbeard_backend.repository.PartieModeArcadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArcadeService {

    private final PartieModeArcadeRepository partieModeArcadeRepository;
    private final JoueurRepository joueurRepository;

    public ArcadeService(PartieModeArcadeRepository partieModeArcadeRepository, JoueurRepository joueurRepository) {
        this.partieModeArcadeRepository = partieModeArcadeRepository;
        this.joueurRepository = joueurRepository;
    }

    private PartieArcadeResponse toPartieResponse(PartieModeArcade partie) {
        return new PartieArcadeResponse(
                partie.getIdPartieModeArcade(),
                partie.getScore(),
                partie.getDatePartie()
        );
    }

    private ClassementResponse toClassementResponse(Joueur joueur) {
        return new ClassementResponse(
                joueur.getNomJoueur(),
                joueur.getRecordArcade()
        );
    }

    @Transactional
    public PartieArcadeResponse enregistrerScore(ScoreArcadeRequest request) {
        if (request == null || request.idJoueur() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'identifiant du joueur est obligatoire.");
        }
        if (request.score() == null || request.score() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le score doit être positif ou nul.");
        }

        Joueur joueur = joueurRepository.findById(request.idJoueur())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur introuvable."));

        PartieModeArcade nouvellePartie = new PartieModeArcade(request.score());
        nouvellePartie.getJoueurs().add(joueur);
        PartieModeArcade partieSauvegardee = partieModeArcadeRepository.save(nouvellePartie);

        if (joueur.getRecordArcade() == null || request.score() > joueur.getRecordArcade()) {
            joueur.setRecordArcade(request.score());
            joueurRepository.save(joueur);
        }

        return toPartieResponse(partieSauvegardee);
    }

    public List<ClassementResponse> getClassementTop10() {
        ArrayList<ClassementResponse> listeClassement = new ArrayList<>();

        for (Joueur joueur : joueurRepository.findTop10ByOrderByRecordArcadeDesc()) {
            listeClassement.add(toClassementResponse(joueur));
        }
        return listeClassement;
    }

    public List<PartieArcadeResponse> getHistoriqueJoueur(Long idJoueur) {
        if (!joueurRepository.existsById(idJoueur)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur introuvable.");
        }

        ArrayList<PartieArcadeResponse> historique = new ArrayList<>();

        for (PartieModeArcade partie : partieModeArcadeRepository.findByJoueursIdJoueurOrderByDatePartieDesc(idJoueur)) {
            historique.add(toPartieResponse(partie));
        }
        return historique;
    }
}
