package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "studie_orientatie")
public class Orientatie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studie_orientatie_id;
    private String orientatie_keuze;

    @ManyToOne
    @JoinColumn(name = "study_id")
    Study study;

    @OneToMany(mappedBy = "orientatie")
    Set<Student> studentSet;

    public Orientatie() {
    }

    public Long getStudie_orientatie_id() {
        return studie_orientatie_id;
    }

    public void setStudie_orientatie_id(Long studie_orientatie_id) {
        this.studie_orientatie_id = studie_orientatie_id;
    }

    public String getOrientatie_keuze() {
        return orientatie_keuze;
    }

    public void setOrientatie_keuze(String orientatie_keuze) {
        this.orientatie_keuze = orientatie_keuze;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }
}
