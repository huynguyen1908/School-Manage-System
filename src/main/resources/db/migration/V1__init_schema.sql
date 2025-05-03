-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: school_db
-- ------------------------------------------------------
-- Server version	8.0.39

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
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
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
  PRIMARY KEY (`tuition_id`),
  KEY `FKkt7x12va9qf2dgnkvem49g6tt` (`parent_id`),
  CONSTRAINT `FKkt7x12va9qf2dgnkvem49g6tt` FOREIGN KEY (`parent_id`) REFERENCES `parent` (`parent_id`)
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

-- Dump completed on 2025-05-03 22:52:58
