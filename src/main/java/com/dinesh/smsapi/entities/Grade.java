package com.dinesh.smsapi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long grade_id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "wetenschapper_id")
    private Wetenschapper examinator;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate exam_date;
    private Float grade;

    public Grade() {
    }

    public Wetenschapper getExaminator() {
        return examinator;
    }

    public void setExaminator(Wetenschapper examinator) {
        this.examinator = examinator;
    }

    public Long getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Long grade_id) {
        this.grade_id = grade_id;
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

    public LocalDate getExam_date() {
        return exam_date;
    }

    public void setExam_date(LocalDate exam_date) {
        this.exam_date = exam_date;
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
