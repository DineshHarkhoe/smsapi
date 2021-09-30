package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Wetenschapper;
import com.dinesh.smsapi.repositories.WetenschapperRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WetenschapperController {
    private final WetenschapperRepository wetenschapperRepository;

    public WetenschapperController(WetenschapperRepository wetenschapperRepository) {
        this.wetenschapperRepository = wetenschapperRepository;
    }

    @GetMapping("/wetenschapper")
    List<Wetenschapper> all() {
        return wetenschapperRepository.findAll();
    }

    @GetMapping("/wetenschapper/{id}")
    Optional<Wetenschapper> all(@PathVariable Long id) {
        return wetenschapperRepository.findById(id);
    }

    @PostMapping("/wetenschapper")
    Wetenschapper newWetenschapper(@RequestBody Wetenschapper wetenschapper) {
        return wetenschapperRepository.save(wetenschapper);
    }

    @PutMapping("/wetenschapper/{id}")
    Optional<Wetenschapper> editWetenschapperName(@RequestBody Wetenschapper newWetenschapper, @PathVariable Long id) {
        return wetenschapperRepository.findById(id).map(wetenschapper -> {
            wetenschapper.setStatus(newWetenschapper.getStatus());
            wetenschapper.setStudy(newWetenschapper.getStudy());
            wetenschapper.setWetenschapper_naam(newWetenschapper.getWetenschapper_naam());
            wetenschapper.setWetenschapper_surname(newWetenschapper.getWetenschapper_surname());
            return wetenschapperRepository.save(wetenschapper);
        });
    }

    @DeleteMapping("/wetenschapper/{id}")
    void deleteWetenschapper(@PathVariable Long id) {
        wetenschapperRepository.deleteById(id);
    }
}

