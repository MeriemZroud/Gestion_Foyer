package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Etudiant;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retrieveEtudiant(Long etudiantId);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long etudiantId);
    public Etudiant modifyEtudiant(Etudiant etudiant);
    public List<Etudiant> retrieveEtudiantsByEcole(String ecole);
    public List<Etudiant> retrieveEtudiantsByDateNaissance(Date startDate, Date endDate);
}
