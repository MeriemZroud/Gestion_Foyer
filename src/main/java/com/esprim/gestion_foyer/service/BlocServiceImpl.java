package com.esprim.gestion_foyer.service;

import com.esprim.gestion_foyer.repositories.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlocServiceImpl implements IBlocService {
    @Autowired
    private BlocRepository blocRepository;
}
