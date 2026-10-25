package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.entities.Bloc;
import com.esprim.gestion_foyer.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {
    @Autowired
    private BlocRepository blocRepository;
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


}
