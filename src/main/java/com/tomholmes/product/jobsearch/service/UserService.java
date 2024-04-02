package com.tomholmes.product.jobsearch.service;

import java.util.List;

import com.tomholmes.product.jobsearch.model.UserEntity;

public interface UserService
{
    // CREATE
    UserEntity create(UserEntity userEntity);

    // RETRIEVE
    UserEntity getById(long userId);

    UserEntity getUserEntityByUsername(String username);

    List<UserEntity> getAllUserEntityList();

    UserEntity getUserByEmail(String email);

    // UPDATE
    UserEntity update(UserEntity userEntity);

}
