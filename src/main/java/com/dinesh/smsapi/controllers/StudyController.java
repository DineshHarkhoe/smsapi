package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Study;
import com.dinesh.smsapi.repositories.StudyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudyController {
    private final StudyRepository studyRepository;

    public StudyController(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    @GetMapping("/study")
    List<Study> all() {
        return studyRepository.findAll();
    }

    @GetMapping("/study/{id}")
    Optional<Study> all(@PathVariable Long id) {
        return studyRepository.findById(id);
    }

    @PostMapping("/study")
    Study newStudy(@RequestBody Study study) {
        return studyRepository.save(study);
    }

    @PutMapping("/study/{id}")
    Optional<Study> editStudyName(@RequestBody Study newStudy, @PathVariable Long id) {
        return studyRepository.findById(id).map(study -> {
            study.setStudy_name(newStudy.getStudy_name());
            study.setFaculty(newStudy.getFaculty());
            return studyRepository.save(study);
        });
    }

    @DeleteMapping("/study/{id}")
    void deleteStudy(@PathVariable Long id) {
        studyRepository.deleteById(id);
    }
}
