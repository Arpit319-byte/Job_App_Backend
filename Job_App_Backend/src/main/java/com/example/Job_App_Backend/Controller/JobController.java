package com.example.Job_App_Backend.Controller;

import com.example.Job_App_Backend.Model.Job;
import com.example.Job_App_Backend.Service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAllJobs(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        Job job = jobService.getJobById(id);

        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


     @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job){
        boolean b=jobService.addJob(job);

        if(b)
            return new ResponseEntity<>("Successfully added the job",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to add the job",HttpStatus.OK);

     }

     @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
         boolean b=jobService.deleteJob(id);

         if(b)
             return new ResponseEntity<>("Deleted the job successfully",HttpStatus.OK);
         else
             return new ResponseEntity<>("Unable to find the job with given id", HttpStatus.OK);

     }

     @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id,@RequestBody Job job){
        boolean b=jobService.updateJob(id,job);
        if(b)
            return new ResponseEntity<>("Updated the job successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Unable to update the job with given id",HttpStatus.NOT_FOUND);
     }


}
