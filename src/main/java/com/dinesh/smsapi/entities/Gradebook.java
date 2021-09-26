package com.dinesh.smsapi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Gradebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gradebook_id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Float grade;

    public Gradebook() {
    }

    public Long getGradebook_id() {
        return gradebook_id;
    }

    public void setGradebook_id(Long gradebook_id) {
        this.gradebook_id = gradebook_id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
