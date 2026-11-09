package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.entities.Universite;
import com.esprim.gestion_foyer.service.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Universite")
@RestController
@RequestMapping("/universite")
public class UniversiteRestController {
    @Autowired
    private IUniversiteService universiteService;

    @Operation(description = "récupérer toutes les universités de la base de données")
    // http://localhost:8085/foyer/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    @Operation(description = "récupérer une université par son id")
    // http://localhost:8085/foyer/universite/retrieve-universite/1
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    @Operation(description = "ajouter une université")
    // http://localhost:8085/foyer/universite/add-universite
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @Operation(description = "supprimer une université par son id")
    // http://localhost:8085/foyer/universite/remove-universite/1
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversite(universiteId);
    }

    @Operation(description = "modifier une université")
    // http://localhost:8085/foyer/universite/modify-universite
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return universiteService.modifyUniversite(universite);
    }
}
