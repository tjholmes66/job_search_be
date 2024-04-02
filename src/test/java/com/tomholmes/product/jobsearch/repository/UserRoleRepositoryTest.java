package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tomholmes.product.jobsearch.model.RoleEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.model.UserRoleEntity;

@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class UserRoleRepositoryTest
{
    @Autowired
    private UserRoleRepository repository;
    
    @Test
    public void testFindById() {
        long id = 1;
        UserRoleEntity userRoleEntity = repository.findById(id).orElse(null);
        assertNotNull(userRoleEntity);
        assertEquals(id, userRoleEntity.getId());
        assertNotNull(userRoleEntity.getUser());
        assertNotNull(userRoleEntity.getRole());
    }
    
    @Test
    public void testFindUsersByRoleId() {
        long roleId = 1;
        List<UserEntity> userList = repository.findUserByRoleId(roleId);
        assertNotNull(userList);
        assertEquals(2, userList.size());
    }
    
    @Test
    public void testFindRolesByUserId() {
        long userId = 1;
        List<RoleEntity> roleList = repository.findRoleByUserId(userId);
        assertNotNull(roleList);
        assertEquals(2, roleList.size());
    }
}
