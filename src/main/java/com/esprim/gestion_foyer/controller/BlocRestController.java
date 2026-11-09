package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.entities.Bloc;
import com.esprim.gestion_foyer.service.IBlocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Bloc")
@RestController
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    private IBlocService blocService;

    @Operation(description = "récupérer toutes les blocs de la base de données")
    // http://localhost:8085/foyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveAllBlocs();
    }

    @Operation(description = "récupérer un bloc par son id")
    // http://localhost:8085/foyer/bloc/retrieve-bloc/1
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }
    @Operation(description = "ajouter un bloc")
    // http://localhost:8085/foyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }

    @Operation(description = "supprimer un bloc par son id")
    // http://localhost:8085/foyer/bloc/remove-bloc/1
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    @Operation(description = "modifier un bloc")
    // http://localhost:8085/foyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return blocService.modifyBloc(bloc);
    }
}
