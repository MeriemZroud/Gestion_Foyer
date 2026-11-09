package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Foyer;
import com.esprim.gestion_foyer.entities.Universite;
import com.esprim.gestion_foyer.repositories.FoyerRepository;
import com.esprim.gestion_foyer.repositories.UniversiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private FoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long universiteId) {
        return universiteRepository.findById(universiteId).get();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public void removeUniversite(Long universiteId) {
        universiteRepository.deleteById(universiteId);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Transactional
    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(()->new RuntimeException("Foyer not found with id: " + idFoyer));
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite).orElseThrow(()->new RuntimeException("Universite not found with name: " + nomUniversite));
        //verifier si l association existe deja
        if (foyer.getUniversite() != null) {
            throw new IllegalStateException("Le foyer" + idFoyer + " est déjà associé à une université.");
        }
        if (universite.getFoyer() != null) {
            throw new IllegalStateException("L'universite" + nomUniversite + "a deja un foyer");
        }

        universite.setFoyer(foyer);
        foyer.setUniversite(universite);
        return universite;
    }
}
