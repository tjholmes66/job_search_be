package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tomholmes.product.jobsearch.model.CompanyEntity;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class CompanyRepositoryTest
{
    @Autowired
    private CompanyRepository repository;
    
    @Test
    public void testFindById() {
        long id = 1;
        CompanyEntity roleEntity = repository.findById(id).orElse(null);
        assertNotNull(roleEntity);
        assertEquals(id, roleEntity.getId());
    }
}
