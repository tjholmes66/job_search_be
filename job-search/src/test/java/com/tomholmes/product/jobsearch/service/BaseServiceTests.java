package com.tomholmes.product.jobsearch.service;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.jobsearch.JobSearchApplication;

@SpringBootTest(classes = JobSearchApplication.class)
@Transactional
@ComponentScan("com.tomholmes.product.jobsearch")
public class BaseServiceTests
{
}