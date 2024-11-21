package tn.itbs.projet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Utilisateur {
    @Id
    private int id;

    private String nom;

    private String prenom;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String login;

    private String mdp;

    private List<Integer> listeIdProjets = new ArrayList<Integer>();

    @Transient
    private ArrayList<Projet> projets = new ArrayList<>();
}
