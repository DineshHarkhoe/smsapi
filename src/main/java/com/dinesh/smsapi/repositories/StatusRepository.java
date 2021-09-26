package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
