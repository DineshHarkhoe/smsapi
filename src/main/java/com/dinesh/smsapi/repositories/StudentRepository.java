package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
