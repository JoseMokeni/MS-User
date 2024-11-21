package tn.itbs.projet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;

@Data
public class Projet {
    private int id;

    private String nom;

    private String description;

    private Date dateDebut;

    private Date dateFin;

    private int id_utilisateur;

}
