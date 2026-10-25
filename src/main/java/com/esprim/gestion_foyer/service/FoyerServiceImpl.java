package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Foyer;
import com.esprim.gestion_foyer.repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {
    @Autowired
    private FoyerRepository foyerRepository;
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
}

