package com.tomholmes.product.jobsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.ApplicationNoteEntity;

public interface ApplicationNoteRepository extends JpaRepository<ApplicationNoteEntity, Long>
{
     List<ApplicationNoteEntity> findByApplicationId(long applicationId);
}
