-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proiect5
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `activitate_grup`
--

DROP TABLE IF EXISTS `activitate_grup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activitate_grup` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_grup` int DEFAULT NULL,
  `nume` varchar(30) DEFAULT NULL,
  `data_activitate` datetime DEFAULT NULL,
  `nr_participanti` int DEFAULT NULL,
  `durata_activitate` time DEFAULT NULL,
  `timp_expirare` time DEFAULT NULL,
  `nr_participanti_curent` int NOT NULL,
  `data_creare` date DEFAULT NULL,
  `ora_creare` time DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_grup` (`id_grup`),
  KEY `id_profesor` (`id_profesor`),
  CONSTRAINT `activitate_grup_ibfk_1` FOREIGN KEY (`id_grup`) REFERENCES `grup_de_studiu` (`id`) ON DELETE CASCADE,
  CONSTRAINT `activitate_grup_ibfk_2` FOREIGN KEY (`id_profesor`) REFERENCES `profesor_curs` (`id_prof`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitate_grup`
--

LOCK TABLES `activitate_grup` WRITE;
/*!40000 ALTER TABLE `activitate_grup` DISABLE KEYS */;
/*!40000 ALTER TABLE `activitate_grup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activitati`
--

DROP TABLE IF EXISTS `activitati`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activitati` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activitate` varchar(30) DEFAULT NULL,
  `data_act` date DEFAULT NULL,
  `ora_inceput` time DEFAULT NULL,
  `ora_sfarsit` time DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  `id_curs` int DEFAULT NULL,
  `nr_max_participanti` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_profesor` (`id_profesor`),
  KEY `id_curs` (`id_curs`),
  CONSTRAINT `activitati_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_utilizator`) ON DELETE CASCADE,
  CONSTRAINT `activitati_ibfk_2` FOREIGN KEY (`id_curs`) REFERENCES `cursuri` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activitati`
--

LOCK TABLES `activitati` WRITE;
/*!40000 ALTER TABLE `activitati` DISABLE KEYS */;
INSERT INTO `activitati` VALUES (1,'Curs','2022-12-07','01:05:00','03:05:00',3,1,140),(2,'Seminar','2022-06-24','03:00:00','06:00:00',3,2,30),(3,'Curs','2022-12-02','06:05:00','08:05:00',3,2,130),(4,'Laborator','2022-12-19','12:00:00','14:00:00',4,3,15),(5,'Laborator','2023-01-06','06:01:01','08:01:01',4,6,15),(6,'Laborator','2023-01-06','06:05:01','08:05:01',4,6,15),(7,'Seminar','2023-01-07','10:00:01','12:00:01',4,3,30),(8,'Laborator','2023-01-04','12:00:01','14:00:01',3,2,15),(9,'Seminar','2023-01-13','08:00:01','10:00:01',34,1,30),(10,'Laborator','2023-01-16','14:00:01','16:00:01',35,3,15),(12,'Seminar','2023-01-18','12:00:01','14:00:01',35,3,30);
/*!40000 ALTER TABLE `activitati` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `administrator`
--

DROP TABLE IF EXISTS `administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrator` (
  `id_utilizator` int NOT NULL,
  PRIMARY KEY (`id_utilizator`),
  CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`id_utilizator`) REFERENCES `utilizator` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrator`
--

LOCK TABLES `administrator` WRITE;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` VALUES (7),(32);
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursuri`
--

