package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long faculty_id;
    private String faculty;

    @OneToMany(mappedBy = "faculty")
    Set<Study> studySet;

    @OneToMany(mappedBy = "faculty")
    Set<Faculty_bestuur> faculty_bestuuurSet;

    public Faculty() {
    }

    public Long getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(Long faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }


}
