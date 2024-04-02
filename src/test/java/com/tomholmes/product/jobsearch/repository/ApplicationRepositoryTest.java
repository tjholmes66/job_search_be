package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.ApplicationEntity;

public class ApplicationRepositoryTest extends BaseRepositoryTest
{
    @Autowired
    private ApplicationRepository repository;
    
    @Test
    public void testFindById() {
        long id = 1;
        long userId = 1;
        long companyId = 1;
        ApplicationEntity applicationEntity = repository.findById(id).orElse(null);
        assertNotNull(applicationEntity);
        assertEquals(id, applicationEntity.getId());
        
        assertNotNull(applicationEntity.getUser().getId());
        assertEquals(userId, applicationEntity.getId());
        
        assertNotNull(applicationEntity.getCompany().getId());
        assertEquals(companyId, applicationEntity.getId());
    }

}
