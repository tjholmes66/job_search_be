package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;
import com.tomholmes.product.jobsearch.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    // CREATE

    // RETRIVE

    @Override
    public List<ApplicationEntity> findAll() {
        List<ApplicationEntity>  applicationEntities = applicationRepository.findAll();
        return  applicationEntities;
    }

    @Override
    public List<ApplicationEntity> findByUsername(String username) {
        List<ApplicationEntity>  applicationEntities = applicationRepository.findByUserUsername(username);
        return  applicationEntities;
    }

    // UPDATE

    // DELETE

}
