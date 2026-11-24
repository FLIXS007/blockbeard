package fr.iutlyon1.krakenbyte.blockbeard_backend.controller;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ClassementResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.PartieArcadeResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ScoreArcadeRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.service.ArcadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arcade")
@CrossOrigin(origins = "*")
public class ArcadeController {

    private final ArcadeService arcadeService;

    public ArcadeController(ArcadeService arcadeService) {
        this.arcadeService = arcadeService;
    }

    @PostMapping("/score")
    @ResponseStatus(HttpStatus.CREATED)
    public PartieArcadeResponse enregistrerScore(@RequestBody ScoreArcadeRequest request) {
        return arcadeService.enregistrerScore(request);
    }

    @GetMapping("/classement")
    public List<ClassementResponse> getClassementTop10() {
        return arcadeService.getClassementTop10();
    }

    @GetMapping("/historique/{idJoueur}")
    public List<PartieArcadeResponse> getHistoriqueJoueur(@PathVariable Long idJoueur) {
        return arcadeService.getHistoriqueJoueur(idJoueur);
    }
}
