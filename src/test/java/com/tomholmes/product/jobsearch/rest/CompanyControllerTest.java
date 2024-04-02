package com.tomholmes.product.jobsearch.rest;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomholmes.product.jobsearch.model.CompanyEntity;

public class CompanyControllerTest extends BaseControllerTests
{
    private final static String BASE_URL = "/v1/company";
    private final static String CREATE_URL = "/create";
    
    ObjectMapper mapper = makeMapper();
    
    @Test
    public void testMockCreateAccount() throws Exception
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).defaultRequest(post(CREATE_URL)).build();

        String filename = "src/test/resources/json/company/company_create_01.json";
        File file = new File(filename);
        assertNotNull(file);

        // Step 1 can we create a Company entity from this json
        CompanyEntity companyEntity = mapper.readValue(file, CompanyEntity.class);
        assertNotNull(companyEntity);

        String json = mapper.writeValueAsString(companyEntity);
        companyEntity = mapper.readValue(json, CompanyEntity.class);
        assertNotNull(companyEntity);

        // this removes the 'springSecurityFilterChain' because this URL has no security
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(BASE_URL + CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(json);

        this.mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
    }

    
}
