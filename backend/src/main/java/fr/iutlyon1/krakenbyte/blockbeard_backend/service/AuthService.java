package fr.iutlyon1.krakenbyte.blockbeard_backend.service;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ConnexionRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.InscriptionRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.JoueurResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Joueur;
import fr.iutlyon1.krakenbyte.blockbeard_backend.repository.JoueurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final JoueurRepository joueurRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    private JoueurResponse toResponse(Joueur joueur) {
        return new JoueurResponse(
                joueur.getIdJoueur(),
                joueur.getNomJoueur(),
                joueur.getPorteMonnaie(),
                joueur.getRecordArcade()
        );
    }

    public JoueurResponse inscription(InscriptionRequest request) {
        if (request.pseudo() == null || request.pseudo().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le pseudo est obligatoire.");
        }
        if (request.email() == null || request.email().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'adresse e-mail est obligatoire.");
        }
        if (request.password() == null || request.password().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le mot de passe est obligatoire.");
        }

        String pseudo = request.pseudo().trim();
        String email = request.email().trim().toLowerCase();

        if (pseudo.length() > 15) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le pseudo ne doit pas dépasser 15 caractères.");
        }
        if (!email.contains("@")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'adresse e-mail n'est pas valide.");
        }
        if (request.password().length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le mot de passe doit contenir au moins 6 caractères.");
        }

        if (joueurRepository.existsByNomJoueur(pseudo)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ce pseudo est déjà utilisé.");
        }
        if (joueurRepository.existsByMailJoueur(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cette adresse e-mail est déjà utilisée.");
        }

        Joueur joueur = new Joueur(pseudo, email);
        joueur.setMotDePasse(passwordEncoder.encode(request.password()));

        Joueur sauvegarde = joueurRepository.save(joueur);
        return toResponse(sauvegarde);
    }

    public JoueurResponse connexion(ConnexionRequest request) {
        if (request.email() == null || request.email().isBlank()
                || request.password() == null || request.password().isBlank()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe incorrect.");
        }

        String email = request.email().trim().toLowerCase();

        Joueur joueur = joueurRepository.findByMailJoueur(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Email ou mot de passe incorrect."
                ));

        if (joueur.getMotDePasse() == null || !passwordEncoder.matches(request.password(), joueur.getMotDePasse())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ou mot de passe incorrect.");
        }

        return toResponse(joueur);
    }
}
