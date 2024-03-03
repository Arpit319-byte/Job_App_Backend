package com.example.Job_App_Backend.Repsoitroy;

import com.example.Job_App_Backend.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
