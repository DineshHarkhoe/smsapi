package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long study_id;
    private String study;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    Faculty faculty;

    @OneToMany(mappedBy = "study")
    private Set<Wetenschapper> wetenschapperSet;

    @OneToMany(mappedBy = "study")
    private Set<Orientatie> orientatieSet;

    @OneToMany(mappedBy = "study")
    private Set<Subject> subjectSet;

    @OneToMany(mappedBy = "study")
    private Set<Student> studentSet;

    public Study() {
    }

    public Long getStudy_id() {
        return study_id;
    }

    public void setStudy_id(Long study_id) {
        this.study_id = study_id;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
