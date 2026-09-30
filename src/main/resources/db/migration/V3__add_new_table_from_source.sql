INSERT INTO `job_search_db`.`user_role` (`id`, `user_id`, `role_id`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('5', '3', '1', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');
INSERT INTO `job_search_db`.`user_role` (`id`, `user_id`, `role_id`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('6', '3', '2', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');
INSERT INTO `job_search_db`.`user_role` (`id`, `user_id`, `role_id`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('7', '3', '3', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');

DROP TABLE IF EXISTS `application_source`;
CREATE TABLE `job_search_db`.`application_source` (
                                                      `application_source_id` BIGINT NOT NULL AUTO_INCREMENT,
                                                      `application_source_code` VARCHAR(45) NOT NULL,
                                                      `application_source_name` VARCHAR(45) NOT NULL,
                                                      `created_by` BIGINT NOT NULL DEFAULT 1,
                                                      `created_date` DATETIME NOT NULL,
                                                      `updated_by` BIGINT NOT NULL DEFAULT 1,
                                                      `updated_date` DATETIME NOT NULL,
                                                      PRIMARY KEY (`application_source_id`));

INSERT INTO `job_search_db`.`application_source` (`application_source_id`, `application_source_code`, `application_source_name`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('1', 'LINKEDIN', 'LinkedIn Message', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');
INSERT INTO `job_search_db`.`application_source` (`application_source_id`, `application_source_code`, `application_source_name`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('2', 'EMAIL', 'Standard Email', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');
INSERT INTO `job_search_db`.`application_source` (`application_source_id`, `application_source_code`, `application_source_name`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('3', 'PHONE', 'Phone Code Call', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');
INSERT INTO `job_search_db`.`application_source` (`application_source_id`, `application_source_code`, `application_source_name`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('4', 'DICE', 'Dice Message', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');
INSERT INTO `job_search_db`.`application_source` (`application_source_id`, `application_source_code`, `application_source_name`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('5', 'INDEED', 'Indeed Mesaage', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');
INSERT INTO `job_search_db`.`application_source` (`application_source_id`, `application_source_code`, `application_source_name`, `created_by`, `created_date`, `updated_by`, `updated_date`) VALUES ('6', 'HIRECAFE', 'Hiring Cafe Message', '1', '2026-09-26 12:34:56', '1', '2026-09-26 12:34:56');

ALTER TABLE `job_search_db`.`application`
    ADD COLUMN `application_source` BIGINT NOT NULL DEFAULT 1 AFTER `updated_date`;

ALTER TABLE `job_search_db`.`application`
    ADD INDEX `fk_app_source_id_idx` (`application_source` ASC) VISIBLE;
;
ALTER TABLE `job_search_db`.`application`
    ADD CONSTRAINT `fk_app_source_id`
        FOREIGN KEY (`application_source`)
            REFERENCES `job_search_db`.`application_source` (`application_source_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;
