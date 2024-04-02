package com.tomholmes.product.jobsearch.rest.ws;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.tomholmes.product.jobsearch.model.UserEntity;
import com.tomholmes.product.jobsearch.repository.UserRepository;

@SpringBootTest
@Transactional
@WebAppConfiguration
public class BaseControllerTests
{
    public final static String BASE_URL = "http://localhost:8080/";

    public final static String JSON_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public final static SimpleDateFormat sdfJson = new SimpleDateFormat(JSON_DATE_FORMAT);

    public final static String DATE_FORMAT = "yyyy-MM-dd";
    // public final static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    public final static DateTimeFormatter sdf = DateTimeFormatter.ofPattern(DATE_FORMAT);

    @Autowired
    protected WebApplicationContext context;

    protected MockMvc mockMvc;

    protected MockHttpSession session;

    @BeforeEach
    public void setUp()
    {
        this.session = new MockHttpSession();
        // _customUser = createAuthenticatedUser1(_externalUserId);
        // _customUser4001 = createAuthenticatedUser1(_customUserId4001);
        // _customUser5001 = createAuthenticatedUser1(_customUserId5001);
        // _customUser1001 = createAuthenticatedUser1(_customUserId1001);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    // ================================================================================================
    // ================================================================================================

    @AfterEach
    public void tearDown() throws Exception
    {
        System.out.println("tearDown: START");
        System.out.println("tearDown: FINISH");
    }

    public static final ObjectMapper makeMapper()
    {
        ObjectMapper _mapper = new ObjectMapper();
        _mapper.registerModule(new ParameterNamesModule());
        _mapper.registerModule(new Jdk8Module());
        _mapper.registerModule(new JavaTimeModule());
        return _mapper;
    }

    // ================================================================================================
    // ================================================================================================

    protected byte[] getByteArrayFromFile(String filename)
    {
        InputStream inputStream = null;

        byte[] bFile = null;

        File file = new File(filename);

        try
        {
            inputStream = new FileInputStream(file);

            // =====================================================================
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1)
            {
                buffer.write(data, 0, nRead);
            }

            buffer.flush();

            bFile = buffer.toByteArray();
            // =====================================================================
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return bFile;
    }

    // ================================================================================================
    // ================================================================================================

    @Autowired
    private UserRepository userRepo;

    public User createAuthenticatedUser1(long userId)
    {
        UserEntity userEntity = userRepo.findById(userId).orElse(null);
        User user = null;
        return user;
    }

    public User initialize(long userId)
    {
        // add principal object to SecurityContextHolder
        /* fill user object */
        // This code sets the authenticated user based on username
        User authenticatedUser = createAuthenticatedUser1(userId);

        Authentication auth = new UsernamePasswordAuthenticationToken(authenticatedUser, null);
        SecurityContextHolder.getContext().setAuthentication(auth);

        // When we come into the web-service, this is how we get the authenticated user
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        if (principal instanceof User)
        {
            user = ((User) principal);
        }
        return user;
    }

    // ================================================================================================
    // ================================================================================================

    protected void setAuthentication(String user, String password, MockHttpSession session)
    {
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, password);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);

        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
    }
}