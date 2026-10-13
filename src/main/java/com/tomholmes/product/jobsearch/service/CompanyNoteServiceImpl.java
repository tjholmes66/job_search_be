package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.repository.CompanyNoteRepository;
import com.tomholmes.product.jobsearch.repository.UserRepository;
import com.tomholmes.product.jobsearch.utils.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyNoteServiceImpl implements CompanyNoteService {

    private final CompanyNoteRepository companyNoteRepository;
    private final UserRepository userRepository;

    public CompanyNoteServiceImpl(CompanyNoteRepository companyNoteRepository, UserRepository userRepository) {
        this.companyNoteRepository = companyNoteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<CompanyNoteEntity> getAllCompanyNotes() {
        List<CompanyNoteEntity> companyNoteyList = companyNoteRepository.findAll();
        return companyNoteyList;
    }

    @Override
    public List<CompanyNoteEntity> getCompanyNotesByCompanyId(Long companyId) {
        List<CompanyNoteEntity> companyNoteyList = companyNoteRepository.findByCompanyId(companyId);
        return companyNoteyList;
    }

    @Override
    public CompanyNoteEntity getById(long id)
    {
        CompanyNoteEntity noteEntity = companyNoteRepository.findById(id).orElse(null);
        return noteEntity;
    }

    @Override
    public CompanyNoteEntity createCompanyNote(CompanyNoteEntity newNote)
    {

        Optional<String> keycloakIdOpt = SecurityUtils.getCurrentUserKeycloakId();
        String keyCloakId = keycloakIdOpt.orElseThrow(() -> new IllegalStateException("No authenticated user"));
        Optional<UserEntity> userEntity = userRepository.findByKeycloakId(keyCloakId);
        Long userId = userEntity.get().getId();

        newNote.setCreatedBy(userId);  // default for now
        newNote.setCreatedDate(LocalDateTime.now());
        newNote.setUpdatedBy(userId);  // default for now
        newNote.setUpdatedDate(LocalDateTime.now());

        CompanyNoteEntity noteEntity = companyNoteRepository.saveAndFlush(newNote);
        return noteEntity;
    }

    @Override
    public CompanyNoteEntity updateCompanyNote(CompanyNoteEntity companyNote)
    {
        Optional<String> keycloakIdOpt = SecurityUtils.getCurrentUserKeycloakId();
        String keyCloakId = keycloakIdOpt.orElseThrow(() -> new IllegalStateException("No authenticated user"));
        Optional<UserEntity> userEntity = userRepository.findByKeycloakId(keyCloakId);
        Long userId = userEntity.get().getId();

        companyNote.setUpdatedBy(userId);  // default for now
        companyNote.setUpdatedDate(LocalDateTime.now());

        CompanyNoteEntity updatedNote = companyNoteRepository.saveAndFlush(companyNote);
        return updatedNote;
    }
}
