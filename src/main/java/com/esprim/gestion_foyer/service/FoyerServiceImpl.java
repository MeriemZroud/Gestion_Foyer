package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.repositories.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoyerServiceImpl implements IFoyerService {
    @Autowired
    private FoyerRepository foyerRepository;
}
