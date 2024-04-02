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
 * CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class UserEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;

    @Column(name = "enabled")
    private boolean enabled;

    // `username` varchar(45) NOT NULL,
    @Column(name = "username")
    private String username;

    // `first_name` varchar(45) DEFAULT NULL,
    @Column(name = "first_name")
    private String firstName;

    // `last_name` varchar(45) DEFAULT NULL,
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created_by")
    private long createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private long updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "email")
    private String email;
    
    @Column(name = "cell_phone")
    private String cellPhone;

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

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCellPhone()
    {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone)
    {
        this.cellPhone = cellPhone;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(Id, cellPhone, createdBy, createdDate, email, enabled, firstName, lastName, updatedBy, updatedDate, username);
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
        UserEntity other = (UserEntity) obj;
        return Id == other.Id && Objects.equals(cellPhone, other.cellPhone) && createdBy == other.createdBy && Objects.equals(createdDate, other.createdDate) && Objects.equals(email, other.email)
            && enabled == other.enabled && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName) && updatedBy == other.updatedBy
            && Objects.equals(updatedDate, other.updatedDate) && Objects.equals(username, other.username);
    }

    @Override
    public String toString()
    {
        return "UserEntity [Id=" + Id + ", enabled=" + enabled + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", createdBy=" + createdBy + ", createdDate="
            + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", email=" + email + ", cellPhone=" + cellPhone + "]";
    }
    
    

}