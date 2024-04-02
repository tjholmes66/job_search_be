package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long>
{

}
