package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChambreServiceImpl implements IChambreService {
    @Autowired
    private ChambreRepository chambreRepository;
}
