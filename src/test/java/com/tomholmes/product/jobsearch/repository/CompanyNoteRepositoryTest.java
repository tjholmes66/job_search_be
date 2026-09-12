package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CompanyNoteRepositoryTest
{
    @Autowired
    private CompanyNoteRepository repository;
    
    @Test
    public void testFindById() {
        long id = 1;
        long companyId = 1;
        CompanyNoteEntity companyNoteEntity = repository.findById(id).orElse(null);
        assertNotNull(companyNoteEntity);
        assertEquals(id, companyNoteEntity.getId());
        assertNotNull(companyNoteEntity);
        assertEquals(companyId, companyNoteEntity.getCompany().getId());
    }
}
