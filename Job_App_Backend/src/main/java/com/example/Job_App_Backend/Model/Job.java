package com.example.Job_App_Backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    private Long id;
    private String title;
    private String description;
    private String maxSalary;
    private String minSalary;
    private String location;

}
