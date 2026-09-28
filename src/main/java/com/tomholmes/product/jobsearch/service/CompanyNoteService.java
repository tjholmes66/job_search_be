package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;

import java.util.List;

public interface CompanyNoteService {

    // CREATE
    CompanyNoteEntity createCompanyNote(CompanyNoteEntity newEntity);

    // RETRIEVE
    List<CompanyNoteEntity> getAllCompanyNotes();

    CompanyNoteEntity getById(long id);

    // UPDATE
    CompanyNoteEntity updateCompanyNote(CompanyNoteEntity newCompanyNote);

    // DELETE
    //void deleteCompanyNote(long id);

   // void deleteCompanyNote(CompanyNoteEntity companyNote);
}
