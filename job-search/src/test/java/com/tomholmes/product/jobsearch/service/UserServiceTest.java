package com.tomholmes.product.jobsearch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.UserEntity;

public class UserServiceTest extends BaseServiceTests
{

    @Autowired
    private UserService service;
    
    @Test
    public void testGetById() {
        long id = 1;
        UserEntity userEntity = service.getById(id);
        assertNotNull(userEntity);
        assertEquals(id, userEntity.getId());
    }
    
}
