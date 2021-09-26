package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Status;
import com.dinesh.smsapi.repositories.StatusRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {
    private final StatusRepository statusRepository;

    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @GetMapping("/status")
    List<Status> all() {
        return statusRepository.findAll();
    }

    @GetMapping("/status/{id}")
    Optional<Status> all(@PathVariable Long id) {
        return statusRepository.findById(id);
    }

    @PostMapping("/status")
    Status newStatus(@RequestBody Status status) {
        return statusRepository.save(status);
    }

    @PutMapping("/status/{id}")
    Optional<Status> editStatusName(@RequestBody Status newStatus, @PathVariable Long id) {
        return statusRepository.findById(id).map(status -> {
            status.setStatus(newStatus.getStatus());
            return statusRepository.save(status);
        });
    }

    @DeleteMapping("/status/{id}")
    void deleteStatus(@PathVariable Long id) {
        statusRepository.deleteById(id);
    }

}
