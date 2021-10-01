package com.dinesh.smsapi.controllers;


import com.dinesh.smsapi.entities.Student;
import com.dinesh.smsapi.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    List<Student> all() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    Optional<Student> all(@PathVariable Long id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/student")
    Student newStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/student/{id}")
    Optional<Student> editStudentName(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentRepository.findById(id).map(student -> {
            student.setStudy(newStudent.getStudy());
            student.setOrientatie(newStudent.getOrientatie());
            student.setGeslacht(newStudent.getGeslacht());
            student.setCohort(newStudent.getCohort());
            student.setStatus(newStudent.getStatus());
            student.setStudent_name(newStudent.getStudent_name());
            student.setStudent_surname(newStudent.getStudent_surname());
            return studentRepository.save(student);
        });
    }

    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

}
