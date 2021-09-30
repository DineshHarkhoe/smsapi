package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
