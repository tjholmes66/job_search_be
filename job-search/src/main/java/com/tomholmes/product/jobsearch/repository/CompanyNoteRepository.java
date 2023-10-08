package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;

public interface CompanyNoteRepository extends JpaRepository<CompanyNoteEntity, Long>
{

}
