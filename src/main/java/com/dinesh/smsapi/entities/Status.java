package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Status implements Serializable {
    @Id
    @Column(name = "status_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long status_id;
    private String status;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Administratie> administratieSet;

    @OneToMany(mappedBy = "status")
    private Set<Student> studentSet;

    @OneToMany(mappedBy = "status")
    private Set<Wetenschapper> wetenschapperSet;

    public Status() {
    }

    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Long status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
