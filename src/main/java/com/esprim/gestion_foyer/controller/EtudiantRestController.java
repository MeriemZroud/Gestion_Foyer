package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EtudiantRestController {
    @Autowired
     private IEtudiantService etudiantService;
}
