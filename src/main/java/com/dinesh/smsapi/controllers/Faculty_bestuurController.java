package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Faculty_bestuur;
import com.dinesh.smsapi.repositories.Faculty_bestuurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Faculty_bestuurController {
    private final Faculty_bestuurRepository faculty_bestuurRepository;

    public Faculty_bestuurController(Faculty_bestuurRepository faculty_bestuurRepository) {
        this.faculty_bestuurRepository = faculty_bestuurRepository;
    }

    @GetMapping("/faculty_bestuur")
    List<Faculty_bestuur> all() {
        return faculty_bestuurRepository.findAll();
    }

    @GetMapping("/faculty_bestuur/{id}")
    Optional<Faculty_bestuur> all(@PathVariable Long id) {
        return faculty_bestuurRepository.findById(id);
    }

    @PostMapping("/faculty_bestuur")
    Faculty_bestuur newFaculty_bestuur(@RequestBody Faculty_bestuur faculty_bestuur) {
        return faculty_bestuurRepository.save(faculty_bestuur);
    }

    @PutMapping("/faculty_bestuur/{id}")
    Optional<Faculty_bestuur> editFaculty_bestuurName(@RequestBody Faculty_bestuur newFaculty_bestuur, @PathVariable Long id) {
        return faculty_bestuurRepository.findById(id).map(faculty_bestuur -> {
            faculty_bestuur.setFaculty(newFaculty_bestuur.getFaculty());
            faculty_bestuur.setRole(newFaculty_bestuur.getRole());
            faculty_bestuur.setWetenschapper(newFaculty_bestuur.getWetenschapper());
            return faculty_bestuurRepository.save(faculty_bestuur);
        });
    }

    @DeleteMapping("/faculty_bestuur/{id}")
    void deleteFaculty_bestuur(@PathVariable Long id) {
        faculty_bestuurRepository.deleteById(id);
    }

}
