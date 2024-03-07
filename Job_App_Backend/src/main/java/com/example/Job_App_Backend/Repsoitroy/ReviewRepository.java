package com.example.Job_App_Backend.Repsoitroy;

import com.example.Job_App_Backend.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long id);
}
