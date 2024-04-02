package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tomholmes.product.jobsearch.model.RoleEntity;

@AutoConfigureTestDatabase(replace=Replace.NONE)
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
