package com.demo_project.DemoProject.domain.entities;

import jakarta.persistence.OneToOne;

public class Header extends BaseEntity {

    private Integer calories;
    private Integer protein;
    private Integer carbohydrates;
    private Integer fats;
    @OneToOne(mappedBy = "header")
    private Diary diary;
}
