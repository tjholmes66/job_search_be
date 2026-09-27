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
    private Long id;
    
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
    private String recruiterCompany;
    
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
    private Long createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "application_source")
    private ApplicationSourceEntity applicationSource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public LocalDateTime getRejectedDate() {
        return rejectedDate;
    }

    public void setRejectedDate(LocalDateTime rejectedDate) {
        this.rejectedDate = rejectedDate;
    }

    public String getRecruiterName() {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName) {
        this.recruiterName = recruiterName;
    }

    public String getRecruiterCompany() {
        return recruiterCompany;
    }

    public void setRecruiterCompany(String recruiterCompany) {
        this.recruiterCompany = recruiterCompany;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getCompanyJobId() {
        return companyJobId;
    }

    public void setCompanyJobId(String companyJobId) {
        this.companyJobId = companyJobId;
    }

    public String getHiringManager() {
        return hiringManager;
    }

    public void setHiringManager(String hiringManager) {
        this.hiringManager = hiringManager;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public ApplicationSourceEntity getApplicationSource() {
        return applicationSource;
    }

    public void setApplicationSource(ApplicationSourceEntity applicationSource) {
        this.applicationSource = applicationSource;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationEntity that = (ApplicationEntity) o;
        return rejected == that.rejected && createdBy == that.createdBy && updatedBy == that.updatedBy && Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(rejectedDate, that.rejectedDate) && Objects.equals(recruiterName, that.recruiterName) && Objects.equals(recruiterCompany, that.recruiterCompany) && Objects.equals(company, that.company) && Objects.equals(companyJobId, that.companyJobId) && Objects.equals(hiringManager, that.hiringManager) && Objects.equals(applicationDate, that.applicationDate) && Objects.equals(createdDate, that.createdDate) && Objects.equals(updatedDate, that.updatedDate) && Objects.equals(applicationSource, that.applicationSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, rejected, rejectedDate, recruiterName, recruiterCompany, company, companyJobId, hiringManager, applicationDate, createdBy, createdDate, updatedBy, updatedDate, applicationSource);
    }

    @Override
    public String toString() {
        return "ApplicationEntity{" +
                "id=" + id +
                ", user=" + user +
                ", rejected=" + rejected +
                ", rejectedDate=" + rejectedDate +
                ", recruiterName='" + recruiterName + '\'' +
                ", recruiterCompany='" + recruiterCompany + '\'' +
                ", company=" + company +
                ", companyJobId='" + companyJobId + '\'' +
                ", hiringManager='" + hiringManager + '\'' +
                ", applicationDate=" + applicationDate +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", updatedBy=" + updatedBy +
                ", updatedDate=" + updatedDate +
                ", applicationSource=" + applicationSource +
                '}';
    }
}
