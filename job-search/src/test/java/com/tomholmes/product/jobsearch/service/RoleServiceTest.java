package com.tomholmes.product.jobsearch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.RoleEntity;

public class RoleServiceTest extends BaseServiceTests
{

    @Autowired
    private RoleService service;
    
    @Test
    public void testGetById() {
        long id = 1;
        RoleEntity entity = service.getById(id);
        assertNotNull(entity);
        assertEquals(id, entity.getId());
    }
    
}
