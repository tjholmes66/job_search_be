package com.tomholmes.product.jobsearch.service;

import java.util.List;

import com.tomholmes.product.jobsearch.model.RoleEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;

public interface UserRoleService
{

    List<UserEntity> findUsersByRoleId(long roleId);

    List<RoleEntity> findRolesByUserId(long userId);

}
