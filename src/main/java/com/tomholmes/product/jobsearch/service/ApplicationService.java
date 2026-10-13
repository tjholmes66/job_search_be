package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;

import java.util.List;

public interface ApplicationService {

    // CREATE
    ApplicationEntity createApplication(ApplicationEntity applicationEntity);

    // RETRIEVE
    List<ApplicationEntity> findAll();

    List<ApplicationEntity> findByUsername(String username);

    ApplicationEntity getById(Long id);

    // UPDATE
    ApplicationEntity updateApplication(ApplicationEntity applicationEntity);

    // DELETE - soft-delete

}
