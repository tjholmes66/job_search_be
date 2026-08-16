package com.tomholmes.product.jobsearch.service;

import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.model.CompanyVotingEntity;

import java.util.List;

public interface CompanyVotingService {
    // CREATE
    CompanyVotingEntity createGhostVote(CompanyVotingEntity newGhostVote);
    CompanyVotingEntity createUpVote(CompanyVotingEntity createUpVote);
    CompanyVotingEntity createDownVote(CompanyVotingEntity createDownVote);

    // RETRIEVE
    List<CompanyVotingEntity> getAllGhostVotes();
    List<CompanyVotingEntity> getAllUpVotes();
    List<CompanyVotingEntity> getAllDownVotes();

    // UPDATE
    CompanyVotingEntity updateGhostVotes(CompanyVotingEntity updateGhostvote);
    CompanyVotingEntity updateUpVote(CompanyVotingEntity updateUpVote);
    CompanyVotingEntity updateDownVote(CompanyVotingEntity updateDownVote);
}
