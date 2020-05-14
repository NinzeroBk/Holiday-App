-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: holiday
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `attractions`
--

DROP TABLE IF EXISTS `attractions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attractions` (
  `attractionId` int NOT NULL AUTO_INCREMENT,
  `description` varchar(76) NOT NULL,
  `locationId` int NOT NULL,
  `baseCost` double NOT NULL,
  `name` varchar(26) NOT NULL,
  `year` int NOT NULL,
  PRIMARY KEY (`attractionId`),
  KEY `locationFK_idx` (`locationId`),
  CONSTRAINT `locationFK` FOREIGN KEY (`locationId`) REFERENCES `locations` (`locationId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `attractions_chk_1` CHECK ((length(`description`) < 76)),
  CONSTRAINT `attractions_chk_2` CHECK ((`baseCost` >= 0)),
  CONSTRAINT `attractions_chk_3` CHECK ((length(`name`) < 26)),
  CONSTRAINT `attractions_chk_4` CHECK ((`year` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attractions`
--

LOCK TABLES `attractions` WRITE;
/*!40000 ALTER TABLE `attractions` DISABLE KEYS */;
INSERT INTO `attractions` VALUES (1,'TestDescription',1,100,'Harbour',1400),(2,'aa',1,23.4,'ok',2),(4,'It\'s really nice beautiful painting.',1,1250.3,'PicturePicture',1988);
/*!40000 ALTER TABLE `attractions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `countryId` int NOT NULL AUTO_INCREMENT,
  `regionId` int NOT NULL,
  `name` varchar(61) NOT NULL,
  PRIMARY KEY (`countryId`),
  KEY `regionFK_idx` (`regionId`),
  CONSTRAINT `regionFK` FOREIGN KEY (`regionId`) REFERENCES `regions` (`regionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `countries_chk_1` CHECK ((length(`name`) < 61))
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,1,'Germany'),(2,1,'Romania123'),(3,1,'France'),(5,1,'Italy');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expenses` (
  `expenseId` int NOT NULL AUTO_INCREMENT,
  `visitedId` int NOT NULL,
  `price` double NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`expenseId`),
  KEY `visitedFK_idx` (`visitedId`),
  CONSTRAINT `visitedFK` FOREIGN KEY (`visitedId`) REFERENCES `visited` (`visitedId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `expenses_chk_1` CHECK ((`price` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses`
--

LOCK TABLES `expenses` WRITE;
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` VALUES (4,14,55.49,'Chocolate cake'),(9,22,20,'Branza'),(11,30,28.214,'Seeds'),(12,32,50,'OK'),(14,32,5.46,'Biscuits');
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holidays`
--

DROP TABLE IF EXISTS `holidays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `holidays` (
  `holidayId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `title` varchar(26) NOT NULL,
  `description` varchar(101) DEFAULT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  PRIMARY KEY (`holidayId`),
  KEY `usernameFK_idx` (`username`),
  CONSTRAINT `usernameFK` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chk_holiday_date` CHECK ((`startDate` <= `endDate`)),
  CONSTRAINT `holidays_chk_1` CHECK ((length(`title`) < 26)),
  CONSTRAINT `holidays_chk_2` CHECK ((length(`description`) < 101))
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holidays`
--

LOCK TABLES `holidays` WRITE;
/*!40000 ALTER TABLE `holidays` DISABLE KEYS */;
INSERT INTO `holidays` VALUES (4,'TestUser','NewTitle','CoolDesc hmm','2020-04-30','2023-04-28'),(13,'TestUser','FFFFFFFoook','lnlk','2014-01-28','2020-01-01'),(19,'TestUser','AmusingCool','DESCRIEREEE!!','2020-01-01','2021-01-01'),(21,'TestUser','Longest','Longest Holiday!!!','1974-01-01','2020-01-01'),(26,'penguin','School is over',NULL,'2021-01-01','2022-02-01'),(27,'penguin','Christmas','COOL','2025-02-01','2026-02-01');
/*!40000 ALTER TABLE `holidays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `locationId` int NOT NULL AUTO_INCREMENT,
  `countryId` int NOT NULL,
  `streetAddress` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `stateProvince` varchar(45) NOT NULL,
  PRIMARY KEY (`locationId`),
  KEY `countryFK_idx` (`countryId`),
  CONSTRAINT `countryFK` FOREIGN KEY (`countryId`) REFERENCES `countries` (`countryId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,1,'TestStreet','Frankfurt','Hessa-Nassau'),(2,1,'AnotherStreet','Munich','Bavaria'),(6,2,'Strada Pateului','Bucuresti','Ilfov');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regions` (
  `regionId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`regionId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (1,'Europe'),(3,'South America');
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resources`
--

DROP TABLE IF EXISTS `resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resources` (
  `resourceId` int NOT NULL AUTO_INCREMENT,
  `visitedId` int NOT NULL,
  `title` varchar(26) NOT NULL,
  `imageUrl` varchar(201) NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`resourceId`),
  KEY `visited_resources_FK_idx` (`visitedId`),
  CONSTRAINT `visited_resources_FK` FOREIGN KEY (`visitedId`) REFERENCES `visited` (`visitedId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `resources_chk_1` CHECK ((length(`title`) < 26))
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resources`
--

LOCK TABLES `resources` WRITE;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` VALUES (3,14,'Foster\'s Home','https://m.media-amazon.com/images/M/MV5BNjYyNGFjOTctYzFmNC00NzdmLThhMDgtNjEzZTRmNzA3ODc5XkEyXkFqcGdeQXVyNjk1Njg5NTA@._V1_UY1200_CR94,0,630,1200_AL_.jpg','2020-04-29 16:08:38'),(4,6,'Amazing','https://miro.medium.com/max/1200/1*mk1-6aYaf_Bes1E3Imhc0A.jpeg','2020-05-08 12:48:05'),(6,30,'ASD','https://images.genius.com/6994a5b4220f6dcabbfa736da85f6b96.1000x1000x1.jpg','2020-01-01 00:00:00'),(7,32,'My Family','https://images.unsplash.com/photo-1551415923-a2297c7fda79?ixlib','2020-01-01 01:00:00'),(9,32,'My Dear Brother','https://www.azocleantech.com/images/Article_Images/ImageForArticle_1061_15837536188863190.png','2020-01-01 00:00:00');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `reviewId` int NOT NULL AUTO_INCREMENT,
  `visitedId` int NOT NULL,
  `title` varchar(26) NOT NULL,
  `content` varchar(251) NOT NULL,
  `rating` double NOT NULL,
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `visitedFK_idx` (`visitedId`),
  CONSTRAINT `visited_reviewFK` FOREIGN KEY (`visitedId`) REFERENCES `visited` (`visitedId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reviews_chk_1` CHECK ((length(`title`) < 26)),
  CONSTRAINT `reviews_chk_2` CHECK ((length(`content`) < 251)),
  CONSTRAINT `reviews_chk_3` CHECK ((`rating` between 1 and 5))
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES (4,6,'sad','sad',2.5,'2020-01-01 00:00:00'),(5,22,'sad','dsa',2.5,'2020-01-01 00:00:00'),(13,21,'YAS','WOOOOOOOOOO',5,'2020-01-01 00:00:00'),(15,30,'Amazing!','I was wonderful',4.12,'2020-01-01 00:00:00'),(16,32,'It sucked!','Uncool',1,'2020-01-01 00:00:00'),(18,32,'asd','asd',2.51,'2020-01-01 01:00:00');
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `emailAddress` varchar(45) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `imageUrl` varchar(200) DEFAULT NULL,
  `password` varchar(21) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `emailAddress_UNIQUE` (`emailAddress`),
  CONSTRAINT `users_chk_1` CHECK (regexp_like(`emailAddress`,_utf8mb4'^[^@]+@[^@]+.[^@]+$')),
  CONSTRAINT `users_chk_2` CHECK ((length(`password`) between 6 and 20))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('sas@aa.co','asda','asdas','asd',NULL,'asdasad'),('asd@sad.asd','asd','asd','asdas',NULL,'asdasd'),('asd@ok.com','asd','asd','asdf',NULL,'asdaasd'),('asd@as.c','asdas','assd','asf',NULL,'asdasasd'),('sjfd@sk.c','h','hfdhsf','dadasd',NULL,'asfasfhasl'),('mypersonalemail@yahoo.com','Andrei','Borcescu','FusedBloxxer',NULL,'MyPassword'),('roblox@yahoo.com','Andrei','Mihael','legoblock222','https://pbs.twimg.com/profile_images/1313425515/Pikachu_and_Buneary_by_FanPikachu_400x400.png','123456'),('a@ok.com','a','a','ok',NULL,'andrei'),('penguin@penguin.penguin','penguin','penguin','penguin','https://upload.wikimedia.org/wikipedia/commons/0/08/South_Shetland-2016-Deception_Island%E2%80%93Chinstrap_penguin_%28Pygoscelis_antarctica%29_04.jpg','paasword'),('student@cti.ro','RandomFirstName','RandomLastName','RandomUser',NULL,'RandomPassword'),('test@gmail.com','TestName','TestLastName','TestUser','https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg','test123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visited`
--

DROP TABLE IF EXISTS `visited`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visited` (
  `visitedId` int NOT NULL AUTO_INCREMENT,
  `holidayId` int NOT NULL,
  `attractionId` int NOT NULL,
  `startDate` datetime NOT NULL,
  `endDate` datetime NOT NULL,
  PRIMARY KEY (`visitedId`),
  KEY `attractionFK_idx` (`attractionId`),
  KEY `holidayFK_idx` (`holidayId`),
  CONSTRAINT `attractionFK` FOREIGN KEY (`attractionId`) REFERENCES `attractions` (`attractionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `holidayFK` FOREIGN KEY (`holidayId`) REFERENCES `holidays` (`holidayId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chk_visited_date` CHECK ((`startDate` <= `endDate`))
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visited`
--

LOCK TABLES `visited` WRITE;
/*!40000 ALTER TABLE `visited` DISABLE KEYS */;
INSERT INTO `visited` VALUES (6,4,4,'2020-04-29 00:00:00','2020-07-28 00:00:00'),(14,4,1,'2020-04-29 00:00:00','2020-04-29 00:00:00'),(15,4,1,'2020-04-29 00:00:00','2020-04-29 00:00:00'),(18,4,1,'2020-01-01 00:00:00','2020-01-01 00:00:00'),(20,19,1,'2020-01-01 00:01:00','2021-01-01 00:00:00'),(21,4,1,'2020-01-01 00:00:00','2021-01-01 01:00:00'),(22,4,1,'2020-01-02 00:00:00','2024-01-01 00:00:00'),(23,13,1,'2020-01-01 01:00:00','2020-01-01 02:00:00'),(30,21,4,'2020-01-01 00:00:00','2020-01-01 00:00:00'),(32,26,1,'2020-01-01 01:00:00','2020-01-01 12:00:00'),(34,26,2,'2020-01-01 00:00:00','2022-01-01 00:00:00'),(35,27,4,'2019-01-01 00:00:00','2020-01-01 00:00:00');
/*!40000 ALTER TABLE `visited` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-10 14:07:24
