package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Role;
import com.dinesh.smsapi.repositories.RoleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoleController {
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/role")
    List<Role> all() {
        return roleRepository.findAll();
    }

    @GetMapping("/role/{id}")
    Optional<Role> all(@PathVariable Long id) {
        return roleRepository.findById(id);
    }

    @PostMapping("/role")
    Role newRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PutMapping("/role/{id}")
    Optional<Role> editRoleName(@RequestBody Role newRole, @PathVariable Long id) {
        return roleRepository.findById(id).map(role -> {
            role.setRole(newRole.getRole());
            return roleRepository.save(role);
        });
    }

    @DeleteMapping("/role/{id}")
    void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }

}
