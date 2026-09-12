package com.tomholmes.product.jobsearch.utils;

import org.springframework.stereotype.Component;

import tools.jackson.databind.json.JsonMapper;

@Component
public class JobSearchUtils
{
    public static JsonMapper getObjectMapper()
    {
        JsonMapper mapper = new JsonMapper();
        return mapper;
    }
}
