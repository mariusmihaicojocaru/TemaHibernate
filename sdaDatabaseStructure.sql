-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: localhost    Database: sdaPython
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendances`
--

DROP TABLE IF EXISTS `attendances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attendances` (
  `attendanceId` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `isPresent` tinyint(1) NOT NULL,
  `moduleId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  PRIMARY KEY (`attendanceId`),
  KEY `fk_attendance_module_idx` (`moduleId`),
  KEY `fk_attendance_student_idx` (`studentId`),
  CONSTRAINT `fk_attendance_module` FOREIGN KEY (`moduleId`) REFERENCES `modules` (`moduleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_attendance_student` FOREIGN KEY (`studentId`) REFERENCES `persons` (`personId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendances`
--

LOCK TABLES `attendances` WRITE;
/*!40000 ALTER TABLE `attendances` DISABLE KEYS */;
INSERT INTO `attendances` VALUES (1,'2019-01-01',1,2,7),(2,'2019-01-01',0,2,8),(3,'2019-01-02',1,2,7),(4,'2019-01-02',1,2,8),(5,'2019-01-03',1,2,7),(6,'2019-01-03',1,2,8);
/*!40000 ALTER TABLE `attendances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classrooms`
--

DROP TABLE IF EXISTS `classrooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classrooms` (
  `classroomId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`classroomId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classrooms`
--

LOCK TABLES `classrooms` WRITE;
/*!40000 ALTER TABLE `classrooms` DISABLE KEYS */;
INSERT INTO `classrooms` VALUES (1,'BucharestCowork','Bucharest, Aviatorilor 23'),(2,'Riga Business Center','Riga, Loften 23'),(3,'Tallin Cozy Space','Tallin, Torgaten 13'),(4,'Cluj Intensa','Cluj Napoca, Sopor 21');
/*!40000 ALTER TABLE `classrooms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modules`
--

DROP TABLE IF EXISTS `modules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `modules` (
  `moduleId` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `teamId` int(11) NOT NULL,
  `topicId` int(11) NOT NULL,
  `trainerId` int(11) NOT NULL,
  `classroomId` int(11) NOT NULL,
  PRIMARY KEY (`moduleId`),
  KEY `fk_module_team_idx` (`teamId`),
  KEY `fk_module_subject_idx` (`topicId`),
  KEY `fk_module_trainer_idx` (`trainerId`),
  KEY `fk_module_classroom_idx` (`classroomId`),
  CONSTRAINT `fk_module_classroom` FOREIGN KEY (`classroomId`) REFERENCES `classrooms` (`classroomId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_module_team` FOREIGN KEY (`teamId`) REFERENCES `teams` (`teamId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_module_topic` FOREIGN KEY (`topicId`) REFERENCES `topics` (`topicId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_module_trainer` FOREIGN KEY (`trainerId`) REFERENCES `persons` (`personId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modules`
--

LOCK TABLES `modules` WRITE;
/*!40000 ALTER TABLE `modules` DISABLE KEYS */;
INSERT INTO `modules` VALUES (1,'2020-03-01','2020-03-15',4,6,4,3),(2,'2019-01-01','2019-02-01',1,3,5,1),(3,'2020-02-02','2020-02-16',2,1,5,4);
/*!40000 ALTER TABLE `modules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `persons` (
  `personId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `isTrainer` tinyint(1) NOT NULL DEFAULT '0',
  `teamId` int(11) DEFAULT NULL,
  PRIMARY KEY (`personId`),
  KEY `fk_student_team_idx` (`teamId`),
  CONSTRAINT `fk_student_team` FOREIGN KEY (`teamId`) REFERENCES `teams` (`teamId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,'John','Johnson','john@johnson.com','1990-01-01',0,4),(2,'Jim','Jameson','jim@jameson.com','1980-01-02',0,4),(3,'Sofia','Sophie','sofia@sophie.com','1995-02-02',0,3),(4,'Mark','Marks','mark@marks.com','1983-01-09',1,NULL),(5,'Pete','Peterson','pete@peterson.com','1975-09-09',1,NULL),(6,'Todd','Toddler','todd@toddler.com','1992-12-12',0,2),(7,'Anne','Anita','anne@anita.com','1993-02-02',0,1),(8,'Barbara','Barbs','barbara@barbs.com','1990-08-07',0,1);
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teams`
--

DROP TABLE IF EXISTS `teams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teams` (
  `teamId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teamId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teams`
--

LOCK TABLES `teams` WRITE;
/*!40000 ALTER TABLE `teams` DISABLE KEYS */;
INSERT INTO `teams` VALUES (1,'Python1Bucharest'),(2,'Java1ClujNapoca'),(3,'Tester1Riga'),(4,'Python1Tallin'),(5,'Java13Arad');
/*!40000 ALTER TABLE `teams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topics`
--

DROP TABLE IF EXISTS `topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `topics` (
  `topicId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`topicId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topics`
--

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` VALUES (1,'Java Fundamentals'),(2,'Java Advanced'),(3,'SQL'),(4,'HTTP'),(5,'Linux'),(6,'Python Fundamentals'),(7,'Python Advanced'),(8,'Final Project');
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-11 11:38:16
