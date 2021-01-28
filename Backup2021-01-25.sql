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
  `Codigo_Homologacion` varchar(2) NOT NULL,
  `Descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_Acabado`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acabados`
--

LOCK TABLES `acabados` WRITE;
/*!40000 ALTER TABLE `acabados` DISABLE KEYS */;
INSERT INTO `acabados` VALUES (1,'11','LACADO NEGRO 9005 MATE LISO'),(2,'1','ANODIZADO PLATA MATE'),(3,'12','LACADO ANTRACITA 7016 MATE LISO'),(4,'10','LACADO BLANCO 9003 MATE LISO'),(5,'50','GALVANIZADO'),(6,'51','CINCADO NATURAL'),(7,'61','PLASTICO TRANSPARENTE'),(8,'62','PLASTICO BLANCO'),(9,'63','PLASTICO GRIS PLATA'),(10,'64','PLASTICO NEGRO'),(11,'65','PLASTICO VERDE'),(12,'66','PLASTICO AZUL'),(13,'70','INOX'),(14,'71','ACERO'),(15,'72','BRUTO'),(16,'75','LANA'),(17,'80','CINTA ADHESIVA'),(18,'81','ACRILICA GRIS'),(19,'82','ACRILICA ANTRACITA'),(20,'83','TELA GRIS'),(21,'84','TELA NEGRO'),(22,'85','LIQUIDO'),(23,'86','SILICONA'),(24,'87','ADHESIVO'),(25,'90','VIDRIO TRANSPARENTE'),(26,'91','VIDRIO TRANSLÚCIDO'),(27,'95','DM'),(28,'96','AGLOMERADO'),(29,'97','CONTRACHAPADO'),(30,'98','MADERA MACIZA');
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
  `Id_Componente` int NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(20) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  `Fecha_Creacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id_Componente`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  UNIQUE KEY `Descripcion_UNIQUE` (`Descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes`
--

LOCK TABLES `componentes` WRITE;
/*!40000 ALTER TABLE `componentes` DISABLE KEYS */;
INSERT INTO `componentes` VALUES (35,'AVS0008-61','IMPULS 100 AV- PERFIL PISO EN U (V 6+6MM)','2021-01-16 13:32:08'),(36,'CIS0003-61','IMPULS 100 CI A1_ PERFIL PISO','2021-01-17 17:50:44'),(37,'CIS0002-61','IMPULS 100 CI A1_ PERFIL PARED','2021-01-20 11:32:14');
/*!40000 ALTER TABLE `componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes_detalle`
--

DROP TABLE IF EXISTS `componentes_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `componentes_detalle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Id_Componente` int NOT NULL,
  `Id_Subcomponente` int NOT NULL,
  `Cantidad_Default` int NOT NULL DEFAULT '1',
  `Cantidad_Adicional` int NOT NULL DEFAULT '30',
  `Aplica_Decremento` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes_detalle`
--

LOCK TABLES `componentes_detalle` WRITE;
/*!40000 ALTER TABLE `componentes_detalle` DISABLE KEYS */;
INSERT INTO `componentes_detalle` VALUES (26,35,9,1,30,0),(27,35,12,1,30,1),(28,35,15,3,30,0),(36,36,9,2,30,0),(37,36,12,1,30,0),(38,36,29,2,30,0),(39,36,308,6,30,0),(40,36,308,6,30,0),(41,37,9,1,30,0),(42,37,10,1,30,0),(43,37,308,5,30,0);
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
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `Id_Subcomponente` int NOT NULL,
  `cantidad` int NOT NULL,
  `medida` decimal(18,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
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
  `Id_Unidad_Calculada` int NOT NULL,
  `Codigo_Homologacion` varchar(20) NOT NULL,
  `Descripcion` varchar(200) NOT NULL,
  PRIMARY KEY (`Id_Subcomponente`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo_Homologacion`)
) ENGINE=InnoDB AUTO_INCREMENT=366 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcomponentes`
--

LOCK TABLES `subcomponentes` WRITE;
/*!40000 ALTER TABLE `subcomponentes` DISABLE KEYS */;
INSERT INTO `subcomponentes` VALUES (9,7,1,'VIC0001','PERFIL ZOCALO VITRUM '),(10,7,1,'VIC0002','PERFIL TAPA VITRUM'),(11,7,1,'VIC0003','PERFIL MODULO TECNICO'),(12,7,1,'VIC0004','PERFIL TAPA MODULO TECNICO'),(13,8,2,'VIC0005','NIVELADOR '),(14,6,2,'VIC0006','UNION PUERTA ZOCALO '),(15,8,2,'VIC0007','SOPORTE TAPA '),(16,2,1,'VIC0008','PERFIL TAPA PINZA '),(17,12,1,'VIC0009','PERFIL BASE PINZA'),(28,5,2,'VIC0010','TUERCA EXCENTRICA PINZA '),(29,6,2,'VIC0011','SOPORTE NIVELADOR BLUEBRANCH '),(31,6,2,'VIC0012','TORNILLO NIVELADOR BLUEBRANCH M6x16 '),(32,8,2,'VIC0013','TAPON TORNILLO NIVELADOR BLUEBRANCH '),(33,9,2,'VIC0014','TAPON FINAL BLUEBRANCH '),(34,9,2,'VIC0015','TOPE INFERIOR IZQUIERDO BLUEBRANCH '),(35,9,2,'VIC0016','TOPE INFERIOR DERECHO BLUEBRANCH '),(36,9,2,'VIC0017','TOPE SUPERIOR IZQUIERDO BLUEBRANCH '),(37,9,2,'VIC0018','TOPE SUPERIOR DERECHO BLUEBRANCH '),(38,6,2,'VIC0019','TORNILLO SOPORTE DE TOPE/TAPON BLUEBRANCH M4x20 '),(39,8,2,'VIC0020','ARANDELA TOPE DE COSTILLA BLUEBRANCH '),(40,7,2,'VIC0021','TOPE PARED BLUEBRANCH '),(41,7,1,'VIC0022','GOMA VITRUM 5+5 '),(42,7,1,'VIC0023','GOMA VITRUM 6+6 '),(43,7,1,'VIC0024','GOMA VITRUM FIJA '),(44,12,1,'VIC0025','CINTA ADHESIVA DOBLE CARA 2mm 5+5 (18mx6mm) '),(45,12,1,'VIC0026','CINTA ADHESIVA DOBLE CARA 2mm 5+5 (15mx6mm) '),(46,12,1,'VIC0027','CINTA ADHESIVA DOBLE CARA 1mm 5+5 (25mx6mm) '),(47,12,1,'VIC0028','CINTA ADHESIVA DOBLE CARA 2mm 6+6 (18mx9mm) '),(48,7,1,'VIC0029','TUBO 40x40 '),(49,5,2,'VIC0030','ESCUADRA UNION MODULO TECNICO '),(50,19,1,'VIC0031','BURLETE ANCHO GRIS ANRACITA 25mx17mmx2mm '),(51,18,1,'VIC0032','BURLETE ANCHO GRIS CLARO 25mx17mmx2mm '),(52,17,1,'VIC0033','CINTA ADHESIVA DOBLE CARA FINA (50mx19mmx0,1mm) '),(53,13,2,'VIC0034','TORNILLO UNION PTA./ZOC. M6x30 '),(54,15,1,'VIC0035','ANGULO 50 x 50 x 6mm '),(55,7,1,'VIC0100','PERFIL MARCO PUERTA VITRUM '),(56,7,1,'VIC0106','GOMA DE BUBUJA PUERTA VITRUM '),(57,7,1,'VIC0107','GOMA DE MARCO VITRUM PARA 5+5 '),(58,7,1,'VIC0108','U  15x14.5x15 GUIA MARCO PUERTA L=3000 '),(59,12,1,'VIC0110','TUBO 25x15 '),(60,7,1,'VIC0111','T 40 x 40 '),(61,6,2,'VIC0500','ESCUADRA MARCO VITRUM '),(62,5,2,'VIC0501','BISAGRA BLUEBRANCH IZQUIERDA VIDRIO-VIDRIO '),(63,5,2,'VIC0502','BISAGRA BLUEBRANCH DERECHA VIDRIO-VIDRIO '),(64,5,2,'VIC0503','BISAGRA BLUEBRANCH IZQUIERDA FRENO VIDRIO-VIDRIO '),(65,5,2,'VIC0504','BISAGRA BLUEBRANCH DERECHA FRENO VIDRIO-VIDRIO '),(66,5,2,'VIC0505','BISAGRA BLUEBRANCH IZQUIERDA PARED-VIDRIO '),(67,5,2,'VIC0506','BISAGRA BLUEBRANCH DERECHA PARED-VIDRIO '),(68,5,2,'VIC0507','BISAGRA BLUEBRANCH IZQUIERDA FRENO PARED-VIDRIO '),(69,5,2,'VIC0508','BISAGRA BLUEBRANCH DERECHA FRENO PARED-VIDRIO '),(70,13,2,'VIC0509','TIRADOR PUERTA '),(71,13,2,'VIC0510','TOPE PUERTA DOBLE BLUEBRANCH '),(72,6,2,'VIC0511','TORNILLO EXCENTRICA BASE PINZA M5x10 '),(73,6,2,'VIC0512','ESPARRAGO TAPA PINZA M5x6 '),(74,15,2,'VIC0513','ESCUADRA PIVOTANTE MARCO VITRUM '),(75,5,1,'IMC0001','PERFIL U ACERO TECHO 60x20 '),(76,5,1,'IMC0002','PERFIL ACERO VERTICAL DE 40 '),(77,5,1,'IMC0003','PERFIL ACERO VERTICAL DE 20 '),(78,7,1,'IMC0004','PERFIL ZOCALO OX '),(79,7,1,'IMC0005','PERFIL 100x100'),(80,7,1,'IMC0006','PERFIL 100x20 '),(87,7,1,'IMC0007','PERFIL MONOVIDRIO RECTO '),(88,7,1,'IMC0008','GOMA IMPULS 6+6 '),(89,12,1,'IMC0010','CINTA ADHESIVA DOBLE CARA 2mm 3+3 (16,5mx4mm) '),(90,14,2,'IMC0011','CALCE VIDRIO VERDE 2mm  '),(91,15,2,'IMC0012','CALCE VIDRIO AZUL 3mm  '),(92,10,2,'IMC0013','CALCE VIDRIO NEGRO 4mm '),(93,8,2,'IMC0014','CALCE VIDRIO BLANCO 5mm '),(94,7,1,'IMC0015','TAPA PERFIL VIDRIO DOBLE '),(95,7,1,'IMC0016','TAPA LARGA PERFIL VIDRIO DOBLE '),(96,19,1,'IMC0017','BURLETE ESTRECHO GRIS ANRACITA 25mx9mmx2mm '),(97,18,1,'IMC0018','BURLETE ESTRECHO GRIS CLARO 25mx9mmx2mm '),(98,21,1,'IMC0019','BURLETE TELA NEGRO 50mx10mm '),(99,20,1,'IMC0020','BURLETE TELA GRIS 50mx10mm '),(100,19,1,'IMC0021','BURLETE ANCHO TABLEROS GRIS ANRACITA 25mx15mmx3mm'),(101,15,1,'IMC0022','ANGULO 40 x 40 x 4mm '),(102,15,1,'IMC0023','PLETINA 40 x 8mm '),(103,15,1,'IMC0024','PLETINA 40 x 4mm '),(104,7,1,'IMC0100','PERFIL MARCO PUERTA DV '),(105,7,1,'IMC0101','GOMA DE BUBUJA PUERTA IMPULS '),(106,7,1,'IMC0102','PERFIL TAPA MARCO PUERTA 100 '),(107,7,1,'IMC0103','MARCO DE PUERTA ACÚSTICA DE 100 '),(108,7,1,'IMC0104','BASTIDOR HOJA DE PUERTA ACÚSTICA DE 100 '),(109,7,1,'IMC0105','BASTIDOR HOJA DE PUERTA ACÚSTICA DE 38 '),(110,7,1,'IMC0106','BASTIDOR HOJA DE PUERTA VIDRIO SIMPLE DE 38 '),(111,7,1,'IMC0107','U PLASTICO VIDRIO 6mm BASTIDOR PUERTA VIDRIO SIMPLE DE 38'),(115,7,1,'IMC0108','L 60 x 15 '),(116,7,1,'IMC0109','L 40 x 20 '),(117,5,2,'IMC0500','PERFIL TELESCOPICO ACERO DE 40 '),(118,5,2,'IMC0501','PERFIL TELESCOPICO ACERO DE 20 '),(119,6,2,'IMC0502','NIVELADOR MONTANTE CIEGO '),(120,6,2,'IMC0503','\"SOPORTE DE AJUSTE PERFIL VERTICAL LIGERO\" '),(121,6,2,'IMC0504','SOPORTE DE AJUSTE PERFIL VERTICAL '),(122,7,2,'IMC0505','ANGULAR DE SOPORTE LARGUERO '),(123,6,2,'IMC0506','ANGULAR DE SOPORTE LARGUERO ATORNILLA '),(124,6,2,'IMC0507','REGULADOR TELESCOPICO '),(125,6,2,'IMC0508','NUEVO CLIP DE COLGAR '),(126,5,2,'IMC0509','ESCUADRA SOPORTE 100x100-100x20-MARCO FLOT '),(132,15,2,'IMC0510','ESCUADRA MARCO DV '),(133,15,2,'IMC0511','ESCUADRA MARCO 100 '),(136,6,2,'IMC0512',' ESCUADRA BASTIDOR PTA. ACUSTICA 38 '),(137,15,2,'IMC0513','ESCUADRA BASTIDOR PTA. ACUSTICA 100 '),(138,15,2,'IMC0514','ESCUADRA VIDRIO DOBLE '),(139,15,2,'IMC0515','HEMBRA TENSOR PTA. ACUSTICA 38 M4x20 '),(140,15,2,'IMC0516','VARILLA TENSOR PTA.ACUSTICA 38 M4 '),(141,15,2,'IMC0517','TORNILLO TENSOR PTA. ACUSTICA 38 M4x30 '),(142,7,2,'IMC0518','TAPA TORNILLO PTA. ACUSTICA 100 '),(143,5,2,'IMC0519','CENTRADOR PANEL '),(144,29,2,'IMC0520','LISTON BASTIDOR PTA. ACUSTICA 38 '),(145,15,2,'IMC0521','ESCUADRA PIVOTANTE MARCO DV IZQ + PLETINA INFERIOR SUJECCION '),(146,15,2,'IMC0522','ESCUADRA PIVOTANTE MARCO DV DCH + PLETINA INFERIOR SUJECCION '),(147,15,2,'IMC0523','ESCUADRA INTERIOR BASTIDOR ACUSTICA 38 40x40x4 (ANTIGUA) '),(148,7,1,'ICC0001','PERFIL ZOCALO BAJO '),(149,7,1,'ICC0002','PERFIL ZOCALO ALTO '),(150,16,1,'ICC0003','LANA DE ROCA '),(151,7,1,'DVC0001','PERFIL VIDRIO DOBLE '),(152,7,1,'DVC0002','IMPULS VIDRIO DOBLE ABIERTO '),(153,7,1,'DVC0003','IMPULS TAPA VIDRIO DOBLE ABIERTO '),(154,7,1,'DVC0004','PERFIL VENTANA VIDRIO DOBLE '),(155,7,1,'AVC0001','PERFIL AV '),(156,7,1,'AVC0002','PERFIL U IMPULS '),(157,7,2,'AVC0003','TAPON AV '),(158,7,1,'AVC0100','PERFIL MARCO PUERTA AV '),(159,15,2,'IMC0110','ESCUADRA MARCO AV '),(160,15,2,'IMC0111','ESCUADRA PIVOTANTE MARCO AV '),(161,7,1,'ITC0001','PERFIL MONOVIDRIO IMPULS T '),(162,7,1,'ITC0002','PERFIL VIDRIO DOBLE IMPULS T '),(163,7,1,'ITC0100','MARCO PUERTA IMPULS T '),(164,7,1,'MTC0001','MARCO TELESCOPICO FIJO '),(165,7,1,'MTC0002','MARCO TELESCOPICO MOVIL ESTRECHO '),(167,7,1,'MTC0003','MARCO TELESCOPICO MOVIL ANCHO '),(168,10,1,'MTC0004','GOMA MARCO TELESCOPICO '),(169,15,2,'MTC0501','ESCUADRA PLANA MARCO TELESCOPICO '),(170,5,2,'PHC0005','ESCUADRA UNION ACERO '),(171,5,2,'PHC0006','ESCUADRA ESTRUCTURA '),(172,1,2,'PHC0501','CHAPA PLEGADA SUELO '),(173,5,2,'PHC0502','L UNION BALDA '),(174,1,2,'PHC0503','REJILLA RECTANGULAR '),(175,1,2,'PHC0504','REJILLA CUADRADA '),(176,7,2,'PHC0505','MOQUETA '),(177,7,2,'PHC0506','VENTILADOR BEQUIET '),(178,7,2,'PHC0507','TRANSFORMADOR PEQUEÑO '),(179,7,2,'PHC0508','TRANSFROMADOR GRANDE '),(180,7,2,'PHC0509','DETECTOR DE LUZ '),(181,7,2,'PHC0510','CAJAS REGISTRABLES '),(182,7,2,'PHC0511','BUZZY '),(183,7,2,'PHC0512','KAPSA XS 1T+1 USB CARGADOR '),(184,7,2,'PHC0513','MACHO WIELAND '),(185,7,2,'PHC0514','HEMBRA WIELAND '),(186,7,2,'PHC0515','MULTIPLICADOR WIELAND x3 '),(187,1,2,'PHC0516','KAPSA XS TAPA NEGRA '),(188,7,2,'PHC0517','CABLE SCHUKO Y WIELAND HEMBRA '),(189,7,2,'PHC0518','TIRA LED '),(190,5,2,'PHC0519','ZOCALO PARA EL LED '),(191,7,2,'PHC0520','TAPA PARA EL LED '),(192,7,2,'PHC0601','VIDRIO TEMPLADO 10mm PUERTA '),(193,7,2,'PHC0602','VIDRIO LAMINAR 5+5 SILENCE '),(194,2,2,'HEC0500','CERRADURA ARMARIO EXENTO '),(195,2,2,'HEC0501','CERRADURA CAJON METALICO '),(196,2,2,'HEC0502','CERRADURA FALLEBA '),(197,9,2,'HEC0503','CERRADURA COMBINACION DERECHA LOCK 57 '),(198,10,2,'HEC0504','CERRADURA COMBINACION IZQUIERDA LOCK 57 '),(199,10,2,'HEC0505','CERRADURA COMBINACION DERECHA LOCK 59 '),(205,14,2,'HEC0506','LLAVE EXTRACTORA BOMBILLOS '),(206,14,2,'HEC0507','PINTXO CERRADURA COMBINACION'),(207,2,2,'HEC0508','TIRADOR POMO '),(208,2,2,'HEC0509','TIRADOR  \" L \" '),(209,8,2,'HEC0510','TIRADOR PUSH '),(210,10,2,'HEC0511','TIRADOR PUSH '),(211,2,2,'HEC0512','TIRADOR CONCHA ENCASTRADO '),(212,2,2,'HEC0513','POMOS DERECHA '),(213,14,2,'HEC0514','CAJONES METÁLICOS '),(214,10,2,'HEC0515','KEKU MACHO '),(215,10,2,'HEC0516','KEKU HEMBRA '),(216,6,2,'HEC0517','NIVELADOR '),(217,28,2,'HEC0518','GALLETAS '),(218,6,2,'HEC0519','EXCENTRICA 15x15 '),(219,6,2,'HEC0520','TORNILLO EXCENTRICA  '),(220,28,2,'HEC0521','ESPIGA D8 '),(221,7,2,'HEC0522','VELCRO '),(222,6,2,'HEC0523','TUERCA EMBUTIDA '),(223,6,2,'HEC0524','TORNILLO M8x20 '),(224,6,2,'HEC0525','ARANDELA DENTADA PARA M8 '),(225,6,2,'HEC0526','PUNTABROCA Ø4,2x16 '),(226,6,2,'HEC0527','PUNTABROCA 4,2x17 '),(227,6,2,'HEC0528','TIRAFONDO 4,2x18 '),(228,2,2,'HEC0529','PERCHA EXTRAIBLE L45 '),(229,2,2,'HEC0530','PERCHA EXTRAIBLE L40 '),(230,2,2,'HEC0531','PERCHA EXTRAIBLE L35 '),(231,10,2,'HEC0532','RUEDAS CAJONERAS '),(232,2,2,'HEC0533','ESCUADRA CERRADURA '),(233,2,2,'HEC0534','LENGÜETA CERRADURA '),(234,10,2,'HEC0535','PATA H17 '),(235,10,2,'HEC0536','PATA H45 '),(236,2,2,'HEC0537','SOPORTE MOD. COLGAR OFFICE '),(237,2,2,'HEC0538','CHAPA MOD. COLGAR OFFICE '),(238,10,2,'HEC0539','PATA MOD. BAJOS OFFICE '),(239,10,2,'HEC0540','GRAPA PATA MOD. BAJOS OFFICE '),(240,9,2,'HEC0541','CAZOLETA D20 '),(241,2,2,'HEC0542','TORNILLO PARA CAZOLETA D20 '),(242,2,2,'HEC0543','CAZOLETA D15 '),(243,2,2,'HEC0544','TORNILLO L24 PARA CAZOLETA D15 '),(244,2,2,'HEC0545','CAZOLETA D20 '),(245,2,2,'HEC0546','TORNILLO PARA CAZOLETA D20 '),(246,14,2,'HEC0547','SET CAJON 70/420 H30 GRIS PLATA '),(247,2,2,'HEC0548','NIVELADOR ARM.TABIQUE '),(248,12,2,'HEC0549','ESCUADRA PARA NIVELADOR ARM.TABIQUE '),(249,8,2,'HEC0550','TAPON PARA NIVELADOR ARM.TABIQUE '),(250,2,2,'HEC0551','ESCUADRA TRASERA '),(251,2,2,'HEC0552','TORNILLO ESCUADRA TRASERA '),(252,10,2,'HEC0553','MEDIA LUNA - CERRADURA '),(263,2,2,'HEC0555','BISAGRA RECTA '),(264,2,2,'HEC0556','BISAGRA OCULTA '),(265,2,2,'HEC0557','BISAGRA RECTA AMORTIGUADA '),(266,6,2,'HEC0580','BISAGRA PUERTA CIEGA RF 1076 R10 2BB INOX '),(267,6,2,'HEC0581','CERRADURA PUERTA CIEGA '),(269,6,2,'HEC0582','JUEGO MANILLA 90 º RECTA PUERTA CIEGA '),(270,6,2,'HEC0583','JUEGO ESCUDO BOCALLAVE PUERTA CIEGA '),(271,7,2,'HEC0584','CERRADURA PUERTA VIDRIO DORMA '),(272,7,2,'HEC0585','CERRADURA PUERTA VIDRIO DORMA PASO '),(273,7,2,'HEC0586','CERRADERO PUERTA DOBLE VIDRIO DORMA '),(274,7,2,'HEC0587','MANILLA PUERTA DE VIDRIO DORMA '),(275,7,2,'HEC0588','POMO/MANILLA PUERTA DE VIDRIO DORMA '),(276,6,2,'HEC0589','BOMBILLO 60 (30/30) LEVA LARGA '),(277,7,2,'HEC0590','PERFIL PIVOTANTE '),(278,7,2,'HEC0591','BISAGRA INFERIOR IZQUIERDA PIVOTANTE VITRUM/DV '),(279,7,2,'HEC0592','BISAGRA SUPERIOR IZQUIERDA PIVOTANTE VITRUM/DV '),(280,7,2,'HEC0593','BISAGRA INFERIOR DERECHA PIVOTANTE VITRUM/DV '),(281,7,2,'HEC0594','BISAGRA SUPERIOR DERECHA PIVOTANTE VITRUM/DV '),(282,7,2,'HEC0595','BISAGRA INFERIOR IZQUIERDA PIVOTANTE AV '),(283,7,2,'HEC0596','BISAGRA SUPERIOR IZQUIERDA PIVOTANTE AV '),(284,7,2,'HEC0597','BISAGRA INFERIOR DERECHA PIVOTANTE AV '),(285,7,2,'HEC0598','BISAGRA SUPERIOR DERECHA PIVOTANTE AV '),(286,8,2,'HEC0599','TAPON PERFIL PIVOTANTE '),(287,8,2,'HEC0600','ARANDELA PIVOTANTE '),(288,8,2,'HEC0601','CASQUILLO PERFIL PIVOTANTE '),(289,6,2,'HEC0602','ESPARRAGO CASQUILLO PERFIL PIVOTANTE M5x25 '),(290,7,2,'HEC0603','BISAGRA PUERTA DE VIDRIO DORMA '),(291,7,2,'HEC0604','BISAGRA PUERTA DE VIDRIO MINUSCO '),(292,5,2,'HEC0605','PLACA SOPORTE BISAGRA GRANDE   LA PAZ '),(293,5,2,'HEC0606','PLACA SOPORTE BISAGRA JNF '),(294,13,2,'HEC0607','TORNILLO PLACA BISAGRA DIN 7991 M4 x 10 INOX '),(295,13,2,'HEC0608','TOPE PUERTA '),(296,6,2,'HEC0609','TORNILLO BISAGRA PIVOTANTE '),(297,13,2,'HEC0610','JUEGO ESCUDO JNF PUERTA ACUSTICA PASO JUEGO ESCUDO JNF PUERTA ACUSTICA PASO '),(298,13,2,'HEC0611','JUEGO ESCUDO JNF PUERTA ACUSTICA CON BOMBILLO '),(299,13,2,'HEC0612','JUEGO MANILLA JNF SIN ROSETA '),(300,6,2,'HEC0613','CERRADURA JNF 50 MECANICA PUERTA ACUSTICA 40 '),(301,6,2,'HEC0614','CERRADURA JNF 60 MECANICA PUERTA ACUSTICA 100 '),(302,7,2,'HEC0615','BISAGRA OCULTA KUBIK '),(303,6,2,'HEC0616','GUILLOTINA PUERTA ACUSTICA 100 '),(304,7,2,'HEC0617','CHAPA GUILLOTINA '),(305,6,2,'HEC0618','CUADRADILLO PUERTA ACUSTICA 100 '),(306,6,2,'HEC0619','BOMBILLO 120 (90/30) LEVA LARGA '),(307,27,2,'HEC0620','CALCE DM CERRADURA '),(308,6,4,'HEC0621','CIERRE ELÉCTRICO '),(309,6,2,'HEC0622','CUADRADILLO MEDIO LOCO '),(310,13,2,'HEC0623','POMO/MANILLA PUERTA CIEGA '),(311,7,2,'HEC0624','BISAGRA PIVOTANTE DERECHA PUERTA CIEGA '),(312,7,2,'HEC0625','BISAGRA PIVOTANTE IZQUIERDA PUERTA CIEGA '),(313,7,2,'HEC0626','BISAGRA PIVOTANTE DERECHA PUERTA V.S. ENMARCADA '),(314,7,2,'HEC0627','BISAGRA PIVOTANTE IZQUIERDA PUERTA V.S. ENMARCADA '),(315,7,2,'HEC0628','ESCUDO MANILLA PUERTA MINIMALISTA '),(316,7,2,'HEC0629','CERRADURA PUERTA ENMARCADA VIDRIO SIMPLE DE 38 '),(317,7,2,'HEC0630','EMBELLECEDOR CERRADERO '),(318,27,2,'HEC0631','TACO DM CERRADURA PUERTA ENMARCADA VIDRIO SIMPLE DE 38 '),(319,7,2,'HEC0632','MUELLE DORMA TS-90 '),(324,7,2,'HEC0633','MUELLE DORMA TS-92 '),(325,7,2,'HEC0634','GUANTE VIDRIO MUELLE DORMA    TS-92 '),(326,14,2,'HEC0635','TORNILLO TACO Ø3,9x45 '),(327,8,2,'HEC0636','TACO TORNILLO Ø6x35 '),(328,6,2,'HEC0637','PUNTABROCA Ø3,5x13 '),(329,6,2,'HEC0638','PUNTABROCA Ø3,5x19 '),(330,6,2,'HEC0639','PUNTABROCA Ø4,2x22 '),(331,6,2,'HEC0640','PUNTABROCA Ø4,2x25 '),(332,6,2,'HEC0641','PUNTABROCA Ø4,2x38 '),(333,6,2,'HEC0642','PUNTABROCA Ø4,8x25 '),(334,6,2,'HEC0643','PUNTABROCA Ø4,8x38 '),(339,6,2,'HEC0644','ROSCACHAPA CABEZA EXTRAPLANA Ø4,2x22 '),(340,6,2,'HEC0645','ROSCACHAPA CABEZA CILINDRICA Ø4,2x16 '),(341,6,2,'HEC0646','TIRAFONDO ROSCAMADERA Ø3x16 '),(342,6,2,'HEC0647','TIRAFONDO ROSCAMADERA Ø3x20 '),(343,6,2,'HEC0648','TIRAFONDO ROSCAMADERA Ø3x25 '),(344,6,2,'HEC0649','TIRAFONDO ROSCAMADERA Ø4x16 '),(345,6,2,'HEC0650','TIRAFONDO ROSCAMADERA Ø4x20 '),(346,6,2,'HEC0651','TIRAFONDO ROSCAMADERA Ø4x25 '),(347,6,2,'HEC0652','TIRAFONDO ROSCAMADERA Ø5x30 '),(348,6,2,'HEC0653','TIRAFONDO ROSCAMADERA Ø5x40 '),(349,6,2,'HEC0654','TIRAFONDO ROSCAMADERA Ø5x50 '),(350,6,2,'HEC0655','TIRAFONDO ROSCAMADERA Ø5x60 '),(351,13,2,'HEC0656','TIRAFONDO ROSCAMADERA Ø4,5x25 '),(352,13,2,'HEC0657','TIRAFONDO ROSCAMADERA Ø4,5x40 '),(353,24,2,'HEC0670','TACOLIT '),(354,24,2,'HEC0671','SICA '),(355,24,2,'HEC0672','ADHESIVO MS POLIMERO '),(360,23,2,'HEC0673','SILICONA TRANSPARENTE '),(361,7,2,'HEC0680','CERRADILLO PTA. DOBLE VIDRIO '),(362,6,2,'HEC0681','PESTILLO PUERTA DOBLE CIEGA CORTO 200mm '),(363,6,2,'HEC0682','PESTILLO PUERTA DOBLE CIEGA LARGO 500mm '),(364,7,2,'HEC0683','PESTILLO SOBREPONER PUERTA ENMARCADA VIDRIO ');
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

--
-- Dumping routines for database 'arquitectdb'
--
/*!50003 DROP FUNCTION IF EXISTS `fnUnidadCalculada` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `fnUnidadCalculada`(
 idUnidadCalculada int
) RETURNS varchar(100) CHARSET utf8
BEGIN
  
  DECLARE unidad nvarchar(100);
  
 SET unidad = "";
 
  IF idUnidadCalculada = 1 THEN 
    SET unidad = "LONGITUD";
  ELSEIF idUnidadCalculada = 2 THEN
    SET unidad = "UNIDAD";
  ELSEIF idUnidadCalculada = 3 THEN
    SET unidad = "CANTIDAD";
   ELSEIF idUnidadCalculada = 4 THEN
    SET unidad = "POR SU CANTIDAD";
  END IF;
  
 RETURN unidad;
 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `componenteDetalleCargar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `componenteDetalleCargar`(
idComponente int
)
BEGIN
   SELECT detalle.Id_Subcomponente,  
		   CONCAT(subcomponente.Codigo_Homologacion , "-" , acabados.Codigo_Homologacion) codigo,
		   subcomponente.Descripcion,
           subcomponente.Id_Unidad_Calculada,
           fnUnidadCalculada(subcomponente.Id_Unidad_Calculada) unidad,
		   Cantidad_Default ,
		   Cantidad_Adicional ,
		   Aplica_Decremento
	FROM arquitectdb.componentes_detalle detalle 
	JOIN arquitectdb.subcomponentes subcomponente ON detalle.Id_Subcomponente = subcomponente.Id_Subcomponente
	JOIN arquitectdb.acabados ON subcomponente.Id_Acabado = acabados.Id_Acabado
	WHERE Id_Componente = idComponente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `componentesConsultar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `componentesConsultar`(
  pCadena nvarchar(100)
)
BEGIN
    SELECT Id_Componente,Codigo,Descripcion 
    FROM arquitectdb.componentes
    WHERE CONCAT(Codigo , "-" , Descripcion) lIKE concat('%',  pCadena , '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spComponenteActualizar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spComponenteActualizar`(
 pCodigo nvarchar(50),
 pDescripcion nvarchar(300),
 pIdComponente int
)
BEGIN
   UPDATE arquitectdb.componentes SET codigo = pCodigo, 
                                       descripcion = pDescripcion
	WHERE Id_Componente = pIdComponente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spComponenteCargar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spComponenteCargar`(
 pidComponente Int,
 plogitud      Int,
 panchura      Int,
 paltura       Int ,
 parea         Int
)
BEGIN

    DECLARE idUnidadCalculada INT; 
    DECLARE cantidad DECIMAL;
	DECLARE aplicaDecremento BIT;
            
    SET @idUnidadCalculada = (SELECT id_Unidad_calculada FROM subcomponentes where id_subcomponente = pidComponente);
    
    IF (@idUnidadCalculada = 1) THEN 
    /* LOGITUD */   
    
       SET @aplicaDecremento = (SELECT aplica_decremento FROM subcomponentes where id_subcomponente = pidComponente);
       
       IF  (@aplicaDecremento = 0) THEN 
	     SET @medida = (SELECT cantidad_adicional FROM subcomponentes where id_subcomponente = pidComponente) + plogitud;
       ELSE 
	     SET @medida = (SELECT cantidad_adicional FROM subcomponentes where id_subcomponente = pidComponente) - plogitud;
       END IF;
       
      SELECT id_subcomponente,
	         codigo_homologacion codigo,
             descripcion,
             Cantidad_defaultd cantidad, 
             @medida medida
      FROM  subcomponentes where id_subcomponente = pidComponente;
 
    ELSEIF (@idUnidadCalculada = 2) THEN 
    /* UNIDAD */   
     SET @cantidad = plogitud/1000;
     
         SELECT  id_subcomponente,
	              codigo_homologacion codigo,
                  descripcion,
				  CEILING(@cantidad) cantidad, 
                  plogitud 
		 FROM subcomponentes where id_subcomponente = pidComponente;
   ELSE
		SELECT  id_subcomponente,
	              codigo_homologacion codigo,
                  descripcion,
				  Cantidad_defaultd, 
                  plogitud 
		 FROM subcomponentes where id_subcomponente = pidComponente;
    END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spComponentePerfilesCargar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spComponentePerfilesCargar`(
 pCodigo       nvarchar(50),
 plogitud      float
 
)
BEGIN

  
   
    DECLARE idUnidadCalculada INT; 
	DECLARE aplicaDecremento BIT;
    DECLARE idSubComponente Int;
    DECLARE count INT;
    DECLARE contador INT default 0;
    DECLARE medida float;
    DECLARE cantidad_U Int;
    
    SET SQL_SAFE_UPDATES = 0;
    
	CREATE TEMPORARY TABLE tableResult (id_subcomponente Int, 
                                        codigo nvarchar(10), 
                                        descripcion nvarchar(45),
                                        cantidad Int,
                                        medida nvarchar(10));
                                        
    CREATE TEMPORARY TABLE tbSubcomponente (idSubcomponente Int);
    INSERT tbSubcomponente (idSubcomponente)
	SELECT Id_Subcomponente FROM  componentes_detalle 
    JOIN componentes ON componentes_detalle.Id_componente = componentes.Id_componente
    WHERE componentes.Codigo = pCodigo;
    
    SET count = (SELECT count(*) FROM tbSubcomponente);

    WHILE contador < count DO
    
	SET idSubComponente = (SELECT * FROM tbSubcomponente order by idSubcomponente LIMIT contador,1);
    
    SET idUnidadCalculada = (SELECT id_Unidad_calculada FROM subcomponentes where id_subcomponente = idSubComponente);
    
    IF (idUnidadCalculada = 1) THEN 
    
       SET aplicaDecremento = (SELECT aplica_decremento FROM componentes_detalle
								JOIN componentes ON componentes_detalle.Id_componente = componentes.Id_componente
                                WHERE id_subcomponente = idSubComponente AND codigo = pCodigo);
       
       IF  (aplicaDecremento = 0) THEN 
       
	     SET medida = plogitud + (SELECT cantidad_adicional FROM componentes_detalle 
                                     JOIN componentes ON componentes_detalle.Id_componente = componentes.Id_componente
                                    WHERE id_subcomponente = idSubComponente AND codigo = pCodigo);
       ELSE 
	     SET medida = plogitud - (SELECT cantidad_adicional FROM componentes_detalle 
                                    JOIN componentes ON componentes_detalle.Id_componente = componentes.Id_componente
									WHERE id_subcomponente = idSubComponente AND codigo = pCodigo);
       END IF;
       

      INSERT tableResult 
      SELECT subcomponentes.id_subcomponente,
	          CONCAT(subcomponentes.codigo_homologacion,"-",acabados.codigo_homologacion) codigo,
             subcomponentes.descripcion,
             Cantidad_default AS cantidad, 
			 CEILING(medida * Cantidad_default) AS medida
     FROM componentes_detalle JOIN subcomponentes ON componentes_detalle.id_subcomponente = subcomponentes.id_subcomponente
     JOIN componentes ON componentes.Id_Componente = componentes_detalle.Id_Componente
	 JOIN acabados ON acabados.Id_Acabado = subcomponentes.Id_Acabado
	 WHERE subcomponentes.id_subcomponente = idSubComponente 
     AND componentes.codigo = pCodigo;
    
    ELSEIF (idUnidadCalculada = 2) THEN 
 
         INSERT tableResult 
         SELECT  subcomponentes.id_subcomponente,
				 CONCAT(subcomponentes.codigo_homologacion,"-",acabados.codigo_homologacion) codigo,
				 subcomponentes.descripcion,
				 CEILING((plogitud * cantidad_default)/1000) AS cantidad, 
				 "" AS medida
		FROM componentes_detalle JOIN subcomponentes ON componentes_detalle.id_subcomponente = subcomponentes.id_subcomponente
		JOIN componentes ON componentes.Id_Componente = componentes_detalle.Id_Componente
        JOIN acabados ON acabados.Id_Acabado = subcomponentes.Id_Acabado
		WHERE subcomponentes.id_subcomponente = idSubComponente 
		AND componentes.codigo = pCodigo;
        
	ELSEIF (idUnidadCalculada = 3) THEN 
    
		 INSERT tableResult 
         SELECT  subcomponentes.id_subcomponente,
				CONCAT(subcomponentes.codigo_homologacion,"-",acabados.codigo_homologacion) codigo,
				 subcomponentes.descripcion,
				 cantidad_default AS cantidad, 
				 "" AS medida
		FROM componentes_detalle JOIN subcomponentes ON componentes_detalle.id_subcomponente = subcomponentes.id_subcomponente
		JOIN componentes ON componentes.Id_Componente = componentes_detalle.Id_Componente
         JOIN acabados ON acabados.Id_Acabado = subcomponentes.Id_Acabado
		WHERE subcomponentes.id_subcomponente = idSubComponente 
		AND componentes.codigo = pCodigo;
        
	ELSEIF (idUnidadCalculada = 4) THEN 
    
	 CREATE TEMPORARY TABLE tbCantidad (idSubcomponente Int, cantidad int);
		INSERT tbCantidad (idSubcomponente, cantidad)
		SELECT  Id_Subcomponente, cantidad_default 
          FROM  componentes_detalle JOIN componentes ON componentes_detalle.Id_componente = componentes.Id_componente
		  WHERE componentes.Codigo = pCodigo;
          
		 SET cantidad_U = (SELECT sum(cantidad) FROM tbCantidad WHERE tbCantidad.idSubcomponente = idSubComponente);
         
		 INSERT tableResult 
         SELECT DISTINCT  subcomponentes.id_subcomponente,
				          CONCAT(subcomponentes.codigo_homologacion,"-",acabados.codigo_homologacion) codigo,
				          subcomponentes.descripcion,
						  cantidad_U AS cantidad, 
				          "" AS medida
		FROM componentes_detalle JOIN subcomponentes ON componentes_detalle.id_subcomponente = subcomponentes.id_subcomponente
		JOIN componentes ON componentes.Id_Componente = componentes_detalle.Id_Componente
         JOIN acabados ON acabados.Id_Acabado = subcomponentes.Id_Acabado
		WHERE subcomponentes.id_subcomponente = idSubComponente 
		AND componentes.codigo = pCodigo;
        
         DELETE FROM tbSubcomponente WHERE tbSubcomponente.idSubcomponente = idSubComponente;
         SET count = count - (SELECT count(*) FROM tbCantidad WHERE idSubcomponente = idSubComponente);
         DROP TABLE tbCantidad;
    END IF; 
    
    SET contador = contador + 1;
    
 END WHILE;  
 
   SELECT * 
	FROM tableResult;
   
   DROP TABLE tableResult;
   DROP TABLE tbSubcomponente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spSubComponenteAgrupar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spSubComponenteAgrupar`()
BEGIN
  SET SQL_SAFE_UPDATES = 0;
  
  SELECT proy.Id_Subcomponente,
		concat(subcomponente.codigo_homologacion, "-",acabado.codigo_homologacion ) codigo,
        subcomponente.Descripcion,
        (SELECT SUM(proyect.cantidad) FROM arquitectdb.proyecto proyect WHERE proyect.Id_Subcomponente = proy.Id_Subcomponente)  cantidad,
        (SELECT SUM(proyect.medida) FROM arquitectdb.proyecto proyect WHERE proyect.Id_Subcomponente = proy.Id_Subcomponente) medida
  FROM arquitectdb.proyecto proy 
  JOIN subcomponentes subcomponente ON proy.Id_Subcomponente = subcomponente.Id_Subcomponente
  JOIN acabados acabado ON acabado.Id_Acabado = subcomponente.Id_Acabado
  GROUP BY proy.Id_Subcomponente;
  DELETE FROM proyecto;
  
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spSubcomponenteCargar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spSubcomponenteCargar`(
 idSubComponente int
)
BEGIN
   SELECT subcomponente.Id_Acabado,
          subcomponente.Id_Unidad_Calculada,
          subcomponente.Codigo_Homologacion,
          subcomponente.Descripcion,
          acabado.Codigo_Homologacion codigo
   FROM subcomponentes subcomponente 
   JOIN acabados acabado ON acabado.Id_Acabado = subcomponente.Id_Acabado
   WHERE Id_Subcomponente = idSubComponente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spSubComponenteConsultar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spSubComponenteConsultar`(
 pCadena nvarchar(300)
)
BEGIN
   SELECT Id_subcomponente, 
          CONCAT(subcomponentes.Codigo_Homologacion , "-" , acabados.Codigo_Homologacion)  codigo,
          subcomponentes.Descripcion 
    FROM arquitectdb.subcomponentes JOIN arquitectdb.acabados 
    ON subcomponentes.Id_Acabado = acabados.Id_Acabado
    WHERE CONCAT(subcomponentes.Codigo_Homologacion,"-",subcomponentes.Descripcion)
    lIKE concat('%',  pCadena , '%');
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spSubComponenteRegistrar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spSubComponenteRegistrar`(
pId_Acabado int,
pCodigo nvarchar(10),
pDescripcion nvarchar(100),
pId_Unidad_Calculada int(11)
)
BEGIN
   INSERT subcomponentes (Id_Acabado,
                          Id_Unidad_Calculada,
                          Codigo_Homologacion,
                          Descripcion) VALUES (pId_Acabado,
                                                      pId_Unidad_Calculada,
                                                      pCodigo,
                                                      pDescripcion
                                                      );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `spSubcomponenteUpdate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `spSubcomponenteUpdate`(
 pIdAcabdo int, 
 pIdUnidadCalculada int,
 pCodigo nvarchar(50),
 pDescripcion  nvarchar(300),
 pIdComponente int
)
BEGIN
    UPDATE `arquitectdb`.`subcomponentes`
SET
	`Id_Acabado` =pIdAcabdo,
	`Id_Unidad_Calculada` = pIdUnidadCalculada,
	`Codigo_Homologacion` = pCodigo,
	`Descripcion` = pDescripcion
    WHERE `Id_Subcomponente` = pIdComponente;
    
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

-- Dump completed on 2021-01-25 10:28:20
