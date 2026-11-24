package fr.iutlyon1.krakenbyte.blockbeard_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilWebController {

    @GetMapping("/")
    public String redirigerVersConnexion() {
        return "redirect:/pageconnexion.html";
    }
}
