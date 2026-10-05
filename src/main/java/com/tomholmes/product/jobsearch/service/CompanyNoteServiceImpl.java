package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import com.tomholmes.product.jobsearch.repository.CompanyNoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CompanyNoteServiceImpl implements CompanyNoteService {

    private final CompanyNoteRepository companyNoteRepository;

    public CompanyNoteServiceImpl(CompanyNoteRepository companyNoteRepository) {
        this.companyNoteRepository = companyNoteRepository;
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
    public CompanyNoteEntity createCompanyNote(CompanyNoteEntity newNote) {

        newNote.setCreatedBy(1);  // default for now
        newNote.setCreatedDate(LocalDateTime.now());
        newNote.setUpdatedBy(1);  // default for now
        newNote.setUpdatedDate(LocalDateTime.now());

        CompanyNoteEntity noteEntity = companyNoteRepository.save(newNote);
        return noteEntity;
    }

    @Override
    public CompanyNoteEntity updateCompanyNote(CompanyNoteEntity companyNote)
    {
        companyNote.setUpdatedBy(1);  // default for now
        companyNote.setUpdatedDate(LocalDateTime.now());

        CompanyNoteEntity updatedNote = companyNoteRepository.saveAndFlush(companyNote);
        return updatedNote;
    }
}
