package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>
{

}
