package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.ApplicationNoteEntity;

public class ApplicationNoteRepositoryTest extends BaseRepositoryTest
{
    @Autowired
    private ApplicationNoteRepository repository;
    
    @Test
    public void testFindById() {
        long id = 1;
        long applicationId = 1;
        ApplicationNoteEntity applicationNoteEntity = repository.findById(id).orElse(null);
        assertNotNull(applicationNoteEntity);
        assertEquals(id, applicationNoteEntity.getId());
        assertNotNull(applicationNoteEntity.getApplication().getId());
        assertEquals(applicationId, applicationNoteEntity.getApplication().getId());
    }
}
