package com.tomholmes.product.jobsearch.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.tomholmes.product.jobsearch")
@EntityScan("com.tomholmes.product.jobsearch.model")
@EnableJpaRepositories(basePackages = "com.tomholmes.product.jobsearch.repository")
@EnableTransactionManagement
public class DatabaseConfiguration
{

}