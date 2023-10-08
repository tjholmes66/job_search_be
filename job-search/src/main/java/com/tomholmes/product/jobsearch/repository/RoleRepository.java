package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>
{

}
