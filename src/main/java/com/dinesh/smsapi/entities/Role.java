package com.dinesh.smsapi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;

    private String role;

    @OneToMany(mappedBy = "role")
    private Set<Person> personSet;

    public Role() {
    }

    /*public List<Person> getPersonSet() {
        //return personSet;
    }

    public void setPersonSet(List<Person> personSet) {
        this.personSet = personSet;
    }*/

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
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
