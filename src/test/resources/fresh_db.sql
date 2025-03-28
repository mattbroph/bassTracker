-- MySQL dump 10.13  Distrib 8.0.35, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bass_tracker_test
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appuser`
--

DROP TABLE IF EXISTS `appuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appuser` (
                           `UserID` int NOT NULL AUTO_INCREMENT,
                           `UserEmail` varchar(50) NOT NULL,
                           `FirstName` varchar(50) NOT NULL,
                           `LastName` varchar(50) NOT NULL,
                           `ProfilePicture` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`UserID`),
                           UNIQUE KEY `UserEmail` (`UserEmail`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appuser`
--

LOCK TABLES `appuser` WRITE;
/*!40000 ALTER TABLE `appuser` DISABLE KEYS */;
INSERT INTO `appuser` VALUES (1,'mattbroph@gmail.com','Matt','Brophy','https://urltomattspic'),(2,'johnB@gmail.com','John','Brophy','https://urltojohnspic'),(3,'frodoB@gmail.com','Frodo','Baggins','https://urltofrodospic');
/*!40000 ALTER TABLE `appuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bassgoal`
--

DROP TABLE IF EXISTS `bassgoal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bassgoal` (
                            `GoalID` int NOT NULL AUTO_INCREMENT,
                            `UserID` int NOT NULL,
                            `GoalYear` year NOT NULL,
                            `GoalCount` int NOT NULL,
                            PRIMARY KEY (`GoalID`),
                            UNIQUE KEY `UserID` (`UserID`,`GoalYear`),
                            CONSTRAINT `FK_BassGoal_User` FOREIGN KEY (`UserID`) REFERENCES `appuser` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bassgoal`
--

LOCK TABLES `bassgoal` WRITE;
/*!40000 ALTER TABLE `bassgoal` DISABLE KEYS */;
INSERT INTO `bassgoal` VALUES (1,1,2025,150),(2,1,2024,120),(3,2,2025,90),(4,3,2025,32);
/*!40000 ALTER TABLE `bassgoal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal`
--

DROP TABLE IF EXISTS `journal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journal` (
                           `JournalID` int NOT NULL AUTO_INCREMENT,
                           `UserID` int NOT NULL,
                           `JournalDate` date NOT NULL,
                           `LakeID` int NOT NULL,
                           `Hours` double NOT NULL,
                           `MethodID` int NOT NULL,
                           `AirTemp` int NOT NULL,
                           `WeatherID` int NOT NULL,
                           `WindID` int NOT NULL,
                           `Comments` text,
                           `ImageURL` varchar(255) DEFAULT NULL,
                           `SM_14_16` int NOT NULL,
                           `SM_16_19` int NOT NULL,
                           `SM_19_PLUS` int NOT NULL,
                           `LM_14_16` int NOT NULL,
                           `LM_16_19` int NOT NULL,
                           `LM_19_PLUS` int NOT NULL,
                           PRIMARY KEY (`JournalID`),
                           KEY `FK_Wind` (`WindID`),
                           KEY `FK_Weather` (`WeatherID`),
                           KEY `FK_Method` (`MethodID`),
                           KEY `FK_Journal_User` (`UserID`),
                           KEY `FK_Lake` (`LakeID`),
                           CONSTRAINT `FK_Journal_User` FOREIGN KEY (`UserID`) REFERENCES `appuser` (`UserID`),
                           CONSTRAINT `FK_Lake` FOREIGN KEY (`LakeID`) REFERENCES `lake` (`LakeID`),
                           CONSTRAINT `FK_Method` FOREIGN KEY (`MethodID`) REFERENCES `method` (`MethodID`),
                           CONSTRAINT `FK_Weather` FOREIGN KEY (`WeatherID`) REFERENCES `weather` (`WeatherID`),
                           CONSTRAINT `FK_Wind` FOREIGN KEY (`WindID`) REFERENCES `wind` (`WindID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal`
--

LOCK TABLES `journal` WRITE;
/*!40000 ALTER TABLE `journal` DISABLE KEYS */;
INSERT INTO `journal` VALUES (1,1,'2025-02-25',2,5,2,80,2,2,'Had a really good time fishing today','https://myimage.com',2,3,4,8,1,0),(2,1,'2025-02-24',1,2,3,75,1,1,'Had so much fun','https://myimage2.com',1,1,0,0,1,0),(3,2,'2025-02-24',4,2,3,62,3,4,'What a day','https://myimage3.com',1,11,0,10,1,0),(4,3,'2025-02-24',6,2,3,90,4,3,'Today was rough','https://myimage4.com',1,1,0,0,6,9),(5,1,'2025-02-23',3,4,1,72,2,3,'Calm and relaxing day','http://fakeImage1.com',2,2,1,3,0,0),(6,1,'2025-02-22',2,3,4,65,3,1,'Caught a few nice ones','http://fakeImage2.com',1,2,0,2,1,0),(7,1,'2025-02-21',1,6,2,78,5,5,'Best fishing this year!','http://fakeImage3.com',3,4,2,5,1,1),(8,1,'2025-02-20',1,2,3,55,1,2,'Chilly but worth it','http://fakeImage4.com',0,1,0,2,1,0),(9,1,'2025-02-19',2,5,5,82,4,4,'Great variety today','http://fakeImage5.com',2,3,1,3,2,0),(10,1,'2025-02-18',3,3,1,70,2,3,'Had a blast!','http://fakeImage6.com',1,1,0,4,2,1),(11,1,'2025-02-17',2,4,2,76,3,5,'Steady action all day','http://fakeImage7.com',2,2,1,3,3,1),(12,1,'2025-02-16',3,5,3,80,1,2,'Weather was perfect','http://fakeImage8.com',3,4,2,5,2,0),(13,1,'2025-02-15',1,2,4,60,5,1,'Bit slow, but enjoyable','http://fakeImage9.com',1,0,0,1,2,0),(14,1,'2025-02-14',2,3,5,68,2,4,'Hooked some nice ones','http://fakeImage10.com',2,3,0,4,1,0);
/*!40000 ALTER TABLE `journal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lake`
--

DROP TABLE IF EXISTS `lake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lake` (
                        `LakeID` int NOT NULL AUTO_INCREMENT,
                        `LakeName` varchar(50) NOT NULL,
                        `UserID` int NOT NULL,
                        `isActive` tinyint(1) DEFAULT '1',
                        PRIMARY KEY (`LakeID`),
                        UNIQUE KEY `UserID` (`UserID`,`LakeName`),
                        CONSTRAINT `FK_Lake_User` FOREIGN KEY (`UserID`) REFERENCES `appuser` (`UserID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lake`
--

LOCK TABLES `lake` WRITE;
/*!40000 ALTER TABLE `lake` DISABLE KEYS */;
INSERT INTO `lake` VALUES (1,'Lake Kegonsa',1,1),(2,'Lake Mendota',1,1),(3,'Lake Monona',1,1),(4,'Fake Lake',1,0),(5,'Boom Lake',2,1),(6,'Lake Flannery',2,1),(7,'Lake Michigan',3,1);
/*!40000 ALTER TABLE `lake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `method`
--

DROP TABLE IF EXISTS `method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `method` (
                          `MethodID` int NOT NULL AUTO_INCREMENT,
                          `MethodName` varchar(50) NOT NULL,
                          PRIMARY KEY (`MethodID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `method`
--

LOCK TABLES `method` WRITE;
/*!40000 ALTER TABLE `method` DISABLE KEYS */;
INSERT INTO `method` VALUES (1,'Crankbaits'),(2,'Shoreline fishing'),(3,'Bed fishing'),(4,'Ned rig'),(5,'Wacky worm'),(6,'Lindy rig'),(7,'Swim bait'),(8,'Swim jig'),(9,'Drop shot'),(10,'Crib fishing'),(11,'Fly fishing'),(12,'Other');
/*!40000 ALTER TABLE `method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weather`
--

DROP TABLE IF EXISTS `weather`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weather` (
                           `WeatherID` int NOT NULL AUTO_INCREMENT,
                           `WeatherType` varchar(50) NOT NULL,
                           PRIMARY KEY (`WeatherID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weather`
--

LOCK TABLES `weather` WRITE;
/*!40000 ALTER TABLE `weather` DISABLE KEYS */;
INSERT INTO `weather` VALUES (1,'Sunny'),(2,'Partly Sunny'),(3,'Cloudy'),(4,'Partly Cloudy'),(5,'Rain');
/*!40000 ALTER TABLE `weather` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wind`
--

DROP TABLE IF EXISTS `wind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wind` (
                        `WindID` int NOT NULL AUTO_INCREMENT,
                        `WindType` varchar(50) NOT NULL,
                        PRIMARY KEY (`WindID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wind`
--

LOCK TABLES `wind` WRITE;
/*!40000 ALTER TABLE `wind` DISABLE KEYS */;
INSERT INTO `wind` VALUES (1,'0-5 mph'),(2,'5-10 mph'),(3,'10-15 mph'),(4,'15-20 mph'),(5,'20+ mph');
/*!40000 ALTER TABLE `wind` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-04  8:14:02
