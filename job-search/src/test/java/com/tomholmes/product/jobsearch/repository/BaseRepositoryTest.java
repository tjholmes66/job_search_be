package com.tomholmes.product.jobsearch.repository;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.jobsearch.JobSearchApplication;

@SpringBootTest(classes = JobSearchApplication.class)
@Transactional
public class BaseRepositoryTest
{
    
}
