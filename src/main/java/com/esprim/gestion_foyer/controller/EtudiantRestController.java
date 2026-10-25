package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.entities.Etudiant;
import com.esprim.gestion_foyer.service.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    private IEtudiantService etudiantService;

    // http://localhost:8085/foyer/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    // http://localhost:8085/foyer/etudiant/retrieve-etudiant/1
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    // http://localhost:8085/foyer/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    // http://localhost:8085/foyer/etudiant/remove-etudiant/1
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.removeEtudiant(etudiantId);
    }

    // http://localhost:8085/foyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.modifyEtudiant(etudiant);
    }

    // http://localhost:8085/foyer/etudiant/retrieve-etudiants-by-ecole/ESPRIT
    @GetMapping("/retrieve-etudiants-by-ecole/{ecole}")
    public List<Etudiant> getEtudiantsByEcole(@PathVariable("ecole") String ecole) {
        return etudiantService.retrieveEtudiantsByEcole(ecole);
    }

    // http://localhost:8085/foyer/etudiant/retrieve-etudiants-by-date?start=2000-01-01&end=2005-12-31
    @GetMapping("/retrieve-etudiants-by-date")
    public List<Etudiant> getEtudiantsByDateNaissance(
            @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
            @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end) {
        return etudiantService.retrieveEtudiantsByDateNaissance(start, end);
    }
}
