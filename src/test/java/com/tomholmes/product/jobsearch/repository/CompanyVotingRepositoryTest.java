package com.tomholmes.product.jobsearch.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import com.tomholmes.product.jobsearch.model.RoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tomholmes.product.jobsearch.model.CompanyVotingEntity;

public class CompanyVotingRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private CompanyVotingRepository repository;

    @Test
    public void testFindById() {
        Long id = 1L;
        Long companyId = 1L;
        CompanyVotingEntity companyVoteEntity = repository.findById(id).orElse(null);
        assertNotNull(companyVoteEntity);
        assertEquals(id, companyVoteEntity.getId());
        assertNotNull(companyVoteEntity);
        assertEquals(companyId, companyVoteEntity.getCompany().getId());
    }

    @Test
    public void testFindGhostVotes() {
        Long ghost_vote = 1L;
        List<CompanyVotingEntity> ghostVotes = repository.getGhostUpvote(ghost_vote);
        assertNotNull(ghostVotes);
        assertEquals(1, ghostVotes.size());
    }
}
