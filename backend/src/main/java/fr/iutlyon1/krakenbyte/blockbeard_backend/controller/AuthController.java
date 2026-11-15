package fr.iutlyon1.krakenbyte.blockbeard_backend.controller;

import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.ConnexionRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.InscriptionRequest;
import fr.iutlyon1.krakenbyte.blockbeard_backend.dto.JoueurResponse;
import fr.iutlyon1.krakenbyte.blockbeard_backend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/inscription")
    @ResponseStatus(HttpStatus.CREATED)
    public JoueurResponse inscription(@RequestBody InscriptionRequest request) {
        return authService.inscription(request);
    }

    @PostMapping("/connexion")
    public JoueurResponse connexion(@RequestBody ConnexionRequest request) {
        return authService.connexion(request);
    }
}
