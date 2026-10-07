package com.tomholmes.product.jobsearch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import com.tomholmes.product.jobsearch.utils.JobSearchUtils;
import tools.jackson.databind.ObjectMapper;


public class CompanyNoteServiceTest extends BaseServiceTests {

    @Autowired
    private CompanyNoteService  noteService;

    @Test
    public void testGetAllCompanyNotes()
    {
        List<CompanyNoteEntity> allCompanyNotes = noteService.getAllCompanyNotes();
        assertNotNull(allCompanyNotes);
        assertEquals(allCompanyNotes.size() > 0, true);
    }

    @Test
    public void testFindCompanyNoteById() {
        Long id = 1L;
        CompanyNoteEntity companyNoteEntity = noteService.getById(id);
        assertNotNull(companyNoteEntity);
        assertEquals(id, companyNoteEntity.getId());
    }

    @Test
    public void testCompanyNoteJson() {
        String jsonCompany = "src/test/resources/json/company/company_note_create_01.json";
        ObjectMapper mapper = JobSearchUtils.getObjectMapper();
        File file = new File(jsonCompany);
        CompanyNoteEntity companyNoteEntity = mapper.readValue(file, CompanyNoteEntity.class);
        assertNotNull(companyNoteEntity);
    }

    @Test
    public void testCreateCompanyNote()
    {
        String jsonCompany = "src/test/resources/json/company/company_note_create_01.json";
        ObjectMapper mapper = JobSearchUtils.getObjectMapper();
        File file = new File(jsonCompany);
        assertNotNull(file);
        CompanyNoteEntity companyNoteEntity = mapper.readValue(file, CompanyNoteEntity.class);
        assertNotNull(companyNoteEntity);
        companyNoteEntity = noteService.createCompanyNote(companyNoteEntity);
        assertNotNull(companyNoteEntity);
        System.out.println(companyNoteEntity);
    }

    @Test
    public void testGetCompanyNoteByCompanyId()
    {
        Long companyId = 1L;
        List<CompanyNoteEntity> noteList =  noteService.getCompanyNotesByCompanyId(companyId);
        assertNotNull(noteList);
        assertEquals(5, noteList.size());
    }
}
