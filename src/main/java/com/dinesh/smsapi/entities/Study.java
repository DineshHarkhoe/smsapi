package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long study_id;
    private String study_name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    Faculty faculty;

    @OneToMany(mappedBy = "study")
    private Set<Staff> staffSet;

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

    public String getStudy_name() {
        return study_name;
    }

    public void setStudy_name(String study_name) {
        this.study_name = study_name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
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
