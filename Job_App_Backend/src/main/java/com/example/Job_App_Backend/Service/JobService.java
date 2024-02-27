package com.example.Job_App_Backend.Service;

import com.example.Job_App_Backend.Model.Job;
import com.example.Job_App_Backend.Repsoitroy.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    public Job getJobById(Long id){
        Optional<Job> b=jobRepository.findById(id);
        return b.orElse(null);
    }

    public boolean addJob(Job job){
        jobRepository.save(job);
        return true;
    }


    public boolean deleteJob(long id){

        Optional<Job> b= jobRepository.findById(id);

        if(b.isPresent()) {
            jobRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }

    public boolean updateJob(long id,Job job){

      Optional<Job> b= jobRepository.findById(id);

       if(b.isPresent()){
           Job curJob=b.get();
           curJob.setDescription(job.getDescription());
           curJob.setLocation(job.getLocation());
           curJob.setTitle(job.getTitle());
           curJob.setMaxSalary(job.getMaxSalary());
           curJob.setMinSalary(job.getMinSalary());
           jobRepository.save(curJob);
           return true;
       }else
        return false;
    }
}
