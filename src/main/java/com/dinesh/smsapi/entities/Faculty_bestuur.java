package com.dinesh.smsapi.entities;

import javax.persistence.*;

@Entity
public class Faculty_bestuur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long faculty_bestuur_id;

    @ManyToOne
    @JoinColumn(name = "wetenschapper")
    private Wetenschapper wetenschapper;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    public Faculty_bestuur() {
    }

    public Long getFaculty_bestuur_id() {
        return faculty_bestuur_id;
    }

    public void setFaculty_bestuur_id(Long faculty_bestuur_id) {
        this.faculty_bestuur_id = faculty_bestuur_id;
    }

    public Wetenschapper getWetenschapper() {
        return wetenschapper;
    }

    public void setWetenschapper(Wetenschapper wetenschapper) {
        this.wetenschapper = wetenschapper;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
