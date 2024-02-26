package com.example.Job_App_Backend.Repsoitroy;

import com.example.Job_App_Backend.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
