package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.ApplicationNoteEntity;

public interface ApplicationNoteRepository extends JpaRepository<ApplicationNoteEntity, Long>
{

}
