package com.demo_project.DemoProject.repositories;

import com.demo_project.DemoProject.domain.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
