package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tomholmes.product.jobsearch.model.UserEntity;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class UserRepositoryTest
{
    @Autowired
    private UserRepository userRepository;

    private long _Id = 0;
    private String _username = "test";
    private String _emailAddress = "tom@tomholmes.xyz";
    private boolean _userActive = true;
    private String _userFirstName = "test_FN";
    private String _userLastName = "test_LN";
    private long _editedBy = 1;
    private long _enteredBy = 1;
    private LocalDateTime _editedDate = LocalDateTime.now();
    private LocalDateTime _enteredDate = LocalDateTime.now();
    private String _cellPhone = "123-456-7890";

    private UserEntity save()
    {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(_Id);

        userEntity.setUsername(_username);

        userEntity.setEnabled(_userActive);

        userEntity.setFirstName(_userFirstName);
        userEntity.setLastName(_userLastName);
        
        userEntity.setCellPhone(_cellPhone);
        userEntity.setEmail(_emailAddress);

        // =====================================================
        // =====================================================

        userEntity.setUpdatedBy(_editedBy);
        userEntity.setUpdatedDate(_editedDate);
        userEntity.setCreatedBy(_enteredBy);
        userEntity.setCreatedDate(_enteredDate);

        return userEntity;
    }
    
    @Test
    public void testFindById() {
        long id = 1;
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        assertNotNull(userEntity);
        assertEquals(id, userEntity.getId());
    }

    // UserEntity save(UserEntity userEntity);
    @Test
    public void testUsersave()
    {
        System.out.println("testUsersave: START");

        UserEntity userEntity = save();

        userEntity = userRepository.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());

        System.out.println("testUsersave: FINISH");
    }

    // UserEntity updateUserEntity(UserEntity userEntity);
    @Test
    public void testUserUpdate()
    {
        System.out.println("testUserUpdate: START");

        UserEntity userEntity = save();

        userEntity = userRepository.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());

        String username = "updated";
        userEntity.setUsername(username);

        userEntity = userRepository.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(username, userEntity.getUsername());

        System.out.println("testUserUpdate: FINISH");
    }

    // void deleteUserEntity(long userId);
    // void deleteUserEntity(UserEntity userEntity);

    // UserEntity getUserEntity(long userId);
    @Test
    public void testGetUserEntityById()
    {
        System.out.println("testGetUserEntity: START");

        UserEntity userEntity = save();

        userEntity = userRepository.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());

        long userId = userEntity.getId();
        userEntity = userRepository.findById(userId).orElse(null);

        assertNotNull(userEntity);
        assertEquals(userId, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());

        System.out.println("testGetUserEntity: FINISH");
    }

    // UserEntity getUserEntityByUsername(String username);
    @Test
    public void testGetUserEntityByUsername()
    {
        System.out.println("testGetUserEntityByUsername: START");

        UserEntity userEntity = save();

        userEntity = userRepository.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());

        String username = userEntity.getUsername();
        userEntity = userRepository.findUserEntityByUsername(username);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());

        System.out.println("testGetUserEntityByUsername: FINISH");
    }

    // List<UserEntity> getAllUserEntityList();
    @Test
    public void testGetAllUserEntityList()
    {
        System.out.println("testGetAllUserEntityList: START");

        List<UserEntity> userList = userRepository.findAll();

        assertNotNull(userList);
        assertEquals(true, userList.size() > 0);

        System.out.println("testGetAllUserEntityList: FINISH");
    }

    @Test
    public void testGetUserEntityByEmailAddress()
    {
        System.out.println("testGetUserEntityByEmailAddress: START");

        UserEntity userEntity = save();

        userEntity = userRepository.save(userEntity);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(_emailAddress, userEntity.getEmail());

        String emailAddress = userEntity.getEmail();
        userEntity = userRepository.findUserByEmail(emailAddress);

        assertNotNull(userEntity);
        assertNotSame(0, userEntity.getId());
        assertEquals(_username, userEntity.getUsername());
        assertEquals(emailAddress, userEntity.getEmail());

        System.out.println("testGetUserEntityByEmailAddress: FINISH");
    }

}
