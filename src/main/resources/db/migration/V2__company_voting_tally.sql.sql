DROP TABLE IF EXISTS `company_vote_tally`;
CREATE TABLE `company_vote_tally` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `company_id` bigint NOT NULL,
  `ghost_upvote` int NOT NULL,
  `upvote` int NOT NULL,
  `downvote` int NOT NULL,
  `updated_date` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_id_idx` (`id`),
  KEY `fk_user_entity_user_idx` (`user_id`),
  CONSTRAINT `fk_company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_user_entity_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_vote_tally`
--

LOCK TABLES `company_vote_tally` WRITE;
/*!40000 ALTER TABLE `company_vote_tally` DISABLE KEYS */;
INSERT INTO `company_vote_tally` VALUES (1,1,1,1,1,1,'2023-10-11 12:34:56');
/*!40000 ALTER TABLE `company_vote_tally` ENABLE KEYS */;
UNLOCK TABLES;
