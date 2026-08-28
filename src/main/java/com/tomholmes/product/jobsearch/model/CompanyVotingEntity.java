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
 * CREATE TABLE `company_vote_tally` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `company_id` int NOT NULL,
  `ghost_upvote` int NOT NULL,
  `upvote` int NOT NULL,
  `downvote` int NOT NULL,
  `updated_date` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_note_company_idx` (`company_id`),
  KEY `fk_user_entity_user_idx` (`user_id`),
  CONSTRAINT `fk_company_note_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
  CONSTRAINT `fk_user_entity_user` FOREIGN KEY (`user_id`) REFERENCES `user_id (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "company_vote_tally")
public class CompanyVotingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyVotingEntity company;

    @Column(name = "ghost_upvote")
    private Long ghost_upvote;

    @Column(name = "upvote")
    private Long upvote;

    @Column(name = "downvote")
    private Long downvote;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    public long getId() { return Id; }

    public void setId(long id)
    {
        Id = id;
    }

    public UserEntity getUser() { return user; }

    public void setUser(UserEntity user) { this.user = user; }

    public CompanyVotingEntity getCompany() { return company; }

    public void setCompany(CompanyVotingEntity company)
    {
        this.company = company;
    }

    public long getGhost_upvote() { return ghost_upvote; }

    public void setGhostUpvote(long ghost_upvote)
    {
        ghost_upvote = ghost_upvote;
    }

    public long getUpvote() { return upvote; }

    public void setUpvote(long ghost_upvote)
    {
        upvote = upvote;
    }

    public long getDownvote() { return downvote; }

    public void setDownvote(long downvote)
    {
        downvote = downvote;
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
        return Objects.hash(company, user, ghost_upvote, Id, upvote, downvote, updatedDate);
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
        CompanyVotingEntity other = (CompanyVotingEntity) obj;
        return Objects.equals(company, other.company) && Id == other.Id && Objects.equals(ghost_upvote, other.ghost_upvote)
                && Objects.equals(upvote, other.upvote) && Objects.equals(downvote, other.downvote) && Objects.equals(updatedDate, other.updatedDate);
    }

    @Override
    public String toString()
    {
        return "CompanyNoteEntity [id=" + Id + ", company=" + company + ", user_id=" + user + ", ghost_upvote=" + ghost_upvote + ", upvote=" + upvote + ", downvote=" + downvote + "updatedDate=" + updatedDate + "]";
    }
}
