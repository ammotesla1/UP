-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: UPtest
-- ------------------------------------------------------
-- Server version	5.7.39

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
-- Table structure for table `check_`
--

DROP TABLE IF EXISTS `check_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `check_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_of_release` varchar(255) DEFAULT NULL,
  `total_cost` double DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `id_order` bigint(20) DEFAULT NULL,
  `register_id` bigint(20) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnnnabd0wmudvl29x61mexsaxj` (`client_id`),
  KEY `FKjblcfd9jswqx6ua1ex1de2172` (`employee_id`),
  KEY `FKfl06x0ikeopdgy9xro2pyttqs` (`id_order`),
  KEY `FK2dppxkptody43jvn29dx4i23q` (`register_id`),
  KEY `FKeel4k3252c8bvpmnwmvk4hx72` (`shift_id`),
  CONSTRAINT `FK2dppxkptody43jvn29dx4i23q` FOREIGN KEY (`register_id`) REFERENCES `register_` (`id`),
  CONSTRAINT `FKeel4k3252c8bvpmnwmvk4hx72` FOREIGN KEY (`shift_id`) REFERENCES `shift_` (`id`),
  CONSTRAINT `FKfl06x0ikeopdgy9xro2pyttqs` FOREIGN KEY (`id_order`) REFERENCES `order_` (`id`),
  CONSTRAINT `FKjblcfd9jswqx6ua1ex1de2172` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKnnnabd0wmudvl29x61mexsaxj` FOREIGN KEY (`client_id`) REFERENCES `client_` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `check_`
--

LOCK TABLES `check_` WRITE;
/*!40000 ALTER TABLE `check_` DISABLE KEYS */;
INSERT INTO `check_` VALUES (2,'12/10/2012',18981,1,1,1,1,NULL);
/*!40000 ALTER TABLE `check_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_`
--

DROP TABLE IF EXISTS `client_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_`
--

LOCK TABLES `client_` WRITE;
/*!40000 ALTER TABLE `client_` DISABLE KEYS */;
INSERT INTO `client_` VALUES (1,'Московская область','danilka.bivol.20@gmail.com','Sergeevich','Vova','+7(909)194-00-04','Petr'),(2,'ул. Тверская 4','ivan@gmail.com','Ivanovich','Ivan','+7(916)123-77-94','Ivanov');
/*!40000 ALTER TABLE `client_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color_`
--

DROP TABLE IF EXISTS `color_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_color` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color_`
--

