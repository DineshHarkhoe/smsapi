package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Faculty;
import com.dinesh.smsapi.repositories.FacultyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FacultyController {
    private final FacultyRepository facultyRepository;

    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @GetMapping("/faculty")
    List<Faculty> all() {
        return facultyRepository.findAll();
    }

    @GetMapping("/faculty/{id}")
    Optional<Faculty> all(@PathVariable Long id) {
        return facultyRepository.findById(id);
    }

    @PostMapping("/faculty")
    Faculty newFaculty(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @PutMapping("/faculty/{id}")
    Optional<Faculty> editFacultyName(@RequestBody Faculty newFaculty, @PathVariable Long id) {
        return facultyRepository.findById(id).map(faculty -> {
            faculty.setFaculty_name(newFaculty.getFaculty_name());
            return facultyRepository.save(faculty);
        });
    }

    @DeleteMapping("/faculty/{id}")
    void deleteFaculty(@PathVariable Long id) {
        facultyRepository.deleteById(id);
    }

}
