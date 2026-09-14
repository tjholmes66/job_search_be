package com.tomholmes.product.jobsearch.utils;

import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class JobSearchUtils
{
    public static ObjectMapper getObjectMapper() 
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }
}
