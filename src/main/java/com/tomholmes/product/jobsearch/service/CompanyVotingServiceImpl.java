package com.tomholmes.product.jobsearch.service;
import java.time.LocalDateTime;
import java.util.List;

import com.tomholmes.product.jobsearch.model.CompanyVotingEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.repository.CompanyVotingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tomholmes.product.jobsearch.model.CompanyEntity;
import com.tomholmes.product.jobsearch.repository.CompanyRepository;

@Service
@Transactional
public class CompanyVotingServiceImpl implements CompanyVotingService {

    private CompanyVotingRepository companyVotingRepository;

    @Override
    public CompanyVotingEntity createGhostVote(CompanyVotingEntity newGhostVote) {
        CompanyVotingEntity createGhostVote = companyVotingRepository.save(newGhostVote);
        return createGhostVote;
    }

    @Override
    public CompanyVotingEntity createUpVote(CompanyVotingEntity newUpVote) {
        CompanyVotingEntity createUpVote = companyVotingRepository.save(newUpVote);
        return createUpVote;
    }

    @Override
    public CompanyVotingEntity createDownVote(CompanyVotingEntity newDownVote) {
        CompanyVotingEntity createDownVote = companyVotingRepository.save(newDownVote);
        return createDownVote;
    }

    @Override
    public List<CompanyVotingEntity> getAllGhostVotes() {
        List<CompanyVotingEntity> getAllGhostVotestList = companyVotingRepository.findAll();
        return getAllGhostVotestList;
    }

    @Override
    public List<CompanyVotingEntity> getAllUpVotes() {
        List<CompanyVotingEntity> getAllUpVotesList = companyVotingRepository.findAll();
        return getAllUpVotesList;
    }

    @Override
    public List<CompanyVotingEntity> getAllDownVotes() {
        List<CompanyVotingEntity> getAllDownVotesList = companyVotingRepository.findAll();
        return getAllDownVotesList;
    }

    @Override
    public CompanyVotingEntity updateGhostVotes(CompanyVotingEntity updateGhostvote) {
        CompanyVotingEntity updateGhostVote = companyVotingRepository.save(updateGhostvote);
        return updateGhostVote;
    }

    @Override
    public CompanyVotingEntity updateUpVote(CompanyVotingEntity updateUpVote) {
        CompanyVotingEntity updateUpVoting = companyVotingRepository.save(updateUpVote);
        return updateUpVoting;
    }

    @Override
    public CompanyVotingEntity updateDownVote(CompanyVotingEntity updateDownVote) {
        CompanyVotingEntity updateDownVoting = companyVotingRepository.save(updateDownVote);
        return updateDownVoting;
    }
}
