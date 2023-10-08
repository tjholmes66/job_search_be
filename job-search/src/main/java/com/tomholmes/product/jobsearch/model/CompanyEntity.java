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
 * CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(545) NOT NULL,
  `active` tinyint NOT NULL DEFAULT '1',
  `take_home_test` tinyint NOT NULL DEFAULT '0',
  `technical_interview` tinyint NOT NULL DEFAULT '0',
  `technical_interview_date` datetime DEFAULT NULL,
  `hr_person` varchar(545) DEFAULT NULL,
  `hr_email` varchar(45) DEFAULT NULL,
  `hr_phone` varchar(45) DEFAULT NULL,
  `hiring_manager` varchar(545) DEFAULT NULL,
  `recruiter` tinyint DEFAULT '0',
  `recruiter_name` varchar(45) DEFAULT NULL,
  `recruiter_email` varchar(45) DEFAULT NULL,
  `recruiter_phone` varchar(45) DEFAULT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "company")
public class CompanyEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    //`company_name` varchar(545) NOT NULL,
    @Column(name = "company_name")
    private String companyName;
    
    //`active` tinyint NOT NULL DEFAULT '1',
    @Column(name = "active")
    private boolean active;
    
    //`take_home_test` tinyint NOT NULL DEFAULT '0',
    @Column(name = "take_home_test")
    private boolean takeHomeTest;
    
    //`technical_interview` tinyint NOT NULL DEFAULT '0',
    @Column(name = "technical_interview")
    private boolean technicalInterview;
    
    //`technical_interview_date` datetime DEFAULT NULL,
    @Column(name = "technical_interview_date")
    private LocalDateTime technicalInterviewDate;
    
    //`hr_person` varchar(545) DEFAULT NULL,
    @Column(name = "hr_person")
    private String hrPerson;
    
    //`hr_email` varchar(45) DEFAULT NULL,
    @Column(name = "hr_email")
    private String hrEmail;
    
    //`hr_phone` varchar(45) DEFAULT NULL,
    @Column(name = "hr_phone")
    private String hrPhone;
    
    //`hiring_manager` varchar(545) DEFAULT NULL,
    @Column(name = "hiring_manager")
    private String hiringManager;
    
    //`recruiter` tinyint DEFAULT '0',
    @Column(name = "recruiter")
    private boolean recruiter;
    
    //`recruiter_name` varchar(45) DEFAULT NULL,
    @Column(name = "recruiter_name")
    private String recruiterName;
    
    //`recruiter_email` varchar(45) DEFAULT NULL,
    @Column(name = "recruiter_email")
    private String recruiterEmail;
    
    //`recruiter_phone` varchar(45) DEFAULT NULL,
    @Column(name = "recruiter_phone")
    private String recruiterPhone;
    
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

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public boolean isTakeHomeTest()
    {
        return takeHomeTest;
    }

    public void setTakeHomeTest(boolean takeHomeTest)
    {
        this.takeHomeTest = takeHomeTest;
    }

    public boolean isTechnicalInterview()
    {
        return technicalInterview;
    }

    public void setTechnicalInterview(boolean technicalInterview)
    {
        this.technicalInterview = technicalInterview;
    }

    public LocalDateTime getTechnicalInterviewDate()
    {
        return technicalInterviewDate;
    }

    public void setTechnicalInterviewDate(LocalDateTime technicalInterviewDate)
    {
        this.technicalInterviewDate = technicalInterviewDate;
    }

    public String getHrPerson()
    {
        return hrPerson;
    }

    public void setHrPerson(String hrPerson)
    {
        this.hrPerson = hrPerson;
    }

    public String getHrEmail()
    {
        return hrEmail;
    }

    public void setHrEmail(String hrEmail)
    {
        this.hrEmail = hrEmail;
    }

    public String getHrPhone()
    {
        return hrPhone;
    }

    public void setHrPhone(String hrPhone)
    {
        this.hrPhone = hrPhone;
    }

    public String getHiringManager()
    {
        return hiringManager;
    }

    public void setHiringManager(String hiringManager)
    {
        this.hiringManager = hiringManager;
    }

    public boolean isRecruiter()
    {
        return recruiter;
    }

    public void setRecruiter(boolean recruiter)
    {
        this.recruiter = recruiter;
    }

    public String getRecruiterName()
    {
        return recruiterName;
    }

    public void setRecruiterName(String recruiterName)
    {
        this.recruiterName = recruiterName;
    }

    public String getRecruiterEmail()
    {
        return recruiterEmail;
    }

    public void setRecruiterEmail(String recruiterEmail)
    {
        this.recruiterEmail = recruiterEmail;
    }

    public String getRecruiterPhone()
    {
        return recruiterPhone;
    }

    public void setRecruiterPhone(String recruiterPhone)
    {
        this.recruiterPhone = recruiterPhone;
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
        return Objects.hash(active, companyName, createdBy, createdDate, hiringManager, hrEmail, hrPerson, hrPhone, id, recruiter, recruiterEmail, recruiterName, recruiterPhone, takeHomeTest,
            technicalInterview, technicalInterviewDate, updatedBy, updatedDate);
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
        CompanyEntity other = (CompanyEntity) obj;
        return active == other.active && Objects.equals(companyName, other.companyName) && createdBy == other.createdBy && Objects.equals(createdDate, other.createdDate)
            && Objects.equals(hiringManager, other.hiringManager) && Objects.equals(hrEmail, other.hrEmail) && Objects.equals(hrPerson, other.hrPerson) && Objects.equals(hrPhone, other.hrPhone)
            && id == other.id && recruiter == other.recruiter && Objects.equals(recruiterEmail, other.recruiterEmail) && Objects.equals(recruiterName, other.recruiterName)
            && Objects.equals(recruiterPhone, other.recruiterPhone) && takeHomeTest == other.takeHomeTest && technicalInterview == other.technicalInterview
            && Objects.equals(technicalInterviewDate, other.technicalInterviewDate) && updatedBy == other.updatedBy && Objects.equals(updatedDate, other.updatedDate);
    }

    @Override
    public String toString()
    {
        return "CompanyEntity [id=" + id + ", companyName=" + companyName + ", active=" + active + ", takeHomeTest=" + takeHomeTest + ", technicalInterview=" + technicalInterview
            + ", technicalInterviewDate=" + technicalInterviewDate + ", hrPerson=" + hrPerson + ", hrEmail=" + hrEmail + ", hrPhone=" + hrPhone + ", hiringManager=" + hiringManager + ", recruiter="
            + recruiter + ", recruiterName=" + recruiterName + ", recruiterEmail=" + recruiterEmail + ", recruiterPhone=" + recruiterPhone + ", createdBy=" + createdBy + ", createdDate=" + createdDate
            + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
    }
    
}
