package com.example.Job_App_Backend.Controller;


import com.example.Job_App_Backend.Model.Review;
import com.example.Job_App_Backend.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<>(reviewService.getAllReview(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        Review r= reviewService.getReviewById(id);

        if (r!=null)
            return new ResponseEntity<>(r,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review){
        boolean b= reviewService.addReview(review);

        if(b)
            return new ResponseEntity<>("Review Added successfully ",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to add the review",HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable Long id,@RequestBody Review review){
        boolean b= reviewService.updateReview(id,review);

        if(b)
            return new ResponseEntity<>("Updated the review Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to update the review",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id){
        boolean b=reviewService.deleteReview(id);

        if(b)
            return new ResponseEntity<>("Deleted the review successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to delete the review ",HttpStatus.NOT_FOUND);
    }


}
