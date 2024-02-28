package com.example.Job_App_Backend.Repsoitroy;

import com.example.Job_App_Backend.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
