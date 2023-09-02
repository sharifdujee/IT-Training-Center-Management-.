-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `Trainee_id` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `User_name` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Course` varchar(45) DEFAULT NULL,
  `Round` varchar(45) DEFAULT NULL,
  `TSP` varchar(45) DEFAULT NULL,
  `Date_of_birth` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Trainee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (1271426,'Israt Jahan','isratcc@12','isratjahanmerin@gmail.com','merin324','WDPE','53','NCLC','1994-08-15'),(1271428,'Israt Jahan','isratcc@12','isratjahanmerin@gmail.com','merin324','WDPE','53','NCLC','1994-08-15'),(1271759,'Sirajum Munira','muniraadam@2016','munira888@gmail.com','muniranu','WDPE','53','NCLC','1997-12-27'),(1271864,'Md Ruble Hossain','rubel@12','rubelhossain@gmail.com','1234','JEE','53','NCLC','1996-10-20'),(1271964,'Md Sharif Hossain ','sharifdu@psy','sharifdu44@gmail.com','sharifdu44','JEE','53','NCLC','1998-11-08'),(1272077,'Mohinur Rahman','mohinur333','mohinur.dev@gmail.com','mohinur123','JEE','53','NCLC','1995-03-17'),(1272146,'Shahidul Islam','reyad123','shahidul@gmail.com','reyad123','JEE','53','NCLC','1997-03-09'),(1272372,'Md. Mahfuz Ullah','hassan','hassan@gmail.com','12345','JEE','54','NCLC','1997-05-02');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-02 13:02:03
