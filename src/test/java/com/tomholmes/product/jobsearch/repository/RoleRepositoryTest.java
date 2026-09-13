package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.tomholmes.product.jobsearch.model.RoleEntity;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RoleRepositoryTest
{
    @Autowired
    private RoleRepository repository;
    
    @Test
    public void testFindById() {
        long id = 1;
        RoleEntity roleEntity = repository.findById(id).orElse(null);
        assertNotNull(roleEntity);
        assertEquals(id, roleEntity.getId());
    }
}
