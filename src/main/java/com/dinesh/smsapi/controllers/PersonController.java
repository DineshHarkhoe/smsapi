package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Person;
import com.dinesh.smsapi.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    List<Person> all() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    Optional<Person> all(@PathVariable Long id) {
        return personRepository.findById(id);
    }

    @PostMapping("/person")
    Person newPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    Optional<Person> editPersonName(@RequestBody Person newPerson, @PathVariable Long id) {
        return personRepository.findById(id).map(person -> {
            person.setName(newPerson.getName());
            person.setLast_name(newPerson.getLast_name());
            person.setRole(newPerson.getRole());
            person.setStatus(newPerson.getStatus());
            return personRepository.save(person);
        });
    }

    @DeleteMapping("/person/{id}")
    void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

}
