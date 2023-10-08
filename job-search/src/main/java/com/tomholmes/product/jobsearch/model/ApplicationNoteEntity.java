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
 * CREATE TABLE `application_note` (
  `id` int NOT NULL AUTO_INCREMENT,
  `application_id` int NOT NULL,
  `note_date` datetime NOT NULL,
  `notes` text NOT NULL,
  `private` tinyint NOT NULL DEFAULT '1',
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `Updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_appnote_app_idx` (`application_id`),
  CONSTRAINT `fk_appnote_app` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "application_note")
public class ApplicationNoteEntity implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    
    // `application_id` int DEFAULT NULL,
    @ManyToOne
    @JoinColumn(name = "application_id")
    private ApplicationEntity application;
    
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

    public ApplicationEntity getApplication()
    {
        return application;
    }

    public void setApplication(ApplicationEntity application)
    {
        this.application = application;
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

    public boolean isPrivateNote()
    {
        return privateNote;
    }

    public void setPrivateNote(boolean privateNote)
    {
        this.privateNote = privateNote;
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
        return Objects.hash(application, createdBy, createdDate, id, noteDate, notes, privateNote, updatedBy, updatedDate);
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
        ApplicationNoteEntity other = (ApplicationNoteEntity) obj;
        return Objects.equals(application, other.application) && createdBy == other.createdBy && Objects.equals(createdDate, other.createdDate) && id == other.id
            && Objects.equals(noteDate, other.noteDate) && Objects.equals(notes, other.notes) && privateNote == other.privateNote && updatedBy == other.updatedBy
            && Objects.equals(updatedDate, other.updatedDate);
    }

    @Override
    public String toString()
    {
        return "ApplicationNoteEntity [id=" + id + ", application=" + application + ", noteDate=" + noteDate + ", notes=" + notes + ", privateNote=" + privateNote + ", createdBy=" + createdBy
            + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
    }
    
}
