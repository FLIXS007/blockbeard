package fr.iutlyon1.krakenbyte.blockbeard_backend.service;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ActionEquipementRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.EquipementResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.InventaireItemResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Equipement;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Joueur;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.Possede;
import fr.iutlyon1.krakenbyte.blockbeard_backend.model.PossedeId;
import fr.iutlyon1.krakenbyte.blockbeard_backend.repository.EquipementRepository;
import fr.iutlyon1.krakenbyte.blockbeard_backend.repository.JoueurRepository;
import fr.iutlyon1.krakenbyte.blockbeard_backend.repository.PossedeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoutiqueService {

    private final EquipementRepository equipementRepository;
    private final PossedeRepository possedeRepository;
    private final JoueurRepository joueurRepository;

    public BoutiqueService(
            EquipementRepository equipementRepository,
            PossedeRepository possedeRepository,
            JoueurRepository joueurRepository
    ) {
        this.equipementRepository = equipementRepository;
        this.possedeRepository = possedeRepository;
        this.joueurRepository = joueurRepository;
    }

    private EquipementResponse toEquipementResponse(Equipement equipement) {
        return new EquipementResponse(
                equipement.getIdEquipement(),
                equipement.getTypeEquipement(),
                equipement.getPrixEquipementPiece(),
                equipement.getPrixEquipementGemmes(),
                equipement.getNomEquipement(),
                equipement.getDescriptionEquipement()
        );
    }

    private InventaireItemResponse toInventaireResponse(Possede possede) {
        Equipement equipement = possede.getEquipement();
        return new InventaireItemResponse(
                equipement.getIdEquipement(),
                equipement.getNomEquipement(),
                equipement.getTypeEquipement(),
                equipement.getDescriptionEquipement(),
                possede.getEstEquipe()
        );
    }

    public List<EquipementResponse> getCatalogue(String typeEquipement) {
        List<Equipement> equipements;
        if (typeEquipement == null || typeEquipement.isBlank()) {
            equipements = equipementRepository.findAll();
        } else {
            equipements = equipementRepository.findByTypeEquipement(typeEquipement.trim().toLowerCase());
        }

        ArrayList<EquipementResponse> resultat = new ArrayList<>();
        for (Equipement equipement : equipements) {
            resultat.add(toEquipementResponse(equipement));
        }
        return resultat;
    }

    public List<InventaireItemResponse> getInventaireJoueur(Long idJoueur) {
        if (!joueurRepository.existsById(idJoueur)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur introuvable.");
        }

        ArrayList<InventaireItemResponse> inventaire = new ArrayList<>();
        for (Possede possede : possedeRepository.findByIdIdPossesseur(idJoueur)) {
            inventaire.add(toInventaireResponse(possede));
        }
        return inventaire;
    }

    @Transactional
    public InventaireItemResponse acheterEquipement(ActionEquipementRequest request) {
        if (request == null || request.idJoueur() == null || request.idEquipement() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'identifiant du joueur et de l'équipement sont obligatoires.");
        }

        Joueur joueur = joueurRepository.findById(request.idJoueur())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Joueur introuvable."));

        Equipement equipement = equipementRepository.findById(request.idEquipement())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Équipement introuvable."));

        PossedeId possedeId = new PossedeId(joueur.getIdJoueur(), equipement.getIdEquipement());
        if (possedeRepository.existsById(possedeId)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Le joueur possède déjà cet équipement.");
        }

        long soldeActuel = joueur.getPorteMonnaie() != null ? joueur.getPorteMonnaie() : 0L;
        long prixPiece = equipement.getPrixEquipementPiece() != null ? equipement.getPrixEquipementPiece() : 0L;

        if (soldeActuel < prixPiece) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Solde de pièces insuffisant.");
        }

        joueur.setPorteMonnaie(soldeActuel - prixPiece);
        joueurRepository.save(joueur);

        Possede nouveauPossede = new Possede(joueur, equipement, false);
        Possede sauvegarde = possedeRepository.save(nouveauPossede);

        return toInventaireResponse(sauvegarde);
    }

    @Transactional
    public InventaireItemResponse equiperObjet(ActionEquipementRequest request) {
        if (request == null || request.idJoueur() == null || request.idEquipement() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'identifiant du joueur et de l'équipement sont obligatoires.");
        }

        PossedeId possedeId = new PossedeId(request.idJoueur(), request.idEquipement());
        Possede objetAEquiper = possedeRepository.findById(possedeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cet équipement n'est pas dans l'inventaire du joueur."));

        String typeCible = objetAEquiper.getEquipement().getTypeEquipement();

        for (Possede possede : possedeRepository.findByIdIdPossesseur(request.idJoueur())) {
            if (possede.getEquipement().getTypeEquipement().equals(typeCible) && Boolean.TRUE.equals(possede.getEstEquipe())) {
                possede.setEstEquipe(false);
                possedeRepository.save(possede);
            }
        }

        objetAEquiper.setEstEquipe(true);
        Possede sauvegarde = possedeRepository.save(objetAEquiper);

        return toInventaireResponse(sauvegarde);
    }
}
