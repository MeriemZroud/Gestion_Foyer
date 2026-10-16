package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.service.IFoyerService;
import com.esprim.gestion_foyer.service.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UniversiteRestController {
    @Autowired
    private IUniversiteService universiteService;
}
