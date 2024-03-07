package com.example.Job_App_Backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String maxSalary;
    private String minSalary;
    private String location;
    @JsonIgnore
    @OneToOne
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Company company;

}
