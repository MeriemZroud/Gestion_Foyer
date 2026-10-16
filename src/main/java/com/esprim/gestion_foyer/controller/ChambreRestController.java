package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.service.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChambreRestController {
    @Autowired
     private IChambreService chambreService;
}
