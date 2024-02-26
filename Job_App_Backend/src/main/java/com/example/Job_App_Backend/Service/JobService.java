package com.example.Job_App_Backend.Service;

import com.example.Job_App_Backend.Model.Job;
import com.example.Job_App_Backend.Repsoitroy.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job getJobById(Long id){
        return jobRepository.findById(id);
    }



}
