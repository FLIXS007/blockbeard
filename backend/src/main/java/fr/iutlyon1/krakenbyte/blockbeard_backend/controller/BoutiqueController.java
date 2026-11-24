package fr.iutlyon1.krakenbyte.blockbeard_backend.controller;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ActionEquipementRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.EquipementResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.InventaireItemResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.service.BoutiqueService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boutique")
@CrossOrigin(origins = "*")
public class BoutiqueController {

    private final BoutiqueService boutiqueService;

    public BoutiqueController(BoutiqueService boutiqueService) {
        this.boutiqueService = boutiqueService;
    }

    @GetMapping("/equipements")
    public List<EquipementResponse> getCatalogue(@RequestParam(required = false) String type) {
        return boutiqueService.getCatalogue(type);
    }

    @GetMapping("/inventaire/{idJoueur}")
    public List<InventaireItemResponse> getInventaireJoueur(@PathVariable Long idJoueur) {
        return boutiqueService.getInventaireJoueur(idJoueur);
    }

    @PostMapping("/acheter")
    @ResponseStatus(HttpStatus.CREATED)
    public InventaireItemResponse acheterEquipement(@RequestBody ActionEquipementRequest request) {
        return boutiqueService.acheterEquipement(request);
    }

    @PutMapping("/equiper")
    public InventaireItemResponse equiperObjet(@RequestBody ActionEquipementRequest request) {
        return boutiqueService.equiperObjet(request);
    }
}
