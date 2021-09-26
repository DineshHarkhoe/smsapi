package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long faculty_id;
    private String faculty_name;

    @OneToMany(mappedBy = "faculty")
    Set<Study> studySet;

    public Faculty(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    public Faculty() {
    }

    public Long getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(Long faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getFaculty_name() {
        return faculty_name;
    }

    public void setFaculty_name(String faculty_name) {
        this.faculty_name = faculty_name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
/*
 * TODO: override functions differ with tutorial
 */
