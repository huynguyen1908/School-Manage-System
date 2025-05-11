-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: school_db
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `assignment`
--

DROP TABLE IF EXISTS `assignment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignment` (
  `due_dates` datetime(6) DEFAULT NULL,
  `assignment_id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `subject` enum('Art','Chemistry','Civic_Education','English','Geography','History','Information_Technology','Literature','Math','Music','Physic','Physical_Education','Science') DEFAULT NULL,
  PRIMARY KEY (`assignment_id`),
  KEY `FK30dlo8n82vkt7657237hn67ko` (`teacher_id`),
  CONSTRAINT `FK30dlo8n82vkt7657237hn67ko` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assignment`
--

LOCK TABLES `assignment` WRITE;
/*!40000 ALTER TABLE `assignment` DISABLE KEYS */;
/*!40000 ALTER TABLE `assignment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classes` (
  `grade` int DEFAULT NULL,
  `assignment_id` varchar(255) DEFAULT NULL,
  `class_id` varchar(255) NOT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `homeroom_teacher_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  UNIQUE KEY `UK3c0c1i937edtvk4o0k6slj44a` (`homeroom_teacher_id`),
  KEY `FK3pvy7xuj4jifb3m9id3vkbdow` (`assignment_id`),
  CONSTRAINT `FK3pvy7xuj4jifb3m9id3vkbdow` FOREIGN KEY (`assignment_id`) REFERENCES `assignment` (`assignment_id`),
  CONSTRAINT `FK7tee8ujdgrkg25sd19iy65qy2` FOREIGN KEY (`homeroom_teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (12,NULL,'89b4fd10-1c61-4fac-87c8-f2d52c0cf992','12A5',NULL),(12,NULL,'a8328e84-52ba-4937-8de9-8257e2805964',NULL,NULL),(12,NULL,'e2f60f91-8b15-44ee-bfbc-f21edd99b700','12A',NULL);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `department_id` varchar(255) NOT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`department_id`),
  UNIQUE KEY `UKf6nogxbvabvfrafxjpu4eiius` (`user_id`),
  CONSTRAINT `FKjw23xhsg9ypkss81sqo5yws5y` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES ('80ff4625-2da1-486e-ad04-fcea244fc167','admin',NULL,'ed595bfd-c483-4067-8496-6180215333be'),('f6094cdc-f12e-47be-b331-d6160f218670','accounting',NULL,'12260778-477e-466a-83c4-616775f2867c');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','<< Flyway Baseline >>','BASELINE','<< Flyway Baseline >>',NULL,'root','2025-05-04 00:34:00',0,1),(2,'2','add data','SQL','V2__add_data.sql',1612673077,'root','2025-05-11 09:37:09',1559,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `message` (
  `sent_at` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `message_id` varchar(255) NOT NULL,
  `receiver_id` varchar(255) DEFAULT NULL,
  `sender_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `FKpvlpwg6nf6mluycoqdlp7h419` (`receiver_id`),
  KEY `FKrdx8hgntft2s9ulc5px1d9rcp` (`sender_id`),
  CONSTRAINT `FKpvlpwg6nf6mluycoqdlp7h419` FOREIGN KEY (`receiver_id`) REFERENCES `user_account` (`user_id`),
  CONSTRAINT `FKrdx8hgntft2s9ulc5px1d9rcp` FOREIGN KEY (`sender_id`) REFERENCES `user_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notification`
--

DROP TABLE IF EXISTS `notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notification` (
  `sent_at` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `notification_id` varchar(255) NOT NULL,
  `receiver_id` varchar(255) DEFAULT NULL,
  `sender_id` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  KEY `FKiu5nmyl9273tk11e9vw1pitsk` (`receiver_id`),
  KEY `FKnp5r1pfodewrlsm2414vtncnc` (`sender_id`),
  CONSTRAINT `FKiu5nmyl9273tk11e9vw1pitsk` FOREIGN KEY (`receiver_id`) REFERENCES `user_account` (`user_id`),
  CONSTRAINT `FKnp5r1pfodewrlsm2414vtncnc` FOREIGN KEY (`sender_id`) REFERENCES `user_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notification`
--

LOCK TABLES `notification` WRITE;
/*!40000 ALTER TABLE `notification` DISABLE KEYS */;
INSERT INTO `notification` VALUES ('2025-05-11 09:17:18.977257','Học sinh nghỉ học từ ngày 11/05/2025','3c4f388b-8123-4140-940d-3a4810eb3064','732622aa-507f-46f2-a604-df0f01fa9d85','ed595bfd-c483-4067-8496-6180215333be','Thông báo nghỉ học '),('2025-05-11 09:19:40.268550','Học sinh hoàn thành học phí trước 15/05/2025','9813938a-95ba-4a14-9634-95867a414812','732622aa-507f-46f2-a604-df0f01fa9d85','ed595bfd-c483-4067-8496-6180215333be','Thông báo đóng học phí'),('2025-05-11 01:11:42.578852','Các bạn học sinh lưu ý: Lịch kiểm tra giữa kỳ sẽ bắt đầu từ thứ Hai tuần sau.','ba6c224f-d26b-4dad-a0c1-db2106091b29','c4563f91-4013-4533-9bb9-13da0451d140','ed595bfd-c483-4067-8496-6180215333be','Lịch kiểm tra giữa kỳ');
/*!40000 ALTER TABLE `notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parent` (
  `age` int DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `occupation` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`parent_id`),
  UNIQUE KEY `UK2er3k7pagjgspesr4bn7a2aa3` (`user_id`),
  CONSTRAINT `FK3lvjknjttbn3xior57co4cfo2` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
INSERT INTO `parent` VALUES (NULL,NULL,NULL,NULL,'3fef3271-1b29-499d-85c6-cbc1189bfe75',NULL,'53562cb0-e803-4183-b637-4e3a45ad889e'),(NULL,NULL,NULL,NULL,'4eb9f609-4ac8-418f-9768-e56d2a97a0de',NULL,'1735a84f-99aa-4909-9401-4c41e03aebbe');
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_feedback`
--

DROP TABLE IF EXISTS `request_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_feedback` (
  `send_at` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `receiver_id` varchar(255) DEFAULT NULL,
  `rf_id` varchar(255) NOT NULL,
  `sender_id` varchar(255) DEFAULT NULL,
  `status` enum('APPROVED','PENDING','REJECTED') DEFAULT NULL,
  `type` enum('APPEAL','PETITION') DEFAULT NULL,
  PRIMARY KEY (`rf_id`),
  KEY `FKc4q8fsunihmwrnay3xq45bhlv` (`receiver_id`),
  KEY `FK590vf2xmpsikmeth0bkioh89e` (`sender_id`),
  CONSTRAINT `FK590vf2xmpsikmeth0bkioh89e` FOREIGN KEY (`sender_id`) REFERENCES `user_account` (`user_id`),
  CONSTRAINT `FKc4q8fsunihmwrnay3xq45bhlv` FOREIGN KEY (`receiver_id`) REFERENCES `user_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_feedback`
--

LOCK TABLES `request_feedback` WRITE;
/*!40000 ALTER TABLE `request_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward_punishment`
--

DROP TABLE IF EXISTS `reward_punishment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reward_punishment` (
  `sent_at` datetime(6) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `decided_by_id` varchar(255) DEFAULT NULL,
  `rp_id` varchar(255) NOT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  `status` enum('APPROVED','PENDING','REJECTED') DEFAULT NULL,
  `type` enum('PUNISHMENT','REWARD') DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text,
  `effective_date` datetime(6) DEFAULT NULL,
  `notification_sent` bit(1) DEFAULT NULL,
  `parent_acknowledged` bit(1) DEFAULT NULL,
  `parent_feedback` text,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`rp_id`),
  KEY `FKcb2932yrit0gullqt6fvw9qfx` (`decided_by_id`),
  KEY `FK3k9yomy1nt1fdsjf7kdgjihdh` (`student_id`),
  KEY `FK88xyhdnxcv1akg7btylyp30m6` (`teacher_id`),
  CONSTRAINT `FK3k9yomy1nt1fdsjf7kdgjihdh` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `FK88xyhdnxcv1akg7btylyp30m6` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `FKcb2932yrit0gullqt6fvw9qfx` FOREIGN KEY (`decided_by_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward_punishment`
--

LOCK TABLES `reward_punishment` WRITE;
/*!40000 ALTER TABLE `reward_punishment` DISABLE KEYS */;
/*!40000 ALTER TABLE `reward_punishment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `date_of_birth` date DEFAULT NULL,
  `class_id` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `UKbkix9btnoi1n917ll7bplkvg5` (`user_id`),
  KEY `FKnsl7w2nw6o6eq53hqlxfcijpm` (`class_id`),
  KEY `FKqqq09m02bgrk47qoe6fs3ht4w` (`parent_id`),
  CONSTRAINT `FKall7qatgcsiy2fgkm0hrt2v9j` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`user_id`),
  CONSTRAINT `FKnsl7w2nw6o6eq53hqlxfcijpm` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `FKqqq09m02bgrk47qoe6fs3ht4w` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (NULL,'89b4fd10-1c61-4fac-87c8-f2d52c0cf992',NULL,NULL,'4eb9f609-4ac8-418f-9768-e56d2a97a0de','62772014-5244-4130-9b60-d404e5351fbc','55dc40c5-db8f-44c0-8249-c57c7d65c1c5'),(NULL,'89b4fd10-1c61-4fac-87c8-f2d52c0cf992',NULL,NULL,'4eb9f609-4ac8-418f-9768-e56d2a97a0de','ab7d5dbf-2438-4333-96a0-2176f176ae26','c4563f91-4013-4533-9bb9-13da0451d140'),(NULL,'89b4fd10-1c61-4fac-87c8-f2d52c0cf992',NULL,NULL,'3fef3271-1b29-499d-85c6-cbc1189bfe75','b0ed292f-e1d8-4893-a79e-1c41787db350','732622aa-507f-46f2-a604-df0f01fa9d85');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_score`
--

DROP TABLE IF EXISTS `study_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `study_score` (
  `score` double DEFAULT NULL,
  `score_id` varchar(255) NOT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  `subject` enum('Art','Chemistry','Civic_Education','English','Geography','History','Information_Technology','Literature','Math','Music','Physic','Physical_Education','Science') DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `FKt2d2j58jsqjlw1r4b98t02hoa` (`student_id`),
  KEY `FK4n679ncj0nr0v0gf2pj54s1fa` (`teacher_id`),
  CONSTRAINT `FK4n679ncj0nr0v0gf2pj54s1fa` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `FKt2d2j58jsqjlw1r4b98t02hoa` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_score`
--

LOCK TABLES `study_score` WRITE;
/*!40000 ALTER TABLE `study_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `study_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `date_of_birth` date DEFAULT NULL,
  `is_homeroom` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  UNIQUE KEY `UK3kv6k1e64a9gylvkn3gnghc2q` (`email`),
  UNIQUE KEY `UKi5wqs2ds2vpmfpbcdxi9m2jvr` (`user_id`),
  CONSTRAINT `FKqhlvaxgic4t63jlqm0qwhwdrl` FOREIGN KEY (`user_id`) REFERENCES `user_account` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (NULL,_binary '\0',NULL,NULL,NULL,NULL,'532c6518-bd6d-46d7-b658-d18cc8ec03b1','204b0098-b584-4efc-a2c8-e56d3f89f161'),(NULL,_binary '\0',NULL,NULL,NULL,NULL,'7020f9f6-c814-43e6-89e0-b9a842029f78','31139fc4-f5ed-4216-8070-c6b9ea59c80f');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuition`
--

DROP TABLE IF EXISTS `tuition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuition` (
  `amount` decimal(38,2) DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `paid_at` datetime(6) DEFAULT NULL,
  `department_id` varchar(255) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `tuition_id` varchar(255) NOT NULL,
  `status` enum('CANCELLED','OVERDUE','PAID','PARTIALLY_PAID','PENDING','UNPAID') DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `description` text,
  `late_fee` decimal(38,2) DEFAULT NULL,
  `notification_sent` bit(1) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `school_year` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `student_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tuition_id`),
  KEY `FKkt7x12va9qf2dgnkvem49g6tt` (`parent_id`),
  KEY `FKmw01a1icmtp696yk6tcruqwce` (`student_id`),
  CONSTRAINT `FKkt7x12va9qf2dgnkvem49g6tt` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`parent_id`),
  CONSTRAINT `FKmw01a1icmtp696yk6tcruqwce` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuition`
--

LOCK TABLES `tuition` WRITE;
/*!40000 ALTER TABLE `tuition` DISABLE KEYS */;
/*!40000 ALTER TABLE `tuition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `is_active` bit(1) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role` enum('ACCOUNTING','ADMIN','MANAGER','OFFICE','PARENT','STUDENT','TEACHER') NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UKcastjbvpeeus0r8lbpehiu0e4` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (_binary '','2025-05-05 23:49:26.031476',NULL,'$2a$10$OA0Ju9G8Uv.kDQ2y76/7hOLwIFqVz5dv7wYiNbqENWmlQU5xQrrZm','12260778-477e-466a-83c4-616775f2867c','accounting1','ACCOUNTING'),(_binary '','2025-05-06 14:32:27.792942',NULL,'$2a$10$RB.9QIdT2V/dcRheZF9TKuOrPgVNzIm0Yy2WrxTPyM9ckLC5soSUW','1735a84f-99aa-4909-9401-4c41e03aebbe','parent5','PARENT'),(_binary '','2025-05-05 21:15:33.130098',NULL,'$2a$10$3m5lFQwlo6HWFVPc0I.scOVL2.KEsx99FnZpPzBfbP6nz4RuAGaSq','204b0098-b584-4efc-a2c8-e56d3f89f161','teacher2','TEACHER'),(_binary '','2025-05-05 17:11:01.888584',NULL,'$2a$10$GPDd8iTQpgkbuY7qZFQpFe/U2VrbR8DSBMmP2T9VUeGlCnYtkQDZO','31139fc4-f5ed-4216-8070-c6b9ea59c80f','teacher1','TEACHER'),(_binary '','2025-05-05 16:58:43.482189',NULL,'$2a$10$B3x3LzrHhZKXgziVJ0qoV.BlRSjBmiALfuQ6ag0ciIi0sTGHwSWVu','53562cb0-e803-4183-b637-4e3a45ad889e','parent4','PARENT'),(_binary '','2025-05-09 20:28:26.232111',NULL,'$2a$10$hfKeHpGMV9KGx.Q8RRgcxuczNR2SohALvhf5RDFJcx/0ZvpWQd22i','55dc40c5-db8f-44c0-8249-c57c7d65c1c5','student2','STUDENT'),(_binary '','2025-05-05 17:03:09.722105',NULL,'$2a$10$BmxmaWNLlPDx931H/2.cMOpavAdg4nBZN.88VezAeSiNnDXwlYufi','732622aa-507f-46f2-a604-df0f01fa9d85','student1','STUDENT'),(_binary '','2025-05-09 20:28:56.101884',NULL,'$2a$10$RdrPlbgFW7r6yMTUjg3KL.EE72s8jmNY4gdkRZ2PvzaYfawIsas72','c4563f91-4013-4533-9bb9-13da0451d140','student3','STUDENT'),(_binary '','2025-05-05 16:38:25.447287',NULL,'$2a$10$coFqBwDhG90GvGlelUPXxeBZojs7tYnYtPBirCgyVfBraCiLle.m2','d3c45cce-182b-4667-84ac-e256fd5ff662','parent2','PARENT'),(_binary '','2025-05-05 16:56:28.292813',NULL,'$2a$10$wdvERu.UGEJTbFur5ThXUOFqfpn3x/I7v6dSvPi4zyxSK0P25vumy','e547e3ad-c1ee-4470-9bce-9fbed6f52bdd','parent3','PARENT'),(_binary '','2025-05-05 23:50:20.027397',NULL,'$2a$10$59ObzN8t9q2mfQO2evfR8uMt5a9DHKSDU1H6kTkkd6gd8TCVf5EOi','ed595bfd-c483-4067-8496-6180215333be','admin','ADMIN');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-11 21:06:00