DROP TABLE IF EXISTS `cursuri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursuri` (
  `id` int NOT NULL AUTO_INCREMENT,
  `materie` varchar(30) DEFAULT NULL,
  `descriere` varchar(100) DEFAULT NULL,
  `nr_max_studenti` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursuri`
--

LOCK TABLES `cursuri` WRITE;
/*!40000 ALTER TABLE `cursuri` DISABLE KEYS */;
INSERT INTO `cursuri` VALUES (1,'MSI','Matematici speciale in inginerie',140),(2,'BD','Baze de date',130),(3,'AF','Algoritmi fundamentali',150),(6,'POO','Programare orientata pe obiecte',160);
/*!40000 ALTER TABLE `cursuri` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cursuri_AFTER_INSERT` AFTER INSERT ON `cursuri` FOR EACH ROW BEGIN
 insert into grup_de_studiu(materia,id_curs)
    values(new.materie,new.id);

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `grup_de_studiu`
--

DROP TABLE IF EXISTS `grup_de_studiu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grup_de_studiu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `materia` varchar(30) DEFAULT NULL,
  `id_curs` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_curs` (`id_curs`),
  CONSTRAINT `grup_de_studiu_ibfk_1` FOREIGN KEY (`id_curs`) REFERENCES `cursuri` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grup_de_studiu`
--

LOCK TABLES `grup_de_studiu` WRITE;
/*!40000 ALTER TABLE `grup_de_studiu` DISABLE KEYS */;
INSERT INTO `grup_de_studiu` VALUES (1,'POO',6),(2,'AF',3),(3,'MSI',1),(4,'BD',2);
/*!40000 ALTER TABLE `grup_de_studiu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscrieri`
--

DROP TABLE IF EXISTS `inscrieri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscrieri` (
  `id_curs` int NOT NULL,
  `id_student` int NOT NULL,
  `nr_studenti` int DEFAULT NULL,
  `nota_curs` int DEFAULT NULL,
  `nota_seminar` int DEFAULT NULL,
  `nota_lab` int DEFAULT NULL,
  `nota_colocviu` int DEFAULT NULL,
  `nota_examen_final` int DEFAULT NULL,
  `id_profesor` int DEFAULT NULL,
  PRIMARY KEY (`id_curs`,`id_student`),
  KEY `id_student` (`id_student`),
  CONSTRAINT `inscrieri_ibfk_1` FOREIGN KEY (`id_curs`) REFERENCES `cursuri` (`id`) ON DELETE CASCADE,
  CONSTRAINT `inscrieri_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_utilizator`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscrieri`
--

LOCK TABLES `inscrieri` WRITE;
/*!40000 ALTER TABLE `inscrieri` DISABLE KEYS */;
INSERT INTO `inscrieri` VALUES (1,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,33,NULL,NULL,NULL,NULL,NULL,NULL,3),(1,38,NULL,NULL,NULL,NULL,NULL,NULL,34),(1,39,NULL,NULL,NULL,NULL,NULL,NULL,5),(2,1,NULL,NULL,NULL,NULL,NULL,NULL,3),(2,2,NULL,NULL,NULL,NULL,NULL,NULL,3),(2,6,NULL,NULL,NULL,NULL,NULL,NULL,3),(2,33,NULL,NULL,NULL,NULL,NULL,NULL,3),(2,37,NULL,NULL,NULL,NULL,NULL,NULL,3),(2,40,NULL,NULL,NULL,NULL,NULL,NULL,3),(3,1,NULL,NULL,8,10,NULL,9,4),(3,2,NULL,NULL,8,9,NULL,9,4),(3,6,NULL,NULL,NULL,NULL,NULL,NULL,4),(3,33,NULL,NULL,NULL,NULL,NULL,NULL,4),(3,36,NULL,NULL,NULL,NULL,NULL,NULL,35),(3,38,NULL,NULL,NULL,NULL,NULL,NULL,35),(3,39,NULL,NULL,NULL,NULL,NULL,NULL,35),(6,1,NULL,7,NULL,10,NULL,0,4),(6,2,NULL,10,NULL,7,NULL,8,5),(6,6,NULL,NULL,NULL,NULL,NULL,NULL,3),(6,36,NULL,NULL,NULL,NULL,NULL,NULL,3),(6,38,NULL,NULL,NULL,NULL,NULL,NULL,4);
/*!40000 ALTER TABLE `inscrieri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesaj`
--

DROP TABLE IF EXISTS `mesaj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesaj` (
  `mesaj_informare` varchar(50) DEFAULT NULL,
  `mesaj_grup` varchar(100) DEFAULT NULL,
  `id_student` int DEFAULT NULL,
  `id_mesaj` int NOT NULL AUTO_INCREMENT,
  `id_grup` int DEFAULT NULL,
  PRIMARY KEY (`id_mesaj`),
  KEY `id_student` (`id_student`),
  KEY `id_grup` (`id_grup`),
  CONSTRAINT `mesaj_ibfk_2` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_utilizator`) ON DELETE CASCADE,
  CONSTRAINT `mesaj_ibfk_3` FOREIGN KEY (`id_grup`) REFERENCES `grup_de_studiu` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesaj`
--

LOCK TABLES `mesaj` WRITE;
/*!40000 ALTER TABLE `mesaj` DISABLE KEYS */;
INSERT INTO `mesaj` VALUES ('','Merge:)',2,3,2),('','Yay!',2,4,2),(NULL,NULL,6,20,1),(NULL,'Yay!',1,21,2),(NULL,'Ma bucur sa fiu aici:)',2,22,2),('',NULL,33,28,3),(NULL,NULL,33,29,4),('','Sunt si eu aici:(',33,31,3),('Pregatire MSI2023-01-16 09:00:01 anulata',NULL,33,40,3),('Pregatire MSI 2023-01-15 14:09:01 anulata',NULL,33,41,3),('Pregatire MSI 2023-01-18 19:00:01 anulata',NULL,33,42,3),('Pregatire AF 2023-01-14 18:00:01 anulata',NULL,2,43,2);
/*!40000 ALTER TABLE `mesaj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id_utilizator` int NOT NULL,
  `nr_min_ore` int DEFAULT NULL,
  `nr_max_ore` int DEFAULT NULL,
  `departament` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_utilizator`),
  CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`id_utilizator`) REFERENCES `utilizator` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (3,12,100,'Informatica'),(4,30,110,'Informatica'),(5,25,75,'Matematica'),(34,10,20,'Matematica'),(35,12,50,'Informatica');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_curs`
--

DROP TABLE IF EXISTS `profesor_curs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor_curs` (
  `id_curs` int NOT NULL,
  `id_prof` int NOT NULL,
  `p_curs` int DEFAULT NULL,
  `p_seminar` int DEFAULT NULL,
  `p_examen_final` int DEFAULT NULL,
  `p_lab` int DEFAULT NULL,
  `p_colocviu` int DEFAULT NULL,
  `nr_studenti_curent` int NOT NULL,
  PRIMARY KEY (`id_curs`,`id_prof`),
  KEY `id_prof` (`id_prof`),
  CONSTRAINT `profesor_curs_ibfk_1` FOREIGN KEY (`id_curs`) REFERENCES `cursuri` (`id`) ON DELETE CASCADE,
  CONSTRAINT `profesor_curs_ibfk_2` FOREIGN KEY (`id_prof`) REFERENCES `profesor` (`id_utilizator`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_curs`
--

LOCK TABLES `profesor_curs` WRITE;
/*!40000 ALTER TABLE `profesor_curs` DISABLE KEYS */;
INSERT INTO `profesor_curs` VALUES (1,3,1,1,1,0,0,2),(1,5,1,1,0,0,0,2),(1,34,1,1,1,0,NULL,1),(2,3,1,1,1,1,NULL,6),(3,4,0,30,NULL,70,NULL,4),(3,35,60,1,1,40,NULL,3),(6,3,1,0,NULL,1,NULL,2),(6,4,1,0,1,1,NULL,2),(6,5,30,0,1,70,NULL,1);
/*!40000 ALTER TABLE `profesor_curs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id_utilizator` int NOT NULL,
  `an_studiu` int DEFAULT NULL,
  `nr_ore` int DEFAULT NULL,
  PRIMARY KEY (`id_utilizator`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`id_utilizator`) REFERENCES `utilizator` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,2,28),(2,2,30),(6,1,20),(33,1,25),(36,2,25),(37,3,35),(38,1,18),(39,1,29),(40,2,30);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_activitate`
--

DROP TABLE IF EXISTS `student_activitate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_activitate` (
  `id_student` int NOT NULL,
  `id_activitati` int NOT NULL,
  PRIMARY KEY (`id_student`,`id_activitati`),
  KEY `id_activitati` (`id_activitati`),
  CONSTRAINT `student_activitate_ibfk_1` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_utilizator`) ON DELETE CASCADE,
  CONSTRAINT `student_activitate_ibfk_2` FOREIGN KEY (`id_activitati`) REFERENCES `activitati` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_activitate`
--

LOCK TABLES `student_activitate` WRITE;
/*!40000 ALTER TABLE `student_activitate` DISABLE KEYS */;
INSERT INTO `student_activitate` VALUES (33,1),(38,1),(39,1),(2,2),(33,2),(37,2),(40,2),(33,3),(37,3),(40,3),(2,4),(38,4),(36,5),(2,6),(38,6),(38,7),(1,8),(33,8),(37,8),(40,8),(39,9),(2,10),(39,10),(2,12),(36,12);
/*!40000 ALTER TABLE `student_activitate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilizator`
--

DROP TABLE IF EXISTS `utilizator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cnp` varchar(13) DEFAULT NULL,
  `nume` varchar(30) DEFAULT NULL,
  `prenume` varchar(30) DEFAULT NULL,
  `adresa` varchar(30) DEFAULT NULL,
  `telefon` varchar(10) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `iban` varchar(30) DEFAULT NULL,
  `functie` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizator`
--

LOCK TABLES `utilizator` WRITE;
/*!40000 ALTER TABLE `utilizator` DISABLE KEYS */;
INSERT INTO `utilizator` VALUES (1,'6020806125791','Coltea','Alexandra','Strada Republicii','0767676767','alexandra@yahoo.com','RO12345678',2),(2,'6020603060589','Strugar','Madalina','Strada Buna Ziua','0740269406','madalina@gmail.com','RO87654321',2),(3,'6020806121583','Ivan','Cosmina','Strada Observator','0712457893','cosmina@yahoo.com','RO18273645',1),(4,'6020806112345','Racolta','Andreea','Strada Popoviciu','071245093','andreea@yahoo.com','RO18273459',1),(5,'2070301127935','Pop','Daniela','Strada Detunata','0725104375','daniela@yahoo.com','RO12783456',1),(6,'2070301121234','Popa','Darius','Strada Fericirii','0721678092','darius@yahoo.com','RO12783908',2),(7,'1970824197753','Morar','Maria','Strada Masinistilor','0712459812','mihaela@gmail.com','RO19794305',0),(32,'1970824124750','Comsa','Marius','Strada Renasterii','0732981628','marius@gmail.com','RO19793149',3),(33,'5010308192475','Cuibus','Rares','Strada Libertatii','0785194755','rares@gmail.com','RO19787942',2),(34,'1730512126753','Salagean','Dan','Calea Dorobantilor','0712369587','dan@gmail.com','RO13747896',1),(35,'2681216236981','Ciobanu','Cosmin','Strada Nadasel','0723367259','cosmin@gmail.com','RO10759363',1),(36,'5010519159357','Ciota','Dragos','Strada Titulescu','0745129843','dragos@yahoo.com','RO12345960',2),(37,'2021227859426','Nagy','Anca','Bulevardul Teilor','0712367982','anca@gmail.com','RO12368547',2),(38,'2000222139452','Bidian','Lucia','Strada Horea','0745983719','lucia@yahoo.com','RO12365498',2),(39,'2030405123987','Crisan','Lavinia','Strada Iancu','0783569371','lavinia@gmail.com','RO32165478',2),(40,'1234567891236','Popescu','Alin','Strada Observator','0745893156','alin@yahoo.com','RO12345698',2);
/*!40000 ALTER TABLE `utilizator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proiect5'
--
/*!50003 DROP PROCEDURE IF EXISTS `adaugare_note` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `adaugare_note`(denumire varchar(30),nume_student varchar(30),
materie varchar(30),nota int)
BEGIN
    -- declare id_p int;
    declare id_s int;
    declare id_c int;
    -- set id_p=(select id from utilizator where nume_profesor=utilizator.nume);
    set id_s=(select id from utilizator where nume_student=utilizator.nume);
    set id_c=(select id from cursuri where materie=cursuri.materie);
    if(denumire="Seminar") then
      update inscrieri set nota_seminar=nota
      where id_s=id_student and id_c=id_curs ;
      elseif (denumire="Curs") then
       update inscrieri set nota_curs=nota
       where id_s=id_student and id_c=id_curs ;
       elseif (denumire="Laborator") then
       update inscrieri set nota_lab=nota
       where id_s=id_student and id_c=id_curs ;
       elseif (denumire="Nota finala") then
       update inscrieri set nota_examen_final=nota
       where id_s=id_student and id_c=id_curs ;
	end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_activitati_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_activitati_profesor`(id_user int)
BEGIN
 
   select distinct dayname(data_act),activitate,materie,ora_inceput,ora_sfarsit from activitati,cursuri,profesor_curs
   where  id_user=activitati.id_profesor
    and activitati.id_curs=cursuri.id
    and id_user=profesor_curs.id_prof;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_activitati_student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_activitati_student`(id_user int)
BEGIN
   
   select dayname(data_act),activitate,materie,ora_inceput,ora_sfarsit from activitati,cursuri,student_activitate
   where  student_activitate.id_activitati=activitati.id
   and activitati.id_curs=cursuri.id
   and id_user=student_activitate.id_student;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_activitati_zi_profesor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_activitati_zi_profesor`(id_user int)
BEGIN
  
   declare id_p int;
   set id_p=(select id_utilizator from profesor where id_utilizator=id_user);
   select activitate,materie,ora_inceput,ora_sfarsit from activitati,cursuri
   where weekday(data_act)=weekday(curdate())
   and id_p=activitati.id_profesor
    and activitati.id_curs=cursuri.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_activitati_zi_student` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_activitati_zi_student`(id_user int)
BEGIN
    
   select activitate,materie,ora_inceput,ora_sfarsit from activitati,cursuri,student_activitate
   where weekday(data_act)=weekday(curdate())
   and student_activitate.id_student=id_user
   and activitati.id=student_activitate.id_activitati
   and activitati.id_curs=cursuri.id ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_participanti_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_participanti_curs`(materie varchar(30))
BEGIN
   select nume as nume_profesor from utilizator,profesor,profesor_curs,cursuri,inscrieri,student
   where cursuri.materie=materie and cursuri.id=profesor_curs.id_curs and profesor_curs.id_prof=profesor.id_utilizator
   and profesor.id_utilizator=utilizator.id
   and inscrieri.id_curs=cursuri.id limit 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_profesor_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_profesor_curs`(materie varchar(30))
BEGIN
   select nume,prenume  from utilizator,profesor,profesor_curs,cursuri
   where cursuri.materie=materie and cursuri.id=profesor_curs.id_curs and profesor_curs.id_prof=profesor.id_utilizator
   and profesor.id_utilizator=utilizator.id;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_studenti_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_studenti_curs`(materie varchar(30),id_prof int)
BEGIN
   select nume,prenume,nota_curs,nota_seminar,nota_lab,nota_examen_final from utilizator,student,cursuri,inscrieri
   where cursuri.materie=materie 
   and student.id_utilizator=utilizator.id
   and inscrieri.id_student=student.id_utilizator
   and inscrieri.id_curs=cursuri.id
   and inscrieri.id_profesor=id_prof;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_studenti_curs_admin` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_studenti_curs_admin`(materie varchar(30))
BEGIN
   select nume,prenume,nota_curs,nota_seminar,nota_lab,nota_examen_final from utilizator,student,cursuri,inscrieri
   where cursuri.materie=materie 
   and student.id_utilizator=utilizator.id
   and inscrieri.id_student=student.id_utilizator
   and inscrieri.id_curs=cursuri.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `afisare_sugestii_membri` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `afisare_sugestii_membri`(materie varchar(30))
BEGIN
     declare id_g int;
    set id_g=(select id from grup_de_studiu where grup_de_studiu.materia=materie);
  select nume from utilizator,student left join mesaj on mesaj.id_student=student.id_utilizator
   where mesaj.id_grup=id_g  ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alegere_activitati` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alegere_activitati`(nume_student varchar(30),nume_activitate varchar(30),materie varchar(30),
data_inscriere date, ora_inscriere time)
BEGIN
   declare id_s int;
   declare id_c int;
   declare id_a int;
   declare nr_participanti int;
   declare nr_participanti_curr int;
   declare data_a date;
   declare ora_i time;
   declare ora_f time;
   declare id_a2 int;
   set id_s=(select id from utilizator where nume_student=utilizator.nume);
   set id_c=(select id from cursuri where materie=cursuri.materie);
   set id_a=(select id from activitati where activitate=nume_activitate and id_curs=id_c and 
   weekday(data_act)=weekday(data_inscriere) and ora_inceput=ora_inscriere);
   set nr_participanti=(select nr_max_participanti from activitati where activitate=nume_activitate and id_curs=id_c  limit 1);
   set nr_participanti_curr=(select nr_studenti_curent from student_activitate where id_s=id_student and id_a=id_activitati limit 1);
   set data_a=(select data_act from activitati where activitate=nume_activitate and id_curs=id_c limit 1);
   set ora_i=(select ora_inceput from activitati where activitate=nume_activitate and id_curs=id_c limit 1);
   set ora_f=(select ora_sfarsit from activitati where activitate=nume_activitate and id_curs=id_c limit 1);
   set id_a2=(select id from activitati,student_activitate where student_activitate.id_student=id_s and
  ( weekday(activitati.data_act)=weekday(data_a) and (activitati.ora_sfarsit<=ora_i  or activitati.ora_inceput>=ora_f))or 
  weekday(activitati.data_act)!=weekday(data_a) limit 1);
   if nr_participanti_curr<nr_participanti then
   if id_a2!=NULL then
   insert into student_activitate(id_student,id_activitati)
   values (id_s,id_a);
   update student_activitate set nr_studenti_curent=nr_studenti_curent+1 where id_s=id_student and id_a=id_activitati;
   end if;
   end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `alegere_activitati2` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `alegere_activitati2`(nume_student varchar(30),id_activitate int)
BEGIN
     declare id_s int;
     declare nr_studenti int;
     declare nr_max_studenti int;
     set id_s=(select id from utilizator where nume_student=utilizator.nume);
      
      select count(*) into nr_studenti from student_activitate where id_activitati=id_activitate;
      select nr_max_participanti into nr_max_studenti from activitati 
      where id=id_activitate;
      if(nr_studenti<nr_max_studenti) then insert into student_activitate(id_student,id_activitati)
      values(id_s,id_activitate);
      else select "activitate plina:(";
      end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `asignare_profesor_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `asignare_profesor_curs`(nume varchar(30),materie varchar(30),proc_curs int ,proc_seminar int ,proc_examen_final int ,proc_lab int)
BEGIN

   set @id_p=NULL;
   set @id_c=NULL;
   set @id_p=(select id from utilizator where nume=utilizator.nume);
   set @id_c=(select id from cursuri where materie=cursuri.materie);
   insert into profesor_curs (id_curs,id_prof,nr_studenti_curent,p_curs,p_seminar,p_examen_final,p_lab) values(@id_c,@id_p,0,proc_curs,proc_seminar,proc_examen_final,proc_lab);
   COMMIT;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `cautare_dupa_nume` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cautare_dupa_nume`(nume varchar(30))
BEGIN
   
   declare functia int;
   set functia=(select functie from utilizator where nume=utilizator.nume);
   
   if(functia=0) then
    select * from utilizator where utilizator.nume=nume;
    else if(functia=1) then
           select * from utilizator,profesor where utilizator.nume=nume
           and utilizator.id=profesor.id_utilizator;
           else select * from utilizator,student where utilizator.nume=nume
           and utilizator.id=student.id_utilizator;
	end if; end if; 
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `creare_activitate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `creare_activitate`(materie varchar(30),nume varchar(30),data_activitate datetime,nr_participanti int,
durata_activitate time,perioada_de_expirare time ,nume_prof varchar(30))
BEGIN
     declare id_g int;
     declare id_p int;
     declare ok int;
     set ok=0;
     set id_g=(select id from grup_de_studiu where materie=grup_de_studiu.materia);
     set id_p=(select id_utilizator from profesor,utilizator where nume_prof=utilizator.nume and 
     utilizator.id=profesor.id_utilizator);
     set ok=(select id_prof from profesor_curs,cursuri where materie=cursuri.materie and profesor_curs.id_curs=cursuri.id and id_p=profesor_curs.id_prof);
     
     insert into activitate_grup(id_grup,nume,data_activitate,nr_participanti,durata_activitate,timp_expirare,data_creare,
     ora_creare,nr_participanti_curent,id_profesor)
     values(id_g,nume ,data_activitate ,nr_participanti, durata_activitate ,perioada_de_expirare,curdate(),
     curtime(),0,ok);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_utilizator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_utilizator`(nume varchar(30),prenume varchar(30))
BEGIN
-- declare id_user int;
   -- set id_user=(select id from utilizator where nume=utilizator.nume and prenume=utilizator.prenume);
  delete from utilizator where nume=utilizator.nume and prenume=utilizator.prenume;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filtrare_tip` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filtrare_tip`(tip int)
BEGIN
     if(tip=0) then
    select * from utilizator where utilizator.functie=tip;
    else if(tip=1) then
           select * from utilizator,profesor where utilizator.functie=tip
           and utilizator.id=profesor.id_utilizator;
           else select * from utilizator,student where utilizator.functie=tip
           and utilizator.id=student.id_utilizator;
	end if; end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscriere_activitate_grup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscriere_activitate_grup`(id_s int,nume_activitate varchar(30),durata_activitate time,
data_activitate datetime,timp_expirare time)
BEGIN
   declare id_a int;
   -- declare id_s int;
   declare id_g int;
   
   -- set id_s=(select id from utilizator where nume_student=utilizator.nume);
   set id_a=(select id_grup from activitate_grup where nume=nume_activitate
   and activitate_grup.data_activitate=data_activitate and activitate_grup.durata_activitate=durata_activitate
   and activitate_grup.timp_expirare=timp_expirare);
   set id_g=(select id from grup_de_studiu where id=id_a);
   

   -- update mesaj set mesaj_informare=concat(nume_activitate,data_act) where id_grup=id_g and id_student=id_s;
   insert into mesaj(id_grup,id_student,mesaj_informare)
   values(id_g,id_s,concat(nume_activitate,data_activitate));
   update activitate_grup set nr_participanti_curent=nr_participanti_curent+1 where id_grup=id_a;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscriere_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscriere_curs`(id_student int,materie varchar(30))
BEGIN
   declare mini int ;
   set mini=(select min(nr_studenti_curent) from profesor_curs,cursuri 
   where cursuri.id=profesor_curs.id_curs and materie=cursuri.materie limit 1 );
   set @id_c=(select cursuri.id from cursuri,profesor_curs 
   where materie=cursuri.materie 
   and cursuri.id=profesor_curs.id_curs 
   and profesor_curs.nr_studenti_curent=mini limit 1);
   set @id_prof=(select id_prof from profesor_curs,cursuri where cursuri.id=profesor_curs.id_curs and materie=cursuri.materie
   and nr_studenti_curent =mini limit 1);
     insert into inscrieri(id_curs,id_student,id_profesor) values (@id_c,id_student,@id_prof);
     update profesor_curs set nr_studenti_curent=nr_studenti_curent+1 where profesor_curs.id_curs=@id_c and profesor_curs.id_prof=@id_prof;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscriere_grup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscriere_grup`(id int,materia varchar(30),id_g int)
BEGIN
    declare id_s int;
   -- declare id_g int;
    declare id_c int;
    set id_c=(select id from cursuri where materia=cursuri.materie);
    set id_s=(select inscrieri.id_student from inscrieri,student,utilizator where id=utilizator.id
     and inscrieri.id_student=student.id_utilizator and inscrieri.id_curs=id_c
     and student.id_utilizator=utilizator.id );
 --   set id_g=(select id from grup_de_studiu where materia=grup_de_studiu.materia and grup_de_studiu.id_curs=id_c);
       -- if(id_s!=null) then
    insert into mesaj(id_grup,id_student) values(id_g,id);
    -- select "asa";
    -- end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscriere_student_grup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscriere_student_grup`(id int,materia varchar(30),id_g int)
BEGIN
    declare id_s int;
   -- declare id_g int;
    declare id_c int;
    set id_c=(select id from cursuri where materia=cursuri.materie);
    set id_s=(select inscrieri.id_student from inscrieri,student,utilizator where id=utilizator.id
     and inscrieri.id_student=student.id_utilizator and inscrieri.id_curs=id_c
     and student.id_utilizator=utilizator.id );
 --   set id_g=(select id from grup_de_studiu where materia=grup_de_studiu.materia and grup_de_studiu.id_curs=id_c);
       if(id_s!=0) then
    insert into mesaj(id_grup,id_student) values(id_g,id_s);
    select "asa";
     end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inscrirere_activitate_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inscrirere_activitate_curs`(id_s int,nume varchar(30),data_act date,ora_inceput time,ora_sfarsit time)
BEGIN
     declare id_a int;
     declare nr_participanti int;
     declare nr_participanti_curr int;
     set id_a=(select id from activitati where activitati.activitate=nume and activitati.data_act=data_act
     and activitati.ora_inceput=ora_inceput and activitati.ora_sfarsit=ora_sfarsit);
     set nr_participanti=(select nr_max_participanti from activitati where activitate=nume and id=id_a  limit 1);
     set nr_participanti_curr=(select count(*) from student_activitate where id_activitati=id_a);
     if(nr_participanti_curr<nr_participanti) then insert into student_activitate(id_student,id_activitati) values(id_s,id_a);
     else select "nu e loc";
     end if;
     end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserare_tabela_utilizator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserare_tabela_utilizator`(functie int,
cnp varchar(13) ,nume varchar(30),prenume varchar(30),adresa varchar(30),telefon varchar(10),
email varchar(30),iban varchar(30), an_studiu int, nr_ore int,
nr_min_ore int,nr_max_ore int,departament varchar(30))
BEGIN
  declare id_user int;
  insert into utilizator(cnp,nume,prenume ,adresa,telefon ,email,iban ,functie) 
  values(cnp,nume,prenume ,adresa,telefon ,email,iban ,functie);
  set id_user=(select id from utilizator where utilizator.cnp=cnp);
  if(functie=0 or functie=3) then 
    insert into administrator(id_utilizator) values(id_user);
  else if(functie=1) then insert into profesor(id_utilizator,nr_min_ore,nr_max_ore,departament)
  values(id_user,nr_min_ore,nr_max_ore,departament);
  else insert into student(id_utilizator,an_studiu, nr_ore) values (id_user,an_studiu, nr_ore);
  end if;
  end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `inserare_tabela_utlizator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserare_tabela_utlizator`(functie int,
cnp varchar(13) ,nume varchar(30),prenume varchar(30),adresa varchar(30),telefon varchar(10),
email varchar(30),iban varchar(30), an_studiu int, nr_ore int,
nr_min_ore int,nr_max_ore int,departament varchar(30))
BEGIN
  declare id_user int;
  insert into utilizator(cnp,nume,prenume ,adresa,telefon ,email,iban ,functie) 
  values(cnp,nume,prenume ,adresa,telefon ,email,iban ,functie);
  set id_user=(select id from utilizator where utilizator.cnp=cnp);
  if(functie=0) then 
    insert into administrator(id_utilizator) values(id_user);
  else if(functie=1) then insert into profesor(id_utilizator,nr_min_ore,nr_max_ore,departament)
  values(id_user,nr_min_ore,nr_max_ore,departament);
  else insert into student(id_utilizator,an_studiu, nr_ore) values (id_user,an_studiu, nr_ore);
  end if;
  end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lasare_mesaj` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lasare_mesaj`(id_student int,materie varchar(30),mesaj varchar(100))
BEGIN
   declare id_g int;
   set id_g=(select id from grup_de_studiu where materie=grup_de_studiu.materia);
   
   insert into mesaj(id_grup,id_student,mesaj_grup)
   values(id_g,id_student,mesaj);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `mesaj_anulare` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `mesaj_anulare`(materie varchar(30),data_act datetime)
BEGIN
    declare id_a int;
    declare sir varchar(30);
    declare np int;
    declare npc int;
    declare dc date;
    declare tc time;
    declare te time;
    declare verif int;
    declare id_g int;
    declare sir2 varchar(50);
    set sir=concat("Pregatire ",materie);
    set sir2=concat(sir,data_act);
    set id_a=(select id from activitate_grup where nume=sir and data_activitate=data_act);
    set id_g=(select id_grup from activitate_grup where nume=sir and data_activitate=data_act);
    set np=(select nr_participanti from activitate_grup where nume=sir and data_activitate=data_act);
    set npc=(select nr_participanti_curent from activitate_grup where nume=sir and data_activitate=data_act);
     set dc=(select data_creare from activitate_grup where nume=sir and data_activitate=data_act);
     set tc=(select ora_creare from activitate_grup where nume=sir and data_activitate=data_act);
        set te=(select timp_expirare from activitate_grup where nume=sir and data_activitate=data_act);
        set verif=(select position(materie in sir));
    if(current_date()=dc and current_time()>=addtime(tc,te)) then
      if(npc<np) then update mesaj set mesaj_informare=concat(sir," ",data_act," anulata") 
      where verif!=0 and id_grup=id_g and mesaj_informare=sir2;
      delete from activitate_grup where id_a=id;
      end if; end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `programare_activitate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `programare_activitate`(denumire varchar(30),materie varchar(30),data_act date,
ora_inceput time,ora_sfarsit time,nr_max_participanti int,n int)
BEGIN
    -- declare n int;
    declare c int;
    -- set n=(select id from utilizator where utilizator.nume=nume);
    set c=(select id from cursuri where cursuri.materie=materie);
    insert into activitati (activitate,data_act,ora_inceput,ora_sfarsit,id_profesor,id_curs,nr_max_participanti)
    values(denumire,data_act,ora_inceput,ora_sfarsit,n,c,nr_max_participanti);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `renuntare_curs` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `renuntare_curs`(materie varchar(30),id_s int)
BEGIN
    
     declare id_c int;
     declare id_p int;
   
     set id_c=(select id from cursuri where materie=cursuri.materie);
     set id_p=(select id_profesor from inscrieri where id_student=id_s and id_curs=id_c);
     update profesor_curs set nr_studenti_curent=nr_studenti_curent-1
     where id_prof=id_p and id_curs=id_c;
     delete from inscrieri where id_curs=id_c and id_student=id_s;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sugestii_membri` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sugestii_membri`(materie varchar(30))
BEGIN
select nume,prenume from utilizator
where not exists(
select nume as nume_student from utilizator,student,cursuri,inscrieri,mesaj,grup_de_studiu
   where cursuri.materie=materie 
   and student.id_utilizator=utilizator.id
   and inscrieri.id_student=student.id_utilizator
   and inscrieri.id_curs=cursuri.id
   and student.id_utilizator=mesaj.id_student
   and grup_de_studiu.id_curs=cursuri.id
   and grup_de_studiu.id=mesaj.id_grup
   );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_procente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_procente`(id_curs int,id_prof int,idc int,ids int,idl int)
BEGIN
     update profesor_curs set p_curs=idc, p_seminar=ids,p_lab=idl
     where profesor_curs.id_curs=id_curs and profesor_curs.id_prof=id_prof;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_utilizator` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_utilizator`(id_user int,tip varchar(30),newchar varchar(30),newint int)
BEGIN
declare functia int;
set functia=(select functie from utilizator where id_user=id);
     if(strcmp(tip,"nume")=0) then update utilizator
       set nume=newchar
       where id_user=id;
	 else if(strcmp(tip,"prenume")=0) then update utilizator
       set prenume=newchar
       where id_user=id;
	 else if(strcmp(tip,"cnp")=0) then update utilizator
       set cnp=newchar
       where id_user=id;
	 else if(strcmp(tip,"adresa")=0) then update utilizator
       set adresa=newchar
       where id_user=id;
	 else if(strcmp(tip,"telefon")=0) then update utilizator
       set telefon=newchar
       where id_user=id;
	 else if(strcmp(tip,"email")=0) then update utilizator
       set email=newchar
       where id_user=id;
	 else if(strcmp(tip,"iban")=0) then update utilizator
       set iban=newchar
       where id_user=id;
	 else if(strcmp(tip,"nr_contract")=0) then update utilizator
       set nume=newint
       where id_user=id;
     end if; end if; end if; end if;
     end if; end if; end if; end if;
     
     if(functia=1) then 
       if(strcmp(tip,"departament")=0) then update profesor
       set departament=newchar
       where id_user=id_utilizator;
       else if(strcmp(tip,"nr_min_ore")=0) then update profesor
       set nr_min_ore=newint
       where id_user=id_utilizator;
       else if(strcmp(tip,"nr_max_ore")=0) then update profesor
       set nr_max_ore=newint
       where id_user=id_utilizator;
       end if; end if; end if;
	else if(functia=2) then
		if(strcmp(tip,"an_studiu")=0) then update student
       set an_studiu=newint
       where id_user=id_utilizator;
       else if(strcmp(tip,"nr_ore")=0) then update student
       set nr_ore=newint
       where id_user=id_utilizator;
       end if; end if; end if; end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vizualizare_cursuri_pt_prof` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vizualizare_cursuri_pt_prof`(id_prof int,id_curs int)
BEGIN
    select id_prof from profesor_curs where id_curs=profesor_curs.id_curs and profesor_curs.id_prof=id_prof;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vizualizare_date_user` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vizualizare_date_user`(nume varchar(30))
BEGIN
   select * from utilizator where utilizator.nume=nume;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vizualizare_membri_grup` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vizualizare_membri_grup`(materie varchar(30))
BEGIN
    select distinct(nume) ,prenume from utilizator,student,cursuri,inscrieri,mesaj,grup_de_studiu
   where cursuri.materie=materie 
   and student.id_utilizator=utilizator.id
   and inscrieri.id_student=student.id_utilizator
   and inscrieri.id_curs=cursuri.id
   and student.id_utilizator=mesaj.id_student
   and grup_de_studiu.id_curs=cursuri.id
   and grup_de_studiu.id=mesaj.id_grup;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vizualizare_note` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vizualizare_note`(id_s int,materie varchar(30))
BEGIN
    
    declare id_c int;
   
    set id_c=(select id from cursuri where materie=cursuri.materie);
    select nota_curs,nota_seminar,nota_lab,nota_examen_final from inscrieri
    where id_student=id_s and id_curs=id_c ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vizualizare_note_descarcare` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vizualizare_note_descarcare`(id_s int)
BEGIN
    select materie,nota_curs,nota_seminar,nota_lab,nota_examen_final from inscrieri,cursuri
    where id_student=id_s and id_curs=cursuri.id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vizualizare_user_id` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vizualizare_user_id`(id int)
BEGIN
   select * from utilizator where utilizator.id=id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-13  9:27:02
