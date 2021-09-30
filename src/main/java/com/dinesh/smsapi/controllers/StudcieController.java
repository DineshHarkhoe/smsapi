package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Studcie;
import com.dinesh.smsapi.repositories.StudcieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudcieController {
    private final StudcieRepository studcieRepository;

    public StudcieController(StudcieRepository studcieRepository) {
        this.studcieRepository = studcieRepository;
    }

    @GetMapping("/studcie")
    List<Studcie> all() {
        return studcieRepository.findAll();
    }

    @GetMapping("/studcie/{id}")
    Optional<Studcie> all(@PathVariable Long id) {
        return studcieRepository.findById(id);
    }

    @PostMapping("/studcie")
    Studcie newStudcie(@RequestBody Studcie studcie) {
        return studcieRepository.save(studcie);
    }

    @PutMapping("/studcie/{id}")
    Optional<Studcie> editStudcieName(@RequestBody Studcie newStudcie, @PathVariable Long id) {
        return studcieRepository.findById(id).map(studcie -> {
            studcie.setRole(newStudcie.getRole());
            studcie.setStudent(newStudcie.getStudent());
            return studcieRepository.save(studcie);
        });
    }

    @DeleteMapping("/studcie/{id}")
    void deleteStudcie(@PathVariable Long id) {
        studcieRepository.deleteById(id);
    }

}
