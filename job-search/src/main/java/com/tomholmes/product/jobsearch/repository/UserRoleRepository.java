package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>
{

}
