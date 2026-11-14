package fr.iutlyon1.krakenbyte.blockbeard_backend.controller;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.JoueurResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.service.JoueurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joueurs")
@CrossOrigin(origins = "*")
public class JoueurController {

    private final JoueurService joueurService;

    public JoueurController(JoueurService joueurService) {
        this.joueurService = joueurService;
    }

    @GetMapping
    public List<JoueurResponse> getAllJoueurs(){
        return joueurService.getAllJoueurs();
    }

    @GetMapping("/{id}")
    public JoueurResponse getJoueurById(@PathVariable Long id){
        return joueurService.getJoueurById(id);
    }
}
