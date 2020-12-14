-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: arquitectdb
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `acabados`
--

DROP TABLE IF EXISTS `acabados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acabados` (
  `Id_Acabado` int NOT NULL AUTO_INCREMENT,
  `Codigo_Homologacion` int NOT NULL,
  `Descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_Acabado`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acabados`
--

LOCK TABLES `acabados` WRITE;
/*!40000 ALTER TABLE `acabados` DISABLE KEYS */;
INSERT INTO `acabados` VALUES (1,11,'LACADO NEGRO 9005 MATE LISO'),(2,1,'ANODIZADO PLATA MATE'),(3,12,'LACADO ANTRACITA 7016 MATE LISO'),(4,10,'LACADO BLANCO 9003 MATE LISO'),(5,50,'GALVANIZADO'),(6,51,'CINCADO NATURAL'),(7,61,'PLASTICO TRANSPARENTE'),(8,62,'PLASTICO BLANCO'),(9,63,'PLASTICO GRIS PLATA'),(10,64,'PLASTICO NEGRO'),(11,65,'PLASTICO VERDE'),(12,66,'PLASTICO AZUL'),(13,70,'INOX'),(14,71,'ACERO'),(15,72,'BRUTO'),(16,75,'LANA'),(17,80,'CINTA ADHESIVA'),(18,81,'ACRILICA GRIS'),(19,82,'ACRILICA ANTRACITA'),(20,83,'TELA GRIS'),(21,84,'TELA NEGRO'),(22,85,'LIQUIDO'),(23,86,'SILICONA'),(24,87,'ADHESIVO'),(25,90,'VIDRIO TRANSPARENTE'),(26,91,'VIDRIO TRANSLÚCIDO'),(27,95,'DM'),(28,96,'AGLOMERADO'),(29,97,'CONTRACHAPADO'),(30,98,'MADERA MACIZA');
/*!40000 ALTER TABLE `acabados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `Id_Categoria` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) NOT NULL,
  `Tipo_Formula` varchar(2) NOT NULL,
  PRIMARY KEY (`Id_Categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Perfiles','A'),(2,'Puertas','B'),(3,'Paneles y Vidrios','C');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes`
--

DROP TABLE IF EXISTS `componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `componentes` (
  `Id_Componente` int NOT NULL,
  `Codigo` varchar(10) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Fecha_Creacion` datetime NOT NULL,
  PRIMARY KEY (`Id_Componente`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  UNIQUE KEY `Descripcion_UNIQUE` (`Descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes`
--

LOCK TABLES `componentes` WRITE;
/*!40000 ALTER TABLE `componentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes_detalle`
--

DROP TABLE IF EXISTS `componentes_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `componentes_detalle` (
  `Id_Componente` int NOT NULL,
  `Id_Subcomponente` int NOT NULL,
  `Id_Corte` int NOT NULL,
  `Medida` int NOT NULL,
  `Unidad_Ensamble` int NOT NULL,
  PRIMARY KEY (`Id_Componente`,`Id_Subcomponente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes_detalle`
--

LOCK TABLES `componentes_detalle` WRITE;
/*!40000 ALTER TABLE `componentes_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `componentes_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cortes`
--

DROP TABLE IF EXISTS `cortes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cortes` (
  `Id_Corte` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(2) NOT NULL,
  `Corte_Derecho` int NOT NULL,
  `Corte_Izquierdo` int NOT NULL,
  PRIMARY KEY (`Id_Corte`),
  UNIQUE KEY `Descripcion_UNIQUE` (`Descripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cortes`
--

LOCK TABLES `cortes` WRITE;
/*!40000 ALTER TABLE `cortes` DISABLE KEYS */;
/*!40000 ALTER TABLE `cortes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcomponentes`
--

DROP TABLE IF EXISTS `subcomponentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subcomponentes` (
  `Id_Subcomponente` int NOT NULL AUTO_INCREMENT,
  `Id_Acabado` int NOT NULL,
  `Id_Unidad` int NOT NULL,
  `Id_Unidad_Calculada` int NOT NULL,
  `Codigo_Homologacion` varchar(10) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad_defaultd` int NOT NULL DEFAULT '1',
  `Aplica_decremento` tinyint NOT NULL DEFAULT '0',
  `Cantidad_Adicional` int NOT NULL DEFAULT '30',
  PRIMARY KEY (`Id_Subcomponente`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo_Homologacion`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcomponentes`
--

LOCK TABLES `subcomponentes` WRITE;
/*!40000 ALTER TABLE `subcomponentes` DISABLE KEYS */;
INSERT INTO `subcomponentes` VALUES (1,2,1,0,'VIC0009-67','PERFIL BASE PINZA',1,0,30),(2,2,1,0,'VIC0008-01','PERFIL TAPA PINZA',1,0,30),(3,2,1,0,'VIC0010-50','TUERCA ESCENTRICA PINZA',1,0,30),(4,2,1,0,'VIC0511-51','TORNILLO DIN 7991 M4 x 10 CINCADO',1,0,30),(5,2,1,0,'VIC0512-51','ESPARRAGO DIN 913 M5 x 6',1,0,30),(7,5,3,0,'00000','prueba',1,0,30);
/*!40000 ALTER TABLE `subcomponentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidades_medidas`
--

DROP TABLE IF EXISTS `unidades_medidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidades_medidas` (
  `Id_Unidad_Medida` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(50) NOT NULL,
  `Convencion` varchar(10) NOT NULL,
  PRIMARY KEY (`Id_Unidad_Medida`),
  UNIQUE KEY `Descripcion_UNIQUE` (`Descripcion`),
  UNIQUE KEY `Convencion_UNIQUE` (`Convencion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades_medidas`
--

LOCK TABLES `unidades_medidas` WRITE;
/*!40000 ALTER TABLE `unidades_medidas` DISABLE KEYS */;
INSERT INTO `unidades_medidas` VALUES (1,'Kilogramos','kg'),(2,'Unidad','ud'),(3,'Metros','m'),(4,'Metros Cuadrado','m²');
/*!40000 ALTER TABLE `unidades_medidas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-07  9:31:33
