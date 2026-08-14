package com.tomholmes.product.jobsearch.repository;

import com.tomholmes.product.jobsearch.model.ApplicationNoteEntity;
import com.tomholmes.product.jobsearch.model.CompanyVotingEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyVotingRepository extends JpaRepository<CompanyVotingEntity, Long> {
    List<CompanyVotingEntity> getGhostUpvote(long ghostVote);
}
