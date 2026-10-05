package com.tomholmes.product.jobsearch.repository;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;
import com.tomholmes.product.jobsearch.model.ApplicationSourceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApplicationSourceRepositoryTest extends BaseRepositoryTest
{
    @Autowired
    private ApplicationSourceRepository repository;
    
    @Test
    public void testFindById() {
        Long id = 1L;
        ApplicationSourceEntity entity = repository.findById(id).orElse(null);
        assertNotNull(entity);
        assertEquals(id, entity.getId());
    }

    @Test
    public void testFindAll() {
        List<ApplicationSourceEntity> entities = repository.findAll();
        assertNotNull(entities);
        assertEquals(6, entities.size());
    }

}