LOCK TABLES `color_` WRITE;
/*!40000 ALTER TABLE `color_` DISABLE KEYS */;
/*!40000 ALTER TABLE `color_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `shift_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdgi5ceay6ox4qtm5ql2wcatb4` (`shift_id`),
  CONSTRAINT `FKdgi5ceay6ox4qtm5ql2wcatb4` FOREIGN KEY (`shift_id`) REFERENCES `shift_` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,_binary '','danilka.bivol.03@gmail.com','Sergeevich','Danila','$2a$08$3SbSTtUhCnDjUwOVHKdtEeJluUJghqhw8h9j8us9yZx2TUhf6NETm','+7(909)994-94-04','Bivol',NULL),(2,_binary '','casher@gmail.com','Ivanovich','Ivan','$2a$08$SBj0csAXzzcbQoULqjWDneX3t.Ej2hVCtC9FTt6jUrLiRWyOV/ns.','+7(123)456-78-90','Ivanov',NULL),(3,_binary '','buyer@gmail.com','Vovanovich','Vova','$2a$08$6DxgTVx5ZSUylzyuf/XTe.c.uwSOAreY1hh3howZrQVO2cIKevWIC','+7(111)444-00-77','Vovan',NULL),(4,_binary '','Petr@gmail.com','Petrovich','Petr','$2a$08$lsm/6xtZOmTlw7nKuXxr5eySidftUMqfM539SgmCDxsL9WWrNXERK','+7(000)123-99-04','Petrov',NULL),(5,_binary '','admin03@gmail.com','ADMin','ADmin','$2a$08$bu3Mx27vK0lptfbq1GsvG.q2LbKfdL2IyBYHDp2no6fxwKo4poMXi','+7(999)999-99-99','Admin',NULL),(6,_binary '','admin@gmail.com','ADMin','ADmin','$2a$08$k/95nNj4pYvKPZ248uEQoefpX6UpRhYiU/3.L7RKWhacdWCYJOg2u','+7(999)999-99-99','Admin',NULL),(7,_binary '','admin2@gmail.com','S','D','$2a$08$jM4zSB2H9XdyottxWXz9XO5QNEvbRp8H1Tc2XeGhLx4lXqYAHbWHK','+7(000)123-99-04','B',NULL),(8,_binary '','admin3@gmail.com','Se','Da','$2a$08$7YOUCIg0VVtcMNgwXpTDKeY3nn9OcsWLZ0R1WjgL7KYky5IIHRT7m','+7(999)999-99-99','BI',NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_route`
--

DROP TABLE IF EXISTS `employee_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_route` (
  `id_route` bigint(20) NOT NULL,
  `id_employee` bigint(20) NOT NULL,
  KEY `FKql1ljack98sd5jde59qofabph` (`id_employee`),
  KEY `FK5p1v2b75sfcffwipu8sdxjhfg` (`id_route`),
  CONSTRAINT `FK5p1v2b75sfcffwipu8sdxjhfg` FOREIGN KEY (`id_route`) REFERENCES `route_` (`id`),
  CONSTRAINT `FKql1ljack98sd5jde59qofabph` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_route`
--

LOCK TABLES `employee_route` WRITE;
/*!40000 ALTER TABLE `employee_route` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_`
--

DROP TABLE IF EXISTS `material_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_material` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_`
--

LOCK TABLES `material_` WRITE;
/*!40000 ALTER TABLE `material_` DISABLE KEYS */;
/*!40000 ALTER TABLE `material_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_`
--

DROP TABLE IF EXISTS `order_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_of_release` varchar(255) DEFAULT NULL,
  `total_cost` double DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKff8wt5idpn96bp9p5bd8abhuy` (`client_id`),
  KEY `FKmodpi9cq7750vwxj0cnrkxv1k` (`employee_id`),
  KEY `FKjgv1ufr5i39pswo0sc9fptpam` (`product_id`),
  CONSTRAINT `FKff8wt5idpn96bp9p5bd8abhuy` FOREIGN KEY (`client_id`) REFERENCES `client_` (`id`),
  CONSTRAINT `FKjgv1ufr5i39pswo0sc9fptpam` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKmodpi9cq7750vwxj0cnrkxv1k` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_`
--

LOCK TABLES `order_` WRITE;
/*!40000 ALTER TABLE `order_` DISABLE KEYS */;
INSERT INTO `order_` VALUES (1,'12/10/2012',18981,1,1,1),(2,'03/16/2023',13178,2,8,2);
/*!40000 ALTER TABLE `order_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `id_product` bigint(20) NOT NULL,
  `id_order` bigint(20) NOT NULL,
  KEY `FK9i1pnq4q3a111yir5uv1jy5go` (`id_order`),
  KEY `FKkm8jfm4t1ocixswclleb7xkxj` (`id_product`),
  CONSTRAINT `FK9i1pnq4q3a111yir5uv1jy5go` FOREIGN KEY (`id_order`) REFERENCES `order_` (`id`),
  CONSTRAINT `FKkm8jfm4t1ocixswclleb7xkxj` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piechart_data`
--

DROP TABLE IF EXISTS `piechart_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piechart_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `yaxis` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piechart_data`
--

LOCK TABLES `piechart_data` WRITE;
/*!40000 ALTER TABLE `piechart_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `piechart_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_`
--

DROP TABLE IF EXISTS `plan_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_of_registration` varchar(255) DEFAULT NULL,
  `total_cost` double DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj9h1xdwnb7pdlgd5k68judch1` (`employee_id`),
  KEY `FKn0st7t6n0m2ai624fwloaoplk` (`supplier_id`),
  KEY `FKilfpw74fqs2xynsqthp075h4c` (`product_id`),
  CONSTRAINT `FKilfpw74fqs2xynsqthp075h4c` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKj9h1xdwnb7pdlgd5k68judch1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKn0st7t6n0m2ai624fwloaoplk` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_`
--

LOCK TABLES `plan_` WRITE;
/*!40000 ALTER TABLE `plan_` DISABLE KEYS */;
INSERT INTO `plan_` VALUES (1,'12/12/2022',18981,1,1,1),(2,'16/12/2022',225,1,1,3),(3,'12/02/2020',13178,1,1,2);
/*!40000 ALTER TABLE `plan_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_product`
--

DROP TABLE IF EXISTS `plan_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_product` (
  `id_product` bigint(20) NOT NULL,
  `id_plan` bigint(20) NOT NULL,
  KEY `FKhm1jn0n1gdb8oqbbenn3qtato` (`id_plan`),
  KEY `FK6dvvs186r6d59yx7ggstmnnh0` (`id_product`),
  CONSTRAINT `FK6dvvs186r6d59yx7ggstmnnh0` FOREIGN KEY (`id_product`) REFERENCES `product` (`id`),
  CONSTRAINT `FKhm1jn0n1gdb8oqbbenn3qtato` FOREIGN KEY (`id_plan`) REFERENCES `plan_` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_product`
--

LOCK TABLES `plan_product` WRITE;
/*!40000 ALTER TABLE `plan_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id_employee` bigint(20) NOT NULL,
  `post` varchar(255) DEFAULT NULL,
  KEY `FKm558rc96vom4nvs6g6qabvy6b` (`id_employee`),
  CONSTRAINT `FKm558rc96vom4nvs6g6qabvy6b` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Администратор'),(1,'Закупщик'),(1,'Кассир'),(1,'Кладовщик'),(1,'Бухгалтер'),(4,'Нет'),(4,'Бухгалтер'),(4,'Кассир'),(5,'Нет'),(7,'Нет'),(8,'Администратор');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `date_of_production` varchar(255) DEFAULT NULL,
  `name_product` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `plan_id` bigint(20) DEFAULT NULL,
  `supplier_id` bigint(20) DEFAULT NULL,
  `warehouse_id` bigint(20) DEFAULT NULL,
  `color_id` bigint(20) DEFAULT NULL,
  `material_id` bigint(20) DEFAULT NULL,
  `product_type_id` bigint(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1cgtmf7ulx8dif4yc51sulv2j` (`order_id`),
  KEY `FKi5jqdyehs630vww3qsb0gh6m2` (`plan_id`),
  KEY `FKnwftsylxv0xgu32jnohnofhnm` (`supplier_id`),
  KEY `FKglw4nivt64a86i7jejh105c0d` (`warehouse_id`),
  KEY `FKn3jr7y11sckprd2svj959bqeg` (`color_id`),
  KEY `FKn503wqrbqwq5428l8bwd5kjm6` (`material_id`),
  KEY `FKlabq3c2e90ybbxk58rc48byqo` (`product_type_id`),
  CONSTRAINT `FK1cgtmf7ulx8dif4yc51sulv2j` FOREIGN KEY (`order_id`) REFERENCES `order_` (`id`),
  CONSTRAINT `FKglw4nivt64a86i7jejh105c0d` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse_` (`id`),
  CONSTRAINT `FKi5jqdyehs630vww3qsb0gh6m2` FOREIGN KEY (`plan_id`) REFERENCES `plan_` (`id`),
  CONSTRAINT `FKlabq3c2e90ybbxk58rc48byqo` FOREIGN KEY (`product_type_id`) REFERENCES `product_type` (`id`),
  CONSTRAINT `FKn3jr7y11sckprd2svj959bqeg` FOREIGN KEY (`color_id`) REFERENCES `color_` (`id`),
  CONSTRAINT `FKn503wqrbqwq5428l8bwd5kjm6` FOREIGN KEY (`material_id`) REFERENCES `material_` (`id`),
  CONSTRAINT `FKnwftsylxv0xgu32jnohnofhnm` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,19,'12/12/2022','Teddy',999,150,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(2,22,'01/01/2000','Car',599,300,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL),(3,15,'16/12/2022','Plane',15,500,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_unicode_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`%`*/ /*!50003 TRIGGER `product_add` BEFORE INSERT ON `product` FOR EACH ROW BEGIN
	INSERT INTO product_log SET product_action = 'Добавление', product_name = NEW.name_product;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_type`
--

LOCK TABLES `product_type` WRITE;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register_`
--

DROP TABLE IF EXISTS `register_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_purchase` datetime(6) DEFAULT NULL,
  `employee_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoui2dysw0nh6uqaa0e4piyh4e` (`employee_id`),
  CONSTRAINT `FKoui2dysw0nh6uqaa0e4piyh4e` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register_`
--

LOCK TABLES `register_` WRITE;
/*!40000 ALTER TABLE `register_` DISABLE KEYS */;
INSERT INTO `register_` VALUES (1,'2001-12-12 00:00:00.000000',1);
/*!40000 ALTER TABLE `register_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_`
--

DROP TABLE IF EXISTS `route_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `time_to_destination` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_`
--

LOCK TABLES `route_` WRITE;
/*!40000 ALTER TABLE `route_` DISABLE KEYS */;
/*!40000 ALTER TABLE `route_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift_`
--

DROP TABLE IF EXISTS `shift_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shift_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_end_shift` varchar(255) DEFAULT NULL,
  `date_start_shift` varchar(255) DEFAULT NULL,
  `name_shift` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift_`
--

LOCK TABLES `shift_` WRITE;
/*!40000 ALTER TABLE `shift_` DISABLE KEYS */;
/*!40000 ALTER TABLE `shift_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_`
--

DROP TABLE IF EXISTS `supplier_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name_supplier` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_`
--

LOCK TABLES `supplier_` WRITE;
/*!40000 ALTER TABLE `supplier_` DISABLE KEYS */;
INSERT INTO `supplier_` VALUES (1,'Piter','vova@gmail.com','Vova','+7(723)668-51-23'),(2,'Moscow','danilka.bivol.03@gmail.com','Dania','+7(723)668-51-20');
/*!40000 ALTER TABLE `supplier_` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse_`
--

DROP TABLE IF EXISTS `warehouse_`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `warehouse_` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `id_employee` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbciggenmspygdtr7d60qtfhpy` (`id_employee`),
  CONSTRAINT `FKbciggenmspygdtr7d60qtfhpy` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse_`
--

LOCK TABLES `warehouse_` WRITE;
/*!40000 ALTER TABLE `warehouse_` DISABLE KEYS */;
INSERT INTO `warehouse_` VALUES (1,'ул. Березовая',500,1);
/*!40000 ALTER TABLE `warehouse_` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-21 14:18:45
