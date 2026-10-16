package com.esprim.gestion_foyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {
    @Id
    private String idReservation;

    private String anneeUniversitaire;

    private boolean estValide;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;
}