package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
