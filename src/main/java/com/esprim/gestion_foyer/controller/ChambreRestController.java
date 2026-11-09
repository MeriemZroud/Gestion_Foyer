package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.entities.Chambre;
import com.esprim.gestion_foyer.service.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Chambre")
@RestController
@RequestMapping("/chambre")
public class ChambreRestController {
    @Autowired
     private IChambreService chambreService;
    @Operation(description = "récupérer toutes les chambres de la base de données")
    // http://localhost:8085/foyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    @Operation(description = "récupérer une chambre par son id")
    // http://localhost:8085/foyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    @Operation(description = "ajouter une chambre")
    // http://localhost:8085/foyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    @Operation(description = "supprimer une chambre par son id")
    // http://localhost:8085/foyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    @Operation(description = "modifier une chambre")
    // http://localhost:8085/foyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }
}
