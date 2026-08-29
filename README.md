# job_search
Job Search Database

What I intend to do is create an application I plan on putting on my AWS account.
I will even register a domain name to place this existing application.
This job search app will be based on the publicly created content.

As I job search, I run across companies that have different processes.  
As a software developer, there are certain things I expect from a company.
I want to know what their process is, and how long the process takes.   
This is a job search tool for us 'software developers' and not for companies and not for recruiters, but for us.

This is my new Winter 2023 and Spring 2024 project, and I intend to eat my own dog food.

First, in continuing my self-education, there are a couple of things I want to do:
1. This project will use a Spring Boot (3.x) backend, with Hibernate 6.x, and Spring Data JPA.
2. The database is a MySQL database, and eventually this will live in a Docker Container pushed to AWS ECS.
3. I usually use the Spring Tool Suite (STS) which is Eclipse co-branded with Spring (Pivotal), 
but I also wanted to learn how to use JetBrains IntelliJ IDE as well since a lot of companies have switched to this.
4. I intend to have traditional RESTful API's that push JSON and are Oauth2 (JWT) Secured.
5. I intend to have GraphQL API's as well since this should be easy with Spring Boot.
6. I intend to have RESTful API's that server HTML (hyper-media) for a HTMX front-end.
7. I intend to have a separate repository for a React front-end.
8. I intend to have a separate repository for an HTMX front-end.
9. I intend to use Docker to run both my Database and Application in Docker Containers.
10. I intend to use Kubernetes to bundle the Docker containers.

UPDATE: 2026-08-27
I have reviewed the differences between using KeyCloak and Auth0.
I have decided to use Keycloak and at this time, it is the DEV version which is using H2 memory DB.
This is recommended for DEV and will NOT be used in Production.
The command to run this is as follows:
docker run -p 127.0.0.1:9000:8080 
-e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin
--network my-network quay.io/keycloak/keycloak:26.7.2 start-dev
The port 9000 is because my running app will need port 8080.
Also, we want the app to use the keycloak with the network, so it will be on the same network.


