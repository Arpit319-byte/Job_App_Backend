package com.example.Job_App_Backend.Service;

import com.example.Job_App_Backend.Model.Company;
import com.example.Job_App_Backend.Repsoitroy.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id){
      Optional<Company> company= companyRepository.findById(id);
        return company.orElse(null);
    }


}
