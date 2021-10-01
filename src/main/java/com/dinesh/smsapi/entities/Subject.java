package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subject_id;
    private String subject;
    private Integer semester;
    private Float studiepunten;

    @ManyToOne
    @JoinColumn(name = "study")
    private Study study;

    @ManyToOne
    @JoinColumn(name = "wetenschapper")
    private Wetenschapper wetenschapper;

    @OneToMany(mappedBy = "subject")
    private Set<Grade> gradeSet;

    public Subject() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Float getStudiepunten() {
        return studiepunten;
    }

    public void setStudiepunten(Float studiepunten) {
        this.studiepunten = studiepunten;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public Wetenschapper getWetenschapper() {
        return wetenschapper;
    }

    public void setWetenschapper(Wetenschapper wetenschapper) {
        this.wetenschapper = wetenschapper;
    }
}
