package com.tomholmes.product.jobsearch.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_enabled` tinyint NOT NULL DEFAULT '1',
  `role_code` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `entered_by` int NOT NULL DEFAULT '1',
  `entered_date` datetime NOT NULL,
  `edited_by` int NOT NULL DEFAULT '1',
  `edited_date` datetime NOT NULL,
  PRIMARY KEY (`role_id`,`entered_by`,`entered_date`,`edited_by`,`edited_date`),
  UNIQUE KEY `uq_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=707 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

 */

@SuppressWarnings("serial")
@Entity
@Table(name = "role")
public class RoleEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name = "role_enabled")
    private boolean enabled;
    
    @Column(name = "role_code")
    private String roleCode;
    
    @Column(name = "role_name")
    private String roleName;
    
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

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(String roleCode)
    {
        this.roleCode = roleCode;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
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
        return Objects.hash(Id, createdBy, createdDate, enabled, roleCode, roleName, updatedBy, updatedDate);
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
        RoleEntity other = (RoleEntity) obj;
        return Id == other.Id && createdBy == other.createdBy && Objects.equals(createdDate, other.createdDate) && enabled == other.enabled && Objects.equals(roleCode, other.roleCode)
            && Objects.equals(roleName, other.roleName) && updatedBy == other.updatedBy && Objects.equals(updatedDate, other.updatedDate);
    }

    @Override
    public String toString()
    {
        return "RoleEntity [Id=" + Id + ", enabled=" + enabled + ", roleCode=" + roleCode + ", roleName=" + roleName + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
            + updatedBy + ", updatedDate=" + updatedDate + "]";
    }
    
    
}
