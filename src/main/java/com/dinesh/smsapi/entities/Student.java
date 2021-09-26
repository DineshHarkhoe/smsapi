package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long student_id;
    private Integer cohort;
    private String adres;
    private Character geslacht;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @ManyToOne
    @JoinColumn(name = "studie_orientatie_id")
    Orientatie orientatie;

    @ManyToOne
    @JoinColumn(name = "study_id")
    Study study;

    @OneToMany(mappedBy = "student")
    private Set<Gradebook> gradebookSet;

    public Student() {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
