package com.tomholmes.product.jobsearch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.utils.JobSearchUtils;

public class CompanyServiceTest extends BaseServiceTests
{

    @Autowired
    private CompanyService service;
    
    @Test
    public void testFindCompanyById() {
        long id = 1;
        CompanyEntity companyEntity = service.getById(id);
        assertNotNull(companyEntity);
        assertEquals(id, companyEntity.getId());
    }
    
    @Test
    public void testCreateCompany_01() throws StreamReadException, DatabindException, IOException
    {
        String jsonCompany = "src/test/resources/json/company/company_create_01.json";
        ObjectMapper mapper = JobSearchUtils.getObjectMapper();
        File file = new File(jsonCompany);
        assertNotNull(file);
        CompanyEntity companyEntity = mapper.readValue(file, CompanyEntity.class);
        assertNotNull(companyEntity);
        companyEntity = service.createCompany(companyEntity);
        assertNotNull(companyEntity);
        System.out.println(companyEntity);
    }

}
