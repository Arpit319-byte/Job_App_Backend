package com.example.Job_App_Backend.Service;

import com.example.Job_App_Backend.Model.Review;
import com.example.Job_App_Backend.Repsoitroy.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReview(){
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id){
        Optional<Review> review= reviewRepository.findById(id);

        return review.orElse(null);
    }

    public Boolean addReview(Review review){
           reviewRepository.save(review);
           return true;
    }

    public Boolean updateReview(Long id, Review review){
        Optional<Review> r =reviewRepository.findById(id);

        if(r.isPresent()){
            r.get().setDescription(review.getDescription());
            r.get().setTitle(review.getTitle());
            r.get().setRating(review.getRating());
            reviewRepository.save(r.get());
            return true;
        }else
            return false;
    }

    public Boolean deleteReview(Long id){
        Optional<Review> r=reviewRepository.findById(id);

        if(r.isPresent()){
            reviewRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
