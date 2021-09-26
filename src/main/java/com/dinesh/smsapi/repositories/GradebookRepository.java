package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Gradebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradebookRepository extends JpaRepository<Gradebook, Long> {
}
