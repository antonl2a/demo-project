package com.demo_project.DemoProject.domain.entities;

import jakarta.persistence.OneToOne;

public class Diary extends BaseEntity {

    @OneToOne(mappedBy = "diary")
    private Header header;
}
