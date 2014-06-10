CREATE DATABASE  IF NOT EXISTS `kos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `kos`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: kos
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `conferences`
--

DROP TABLE IF EXISTS `conferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conferences` (
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `owner` varchar(30) DEFAULT NULL,
  KEY `owner_idx` (`owner`),
  CONSTRAINT `fk_conf_user` FOREIGN KEY (`owner`) REFERENCES `users` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conferences`
--

LOCK TABLES `conferences` WRITE;
/*!40000 ALTER TABLE `conferences` DISABLE KEYS */;
INSERT INTO `conferences` VALUES ('6th International Conference on Computer Supported Education – CSEDU 2014','Date: Tue, Apr 01, 2014 - Thu, Apr 03, 2014\nCountry: Spain','bartosz'),('Licensing Marketed Pharmaceuticals','Date: Tue, Apr 01, 2014 - Wed, Apr 02, 2014\nCountry: Belgium','ciecholewski');
/*!40000 ALTER TABLE `conferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publications`
--

DROP TABLE IF EXISTS `publications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publications` (
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(400) DEFAULT NULL,
  `owner` varchar(30) DEFAULT NULL,
  KEY `owner_idx` (`owner`),
  CONSTRAINT `fk_pub_user` FOREIGN KEY (`owner`) REFERENCES `users` (`login`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publications`
--

LOCK TABLES `publications` WRITE;
/*!40000 ALTER TABLE `publications` DISABLE KEYS */;
INSERT INTO `publications` VALUES ('Hemivariational Inequality Approach to the Dynamic Viscoelastic Sliding Contact Problem with Wear','Nonlinear Analysis, Theory, Methods and Applications 65 (2006) 546-566','bartosz'),('Automatic Liver Segmentation from 2D CT Images Using an Approximate Contour Model','Journal of Signal Processing Systems for Signal, Image and Video Technology, 2014, Springer','ciecholewski');
/*!40000 ALTER TABLE `publications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `login` varchar(30) NOT NULL,
  `passMD5` varchar(40) NOT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('bartosz','21232f297a57a5a743894a0e4a801fc3'),('ciecholewski','21232f297a57a5a743894a0e4a801fc3');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_profile`
--

DROP TABLE IF EXISTS `users_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_profile` (
  `user` varchar(30) NOT NULL,
  `email` varchar(60) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `office` varchar(200) DEFAULT NULL,
  `phone` varchar(60) DEFAULT NULL,
  `office_hours` varchar(100) DEFAULT NULL,
  `main_interests` varchar(400) DEFAULT NULL,
  `cv` varchar(400) DEFAULT NULL,
  `first_name` varchar(40) DEFAULT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`user`),
  UNIQUE KEY `user_UNIQUE` (`user`),
  CONSTRAINT `fk_profile_user` FOREIGN KEY (`user`) REFERENCES `users` (`login`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_profile`
--

LOCK TABLES `users_profile` WRITE;
/*!40000 ALTER TABLE `users_profile` DISABLE KEYS */;
INSERT INTO `users_profile` VALUES ('bartosz','krzysztof.bartosz@ii.uj.edu.pl','Jagiellonian University\nFaculty of Mathematics and Computer Science\nul. Lojasiewicza 6, PL-30348 Kraków','Institute of Computer Science\nul. Lojasiewicza 6, PL-30348 Kraków\nOffice no. 2148','48 12 664 7556','Wednesday, 14-16','Computer graphics; Computer vision; Image processing; Medical image analysis; Pattern recognition algorithms; Geometrical and statistical modeling; Mathematical morphology','PhD in Computer Science 2008, AGH University of Science and Technology','Krzysztof','Bartosz'),('ciecholewski','marcin.ciecholewski@ii.uj.edu.pl','Jagiellonian University\nFaculty of Mathematics and Computer Science\nul. Lojasiewicza 6, PL-30348 Kraków','Institute of Computer Science\nul. Lojasiewicza 6, PL-30348 Kraków\nOffice no. 2148','48 12 664 7556','Monday, 10-12','Theory of Sobolev spaces, partial differential equations, variational and hemivariational inequalities, mechanics of solids concerning elasticity and viscosity properties of material and nonmonotone contact conditions, optimal control and numerical solving of the above problems, Rothe method, Galerkin method, Finite Element Method, computer simulations.','Studied Mathematics 1998-2003, AGH University of Science and Technology, Krakow\nMaster of Science in Mathematics 2003, AGH University of Science and Technology\nPhD in Mathematics 2007, Jagiellonian University','Marcin','Ciecholewski');
/*!40000 ALTER TABLE `users_profile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-02-04 21:11:05
