package com.dinesh.smsapi.entities;

import javax.persistence.*;

@Entity
public class Administratie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long admin_id;
    private String admin_name;
    private String admin_surname;

    @ManyToOne
    @JoinColumn(name = "study")
    private Study study;

    @ManyToOne
    @JoinColumn(name = "status")
    private Status status;

    public Administratie() {
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_surname() {
        return admin_surname;
    }

    public void setAdmin_surname(String admin_surname) {
        this.admin_surname = admin_surname;
    }

    public Study getStudy() {
        return study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
