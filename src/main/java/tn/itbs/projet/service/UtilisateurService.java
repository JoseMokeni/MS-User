package tn.itbs.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.itbs.projet.model.Utilisateur;
import tn.itbs.projet.repository.UtilisateurRepository;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * @param utilisateur
     * @return ResponseEntity
     */
    public ResponseEntity<String> ajouter(Utilisateur utilisateur) {
        utilisateurRepository.findById(utilisateur.getId())
                        .ifPresentOrElse(u -> {
                            throw new ResponseStatusException(HttpStatus.CONFLICT, "Utilisateur déjà existant");
                        }, () -> utilisateurRepository.save(utilisateur)
                        );
        return ResponseEntity.accepted().body("Utilisateur Ajouté");
    }

    /**
     * @param idUtilisateur
     * @return The user with id $idUtilisateur if it exists
     */
    public Optional<Utilisateur> chercher(int idUtilisateur) {
        return utilisateurRepository.findById(idUtilisateur);
    }

    /**
     * @param idUtilisateur
     */
    public ResponseEntity<String> supprimer(int idUtilisateur) {
        utilisateurRepository.findById(idUtilisateur)
                        .ifPresentOrElse(
                                (u) -> {
                                    utilisateurRepository.deleteById(idUtilisateur);
                                },
                                () -> {
                                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur inexistant");
                                }
                        );
        return ResponseEntity.ok().body("Utilisateur supprimé");

    }

    /**
     * @param id
     * @param utilisateur
     */
    public ResponseEntity<String> modifier(int id, Utilisateur utilisateur) {
        utilisateurRepository.findById(id)
                .ifPresentOrElse(
                        (u) -> {
                            u.setId(utilisateur.getId());
                            u.setNom(utilisateur.getNom());
                            u.setPrenom(utilisateur.getPrenom());
                            u.setEmail(utilisateur.getEmail());
                            u.setLogin(utilisateur.getLogin());
                            u.setMdp(utilisateur.getMdp());
                            utilisateurRepository.save(u);
                        },
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur inexistant");
                        }
                );
        return ResponseEntity.ok().body("Utilisateur modifié");
    }
}
