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
CREATE TABLE `company_note` (
        `id` bigint NOT NULL AUTO_INCREMENT,
        `company_id` bigint NOT NULL,
        `note_date` datetime NOT NULL,
        `is_active` tinyint(1) NOT NULL DEFAULT '0',
        `notes` text NOT NULL,
        `created_by` bigint NOT NULL DEFAULT '1',
        `created_date` datetime NOT NULL,
        `updated_by` bigint NOT NULL DEFAULT '1',
        `updated_date` datetime NOT NULL,
PRIMARY KEY (`id`),
KEY `fk_company_note_company_idx` (`company_id`),
CONSTRAINT `fk_company_note_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/

@SuppressWarnings("serial")
@Entity
@Table(name = "company_note")
public class CompanyNoteEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    //`company_id` int NOT NULL,
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
    
    //`note_date` datetime NOT NULL,
    @Column(name = "note_date")
    private LocalDateTime noteDate;
    
    //`notes` text NOT NULL,
    @Column(name = "notes")
    private String notes;
    
    //`is_active` text NOT NULL,
    @Column(name = "is_active")
    private boolean active;
    
    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public LocalDateTime getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(LocalDateTime noteDate) {
        this.noteDate = noteDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy)
    {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
    
    public Long getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy)
    {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompanyNoteEntity that = (CompanyNoteEntity) o;
        return active == that.active && createdBy == that.createdBy && updatedBy == that.updatedBy && Objects.equals(id, that.id) && Objects.equals(company, that.company) && Objects.equals(noteDate, that.noteDate) && Objects.equals(notes, that.notes) && Objects.equals(createdDate, that.createdDate) && Objects.equals(updatedDate, that.updatedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, noteDate, notes, active, createdBy, createdDate, updatedBy, updatedDate);
    }

    @Override
    public String toString() {
        return "CompanyNoteEntity{" +
                "id=" + id +
                ", company=" + company +
                ", noteDate=" + noteDate +
                ", notes='" + notes + '\'' +
                ", active=" + active +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", updatedBy=" + updatedBy +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
