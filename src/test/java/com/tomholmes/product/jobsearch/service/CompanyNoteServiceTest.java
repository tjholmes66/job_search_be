package com.tomholmes.product.jobsearch.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.time.Instant;
import java.util.List;
import java.util.Map;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import com.tomholmes.product.jobsearch.model.CompanyNoteEntity;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.repository.UserRepository;
import com.tomholmes.product.jobsearch.utils.JobSearchUtils;
import tools.jackson.databind.ObjectMapper;


public class CompanyNoteServiceTest extends BaseServiceTests {

    @Autowired
    private CompanyNoteService  noteService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetAllCompanyNotes()
    {
        List<CompanyNoteEntity> allCompanyNotes = noteService.getAllCompanyNotes();
        assertNotNull(allCompanyNotes);
        assertEquals(allCompanyNotes.size() > 0, true);
    }

    @Test
    public void testFindCompanyNoteById() {
        Long id = 1L;
        CompanyNoteEntity companyNoteEntity = noteService.getById(id);
        assertNotNull(companyNoteEntity);
        assertEquals(id, companyNoteEntity.getId());
    }

    @Test
    public void testCompanyNoteJson() {
        String jsonCompany = "src/test/resources/json/company/company_note_create_01.json";
        ObjectMapper mapper = JobSearchUtils.getObjectMapper();
        File file = new File(jsonCompany);
        CompanyNoteEntity companyNoteEntity = mapper.readValue(file, CompanyNoteEntity.class);
        assertNotNull(companyNoteEntity);
    }

    @Test
    public void testCreateCompanyNote()
    {
        UserEntity dbUser = userRepository.findByKeycloakId("56f3b625-0c1f-47ea-80d1-5efff93f2194")
            .orElseThrow(() -> new IllegalStateException("No user with that keycloak id in the database"));
        authenticateAs(dbUser);

        String jsonCompany = "src/test/resources/json/company/company_note_create_01.json";
        ObjectMapper mapper = JobSearchUtils.getObjectMapper();
        File file = new File(jsonCompany);
        assertNotNull(file);
        CompanyNoteEntity companyNoteEntity = mapper.readValue(file, CompanyNoteEntity.class);
        assertNotNull(companyNoteEntity);
        companyNoteEntity = noteService.createCompanyNote(companyNoteEntity);
        assertNotNull(companyNoteEntity);
        System.out.println(companyNoteEntity);
    }

    @Test
    public void testGetCompanyNoteByCompanyId()
    {
        Long companyId = 1L;
        List<CompanyNoteEntity> noteList =  noteService.getCompanyNotesByCompanyId(companyId);
        assertNotNull(noteList);
        assertEquals(5, noteList.size());
    }

    private void authenticateAs(UserEntity dbUser) {
        OidcIdToken idToken = new OidcIdToken(
            "test-token",
            Instant.now(),
            Instant.now().plusSeconds(300),
            Map.of("sub", dbUser.getKeycloakId(),
                   "preferred_username", dbUser.getUsername(),
                   "email", dbUser.getEmail()));

        OidcUser oidcUser = new DefaultOidcUser(
            List.of(new SimpleGrantedAuthority("ROLE_USER")),
            idToken, "preferred_username");

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(
                oidcUser, idToken, List.of(new SimpleGrantedAuthority("ROLE_USER"))));
    }
}
