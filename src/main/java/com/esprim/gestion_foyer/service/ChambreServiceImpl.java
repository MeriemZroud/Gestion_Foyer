package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Bloc;
import com.esprim.gestion_foyer.entities.Chambre;
import com.esprim.gestion_foyer.repositories.BlocRepository;
import com.esprim.gestion_foyer.repositories.ChambreRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service

public class ChambreServiceImpl implements IChambreService {
    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> findByNumeroChambreIn(List<Long> numChambre) {
        return chambreRepository.findByNumeroChambreIn(numChambre);
    }
}
