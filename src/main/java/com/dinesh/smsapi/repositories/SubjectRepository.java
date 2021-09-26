package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
