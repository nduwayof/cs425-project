-- MySQL dump 10.13  Distrib 8.0.15, for macos10.14 (x86_64)
--
-- Host: uasdb.cusad7hlzfxk.us-east-2.rds.amazonaws.com    Database: presentation-db
-- ------------------------------------------------------
-- Server version	8.0.15

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `aircraft`
--

DROP TABLE IF EXISTS `aircraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `aircraft` (
  `aircraft_id` int(11) NOT NULL AUTO_INCREMENT,
  `aircraft_model` varchar(255) DEFAULT NULL,
  `business_capacity` int(11) NOT NULL,
  `economy_capacity` int(11) NOT NULL,
  `registration_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aircraft_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aircraft`
--

LOCK TABLES `aircraft` WRITE;
/*!40000 ALTER TABLE `aircraft` DISABLE KEYS */;
INSERT INTO `aircraft` VALUES (1,'Boeing 787-8',15,30,'B78X'),(2,'Boeing 787-8',15,45,'B788');
/*!40000 ALTER TABLE `aircraft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `airport` (
  `airport_id` int(11) NOT NULL AUTO_INCREMENT,
  `airport_code` varchar(255) DEFAULT NULL,
  `airport_name` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`airport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES (1,'ETB','Entebbe Internamtional Airport','Entebbe','Uganda'),(2,'NBO','JKIA Nairobi','Nairobi','Kenya'),(3,'KGL','Kigali International Airport','Kigali','Rwanda');
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `booking_cost` double DEFAULT NULL,
  `booking_status` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `flight_flight_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FKlnnelfsha11xmo2ndjq66fvro` (`customer_id`),
  KEY `FKfgvun0amyvoviy0gc6teawo16` (`flight_flight_id`),
  CONSTRAINT `FKfgvun0amyvoviy0gc6teawo16` FOREIGN KEY (`flight_flight_id`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `FKlnnelfsha11xmo2ndjq66fvro` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,240,0,1,1),(2,240,1,2,1),(3,240,0,3,1),(4,240,0,4,1),(5,240,1,5,1),(6,720,0,6,1),(7,240,1,7,1);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_passenger`
--

DROP TABLE IF EXISTS `booking_passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking_passenger` (
  `booking_booking_id` int(11) NOT NULL,
  `passengers_passenger_id` int(11) NOT NULL,
  UNIQUE KEY `UK_o1qleibdxdvjcjd3hc4ljlm97` (`passengers_passenger_id`),
  KEY `FK59tqp5ohupkcjlnys5oojvdyb` (`booking_booking_id`),
  CONSTRAINT `FK59tqp5ohupkcjlnys5oojvdyb` FOREIGN KEY (`booking_booking_id`) REFERENCES `booking` (`booking_id`),
  CONSTRAINT `FKjxcbkkxdd6n0lnc3romhb9w0j` FOREIGN KEY (`passengers_passenger_id`) REFERENCES `passenger` (`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_passenger`
--

LOCK TABLES `booking_passenger` WRITE;
/*!40000 ALTER TABLE `booking_passenger` DISABLE KEYS */;
INSERT INTO `booking_passenger` VALUES (1,1);
/*!40000 ALTER TABLE `booking_passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'nduwayof@icloud.com','Nduwayo',0,'Fabrice','','788263933'),(2,'bbwengye@mum.edu','Brian',0,'Bwengye','C','2567383281'),(3,'nduwayof@icloud.com','Nduwayo',0,'Fabrice','','6272728082'),(4,'fnduwayo@mum.edu','Fabrice',0,'Nduwayo','','3124688788'),(5,'msoroncho@gmail.com','Faustin',0,'Soroncho','','0728852756'),(6,'fsoroncho@mum.edu','Lukas',0,'Soroncho','M','777887'),(7,'msoroncho@gmail.com','Chinedu',0,'Raphael','M','0728852756');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight` (
  `flight_id` int(11) NOT NULL AUTO_INCREMENT,
  `arrival_time` datetime(6) DEFAULT NULL,
  `business_cost` double DEFAULT NULL,
  `departure_time` datetime(6) DEFAULT NULL,
  `economy_cost` double DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `aircraft_aircraft_id` int(11) DEFAULT NULL,
  `arrival_airport_airport_id` int(11) DEFAULT NULL,
  `departure_airport_airport_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`flight_id`),
  KEY `FK98q69epkawxnm44tayvrppdbs` (`aircraft_aircraft_id`),
  KEY `FKjssndqlu4yb3w5doyomboforr` (`arrival_airport_airport_id`),
  KEY `FK3oa47xgnaiy3jyqk2j1a4bdmq` (`departure_airport_airport_id`),
  CONSTRAINT `FK3oa47xgnaiy3jyqk2j1a4bdmq` FOREIGN KEY (`departure_airport_airport_id`) REFERENCES `airport` (`airport_id`),
  CONSTRAINT `FK98q69epkawxnm44tayvrppdbs` FOREIGN KEY (`aircraft_aircraft_id`) REFERENCES `aircraft` (`aircraft_id`),
  CONSTRAINT `FKjssndqlu4yb3w5doyomboforr` FOREIGN KEY (`arrival_airport_airport_id`) REFERENCES `airport` (`airport_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (1,'2019-08-16 19:00:00.000000',280,'2019-08-16 17:00:00.000000',240,'UG0001',1,2,1),(2,'2019-08-16 18:45:00.000000',350,'2019-08-16 17:45:00.000000',270,'UG0002',1,3,2),(3,'2019-08-17 00:45:00.000000',398,'2019-08-16 23:45:00.000000',350,'UG0003',1,2,1),(4,'2019-08-24 18:20:00.000000',500,'2019-08-24 17:20:00.000000',450,'UG0004',2,1,3),(5,'2019-08-24 18:20:00.000000',550,'2019-08-24 17:20:00.000000',450,'UG0005',2,1,3);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_class`
--

DROP TABLE IF EXISTS `flight_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight_class` (
  `flight_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `flight_class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`flight_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_class`
--

LOCK TABLES `flight_class` WRITE;
/*!40000 ALTER TABLE `flight_class` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_cost`
--

DROP TABLE IF EXISTS `flight_cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `flight_cost` (
  `flight_coast_id` int(11) NOT NULL AUTO_INCREMENT,
  `cost` double NOT NULL,
  `flight_type` varchar(255) DEFAULT NULL,
  `flight_flight_id` int(11) DEFAULT NULL,
  `flight_class_flight_class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`flight_coast_id`),
  KEY `FKj4uco16evsakx3ugaondxa8e5` (`flight_flight_id`),
  KEY `FKoloiwg47ck4kgk8iveq1ytb0q` (`flight_class_flight_class_id`),
  CONSTRAINT `FKj4uco16evsakx3ugaondxa8e5` FOREIGN KEY (`flight_flight_id`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `FKoloiwg47ck4kgk8iveq1ytb0q` FOREIGN KEY (`flight_class_flight_class_id`) REFERENCES `flight_class` (`flight_class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_cost`
--

LOCK TABLES `flight_cost` WRITE;
/*!40000 ALTER TABLE `flight_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `passenger` (
  `passenger_id` int(11) NOT NULL AUTO_INCREMENT,
  `destination_address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `passenger_class` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `booking_booking_id` int(11) DEFAULT NULL,
  `flight_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`passenger_id`),
  KEY `FKlua695na8cyh2xe6bi94d0b18` (`booking_booking_id`),
  KEY `FKr5a1oojukm72i234yfsm7qmfs` (`flight_id`),
  CONSTRAINT `FKlua695na8cyh2xe6bi94d0b18` FOREIGN KEY (`booking_booking_id`) REFERENCES `booking` (`booking_id`),
  CONSTRAINT `FKr5a1oojukm72i234yfsm7qmfs` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`flight_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (1,'KN 8 Ave, Kigali, Rwanda','nduwayof@icloud.com','Nduwayo',0,'Fabrice','of','Economy','3124688754',1,1),(2,'Kn 527 Nairobi','bbwengye@mum.edu','Brian',0,'Bwengye','C','Economy','2567383281',2,1),(3,'KN 8 Ave, Kigali, Rwanda','nduwayof@icloud.com','Nduwayo',0,'Fabrice','','Economy','8373838391',3,1),(4,'Nairobo Kenya','fnduwayo@mum.edu','Fabrice',0,'Nduwayo','','Economy','3124688788',4,1),(5,'1000 N. 4th Street','msoroncho@gmail.com','Faustin',0,'Soroncho','','Economy','6418191059',5,1),(6,'1000 N. 4th Street','msoroncho@gmail.com','Faustin',0,'Soroncho','M','Economy','0728852756',6,1),(7,'1000 N. 4th Street','msoroncho@gmail.com','Faustin',0,'Soroncho','','Economy','0728852756',6,1),(8,'1000 N. 4th Street','msoroncho@gmail.com','Lukas',0,'Joseph','M','Economy','0728852756',6,1),(9,'KG 200','msoroncho@gmail.com','Chinedu',0,'Raphael','M','Economy','0728852756',7,1);
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `payment_type` varchar(255) DEFAULT NULL,
  `booking_booking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`payment_id`),
  KEY `FKrfa1skvg2qhkwkwl73eedk2mu` (`booking_booking_id`),
  CONSTRAINT `FKrfa1skvg2qhkwkwl73eedk2mu` FOREIGN KEY (`booking_booking_id`) REFERENCES `booking` (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,240,'PayPalOrCard',2),(2,240,'PayPalOrCard',2),(3,240,'PayPalOrCard',5),(4,240,'PayPalOrCard',7);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_ADMINISTRATOR'),(2,'ROLE_MANAGER'),(3,'ROLE_CUSTOMER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `staff` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket` (
  `ticket_no` int(11) NOT NULL AUTO_INCREMENT,
  `booking_booking_id` int(11) DEFAULT NULL,
  `flight_flight_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ticket_no`),
  KEY `FKkghbqrr70nm2jk2xqvop860s3` (`booking_booking_id`),
  KEY `FKetdsicox549rxl5orbkj27gy2` (`flight_flight_id`),
  CONSTRAINT `FKetdsicox549rxl5orbkj27gy2` FOREIGN KEY (`flight_flight_id`) REFERENCES `flight` (`flight_id`),
  CONSTRAINT `FKkghbqrr70nm2jk2xqvop860s3` FOREIGN KEY (`booking_booking_id`) REFERENCES `booking` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `names` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '','admin@ugandaairlines.com','Fabrice Nduwayo','$2a$10$qi7T0NbbwdCB7zfmDN/FW.S3Z1sO2wT7/U8U6ehzFbLIeVRYrsGcG','3126488754','STAFF'),(2,_binary '','manager@ugandaairlines.com','Fabrice Nduwayo','$2a$10$qi7T0NbbwdCB7zfmDN/FW.S3Z1sO2wT7/U8U6ehzFbLIeVRYrsGcG','3126488754','STAFF');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-15 16:49:42
