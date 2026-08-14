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
        long id = 1;
        long companyId = 1;
        CompanyVotingEntity companyVoteEntity = repository.findById(id).orElse(null);
        assertNotNull(companyVoteEntity);
        assertEquals(id, companyVoteEntity.getId());
        assertNotNull(companyVoteEntity);
        assertEquals(companyId, companyVoteEntity.getCompany().getId());
    }

    @Test
    public void testFindGhostVotesByUserId() {
        long ghost_vote = 1;
        List<CompanyVotingEntity> ghostVotes = repository.getGhostUpvote(ghost_vote);
        assertNotNull(ghostVotes);
        assertEquals(2, ghostVotes.size());
    }
}
