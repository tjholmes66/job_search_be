package com.tomholmes.product.jobsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.product.jobsearch.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
    @Query(value = "from UserEntity u where (u.email = :email)")
    UserEntity findUserByEmail(String email);

    @Query(value = "from UserEntity u where (u.username = :username)")
    UserEntity findUserEntityByUsername(String username);
}