package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.RoleEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.model.UserRoleEntity;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRoleRepositoryTest
{
    @Autowired
    private UserRoleRepository repository;
    
    @Test
    public void testFindById() {
        Long id = 1L;
        UserRoleEntity userRoleEntity = repository.findById(id).orElse(null);
        assertNotNull(userRoleEntity);
        assertEquals(id, userRoleEntity.getId());
        assertNotNull(userRoleEntity.getUser());
        assertNotNull(userRoleEntity.getRole());
    }
    
    @Test
    public void testFindUsersByRoleId() {
        Long roleId = 1L;
        List<UserEntity> userList = repository.findUserByRoleId(roleId);
        assertNotNull(userList);
        assertEquals(3, userList.size());
    }
    
    @Test
    public void testFindRolesByUserId() {
        Long userId = 1L;
        List<RoleEntity> roleList = repository.findRoleByUserId(userId);
        assertNotNull(roleList);
        assertEquals(2, roleList.size());
    }
}
