package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
