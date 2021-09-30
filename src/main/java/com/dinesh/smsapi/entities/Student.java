package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long student_id;
    private String student_name;
    private String student_surname;
    private Integer cohort;
    private String adres;
    private Character geslacht;

    @ManyToOne
    @JoinColumn(name = "orientatie_id")
    Orientatie orientatie;

    @ManyToOne
    @JoinColumn(name = "study_id")
    Study study;

    @ManyToOne
    @JoinColumn(name = "status_id")
    Status status;

    @OneToMany(mappedBy = "student")
    private Set<Grade> gradeSet;

    @OneToMany(mappedBy = "student")
    private Set<Studcie> studcieSet;

    public Student() {
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public Integer getCohort() {
        return cohort;
    }

    public void setCohort(Integer cohort) {
        this.cohort = cohort;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Character getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Character geslacht) {
        this.geslacht = geslacht;
    }

    public Orientatie getOrientatie() {
        return orientatie;
    }

    public void setOrientatie(Orientatie orientatie) {
        this.orientatie = orientatie;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
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
