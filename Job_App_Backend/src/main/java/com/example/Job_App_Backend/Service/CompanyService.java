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

    public boolean addCompany(Company company){
        companyRepository.save(company);
        return true;
    }

    public boolean deleteCompany(Long id){
        Optional<Company> company=companyRepository.findById(id);

        if(company.isPresent()){
            companyRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    public boolean updateCompany(Long id,Company company){
        Optional<Company> c=companyRepository.findById(id);

        if(c.isPresent()){
            c.get().setDescription(company.getDescription());
            c.get().setName(company.getName());

            return true;
        }else
            return false;

    }

}
