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
 * CREATE TABLE `application` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `rejected` tinyint NOT NULL DEFAULT '0',
  `rejected_date` datetime DEFAULT NULL,
  `recruiter_name` varchar(145) DEFAULT NULL,
  `recruiter_company` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  `company_job_id` varchar(45) DEFAULT NULL,
  `hiring_manager` varchar(45) DEFAULT NULL,
  `application_date` datetime NOT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_company_id_idx` (`company_id`),
  KEY `fk_app_updated_by_idx` (`updated_by`),
  CONSTRAINT `fk_app_company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_app_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "application")
public class ApplicationEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    // `user_id` int DEFAULT NULL,
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
    // `rejected` tinyint NOT NULL DEFAULT '0',
    @Column(name = "rejected")
    private boolean rejected;
    
    // `rejected_date` datetime DEFAULT NULL,
    @Column(name = "rejected_date")
    private LocalDateTime rejectedDate;
    
    // `recruiter_name` varchar(145) DEFAULT NULL,
    @Column(name = "recruiter_name")
    private String recruiterName;
    
    // `recruiter_company` varchar(45) DEFAULT NULL,
    @Column(name = "recruiter_company")
    private String recruiter_company;
    
    // `company_id` int NOT NULL,
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
    
    // `company_job_id` varchar(45) DEFAULT NULL,
    @Column(name = "company_job_id")
    private String companyJobId;
    
    // `hiring_manager` varchar(45) DEFAULT NULL,
    @Column(name = "hiring_manager")
    private String hiringManager;
  
    // `application_date` datetime NOT NULL,
    @Column(name = "application_date")
    private LocalDateTime applicationDate;
    
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
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public UserEntity getUser()
    {
        return user;
    }

    public void setUser(UserEntity user)
    {
        this.user = user;
    }

    public boolean isRejected()
    {
        return rejected;
    }

    public void setRejected(boolean rejected)
    {
        this.rejected = rejected;
    }

    public LocalDateTime getRejectedDate()
    {
        return rejectedDate;
    }

    public void setRejectedDate(LocalDateTime rejectedDate)
    {
        this.rejectedDate = rejectedDate;
    }

    public String getRecruiterName()
    {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName)
    {
        this.recruiterName = recruiterName;
    }

    public String getRecruiter_company()
    {
        return recruiter_company;
    }

    public void setRecruiter_company(String recruiter_company)
    {
        this.recruiter_company = recruiter_company;
    }

    public CompanyEntity getCompany()
    {
        return company;
    }

    public void setCompany(CompanyEntity company)
    {
        this.company = company;
    }

    public String getCompanyJobId()
    {
        return companyJobId;
    }

    public void setCompanyJobId(String companyJobId)
    {
        this.companyJobId = companyJobId;
    }

    public String getHiringManager()
    {
        return hiringManager;
    }

    public void setHiringManager(String hiringManager)
    {
        this.hiringManager = hiringManager;
    }

    public LocalDateTime getApplicationDate()
    {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate)
    {
        this.applicationDate = applicationDate;
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
        return Objects.hash(applicationDate, company, companyJobId, createdBy, createdDate, hiringManager, id, recruiterName, recruiter_company, rejected, rejectedDate, updatedBy, updatedDate, user);
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
        ApplicationEntity other = (ApplicationEntity) obj;
        return Objects.equals(applicationDate, other.applicationDate) && Objects.equals(company, other.company) && Objects.equals(companyJobId, other.companyJobId) && createdBy == other.createdBy
            && Objects.equals(createdDate, other.createdDate) && Objects.equals(hiringManager, other.hiringManager) && id == other.id && Objects.equals(recruiterName, other.recruiterName)
            && Objects.equals(recruiter_company, other.recruiter_company) && rejected == other.rejected && Objects.equals(rejectedDate, other.rejectedDate) && updatedBy == other.updatedBy
            && Objects.equals(updatedDate, other.updatedDate) && Objects.equals(user, other.user);
    }

    @Override
    public String toString()
    {
        return "ApplicationEntity [id=" + id + ", user=" + user + ", rejected=" + rejected + ", rejectedDate=" + rejectedDate + ", recruiterName=" + recruiterName + ", recruiter_company="
            + recruiter_company + ", company=" + company + ", companyJobId=" + companyJobId + ", hiringManager=" + hiringManager + ", applicationDate=" + applicationDate + ", createdBy=" + createdBy
            + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
    }
    
}
