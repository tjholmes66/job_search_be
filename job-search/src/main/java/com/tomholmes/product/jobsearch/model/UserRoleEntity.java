package com.tomholmes.product.jobsearch.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `entered_by` int NOT NULL DEFAULT '1',
  `entered_date` date NOT NULL,
  `edited_by` int NOT NULL DEFAULT '1',
  `edited_date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_user_role_idx` (`user_id`,`role_id`),
  KEY `fk_role_user_id_idx` (`role_id`),
  CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "user_role")
public class UserRoleEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
    
    @Column(name = "created_by")
    private long createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private long updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public long getId()
    {
        return Id;
    }

    public void setId(long id)
    {
        Id = id;
    }

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }

    public RoleEntity getRole()
    {
        return role;
    }

    public void setRole(RoleEntity role)
    {
        this.role = role;
    }

    public long getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(long createdBy)
    {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate)
    {
        this.createdDate = createdDate;
    }

    public long getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate()
    {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate)
    {
        this.updatedDate = updatedDate;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Id, createdBy, createdDate, role, updatedBy, updatedDate, user);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserRoleEntity other = (UserRoleEntity) obj;
        return Id == other.Id && createdBy == other.createdBy && Objects.equals(createdDate, other.createdDate) && Objects.equals(role, other.role) && updatedBy == other.updatedBy
            && Objects.equals(updatedDate, other.updatedDate) && Objects.equals(user, other.user);
    }

    @Override
    public String toString()
    {
        return "UserRoleEntity [Id=" + Id + ", user=" + user + ", role=" + role + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
            + updatedDate + "]";
    }

  
    
}
