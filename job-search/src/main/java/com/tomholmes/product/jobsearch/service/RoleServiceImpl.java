package com.tomholmes.product.jobsearch.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.jobsearch.model.RoleEntity;
import com.tomholmes.product.jobsearch.repository.RoleRepository;

@Transactional
@Service
public class RoleServiceImpl implements RoleService
{
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository)
    {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity getById(long id)
    {
        RoleEntity role = roleRepository.findById(id).orElse(null);
        return role;
    }

}