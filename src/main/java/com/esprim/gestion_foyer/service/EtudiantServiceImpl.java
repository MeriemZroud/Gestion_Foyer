package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Etudiant;
import com.esprim.gestion_foyer.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long etudiantId) {
        return etudiantRepository.findById(etudiantId).get();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void removeEtudiant(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> retrieveEtudiantsByEcole(String ecole) {
        return etudiantRepository.findByEcole(ecole);
    }

    @Override
    public List<Etudiant> retrieveEtudiantsByDateNaissance(Date startDate, Date endDate) {
        return etudiantRepository.findByDateNaissanceBetween(startDate, endDate);
    }
}

