package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Bloc;
import com.esprim.gestion_foyer.entities.Chambre;
import com.esprim.gestion_foyer.repositories.BlocRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {
    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private ChambreServiceImpl chambreRepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new EntityNotFoundException("Bloc not found with id: " + idBloc));
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        if (chambres.size() != new HashSet<>(numChambre).size()) {
            throw new RuntimeException("Une ou plusieurs chambres sont introuvables");
        }
        for (Chambre chambre : chambres) {
            if (chambre.getBloc() != null && chambre.getBloc().getIdBloc().equals(idBloc)) {
                throw new IllegalStateException("La chambre " + chambre.getNumeroChambre() + " est déjà affectée à un bloc");
            }
            for (Chambre c:chambres) {
                c.setBloc(bloc);
            }
        }
        return bloc;
    }


}
