package com.dinesh.smsapi.repositories;

import com.dinesh.smsapi.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
