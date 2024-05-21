package hu.temetkezes.demo.controllers;

import hu.temetkezes.demo.models.Company;
import hu.temetkezes.demo.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    public List<Company> getCompanies(){
        return companyService.getAll();
    }
}
