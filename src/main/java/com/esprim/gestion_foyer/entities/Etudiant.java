package com.esprim.gestion_foyer.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private long cin;
    private String ecole;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Reservation> reservations;
}
