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
 * CREATE TABLE `company_note` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `note_date` datetime NOT NULL,
  `notes` text NOT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_note_company_idx` (`company_id`),
  CONSTRAINT `fk_company_note_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "company_note")
public class CompanyNoteEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
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
    
    //`notes` text NOT NULL,
    @Column(name = "private")
    private boolean privateNote;
    
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

    public CompanyEntity getCompany()
    {
        return company;
    }

    public void setCompany(CompanyEntity company)
    {
        this.company = company;
    }

    public LocalDateTime getNoteDate()
    {
        return noteDate;
    }

    public void setNoteDate(LocalDateTime noteDate)
    {
        this.noteDate = noteDate;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
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
        return Objects.hash(company, createdBy, createdDate, id, noteDate, notes, updatedBy, updatedDate);
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
        CompanyNoteEntity other = (CompanyNoteEntity) obj;
        return Objects.equals(company, other.company) && createdBy == other.createdBy && Objects.equals(createdDate, other.createdDate) && id == other.id && Objects.equals(noteDate, other.noteDate)
            && Objects.equals(notes, other.notes) && updatedBy == other.updatedBy && Objects.equals(updatedDate, other.updatedDate);
    }

    @Override
    public String toString()
    {
        return "CompanyNoteEntity [id=" + id + ", company=" + company + ", noteDate=" + noteDate + ", notes=" + notes + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy="
            + updatedBy + ", updatedDate=" + updatedDate + "]";
    }
    
}
