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
-- Table structure for table `admission`
--

DROP TABLE IF EXISTS `admission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admission` (
  `Trainee_id` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `User_Name` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Course` varchar(45) DEFAULT NULL,
  `Round` varchar(45) DEFAULT NULL,
  `DOB` varchar(45) DEFAULT NULL,
  `Branch` varchar(45) DEFAULT NULL,
  `Scholarship` double DEFAULT NULL,
  `Tuition_Fee` double DEFAULT NULL,
  `Admission` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Trainee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admission`
--

LOCK TABLES `admission` WRITE;
/*!40000 ALTER TABLE `admission` DISABLE KEYS */;
INSERT INTO `admission` VALUES (1271428,'Israt Jahan Merin','isratcc@12','isratjahanmerin@gmail.com','merin324','53','WDPE','1994-08-15','NCLC',35,20,'Admission Done'),(1271759,'Sirajum Munira ','muniraadam2016','munirasiraj888@gmail.com','munira321','JEE','53','1996-12-27','NCLC',35,20,'Admission Done'),(1271864,'Md Ruble Hossain','rubel@12','rubelhossain@gmail.com','1234','JEE','53','1996-10-20','NCLC',35,15,'Admission Done'),(1271964,'Md Sharif Hossain ','sharifdu@psy','sharifdu44@gmail.com','sharifdu44','53','JEE','1998-11-08','NCLC',45,20,'Admission Done'),(1272077,'Mohinur Rahman','mohinur333','mohinur.dev@gmail.com','mohinur123','JEE','53','1995-03-17','NCLC',50,25,'Admission Done'),(1272372,'Md. Mahfuz Ullah','hassan','hassan@gmail.com','12345','JEE','54','1997-05-02','NCLC',45,25,'Admission Done');
/*!40000 ALTER TABLE `admission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-02 13:02:04
