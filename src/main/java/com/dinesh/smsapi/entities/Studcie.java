package com.dinesh.smsapi.entities;

import javax.persistence.*;

@Entity
public class Studcie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studcie_id;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    public Studcie() {
    }

    public Long getStudcie_id() {
        return studcie_id;
    }

    public void setStudcie_id(Long studcie_id) {
        this.studcie_id = studcie_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
