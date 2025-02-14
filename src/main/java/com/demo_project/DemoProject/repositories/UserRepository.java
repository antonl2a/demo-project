package com.demo_project.DemoProject.repositories;

import com.demo_project.DemoProject.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
