package com.tomholmes.product.jobsearch.repository;

import com.tomholmes.product.jobsearch.model.ApplicationSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationSourceRepository extends JpaRepository<ApplicationSourceEntity, Long>
{

}
