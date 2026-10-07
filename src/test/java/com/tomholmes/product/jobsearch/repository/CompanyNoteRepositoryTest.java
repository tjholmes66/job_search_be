package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CompanyNoteRepositoryTest
{
    @Autowired
    private CompanyNoteRepository repository;
    
    @Test
    public void testFindById() {
        Long id = 1L;
        Long companyId = 1L;
        CompanyNoteEntity companyNoteEntity = repository.findById(id).orElse(null);
        assertNotNull(companyNoteEntity);
        assertEquals(id, companyNoteEntity.getId());
        assertNotNull(companyNoteEntity);
        assertEquals(companyId, companyNoteEntity.getCompany().getId());
    }

    @Test
    public void testFindByCompanyId() {
        Long companyId = 1L;
        List<CompanyNoteEntity> noteList = repository.findByCompanyId(companyId);
        assertNotNull(noteList);
        assertEquals(5, noteList.size());
    }
}
