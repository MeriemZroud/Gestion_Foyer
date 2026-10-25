package com.esprim.gestion_foyer.controller;

import com.esprim.gestion_foyer.entities.Bloc;
import com.esprim.gestion_foyer.service.IBlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    private IBlocService blocService;

    // http://localhost:8085/foyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveAllBlocs();
    }

    // http://localhost:8085/foyer/bloc/retrieve-bloc/1
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }

    // http://localhost:8085/foyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }

    // http://localhost:8085/foyer/bloc/remove-bloc/1
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    // http://localhost:8085/foyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return blocService.modifyBloc(bloc);
    }
}
