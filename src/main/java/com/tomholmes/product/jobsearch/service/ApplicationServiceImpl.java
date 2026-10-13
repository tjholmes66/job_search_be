package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;
import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.repository.ApplicationRepository;
import com.tomholmes.product.jobsearch.repository.UserRepository;
import com.tomholmes.product.jobsearch.utils.SecurityUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository,
                   UserRepository userRepository)
    {
        this.applicationRepository = applicationRepository;
        this.userRepository = userRepository;
    }

    // CREATE

    @Override
    public ApplicationEntity createApplication(ApplicationEntity applicationEntity)
    {
        String keyCloakId = String.valueOf(SecurityUtils.getCurrentUserKeycloakId());
        Optional<UserEntity> userEntity = userRepository.findByKeycloakId(keyCloakId);
        Long userId = userEntity.get().getId();

        applicationEntity.setCreatedBy(userId);  // default for now
        applicationEntity.setCreatedDate(LocalDateTime.now());
        applicationEntity.setUpdatedBy(userId);  // default for now
        applicationEntity.setUpdatedDate(LocalDateTime.now());

        ApplicationEntity newApplicationEntity = applicationRepository.saveAndFlush(applicationEntity);
        return newApplicationEntity;
    }

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

    @Override
    public ApplicationEntity getById(Long id) {
        ApplicationEntity  applicationEntity = applicationRepository.findById(id).orElse(null);
        return  applicationEntity;
    }

    // UPDATE

    @Override
    public ApplicationEntity updateApplication(ApplicationEntity applicationEntity)
    {
        return null;
    }

    // DELETE

}
