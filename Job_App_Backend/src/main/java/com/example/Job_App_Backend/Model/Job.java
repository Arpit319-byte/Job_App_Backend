package com.example.Job_App_Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Job {

    @Id
    private Long id;
    private String title;
    private String description;
    private String maxSalary;
    private String minSalary;
    private String location;

}
