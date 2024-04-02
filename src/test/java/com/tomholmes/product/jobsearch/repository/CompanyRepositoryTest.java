package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.utils.JobSearchUtils;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class CompanyRepositoryTest
{
    @Autowired
    private CompanyRepository repository;
    
    @Test
    public void testFindById() {
        long id = 1;
        CompanyEntity companyEntity = repository.findById(id).orElse(null);
        assertNotNull(companyEntity);
        assertEquals(id, companyEntity.getId());
    }
    
    @Test
    public void testFindById_JSON() throws JsonProcessingException {
        long id = 1;
        CompanyEntity companyEntity = repository.findById(id).orElse(null);
        assertNotNull(companyEntity);
        assertEquals(id, companyEntity.getId());
        ObjectMapper mapper = JobSearchUtils.getObjectMapper();
        String json = mapper.writeValueAsString(companyEntity);
        System.out.println(json);
    }
}
