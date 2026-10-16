package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    @Autowired
    private UniversiteRepository universiteRepository;
}
