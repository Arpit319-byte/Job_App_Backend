package com.example.Job_App_Backend.Controller;

import com.example.Job_App_Backend.Model.Company;
import com.example.Job_App_Backend.Repsoitroy.CompanyRepository;
import com.example.Job_App_Backend.Service.CompanyService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<Company>> getCompanyList(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company=companyService.getCompanyById(id);

        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        boolean v=companyService.addCompany(company);

        if(v)
            return new ResponseEntity<>("Company added successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to added the company to the database",HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
         boolean b=companyService.deleteCompany(id);

         if(b)
             return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);
         else
             return new ResponseEntity<>("Failed to delete the Company",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        boolean b=companyService.updateCompany(id,company);

        if(b)
            return new ResponseEntity<>("Successfully updated the Company",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to update the company",HttpStatus.NOT_FOUND);
    }

}
