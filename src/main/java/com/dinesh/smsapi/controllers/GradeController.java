package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Grade;
import com.dinesh.smsapi.repositories.GradeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GradeController {
    private final GradeRepository gradeRepository;

    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @GetMapping("/gradebook")
    List<Grade> all() {
        return gradeRepository.findAll();
    }

    @GetMapping("/gradebook/{id}")
    Optional<Grade> all(@PathVariable Long id) {
        return gradeRepository.findById(id);
    }

    @PostMapping("/grade")
    Grade newGradebook(@RequestBody Grade grade) {
        return gradeRepository.save(grade);
    }

    @PutMapping("/gradebook/{id}")
    Optional<Grade> editGradebookName(@RequestBody Grade newGrade, @PathVariable Long id) {
        return gradeRepository.findById(id).map(grade -> {
            grade.setExam_date(newGrade.getExam_date());
            grade.setGrade(newGrade.getGrade());
            grade.setStudent(newGrade.getStudent());
            grade.setSubject(newGrade.getSubject());
            return gradeRepository.save(grade);
        });
    }

    @DeleteMapping("/gradebook/{id}")
    void deleteGradebook(@PathVariable Long id) {
        gradeRepository.deleteById(id);
    }

}
