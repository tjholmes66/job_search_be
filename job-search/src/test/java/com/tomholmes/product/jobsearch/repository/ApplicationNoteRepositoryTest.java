package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

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
    
    @Test
    public void testFindByApplicationId() {
        long id = 1;
        long applicationId = 1;
        List<ApplicationNoteEntity> applicationNoteList = repository.findByApplicationId(applicationId);
        assertNotNull(applicationNoteList);
        assertEquals(1, applicationNoteList.size());
        
        ApplicationNoteEntity applicationNoteEntity = applicationNoteList.get(0);
        assertNotNull(applicationNoteEntity);
        assertEquals(id, applicationNoteEntity.getId());
        assertNotNull(applicationNoteEntity.getApplication().getId());
        assertEquals(applicationId, applicationNoteEntity.getApplication().getId());
    }
    
}
