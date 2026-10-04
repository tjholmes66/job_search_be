package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;

import java.util.List;

public interface CompanyNoteRepository extends JpaRepository<CompanyNoteEntity, Long>
{
    List<CompanyNoteEntity> findByCompanyId(Long companyId);
}
