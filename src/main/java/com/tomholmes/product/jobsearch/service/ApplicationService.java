package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;

import java.util.List;

public interface ApplicationService {

    // CREATE

    // RETRIEVE
    List<ApplicationEntity> findAll();

    List<ApplicationEntity> findByUsername(String username);

    // UPDATE

    // DELETE - soft-delete

}
