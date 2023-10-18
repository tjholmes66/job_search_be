package com.tomholmes.product.jobsearch.service;

import java.util.List;

import com.tomholmes.product.jobsearch.model.RoleEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.repository.UserRoleRepository;

public class UserRoleServiceImpl  implements UserRoleService
{
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserEntity> findUsersByRoleId(long roleId) {
        List<UserEntity> list = userRoleRepository.findUserByRoleId(roleId);
        return list;
    }
    
    @Override
    public List<RoleEntity> findRolesByUserId(long userId) {
        List<RoleEntity> list = userRoleRepository.findRoleByUserId(userId);
        return list;
    }

}
