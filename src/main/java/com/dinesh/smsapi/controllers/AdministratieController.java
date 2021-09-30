package com.dinesh.smsapi.controllers;


import com.dinesh.smsapi.entities.Administratie;
import com.dinesh.smsapi.repositories.AdministratieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AdministratieController {
    private final AdministratieRepository administratieRepository;

    public AdministratieController(AdministratieRepository administratieRepository) {
        this.administratieRepository = administratieRepository;
    }

    @GetMapping("/administratie")
    List<Administratie> all() {
        return administratieRepository.findAll();
    }

    @GetMapping("/administratie/{id}")
    Optional<Administratie> all(@PathVariable Long id) {
        return administratieRepository.findById(id);
    }

    @PostMapping("/administratie")
    Administratie newAdministratie(@RequestBody Administratie administratie) {
        return administratieRepository.save(administratie);
    }

    @PutMapping("/administratie/{id}")
    Optional<Administratie> editAdministratieName(@RequestBody Administratie newAdministratie, @PathVariable Long id) {
        return administratieRepository.findById(id).map(administratie -> {
            administratie.setStatus(newAdministratie.getStatus());
            administratie.setStudy(newAdministratie.getStudy());
            administratie.setWetenschapper_naam(newAdministratie.getWetenschapper_naam());
            administratie.setWetenschapper_surname(newAdministratie.getWetenschapper_surname());
            return administratieRepository.save(administratie);
        });
    }

    @DeleteMapping("/administratie/{id}")
    void deleteAdministratie(@PathVariable Long id) {
        administratieRepository.deleteById(id);
    }

}
