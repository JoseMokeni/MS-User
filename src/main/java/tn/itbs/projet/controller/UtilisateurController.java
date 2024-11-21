package tn.itbs.projet.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.itbs.projet.model.Utilisateur;
import tn.itbs.projet.service.UtilisateurService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/utilisateur")
@AllArgsConstructor
public class UtilisateurController {

    private UtilisateurService utilisateurService;

    @PostMapping("/ajouter")
    public ResponseEntity<String> ajouter(@RequestBody Utilisateur utilisateur){
        return utilisateurService.ajouter(utilisateur);
    }

    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<String> supprimer(@PathVariable int id){
        return utilisateurService.supprimer(id);
    }

    @PutMapping("/modifier/{id}")
    public ResponseEntity<String> modifier(@PathVariable int id, @RequestBody Utilisateur utilisateur){
        return utilisateurService.modifier(id, utilisateur);
    }

    @GetMapping("/chercher/{id}")
    public Optional<Utilisateur> chercher(@PathVariable int id){
        return utilisateurService.chercher(id);
    }
}
