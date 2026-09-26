package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.utils.JobSearchUtils;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CompanyRepositoryTest
{
    @Autowired
    private CompanyRepository repository;

    @Test
    public void testGetAllCompanies() {
        List<CompanyEntity> companyEntityList = repository.findAll();
        assertNotNull(companyEntityList);
        assertEquals(2, companyEntityList.size() );
    }
    
    @Test
    public void testFindById() {
        long id = 1;
        CompanyEntity companyEntity = repository.findById(id).orElse(null);
        assertNotNull(companyEntity);
        assertEquals(id, companyEntity.getId());

        id = 2;
        companyEntity = repository.findById(id).orElse(null);
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
