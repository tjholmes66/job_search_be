package com.tomholmes.product.jobsearch.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.service.CompanyService;

@RestController
@RequestMapping("/v1/company")
public class CompanyController
{
    @Autowired
    private CompanyService service;
    
    @PostMapping("/create")
    public CompanyEntity createCompany(@RequestBody CompanyEntity newCompany)
    {
        CompanyEntity newEntity = service.createCompany(newCompany);
        return newEntity;
    }
    
    @PostMapping("/update")
    public CompanyEntity updateCompany(@RequestBody CompanyEntity newCompany)
    {
        CompanyEntity newEntity = service.updateCompany(newCompany);
        return newEntity;
    }
    
}