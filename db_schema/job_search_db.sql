CREATE DATABASE  IF NOT EXISTS `job_search_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `job_search_db`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: job_search_db
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `application`
--

DROP TABLE IF EXISTS `application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `rejected` tinyint NOT NULL DEFAULT '0',
  `rejected_date` datetime DEFAULT NULL,
  `recruiter_name` varchar(145) DEFAULT NULL,
  `recruiter_company` varchar(45) DEFAULT NULL,
  `company_id` int NOT NULL,
  `company_job_id` varchar(45) DEFAULT NULL,
  `hiring_manager` varchar(45) DEFAULT NULL,
  `application_date` datetime NOT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_company_id_idx` (`company_id`),
  KEY `fk_app_updated_by_idx` (`updated_by`),
  CONSTRAINT `fk_app_company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `fk_app_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application`
--

LOCK TABLES `application` WRITE;
/*!40000 ALTER TABLE `application` DISABLE KEYS */;
INSERT INTO `application` VALUES (1,1,1,'2023-10-12 00:00:00','Recruiter Name','Fuck Them Co.',1,'',NULL,'2023-10-11 00:00:00',1,'2023-10-11 12:34:56',1,'2023-10-11 12:34:56');
/*!40000 ALTER TABLE `application` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `application_note`
--

DROP TABLE IF EXISTS `application_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `application_note` (
  `id` int NOT NULL AUTO_INCREMENT,
  `application_id` int NOT NULL,
  `note_date` datetime NOT NULL,
  `notes` text NOT NULL,
  `private` tinyint NOT NULL DEFAULT '1',
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `Updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_appnote_app_idx` (`application_id`),
  CONSTRAINT `fk_appnote_app` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `application_note`
--

LOCK TABLES `application_note` WRITE;
/*!40000 ALTER TABLE `application_note` DISABLE KEYS */;
INSERT INTO `application_note` VALUES (1,1,'2023-10-11 00:00:00','This is a test Application Note',1,1,'2023-10-11 12:34:56',1,'2023-10-11 12:34:56');
/*!40000 ALTER TABLE `application_note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_name` varchar(545) NOT NULL,
  `active` tinyint NOT NULL DEFAULT '1',
  `take_home_test` tinyint NOT NULL DEFAULT '0',
  `technical_interview` tinyint NOT NULL DEFAULT '0',
  `technical_interview_date` datetime DEFAULT NULL,
  `hr_person` varchar(545) DEFAULT NULL,
  `hr_email` varchar(45) DEFAULT NULL,
  `hr_phone` varchar(45) DEFAULT NULL,
  `hiring_manager` varchar(545) DEFAULT NULL,
  `recruiter` tinyint DEFAULT '0',
  `recruiter_name` varchar(45) DEFAULT NULL,
  `recruiter_email` varchar(45) DEFAULT NULL,
  `recruiter_phone` varchar(45) DEFAULT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Test Company',1,0,1,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,1,'2023-01-01 12:34:56',1,'0203-01-01 12:34:56');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_note`
--

DROP TABLE IF EXISTS `company_note`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company_note` (
  `id` int NOT NULL AUTO_INCREMENT,
  `company_id` int NOT NULL,
  `note_date` datetime NOT NULL,
  `private` tinyint NOT NULL DEFAULT '1',
  `notes` text NOT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_company_note_company_idx` (`company_id`),
  CONSTRAINT `fk_company_note_company` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_note`
--

LOCK TABLES `company_note` WRITE;
/*!40000 ALTER TABLE `company_note` DISABLE KEYS */;
INSERT INTO `company_note` VALUES (1,1,'2023-10-11 12:34:56',1,'these are test notes',1,'2023-10-11 12:34:56',1,'2023-10-11 12:34:56');
/*!40000 ALTER TABLE `company_note` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_enabled` tinyint NOT NULL DEFAULT '1',
  `role_code` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=707 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,1,'ADMIN','Admin',1,'2023-01-01 12:34:56',1,'2023-01-01 12:34:56'),(2,1,'USER','User',1,'2023-01-01 12:34:56',1,'2023-01-01 12:34:56'),(3,1,'MODERATOR','Moderator',1,'2023-01-01 12:34:56',1,'2023-01-01 12:34:56');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enabled` tinyint NOT NULL DEFAULT '1',
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `cell_phone` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `created_by` int NOT NULL DEFAULT '1',
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL DEFAULT '1',
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'tjholmes66','tom@tomholmes.net','111-111-1111','Thomas','Holmes',1,'2023-01-01 12:34:56',1,'2023-01-01 12:34:56'),(2,1,'duncan20s@msn.com','duncan20s@msn.com','222-222-2222','Kevin','Folan',1,'2023-01-01 12:34:56',1,'2023-01-01 12:34:56'),(3,1,'ryan.kahil@gmail.com','ryan.kahil@gmail.com','333-333-3333','Ryan','Kahil',1,'2023-01-01 12:34:56',1,'2023-01-01 12:34:56');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  `created_by` int NOT NULL,
  `created_date` datetime NOT NULL,
  `updated_by` int NOT NULL,
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_user_role_idx` (`user_id`,`role_id`),
  KEY `fk_role_idx` (`role_id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,1,'2024-05-05 12:34:56',1,'2024-05-05 12:34:56'),(2,2,1,1,'2024-05-05 12:34:56',1,'2024-05-05 12:34:56'),(3,1,2,1,'2024-05-05 12:34:56',1,'2024-05-05 12:34:56'),(4,2,2,1,'2024-05-05 12:34:56',1,'2024-05-05 12:34:56');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-08-06 22:29:52
