package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Subject;
import com.dinesh.smsapi.repositories.SubjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubjectController {
    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/subject")
    List<Subject> all() {
        return subjectRepository.findAll();
    }

    @GetMapping("/subject/{id}")
    Optional<Subject> all(@PathVariable Long id) {
        return subjectRepository.findById(id);
    }

    @PostMapping("/subject")
    Subject newSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/subject/{id}")
    Optional<Subject> editSubjectName(@RequestBody Subject newSubject, @PathVariable Long id) {
        return subjectRepository.findById(id).map(subject -> {
            subject.setSemester(newSubject.getSemester());
            subject.setStaff(newSubject.getStaff());
            subject.setStudy(newSubject.getStudy());
            subject.setSubject_name(newSubject.getSubject_name());
            return subjectRepository.save(subject);
        });
    }

    @DeleteMapping("/subject/{id}")
    void deleteSubject(@PathVariable Long id) {
        subjectRepository.deleteById(id);
    }

}
