package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Staff;
import com.dinesh.smsapi.repositories.WetenschapperRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WetenschapperController {
    private final WetenschapperRepository wetenschapperRepository;

    public WetenschapperController(WetenschapperRepository wetenschapperRepository) {
        this.wetenschapperRepository = wetenschapperRepository;
    }

    @GetMapping("/staff")
    List<Staff> all() {
        return wetenschapperRepository.findAll();
    }

    @GetMapping("/staff/{id}")
    Optional<Staff> all(@PathVariable Long id) {
        return wetenschapperRepository.findById(id);
    }

    @PostMapping("/staff")
    Staff newStaff(@RequestBody Staff staff) {
        return wetenschapperRepository.save(staff);
    }

    @PutMapping("/staff/{id}")
    Optional<Staff> editStaffName(@RequestBody Staff newStaff, @PathVariable Long id) {
        return wetenschapperRepository.findById(id).map(staff -> {
            staff.setPerson(newStaff.getPerson());
            staff.setStudy(newStaff.getStudy());
            return wetenschapperRepository.save(staff);
        });
    }

    @DeleteMapping("/staff/{id}")
    void deleteStaff(@PathVariable Long id) {
        wetenschapperRepository.deleteById(id);
    }
}

