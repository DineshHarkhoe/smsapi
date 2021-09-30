package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Orientatie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orientatie_id;
    private String orientatie;

    @ManyToOne
    @JoinColumn(name = "study_id")
    Study study;

    @OneToMany(mappedBy = "orientatie")
    Set<Student> studentSet;

    public Orientatie() {
    }

    public Long orientatie_id() {
        return orientatie_id;
    }

    public void orientatie_id(Long orientatie_id) {
        this.orientatie_id = orientatie_id;
    }

    public String getOrientatie() {
        return orientatie;
    }

    public void setOrientatie(String orientatie) {
        this.orientatie = orientatie;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }
}
