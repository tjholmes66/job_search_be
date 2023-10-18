package com.tomholmes.product.jobsearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tomholmes.product.jobsearch.model.RoleEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.model.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>
{
    @Query("select ure.user from UserRoleEntity ure where ure.role.id = :roleId")
    List<UserEntity> findUserByRoleId(long roleId);
    
    @Query("select ure.role from UserRoleEntity ure where ure.user.id = :userId")
    List<RoleEntity> findRoleByUserId(long userId);
}
