package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Orientatie;
import com.dinesh.smsapi.repositories.OrientatieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrientatieController {
    private final OrientatieRepository orientatieRepository;

    public OrientatieController(OrientatieRepository orientatieRepository) {
        this.orientatieRepository = orientatieRepository;
    }

    @GetMapping("/orientatie")
    List<Orientatie> all() {
        return orientatieRepository.findAll();
    }

    @GetMapping("/orientatie/{id}")
    Optional<Orientatie> all(@PathVariable Long id) {
        return orientatieRepository.findById(id);
    }

    @PostMapping("/orientatie")
    Orientatie newOrientatie(@RequestBody Orientatie orientatie) {
        return orientatieRepository.save(orientatie);
    }

    @PutMapping("/orientatie/{id}")
    Optional<Orientatie> editOrientatieName(@RequestBody Orientatie newOrientatie, @PathVariable Long id) {
        return orientatieRepository.findById(id).map(orientatie -> {
            orientatie.setOrientatie_keuze(newOrientatie.getOrientatie_keuze());
            orientatie.setStudy(newOrientatie.getStudy());
            return orientatieRepository.save(orientatie);
        });
    }

    @DeleteMapping("/orientatie/{id}")
    void deleteOrientatie(@PathVariable Long id) {
        orientatieRepository.deleteById(id);
    }

}
