package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Bloc;
import com.esprim.gestion_foyer.entities.Foyer;
import com.esprim.gestion_foyer.entities.Universite;
import com.esprim.gestion_foyer.repositories.BlocRepository;
import com.esprim.gestion_foyer.repositories.FoyerRepository;
import com.esprim.gestion_foyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {
    @Autowired
    private FoyerRepository foyerRepository;
    @Autowired
    private UniversiteRepository universiteRepository;
    @Autowired
    private BlocRepository blocRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).get();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        // Vérifier si l'université existe;
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée avec l'ID: " + idUniversite));

        // Vérifier si l'université a déjà un foyer associé
        if (universite.getFoyer() != null) {
            throw new IllegalStateException("L'université " + idUniversite + " a déjà un foyer associé.");
        }
        if (foyer.getBlocs()!=null) {
            foyer.getBlocs().forEach(bloc -> bloc.setFoyer(foyer));
        }


         Foyer saveFoyer =foyerRepository.save(foyer);
        universiteRepository.saveFoyer(saveFoyer);
        return saveFoyer;
    }
}

