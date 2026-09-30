package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long>
{

    List<ApplicationEntity> findByUserUsername(String username);

}
