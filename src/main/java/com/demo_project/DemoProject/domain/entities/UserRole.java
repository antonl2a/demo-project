package com.demo_project.DemoProject.domain.entities;

import com.demo_project.DemoProject.domain.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRole extends BaseEntity{

    @Column(name = "role")
    @Enumerated
    private Role role;
    @ManyToOne()
    private User user;

    public UserRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
