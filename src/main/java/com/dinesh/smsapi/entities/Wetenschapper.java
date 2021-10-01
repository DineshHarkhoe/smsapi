package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Wetenschapper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wetenschapper_id;
    private String wetenschapper_naam;
    private String wetenschapper_surname;

    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "study")
    private Study study;

    @OneToMany(mappedBy = "wetenschapper")
    private Set<Subject> subjectSet;

    @OneToMany(mappedBy = "examinator")
    private Set<Grade> gradeSet;

    @OneToMany(mappedBy = "wetenschapper")
    private Set<Faculty_bestuur> faculty_bestuurSet;

    public Wetenschapper() {
    }

    public Long getWetenschapper_id() {
        return wetenschapper_id;
    }

    public void setWetenschapper_id(Long wetenschapper_id) {
        this.wetenschapper_id = wetenschapper_id;
    }

    public String getWetenschapper_naam() {
        return wetenschapper_naam;
    }

    public void setWetenschapper_naam(String wetenschapper_naam) {
        this.wetenschapper_naam = wetenschapper_naam;
    }

    public String getWetenschapper_surname() {
        return wetenschapper_surname;
    }

    public void setWetenschapper_surname(String wetenschapper_surname) {
        this.wetenschapper_surname = wetenschapper_surname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }
}
