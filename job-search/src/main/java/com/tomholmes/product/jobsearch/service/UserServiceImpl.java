package com.tomholmes.product.jobsearch.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.repository.UserRepository;

@Transactional
@Service
public class UserServiceImpl implements UserService
{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity create(UserEntity userEntity)
    {
        UserEntity user = userRepository.save(userEntity);
        return user;
    }

    @Override
    public UserEntity getById(long userId)
    {
        UserEntity user = userRepository.findById(userId).orElse(null);
        return user;
    }

    @Override
    public UserEntity getUserEntityByUsername(String username)
    {
        UserEntity user = userRepository.findUserEntityByUsername(username);
        return user;
    }

    @Override
    public List<UserEntity> getAllUserEntityList()
    {
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public UserEntity getUserByEmail(String email)
    {
        UserEntity user = userRepository.findUserByEmail(email);
        return user;
    }

    @Override
    public UserEntity update(UserEntity userEntity)
    {
        UserEntity user = userRepository.save(userEntity);
        return user;
    }

}