ALTER TABLE `company_vote_tally`
    MODIFY COLUMN `user_id` BIGINT NOT NULL;

ALTER TABLE `user` ADD COLUMN `keycloak_id` BIGINT NOT NULL;