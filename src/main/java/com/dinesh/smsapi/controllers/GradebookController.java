package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Gradebook;
import com.dinesh.smsapi.repositories.GradebookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GradebookController {
    private final GradebookRepository gradebookRepository;

    public GradebookController(GradebookRepository gradebookRepository) {
        this.gradebookRepository = gradebookRepository;
    }

    @GetMapping("/gradebook")
    List<Gradebook> all() {
        return gradebookRepository.findAll();
    }

    @GetMapping("/gradebook/{id}")
    Optional<Gradebook> all(@PathVariable Long id) {
        return gradebookRepository.findById(id);
    }

    @PostMapping("/gradebook")
    Gradebook newGradebook(@RequestBody Gradebook gradebook) {
        return gradebookRepository.save(gradebook);
    }

    @PutMapping("/gradebook/{id}")
    Optional<Gradebook> editGradebookName(@RequestBody Gradebook newGradebook, @PathVariable Long id) {
        return gradebookRepository.findById(id).map(gradebook -> {
            gradebook.setDate(newGradebook.getDate());
            gradebook.setGrade(newGradebook.getGrade());
            gradebook.setStudent(newGradebook.getStudent());
            gradebook.setSubject(newGradebook.getSubject());
            return gradebookRepository.save(gradebook);
        });
    }

    @DeleteMapping("/gradebook/{id}")
    void deleteGradebook(@PathVariable Long id) {
        gradebookRepository.deleteById(id);
    }

}
