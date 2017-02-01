CREATE DATABASE  IF NOT EXISTS `sem4` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sem4`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: sem4
-- ------------------------------------------------------
-- Server version	5.6.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('saumyaj','saumya123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop`
--

DROP TABLE IF EXISTS `crop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crop` (
  `crop_id` int(11) NOT NULL,
  `crop_name` varchar(45) NOT NULL,
  `min_rainfall` decimal(5,0) NOT NULL,
  `max_rainfall` decimal(5,0) NOT NULL,
  `min_temp` decimal(5,0) NOT NULL,
  `max_temp` decimal(5,0) NOT NULL,
  `MRP` decimal(6,0) DEFAULT NULL,
  `yield` int(11) DEFAULT NULL,
  `water` int(11) NOT NULL,
  PRIMARY KEY (`crop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop`
--

LOCK TABLES `crop` WRITE;
/*!40000 ALTER TABLE `crop` DISABLE KEYS */;
INSERT INTO `crop` VALUES (1,'Rice',175,300,20,27,1450,2372,130000),(2,'Jowar',60,70,26,33,1590,954,70000),(3,'Bajra',40,50,25,31,1295,1156,35000),(4,'Ragi',70,120,27,31,1650,748,80000),(5,'Maize',50,75,21,27,1325,2476,35000),(6,'Jute',170,150,27,30,2700,2422,120000),(7,'wheat',50,75,14,18,1450,3140,45000),(8,'Barley',40,50,22,26,1150,1803,40000),(9,'Mustard',35,45,4,5,3100,1135,35000),(10,'Coriander',10,15,20,40,2000,600,20000),(11,'coffee',152,203,23,27,4000,838,100000),(12,'Cotton',50,100,21,30,4100,491,40000),(13,'Sugarcane',110,150,32,38,230,70000,90000),(14,'tea',150,250,21,29,15000,1695,110000);
/*!40000 ALTER TABLE `crop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crop_type_link`
--

DROP TABLE IF EXISTS `crop_type_link`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crop_type_link` (
  `type_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  PRIMARY KEY (`crop_id`,`type_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `crop_type_link_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `crops_type` (`type_id`),
  CONSTRAINT `crop_type_link_ibfk_2` FOREIGN KEY (`crop_id`) REFERENCES `crop` (`crop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crop_type_link`
--

LOCK TABLES `crop_type_link` WRITE;
/*!40000 ALTER TABLE `crop_type_link` DISABLE KEYS */;
/*!40000 ALTER TABLE `crop_type_link` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crops_type`
--

DROP TABLE IF EXISTS `crops_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crops_type` (
  `type_id` int(11) NOT NULL,
  `crop_type` varchar(45) NOT NULL,
  `start_month` varchar(45) NOT NULL,
  `end_month` varchar(45) NOT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crops_type`
--

LOCK TABLES `crops_type` WRITE;
/*!40000 ALTER TABLE `crops_type` DISABLE KEYS */;
INSERT INTO `crops_type` VALUES (1,'Rabi','October','March'),(2,'Kharif','July','October'),(3,'Cash','January','December'),(4,'Plantation','January','December');
/*!40000 ALTER TABLE `crops_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rainforecast`
--

DROP TABLE IF EXISTS `rainforecast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rainforecast` (
  `id` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `month` varchar(45) NOT NULL,
  `amount` decimal(6,3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rainforecast`
--

LOCK TABLES `rainforecast` WRITE;
/*!40000 ALTER TABLE `rainforecast` DISABLE KEYS */;
INSERT INTO `rainforecast` VALUES (1,2012,'january',20.000),(2,2012,'february',14.000),(3,2012,'march',15.000),(4,2012,'april',21.000),(5,2012,'may',25.000),(6,2012,'june',70.000),(7,2012,'july',245.000),(8,2012,'august',250.000),(9,2012,'september',114.000),(10,2012,'october',17.000),(11,2012,'november',9.000),(12,2012,'december',10.000),(13,2013,'january',18.000),(14,2013,'february',22.000),(15,2013,'march',21.000),(16,2013,'april',25.000),(17,2013,'may',24.000),(18,2013,'june',88.000),(19,2013,'july',285.000),(20,2013,'august',275.000),(21,2013,'september',126.000),(22,2013,'october',21.000),(23,2013,'november',10.000),(24,2013,'december',11.000),(25,2014,'january',19.000),(26,2014,'february',19.000),(27,2014,'march',21.000),(28,2014,'april',29.000),(29,2014,'may',35.000),(30,2014,'june',125.000),(31,2014,'july',284.000),(32,2014,'august',295.000),(33,2014,'september',140.000),(34,2014,'october',20.000),(35,2014,'november',13.000),(36,2014,'december',11.000),(37,2015,'january',10.000),(38,2015,'february',12.000),(39,2015,'march',13.000),(40,2015,'april',30.000),(41,2015,'may',25.000),(42,2015,'june',125.000),(43,2015,'july',278.000),(44,2015,'august',291.000),(45,2015,'september',125.000),(46,2015,'october',21.000),(47,2015,'november',9.000),(48,2015,'december',10.000);
/*!40000 ALTER TABLE `rainforecast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `riverwater`
--

DROP TABLE IF EXISTS `riverwater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `riverwater` (
  `id` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `month` varchar(45) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `riverwater`
--

LOCK TABLES `riverwater` WRITE;
/*!40000 ALTER TABLE `riverwater` DISABLE KEYS */;
INSERT INTO `riverwater` VALUES (1,2012,'january',10),(2,2012,'february',10),(3,2012,'march',20),(4,2012,'april',25),(5,2012,'may',28),(6,2012,'june',100),(7,2012,'july',150),(8,2012,'august',120),(9,2012,'september',70),(10,2012,'october',60),(11,2012,'november',50),(12,2012,'december',20),(13,2013,'january',9),(14,2013,'february',11),(15,2013,'march',21),(16,2013,'april',27),(17,2013,'may',21),(18,2013,'june',110),(19,2013,'july',140),(20,2013,'august',130),(21,2013,'september',60),(22,2013,'october',60),(23,2013,'november',40),(24,2013,'december',20),(25,2014,'january',11),(26,2014,'february',9),(27,2014,'march',22),(28,2014,'april',26),(29,2014,'may',22),(30,2014,'june',100),(31,2014,'july',130),(32,2014,'august',135),(33,2014,'september',65),(34,2014,'october',55),(35,2014,'november',45),(36,2014,'december',21),(37,2015,'january',12),(38,2015,'february',11),(39,2015,'march',21),(40,2015,'april',27),(41,2015,'may',23),(42,2015,'june',120),(43,2015,'july',150),(44,2015,'august',140),(45,2015,'september',75),(46,2015,'october',65),(47,2015,'november',50),(48,2015,'december',21);
/*!40000 ALTER TABLE `riverwater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil`
--

DROP TABLE IF EXISTS `soil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soil` (
  `id` int(11) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil`
--

LOCK TABLES `soil` WRITE;
/*!40000 ALTER TABLE `soil` DISABLE KEYS */;
INSERT INTO `soil` VALUES (1,'Alluvial Soil'),(2,'Red Soil'),(3,'Black Soil'),(4,'Laterite Soil'),(5,'Mountain Soil'),(6,'Clay Soil'),(7,'Desert Soil'),(8,' Asd');
/*!40000 ALTER TABLE `soil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soil_crop`
--

DROP TABLE IF EXISTS `soil_crop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soil_crop` (
  `soil_id` int(11) NOT NULL,
  `crop_id` int(11) NOT NULL,
  PRIMARY KEY (`soil_id`,`crop_id`),
  KEY `crop_id_idx` (`crop_id`),
  CONSTRAINT `crop_id` FOREIGN KEY (`crop_id`) REFERENCES `crop` (`crop_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id` FOREIGN KEY (`soil_id`) REFERENCES `soil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soil_crop`
--

LOCK TABLES `soil_crop` WRITE;
/*!40000 ALTER TABLE `soil_crop` DISABLE KEYS */;
INSERT INTO `soil_crop` VALUES (1,1),(2,1),(3,1),(3,2),(7,2),(3,3),(7,3),(2,4),(1,5),(7,5),(1,6),(1,7),(2,7),(3,7),(7,8),(3,9),(1,10),(3,10),(4,10),(4,11),(5,11),(1,12),(3,12),(1,13),(2,13),(3,13),(4,14),(5,14);
/*!40000 ALTER TABLE `soil_crop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-23  3:15:45
