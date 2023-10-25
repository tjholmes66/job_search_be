package com.tomholmes.product.jobsearch.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.repository.CompanyRepository;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService
{
    
    private CompanyRepository companyRepository;
    
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    
    @Override
    public CompanyEntity getById(long id)
    {
        CompanyEntity entity = companyRepository.findById(id).orElse(null);
        return entity;
    }
    
    @Override
    public CompanyEntity createCompany(CompanyEntity newEntity) {
        
        newEntity.setCreatedBy(1);  // default for now
        newEntity.setCreatedDate(LocalDateTime.now());
        newEntity.setUpdatedBy(1);  // default for now
        newEntity.setUpdatedDate(LocalDateTime.now());
        
        CompanyEntity entity = companyRepository.save(newEntity);
        return entity;
    }

    @Override
    public CompanyEntity updateCompany(CompanyEntity oldCompany)
    {
        oldCompany.setUpdatedBy(1);  // default for now
        oldCompany.setUpdatedDate(LocalDateTime.now());
        
        CompanyEntity entity = companyRepository.save(oldCompany);
        return entity;
    }

    @Override
    public void deleteCompany(long id)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deleteCompany(CompanyEntity company)
    {
        // TODO Auto-generated method stub
        
    }
    
    
}
