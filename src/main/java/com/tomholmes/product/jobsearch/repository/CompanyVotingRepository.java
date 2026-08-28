package com.tomholmes.product.jobsearch.repository;

import com.tomholmes.product.jobsearch.model.ApplicationNoteEntity;
import com.tomholmes.product.jobsearch.model.CompanyVotingEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyVotingRepository extends JpaRepository<CompanyVotingEntity, Long> {
    @Query(value = "SELECT * FROM company_vote_tally WHERE ghost_upvote = :ghostVote", nativeQuery = true)
    List<CompanyVotingEntity> getGhostUpvote(@Param("ghostVote") long ghostVote);
    //List<CompanyVotingEntity> getGhostUpvote(long ghost_upvote);
}
