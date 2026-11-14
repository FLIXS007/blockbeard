package fr.iutlyon1.krakenbyte.blockbeard_backend.service;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.JoueurResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Joueur;
import fr.iutlyon1.krakenbyte.blockbeard_backend.repository.JoueurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoueurService {

    private final JoueurRepository joueurRepository;


    public JoueurService(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    private JoueurResponse toResponse(Joueur joueur){
        return new JoueurResponse(joueur.getIdJoueur(),joueur.getNomJoueur(),joueur.getPorteMonnaie(),joueur.getRecordArcade());
    }

    public List<JoueurResponse> getAllJoueurs(){

        ArrayList<JoueurResponse> listeJoueurResponse = new ArrayList<>();

        for(Joueur joueur : joueurRepository.findAll()){
            listeJoueurResponse.add(toResponse(joueur));
        }
        return listeJoueurResponse;
    }

    public JoueurResponse getJoueurById(Long id){
        return toResponse(joueurRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur introuvable")));
    }
}
