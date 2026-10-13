ALTER TABLE `company_vote_tally`
    MODIFY COLUMN `user_id` BIGINT NOT NULL;

ALTER TABLE `user` ADD COLUMN `keycloak_id` BIGINT NOT NULL;

ALTER TABLE `job_search_db`.`user`
    CHANGE COLUMN `cell_phone` `cell_phone` VARCHAR(45) NULL;