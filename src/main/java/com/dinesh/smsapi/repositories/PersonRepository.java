package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
