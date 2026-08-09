package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.CompanyEntity;

import java.util.List;

public interface CompanyService
{
    // CREATE
    CompanyEntity createCompany(CompanyEntity newEntity);

    // RETRIEVE
    List<CompanyEntity> getAllCompanies();

    CompanyEntity getById(long id);

    // UPDATE
    CompanyEntity updateCompany(CompanyEntity newCompany);

    // DELETE
    void deleteCompany(long id);
    
    void deleteCompany(CompanyEntity company);
}