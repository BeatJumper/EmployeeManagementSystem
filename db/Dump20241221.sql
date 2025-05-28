-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `evection_log`
--

DROP TABLE IF EXISTS `evection_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evection_log` (
  `destination` char(18) DEFAULT NULL,
  `objective` char(18) DEFAULT NULL,
  `T_ID` char(18) NOT NULL,
  PRIMARY KEY (`T_ID`),
  CONSTRAINT `evection_log_ibfk_1` FOREIGN KEY (`T_ID`) REFERENCES `time` (`T_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evection_log`
--

LOCK TABLES `evection_log` WRITE;
/*!40000 ALTER TABLE `evection_log` DISABLE KEYS */;
INSERT INTO `evection_log` VALUES ('北京市','市场调研','1'),('北京','睡觉','2'),('河北','少玩','3'),('西安','多玩','4'),('郑州','使劲玩','5'),('东京','好好玩','6');
/*!40000 ALTER TABLE `evection_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `M_ID` char(18) NOT NULL,
  `m_password` char(18) DEFAULT NULL,
  `R_ID` char(18) DEFAULT NULL,
  PRIMARY KEY (`M_ID`),
  KEY `R_11` (`R_ID`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`R_ID`) REFERENCES `role` (`R_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('1','11111','1'),('2','12345678','2'),('3','87654321','3');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `memberinfo`
--

DROP TABLE IF EXISTS `memberinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `memberinfo` (
  `M_ID` char(18) NOT NULL,
  `M_Name` char(18) DEFAULT NULL,
  `entryTime` date DEFAULT NULL,
  `position` char(18) DEFAULT NULL,
  `phone` char(18) DEFAULT NULL,
  `status` char(18) DEFAULT NULL,
  PRIMARY KEY (`M_ID`),
  CONSTRAINT `memberinfo_ibfk_1` FOREIGN KEY (`M_ID`) REFERENCES `member` (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `memberinfo`
--

LOCK TABLES `memberinfo` WRITE;
/*!40000 ALTER TABLE `memberinfo` DISABLE KEYS */;
INSERT INTO `memberinfo` VALUES ('1','aaa','2022-10-18','aaa','1','qqq'),('2','bbb','2022-10-04','eee','113','qqq');
/*!40000 ALTER TABLE `memberinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewards_log`
--

DROP TABLE IF EXISTS `rewards_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewards_log` (
  `rewards_ID` char(18) NOT NULL,
  `rewards_Name` char(18) DEFAULT NULL,
  `rewards_type` char(18) DEFAULT NULL,
  `rewards_time` date DEFAULT NULL,
  `M_ID` char(18) DEFAULT NULL,
  PRIMARY KEY (`rewards_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards_log`
--

LOCK TABLES `rewards_log` WRITE;
/*!40000 ALTER TABLE `rewards_log` DISABLE KEYS */;
INSERT INTO `rewards_log` VALUES ('1','睡觉奖','奖励','2024-12-21','1'),('11','kkkkkkk','奖励','2024-12-21','6'),('2','2','奖励','2022-12-17','2'),('20','2','奖励','2022-12-17','10'),('3','4','奖励','2022-12-17','2'),('54','2','奖励','2022-12-17','8'),('69','测试','奖励','2024-12-21','1'),('7','55','奖励','2022-12-17','4');
/*!40000 ALTER TABLE `rewards_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `R_ID` char(18) NOT NULL,
  `R_Name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`R_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES ('1','普通员工'),('2','企业经理'),('3','高级管理员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `T_ID` char(18) NOT NULL,
  `start_time` date DEFAULT NULL,
  `end_time` date DEFAULT NULL,
  `M_ID` char(18) DEFAULT NULL,
  PRIMARY KEY (`T_ID`),
  KEY `R_19` (`M_ID`),
  CONSTRAINT `time_ibfk_1` FOREIGN KEY (`M_ID`) REFERENCES `memberinfo` (`M_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES ('1','2022-10-18','2022-10-20','1'),('2','2020-09-28','2020-09-29','1'),('3','2021-09-28','2021-09-29','1'),('4','2023-09-28','2023-09-29','1'),('5','2024-09-28','2024-09-29','1'),('6','2025-09-28','2025-09-29','1');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_log`
--

DROP TABLE IF EXISTS `train_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `train_log` (
  `train_content` char(18) DEFAULT NULL,
  `train_achieve` char(18) DEFAULT NULL,
  `T_ID` char(18) NOT NULL,
  PRIMARY KEY (`T_ID`),
  CONSTRAINT `train_log_ibfk_1` FOREIGN KEY (`T_ID`) REFERENCES `time` (`T_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_log`
--

LOCK TABLES `train_log` WRITE;
/*!40000 ALTER TABLE `train_log` DISABLE KEYS */;
INSERT INTO `train_log` VALUES ('1','1','1');
/*!40000 ALTER TABLE `train_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-21  7:08:09
