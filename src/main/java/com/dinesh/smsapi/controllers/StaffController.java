package com.dinesh.smsapi.controllers;

import com.dinesh.smsapi.entities.Staff;
import com.dinesh.smsapi.repositories.StaffRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StaffController {
    private final StaffRepository staffRepository;

    public StaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @GetMapping("/staff")
    List<Staff> all() {
        return staffRepository.findAll();
    }

    @GetMapping("/staff/{id}")
    Optional<Staff> all(@PathVariable Long id) {
        return staffRepository.findById(id);
    }

    @PostMapping("/staff")
    Staff newStaff(@RequestBody Staff staff) {
        return staffRepository.save(staff);
    }

    @PutMapping("/staff/{id}")
    Optional<Staff> editStaffName(@RequestBody Staff newStaff, @PathVariable Long id) {
        return staffRepository.findById(id).map(staff -> {
            staff.setPerson(newStaff.getPerson());
            staff.setStudy(newStaff.getStudy());
            return staffRepository.save(staff);
        });
    }

    @DeleteMapping("/staff/{id}")
    void deleteStaff(@PathVariable Long id) {
        staffRepository.deleteById(id);
    }
}

