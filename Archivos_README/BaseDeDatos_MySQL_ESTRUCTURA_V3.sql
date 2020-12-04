-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: database-1.cjxw1f4bh3ms.us-east-1.rds.amazonaws.com    Database: Horarios_Tics_y_Laboratorios
-- ------------------------------------------------------
-- Server version	8.0.20

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `CODIGOS_SEGURIDAD`
--

DROP TABLE IF EXISTS `CODIGOS_SEGURIDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CODIGOS_SEGURIDAD` (
  `idCODIGOS_SEGURIDAD` int NOT NULL AUTO_INCREMENT,
  `codigo_seguridad` char(255) NOT NULL,
  `Fecha_de_creacion_codigo` datetime NOT NULL,
  `USUARIOINSTITUCIONAL` char(255) NOT NULL,
  `utilizado_codigo` tinyint NOT NULL,
  PRIMARY KEY (`idCODIGOS_SEGURIDAD`),
  KEY `FK_CODIGO_USUARIO_idx` (`USUARIOINSTITUCIONAL`),
  CONSTRAINT `FK_CODIGO_USUARIO` FOREIGN KEY (`USUARIOINSTITUCIONAL`) REFERENCES `USUARIOS` (`USUARIOINSTITUCIONAL`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DIAS_DE_SEMANA`
--

DROP TABLE IF EXISTS `DIAS_DE_SEMANA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DIAS_DE_SEMANA` (
  `ID_DIA` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_DIA` char(255) NOT NULL,
  PRIMARY KEY (`ID_DIA`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DIAS_DE_SEMANA_EVENTOS`
--

DROP TABLE IF EXISTS `DIAS_DE_SEMANA_EVENTOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DIAS_DE_SEMANA_EVENTOS` (
  `ID_DIA` int NOT NULL,
  `ID_EVENTO` int NOT NULL,
  PRIMARY KEY (`ID_DIA`,`ID_EVENTO`),
  KEY `FK_DIAS_DE_SEMANA_EVENTOS` (`ID_EVENTO`),
  CONSTRAINT `FK_DIAS_DE_SEMANA_EVENTOS` FOREIGN KEY (`ID_EVENTO`) REFERENCES `EVENTOS` (`ID_EVENTO`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_DIAS_DE_SEMANA_EVENTOS2` FOREIGN KEY (`ID_DIA`) REFERENCES `DIAS_DE_SEMANA` (`ID_DIA`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `EDIFICIOS`
--

DROP TABLE IF EXISTS `EDIFICIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EDIFICIOS` (
  `ID_EDIFICIO` int NOT NULL,
  `NOMBRE_EDIFICIOS` char(255) NOT NULL,
  PRIMARY KEY (`ID_EDIFICIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ESPACIOS`
--

DROP TABLE IF EXISTS `ESPACIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ESPACIOS` (
  `ID_ESPACIO` int NOT NULL AUTO_INCREMENT,
  `ID_EDIFICIO` int NOT NULL,
  `ID_TIPOESPACIO` int NOT NULL,
  `ID_PERSONA` int DEFAULT NULL,
  `NOMBRE_ESPACIO` char(255) DEFAULT NULL,
  `NUM_ESPACIO` char(255) NOT NULL,
  `ACTIVO` tinyint(1) NOT NULL,
  `CAPACIDAD` int NOT NULL,
  `VIVO` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID_ESPACIO`),
  KEY `FK_ESPACIO_TIPO_ESPACIO` (`ID_TIPOESPACIO`),
  KEY `FK_ESPACIOS_EDIFICIOS` (`ID_EDIFICIO`),
  KEY `FK_ESPACIOS_PERSONA_idx` (`ID_PERSONA`),
  CONSTRAINT `FK_ESPACIO_TIPO_ESPACIO` FOREIGN KEY (`ID_TIPOESPACIO`) REFERENCES `TIPO_ESPACIOS` (`ID_TIPOESPACIO`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ESPACIOS_EDIFICIOS` FOREIGN KEY (`ID_EDIFICIO`) REFERENCES `EDIFICIOS` (`ID_EDIFICIO`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_ESPACIOS_PERSONA` FOREIGN KEY (`ID_PERSONA`) REFERENCES `PERSONA` (`ID_PERSONA`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `ESPACIOS_BEFORE_UPDATE` BEFORE UPDATE ON `ESPACIOS` FOR EACH ROW BEGIN
	IF (old.ID_TIPOESPACIO)!=new.ID_TIPOESPACIO then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"ID_TIPOESPACIO", old.ID_TIPOESPACIO,old.ID_ESPACIO);
    end if;
    if old.ID_EDIFICIO!=new.ID_EDIFICIO then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"ID_EDIFICIO", old.ID_EDIFICIO,old.ID_ESPACIO);
    end if;
    if  old.ID_PERSONA!=new.ID_PERSONA  then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"ID_PERSONA", old.ID_PERSONA,old.ID_ESPACIO);
        if (select COUNT(*) FROM ESPACIOS where ID_PERSONA=old.ID_PERSONA and VIVO=1)=1 and old.VIVO=1 then
			UPDATE USUARIOS SET ID_TIPOUSUARIO=1 WHERE USUARIOINSTITUCIONAL=(SELECT USUARIOINSTITUCIONAL FROM PERSONA WHERE ID_PERSONA=old.ID_PERSONA);
            end if;
	end if;
    if  old.NOMBRE_ESPACIO!=new.NOMBRE_ESPACIO  then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"NOMBRE_ESPACIO", old.NOMBRE_ESPACIO,old.ID_ESPACIO);    
   end if;
   if  old.NUM_ESPACIO!=new.NUM_ESPACIO  then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"NUM_ESPACIO", old.NUM_ESPACIO,old.ID_ESPACIO);    
   end if;
   if  old.ACTIVO!=new.ACTIVO  then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"ACTIVO", old.ACTIVO,old.ID_ESPACIO);    
	end if;
    if  old.CAPACIDAD!=new.CAPACIDAD  then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"CAPACIDAD", old.CAPACIDAD,old.ID_ESPACIO);    
	end if;
    if  old.VIVO!=new.VIVO  then
		INSERT INTO MODIFICACIONES_ESPACIOS(FECHA_HORA_MODIFICACION_ESPACIO,USUARIO_MODIFICO_DESDE_BD,NOMBRE_ATRIBUTO_MODIFICADO,DATO_ANTIGUO_ESPACIO,ID_ESPACIO) VALUES (now(),CURRENT_USER(),"VIVO", old.VIVO,old.ID_ESPACIO);    
		 if (select COUNT(*) FROM ESPACIOS where ID_PERSONA=old.ID_PERSONA and VIVO=1)=1 then
			UPDATE USUARIOS SET ID_TIPOUSUARIO=1 WHERE USUARIOINSTITUCIONAL=(SELECT USUARIOINSTITUCIONAL FROM PERSONA WHERE ID_PERSONA=old.ID_PERSONA);
            end if;
  END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ESTADOS_SOLICITUD`
--

DROP TABLE IF EXISTS `ESTADOS_SOLICITUD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ESTADOS_SOLICITUD` (
  `ID_ESTADO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_ESTADO` char(255) NOT NULL,
  PRIMARY KEY (`ID_ESTADO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `EVENTOS`
--

DROP TABLE IF EXISTS `EVENTOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EVENTOS` (
  `ID_EVENTO` int NOT NULL AUTO_INCREMENT,
  `ID_REPETICION` int NOT NULL,
  `FECHA_EVENTO` date NOT NULL,
  `HORA_INICIOEVENTO` time NOT NULL,
  `HORA_FINALEVENTO` time NOT NULL,
  `FECHA_TERMINA` date DEFAULT NULL,
  `OBSERVACIONES` char(255) DEFAULT NULL,
  `ID_MOTIVO` int NOT NULL,
  PRIMARY KEY (`ID_EVENTO`),
  KEY `FK_TIPO_REPETICION_EVENTOS` (`ID_REPETICION`),
  KEY `FK_MOTIVOS_EVENTOS` (`ID_MOTIVO`),
  CONSTRAINT `FK_MOTIVOS_EVENTOS` FOREIGN KEY (`ID_MOTIVO`) REFERENCES `MOTIVOS_EVENTOS` (`ID_MOTIVO`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TIPO_REPETICION_EVENTOS` FOREIGN KEY (`ID_REPETICION`) REFERENCES `TIPODEREPETICION` (`ID_REPETICION`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `INVENTARIOS`
--

DROP TABLE IF EXISTS `INVENTARIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `INVENTARIOS` (
  `ID_INVENTARIO` int NOT NULL AUTO_INCREMENT,
  `ID_ESPACIO` int NOT NULL,
  `NOMBREATRIBUTO` char(255) NOT NULL,
  `DESCRIPCION` longtext,
  `VIVO_INV` tinyint NOT NULL,
  PRIMARY KEY (`ID_INVENTARIO`),
  KEY `FK_ESPACIOS_INVENTARIOS` (`ID_ESPACIO`),
  CONSTRAINT `FK_ESPACIOS_INVENTARIOS` FOREIGN KEY (`ID_ESPACIO`) REFERENCES `ESPACIOS` (`ID_ESPACIO`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `INVENTARIOS_AFTER_UPDATE` AFTER UPDATE ON `INVENTARIOS` FOR EACH ROW BEGIN
	IF (old.ID_ESPACIO)!=new.ID_ESPACIO then
		INSERT INTO MODIFICACIONES_INVENTARIOS(FECHA_HORA_MODIFICACION_INVENTARIO,USUARIO_MODIFICO_DESDEBD_INV,NOMBRE_ATRIBUTO_MODIFICADO_INV,DATO_ANTIGUO_INV,ID_INVENTARIO) VALUES (now(),CURRENT_USER(),"ID_ESPACIO", old.ID_ESPACIO,old.ID_INVENTARIO);
    end if;
    IF (old.NOMBREATRIBUTO)!=new.NOMBREATRIBUTO then
		INSERT INTO MODIFICACIONES_INVENTARIOS(FECHA_HORA_MODIFICACION_INVENTARIO,USUARIO_MODIFICO_DESDEBD_INV,NOMBRE_ATRIBUTO_MODIFICADO_INV,DATO_ANTIGUO_INV,ID_INVENTARIO) VALUES (now(),CURRENT_USER(),"NOMBREATRIBUTO", old.NOMBREATRIBUTO,old.ID_INVENTARIO);
    end if;
    IF (old.DESCRIPCION)!=new.DESCRIPCION then
		INSERT INTO MODIFICACIONES_INVENTARIOS(FECHA_HORA_MODIFICACION_INVENTARIO,USUARIO_MODIFICO_DESDEBD_INV,NOMBRE_ATRIBUTO_MODIFICADO_INV,DATO_ANTIGUO_INV,ID_INVENTARIO) VALUES (now(),CURRENT_USER(),"DESCRIPCION", old.DESCRIPCION,old.ID_INVENTARIO);
     end if;
     IF (old.VIVO_INV)!=new.VIVO_INV then
		INSERT INTO MODIFICACIONES_INVENTARIOS(FECHA_HORA_MODIFICACION_INVENTARIO,USUARIO_MODIFICO_DESDEBD_INV,NOMBRE_ATRIBUTO_MODIFICADO_INV,DATO_ANTIGUO_INV,ID_INVENTARIO) VALUES (now(),CURRENT_USER(),"VIVO_INV", old.VIVO_INV,old.ID_INVENTARIO);
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `MODIFICACIONES_ESPACIOS`
--

DROP TABLE IF EXISTS `MODIFICACIONES_ESPACIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MODIFICACIONES_ESPACIOS` (
  `ID_MODIFICACIONES_ESPACIOS` int NOT NULL AUTO_INCREMENT,
  `FECHA_HORA_MODIFICACION_ESPACIO` datetime NOT NULL,
  `NOMBRE_ATRIBUTO_MODIFICADO` char(255) NOT NULL,
  `USUARIO_MODIFICO_DESDE_BD` char(255) NOT NULL,
  `DATO_ANTIGUO_ESPACIO` char(255) NOT NULL,
  `ID_ESPACIO` int NOT NULL,
  PRIMARY KEY (`ID_MODIFICACIONES_ESPACIOS`),
  KEY `FK_ESPACIO_MODIFICACIONES_idx` (`ID_ESPACIO`),
  CONSTRAINT `FK_ESPACIO_MODIFICACIONES` FOREIGN KEY (`ID_ESPACIO`) REFERENCES `ESPACIOS` (`ID_ESPACIO`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MODIFICACIONES_INVENTARIOS`
--

DROP TABLE IF EXISTS `MODIFICACIONES_INVENTARIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MODIFICACIONES_INVENTARIOS` (
  `ID_MODIFICACION_INVENTARIO` int NOT NULL AUTO_INCREMENT,
  `FECHA_HORA_MODIFICACION_INVENTARIO` datetime NOT NULL,
  `ID_INVENTARIO` int NOT NULL,
  `NOMBRE_ATRIBUTO_MODIFICADO_INV` char(255) NOT NULL,
  `USUARIO_MODIFICO_DESDEBD_INV` char(255) NOT NULL,
  `DATO_ANTIGUO_INV` varchar(500) NOT NULL,
  PRIMARY KEY (`ID_MODIFICACION_INVENTARIO`),
  KEY `FK_MODIF_INV_idx` (`ID_INVENTARIO`),
  CONSTRAINT `FK_MODIF_INV` FOREIGN KEY (`ID_INVENTARIO`) REFERENCES `INVENTARIOS` (`ID_INVENTARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MODIFICACIONES_SOLICITUDES`
--

DROP TABLE IF EXISTS `MODIFICACIONES_SOLICITUDES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MODIFICACIONES_SOLICITUDES` (
  `ID_MODIFICACION_SOLICITUD` int NOT NULL AUTO_INCREMENT,
  `FECHA_HORA_MODIFICACION_SOLICITUD` datetime NOT NULL,
  `USUARIO_MODIFICIO_DESDEBD_SOL` char(255) NOT NULL,
  `NOMBRE_ATRIBUTO_MODIFICADO_SOL` char(255) NOT NULL,
  `DATO_ANTIGUO_SOLICITUD` char(255) NOT NULL,
  `ID_SOLICITUD` int NOT NULL,
  PRIMARY KEY (`ID_MODIFICACION_SOLICITUD`),
  KEY `FK_SOLICITUD_MODIFICACION_idx` (`ID_SOLICITUD`),
  CONSTRAINT `FK_SOLICITUD_MODIFICACION` FOREIGN KEY (`ID_SOLICITUD`) REFERENCES `SOLICITUDES` (`ID_SOLICITUD`)
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MODIFICACIONES_USUARIOS`
--

DROP TABLE IF EXISTS `MODIFICACIONES_USUARIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MODIFICACIONES_USUARIOS` (
  `ID_MODIFICACIONES_USUARIOS` int NOT NULL AUTO_INCREMENT,
  `FECHA_HORA_DE_MODIFICACION_USUARIO` datetime NOT NULL,
  `USUARIOINSTITUCIONAL` char(255) NOT NULL,
  `NOMBRE_ATRIBUTO_MODIFICADO_USUARIO` char(255) NOT NULL,
  `USUARIO_MODIFICO_DESDEBD` char(255) NOT NULL,
  `DATO_ANTIGUO_USUARIO` char(255) NOT NULL,
  PRIMARY KEY (`ID_MODIFICACIONES_USUARIOS`),
  KEY `FK_MOD_USUARIOS_idx` (`USUARIOINSTITUCIONAL`),
  CONSTRAINT `FK_MODIF_USUARIOS` FOREIGN KEY (`USUARIOINSTITUCIONAL`) REFERENCES `USUARIOS` (`USUARIOINSTITUCIONAL`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MOTIVOS_EVENTOS`
--

DROP TABLE IF EXISTS `MOTIVOS_EVENTOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MOTIVOS_EVENTOS` (
  `ID_MOTIVO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_MOTIVO` char(255) NOT NULL,
  PRIMARY KEY (`ID_MOTIVO`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PERSONA`
--

DROP TABLE IF EXISTS `PERSONA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PERSONA` (
  `ID_PERSONA` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_PERSONA` char(255) NOT NULL,
  `USUARIOINSTITUCIONAL` char(255) NOT NULL,
  PRIMARY KEY (`ID_PERSONA`,`USUARIOINSTITUCIONAL`),
  KEY `FK_USUARIO_PERSONA_idx` (`USUARIOINSTITUCIONAL`),
  CONSTRAINT `FK_USUARIO_PERSONA` FOREIGN KEY (`USUARIOINSTITUCIONAL`) REFERENCES `USUARIOS` (`USUARIOINSTITUCIONAL`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `SOLICITUDES`
--

DROP TABLE IF EXISTS `SOLICITUDES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SOLICITUDES` (
  `ID_SOLICITUD` int NOT NULL AUTO_INCREMENT,
  `ID_ESTADO` int NOT NULL,
  `USUARIOINSTITUCIONAL` char(255) NOT NULL,
  `ID_EVENTO` int NOT NULL,
  `ID_ESPACIO` int NOT NULL,
  `FECHA_SOLICITUD` date NOT NULL,
  `OBSERVACIONES_SOLICITUD` char(255) DEFAULT NULL,
  `FECHA_MODIFICACION` date DEFAULT NULL,
  `USUARIO_MODIFICO` char(255) DEFAULT NULL,
  PRIMARY KEY (`ID_SOLICITUD`),
  KEY `FK_EVENTOS_SOLICITUDES` (`ID_EVENTO`),
  KEY `FK_SOLICITUDES_ESPACIO` (`ID_ESPACIO`),
  KEY `FK_SOLICITUDES_ESTADOS_SOLICITUD` (`ID_ESTADO`),
  KEY `FK_USUARIOS_SOLICITUDES` (`USUARIOINSTITUCIONAL`),
  CONSTRAINT `FK_EVENTOS_SOLICITUDES` FOREIGN KEY (`ID_EVENTO`) REFERENCES `EVENTOS` (`ID_EVENTO`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_SOLICITUDES_ESPACIO` FOREIGN KEY (`ID_ESPACIO`) REFERENCES `ESPACIOS` (`ID_ESPACIO`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_SOLICITUDES_ESTADOS_SOLICITUD` FOREIGN KEY (`ID_ESTADO`) REFERENCES `ESTADOS_SOLICITUD` (`ID_ESTADO`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_USUARIOS_SOLICITUDES` FOREIGN KEY (`USUARIOINSTITUCIONAL`) REFERENCES `USUARIOS` (`USUARIOINSTITUCIONAL`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `SOLICITUDES_BEFORE_UPDATE` BEFORE UPDATE ON `SOLICITUDES` FOR EACH ROW BEGIN
	IF (old.ID_SOLICITUD)!=new.ID_SOLICITUD then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"ID_SOLICITUD", old.ID_SOLICITUD,old.ID_SOLICITUD);
    end if;
    if old.ID_ESTADO!=new.ID_ESTADO then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"ID_ESTADO", old.ID_ESTADO,old.ID_SOLICITUD);
    end if;
    if old.USUARIOINSTITUCIONAL!=new.USUARIOINSTITUCIONAL then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"USUARIOINSTITUCIONAL", old.USUARIOINSTITUCIONAL,old.ID_SOLICITUD);
   end if;
   if old.ID_EVENTO!=new.ID_EVENTO then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"ID_EVENTO", old.ID_EVENTO,old.ID_SOLICITUD);
   end if;
   if old.ID_ESPACIO!=new.ID_ESPACIO then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"ID_ESPACIO", old.ID_ESPACIO,old.ID_SOLICITUD);
   end if;
   if old.FECHA_SOLICITUD!=new.FECHA_SOLICITUD then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"FECHA_SOLICITUD", old.FECHA_SOLICITUD,old.ID_SOLICITUD);
   end if;
   if old.OBSERVACIONES_SOLICITUD!=new.OBSERVACIONES_SOLICITUD then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"OBSERVACIONES_SOLICITUD", old.OBSERVACIONES_SOLICITUD,old.ID_SOLICITUD);
   end if;
   if old.FECHA_MODIFICACION!=new.FECHA_MODIFICACION then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"FECHA_MODIFICACION", old.FECHA_MODIFICACION,old.ID_SOLICITUD);
   end if;
   if old.USUARIO_MODIFICO!=new.USUARIO_MODIFICO then
		INSERT INTO MODIFICACIONES_SOLICITUDES(FECHA_HORA_MODIFICACION_SOLICITUD,USUARIO_MODIFICIO_DESDEBD_SOL,NOMBRE_ATRIBUTO_MODIFICADO_SOL,DATO_ANTIGUO_SOLICITUD,ID_SOLICITUD) VALUES (now(),CURRENT_USER(),"USUARIO_MODIFICO", old.USUARIO_MODIFICO,old.ID_SOLICITUD);
	end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `TIPODEREPETICION`
--

DROP TABLE IF EXISTS `TIPODEREPETICION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIPODEREPETICION` (
  `ID_REPETICION` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_REPETICION` char(255) NOT NULL,
  PRIMARY KEY (`ID_REPETICION`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TIPOUSUARIO`
--

DROP TABLE IF EXISTS `TIPOUSUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIPOUSUARIO` (
  `ID_TIPOUSUARIO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_TIPOUSUARIO` char(255) NOT NULL,
  PRIMARY KEY (`ID_TIPOUSUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TIPO_ESPACIOS`
--

DROP TABLE IF EXISTS `TIPO_ESPACIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIPO_ESPACIOS` (
  `ID_TIPOESPACIO` int NOT NULL AUTO_INCREMENT,
  `NOMBRE_TIPOESPACIO` char(255) NOT NULL,
  PRIMARY KEY (`ID_TIPOESPACIO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `USUARIOS`
--

DROP TABLE IF EXISTS `USUARIOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USUARIOS` (
  `ID_TIPOUSUARIO` int NOT NULL,
  `USUARIOINSTITUCIONAL` char(255) NOT NULL,
  `CONTRASENIA` char(255) NOT NULL,
  PRIMARY KEY (`USUARIOINSTITUCIONAL`),
  UNIQUE KEY `USUARIOINSTITUCIONAL_UNIQUE` (`USUARIOINSTITUCIONAL`),
  KEY `FK_RELATIONSHIP_1` (`ID_TIPOUSUARIO`),
  CONSTRAINT `FK_RELATIONSHIP_1` FOREIGN KEY (`ID_TIPOUSUARIO`) REFERENCES `TIPOUSUARIO` (`ID_TIPOUSUARIO`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`admin`@`%`*/ /*!50003 TRIGGER `USUARIOS_BEFORE_UPDATE` BEFORE UPDATE ON `USUARIOS` FOR EACH ROW BEGIN
	
	IF(old.ID_TIPOUSUARIO!=5) then
    IF (old.USUARIOINSTITUCIONAL)!=new.USUARIOINSTITUCIONAL then
	INSERT INTO MODIFICACIONES_USUARIOS(FECHA_HORA_DE_MODIFICACION_USUARIO,USUARIO_MODIFICO_DESDEBD,NOMBRE_ATRIBUTO_MODIFICADO_USUARIO,DATO_ANTIGUO_USUARIO,USUARIOINSTITUCIONAL) VALUES (now(),CURRENT_USER(),"USUARIOINSTITUCIONAL", old.USUARIOINSTITUCIONAL,old.USUARIOINSTITUCIONAL);
	end if;	 
	IF (old.CONTRASENIA)!=new.CONTRASENIA then
	INSERT INTO MODIFICACIONES_USUARIOS(FECHA_HORA_DE_MODIFICACION_USUARIO,USUARIO_MODIFICO_DESDEBD,NOMBRE_ATRIBUTO_MODIFICADO_USUARIO,DATO_ANTIGUO_USUARIO,USUARIOINSTITUCIONAL) VALUES (now(),CURRENT_USER(),"CONTRASENIA", old.CONTRASENIA,old.USUARIOINSTITUCIONAL);
	end if;	
	IF (old.ID_TIPOUSUARIO)!=new.ID_TIPOUSUARIO then
	INSERT INTO MODIFICACIONES_USUARIOS(FECHA_HORA_DE_MODIFICACION_USUARIO,USUARIO_MODIFICO_DESDEBD,NOMBRE_ATRIBUTO_MODIFICADO_USUARIO,DATO_ANTIGUO_USUARIO,USUARIOINSTITUCIONAL) VALUES (now(),CURRENT_USER(),"ID_TIPOUSUARIO", old.ID_TIPOUSUARIO,old.USUARIOINSTITUCIONAL);
	end if;        
 end if; 
   
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'Horarios_Tics_y_Laboratorios'
--

--
-- Dumping routines for database 'Horarios_Tics_y_Laboratorios'
--
/*!50003 DROP FUNCTION IF EXISTS `ActualizarEdf` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` FUNCTION `ActualizarEdf`(nedf int, nombedf char(255)) RETURNS int
BEGIN
	DECLARE resul int;
	
		IF(SELECT ID_EDIFICIO FROM EDIFICIOS WHERE ID_EDIFICIO=nedf)=nedf THEN		
                IF nombedf = ('') THEN
				SET resul=nedf;
				ELSE 
						update EDIFICIOS set nombre_edificios = nombedf where ID_EDIFICIO=nedf;
						SET resul=nedf;
				END IF;   
			ELSE
				IF nombedf = ('') THEN
						INSERT INTO EDIFICIOS(ID_EDIFICIO,nombre_edificios) VALUES (nedf,nedf);                        
						SET resul=nedf;
				ELSE 
						INSERT INTO EDIFICIOS(ID_EDIFICIO,nombre_edificios) VALUES (nedf,nombedf);                         
						SET resul=nedf;
				END IF;
			END IF;  	
		
RETURN resul;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `ActualizarEnc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` FUNCTION `ActualizarEnc`(persona char(255),  nper char(255)) RETURNS int
BEGIN
	DECLARE resul int;
    IF(SELECT ID_TIPOUSUARIO FROM USUARIOS WHERE USUARIOINSTITUCIONAL=persona)=1 OR (SELECT ID_TIPOUSUARIO FROM USUARIOS WHERE USUARIOINSTITUCIONAL=persona)=4 Then
	IF(SELECT USUARIOINSTITUCIONAL FROM USUARIOS WHERE USUARIOINSTITUCIONAL=persona)=persona THEN
		IF(SELECT USUARIOINSTITUCIONAL FROM PERSONA WHERE USUARIOINSTITUCIONAL=persona)=persona THEN		
                IF nper = ('') THEN
				SET resul=(SELECT ID_PERSONA FROM PERSONA WHERE USUARIOINSTITUCIONAL=persona);
                      update USUARIOS set ID_TIPOUSUARIO = 4 where USUARIOINSTITUCIONAL=persona;
				ELSE 
					    update USUARIOS set ID_TIPOUSUARIO = 4 where USUARIOINSTITUCIONAL=persona;
						update PERSONA set NOMBRE_PERSONA = nper where USUARIOINSTITUCIONAL=persona;
						SET resul=(SELECT ID_PERSONA FROM PERSONA WHERE USUARIOINSTITUCIONAL=persona);
				END IF;   
			ELSE
				IF nper = ('') THEN
						INSERT INTO PERSONA(NOMBRE_PERSONA,USUARIOINSTITUCIONAL) VALUES (persona,persona);
                        update USUARIOS set ID_TIPOUSUARIO = 4 where USUARIOINSTITUCIONAL=persona;
						SET resul=(SELECT ID_PERSONA FROM PERSONA WHERE USUARIOINSTITUCIONAL=persona);
				ELSE 
						INSERT INTO PERSONA(NOMBRE_PERSONA,USUARIOINSTITUCIONAL) VALUES (nper,persona);
                        update USUARIOS set ID_TIPOUSUARIO = 4 where USUARIOINSTITUCIONAL=persona;
						SET resul=(SELECT ID_PERSONA FROM PERSONA WHERE USUARIOINSTITUCIONAL=persona);
				END IF;
			END IF;  	
		 ELSE SET resul=-1;
		 END IF; 
	 ELSE SET resul=-3;
    END IF;
RETURN resul;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `actualizarEspacio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` FUNCTION `actualizarEspacio`(usuario char(255), id int, tipE int, nesp char (255), salon char(255), nedf int, nombedf char(255), persona char(255),  nper char(255), estado boolean, cap int) RETURNS int
BEGIN
	DECLARE resul int;
    DECLARE idPer int;

    IF(SELECT ID_TIPOUSUARIO FROM USUARIOS WHERE USUARIOINSTITUCIONAL=usuario)=2 THEN
		if (SELECT ID_TIPOESPACIO,ID_EDIFICIO,NUM_ESPACIO,VIVO FROM ESPACIOS where ID_TIPOESPACIO=tipE and ID_EDIFICIO=nedf and  NUM_ESPACIO= salon and VIVO=1)=(tipE, nedf,salon,1) then
					if (SELECT ID_TIPOESPACIO,ID_EDIFICIO,NUM_ESPACIO,VIVO  FROM ESPACIOS WHERE ID_ESPACIO=id )=(tipE, nedf,salon,1) then
						IF(SELECT VIVO FROM ESPACIOS where ID_ESPACIO=id)=1 THEN
							set idPer=(ActualizarEnc(persona,nper));
							if idPer>0 then
							SET nedf= (ActualizarEdf(nedf, nombedf));
							update ESPACIOS set ID_PERSONA=idPer, NOMBRE_ESPACIO=nesp, ACTIVO=estado, CAPACIDAD=cap where ID_ESPACIO=id;
							SET resul=1;
							ELSE SET resul=-3;
							END IF;
						ELSE 	
						SET resul=-9;
						END IF; 
                    ELSE SET resul=-2;						
					END IF; 	                   
		 ELSE 	
				
					IF id < 0 then
						set idPer=(ActualizarEnc(persona,nper));
						if idPer>0  then
						SET nedf= (ActualizarEdf(nedf, nombedf));
						INSERT INTO ESPACIOS(ID_EDIFICIO,ID_TIPOESPACIO,ID_PERSONA,NOMBRE_ESPACIO,NUM_ESPACIO,ACTIVO,CAPACIDAD,VIVO) VALUES (nedf,tipE,idPer,nesp,salon,estado,cap,1);
                             SET resul=(SELECT ID_ESPACIO FROM ESPACIOS WHERE ID_EDIFICIO=nedf AND ID_TIPOESPACIO=tipE and NUM_ESPACIO=salon and VIVO=1);
						ELSE 	
							SET resul=-3;
						END IF;  
				   ELSE 
                     IF(SELECT VIVO FROM ESPACIOS where ID_ESPACIO=id)=1 THEN
						set idPer=(ActualizarEnc(persona,nper));
						if idPer>0  then
						SET nedf= (ActualizarEdf(nedf, nombedf));
								update ESPACIOS set ID_EDIFICIO = nedf, ID_PERSONA=idPer, NOMBRE_ESPACIO=nesp,NUM_ESPACIO=salon, ACTIVO=estado, CAPACIDAD=cap where ID_ESPACIO=id;
								SET resul=1;
						ELSE 	
						SET resul=-3;
						END IF; 
					ELSE 	
					SET resul=-9;
					END IF; 
				END IF; 
		END IF;
	 ELSE 
		SET resul=-1;
     END IF;  
	
RETURN resul;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `cambiar_estado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` FUNCTION `cambiar_estado`(usuario char(255), idSol int, tipE int, obs char(255)) RETURNS int
BEGIN
	DECLARE resul int;
    DECLARE idEspacio int;
    DECLARE horaInicio time;
    DECLARE horaFinal time;
    DECLARE tipoRepeticion int;
    DECLARE fechainEvento date;
	DECLARE fechaterEvento date;
	DECLARE dias varchar(10);
    DECLARE tipEA int;
		
	set tipEA=(SELECT ID_ESTADO FROM SOLICITUDES WHERE ID_SOLICITUD=idSol);
		IF tipE=tipEA then
			 set resul=-5;
        ELSEIF tipE=3 AND tipEA=1 then
			 set resul=-5;
        ELSEIF tipE=4 AND tipEA=3 then
			 set resul=-5;
		ELSEIF tipE=1 AND tipEA=4 then
			 set resul=-5;
		ELSEIF tipE=3 AND tipEA=4 then
			 set resul=-5;
        ELSEIF tipE=1 and (SELECT ID_TIPOUSUARIO FROM USUARIOS WHERE USUARIOINSTITUCIONAL=usuario)=2 then
				SET horaInicio=(select HORA_INICIOEVENTO FROM SOLICITUDES AS sol, EVENTOS as eve WHERE eve.ID_EVENTO=sol.ID_EVENTO  AND sol.ID_SOLICITUD=idSol);
				SET horaFinal=(select HORA_FINALEVENTO FROM SOLICITUDES AS sol, EVENTOS as eve WHERE eve.ID_EVENTO=sol.ID_EVENTO  AND sol.ID_SOLICITUD=idSol);
				SET fechainEvento=(select FECHA_EVENTO FROM SOLICITUDES AS sol, EVENTOS as eve WHERE eve.ID_EVENTO=sol.ID_EVENTO  AND sol.ID_SOLICITUD=idSol);
				SET fechaterEvento=(select FECHA_TERMINA FROM SOLICITUDES AS sol, EVENTOS as eve WHERE eve.ID_EVENTO=sol.ID_EVENTO  AND sol.ID_SOLICITUD=idSol);
				SET tipoRepeticion=(select ID_REPETICION FROM SOLICITUDES AS sol, EVENTOS as eve WHERE eve.ID_EVENTO=sol.ID_EVENTO  AND sol.ID_SOLICITUD=idSol);
                SET idEspacio=(select ID_ESPACIO FROM SOLICITUDES WHERE ID_SOLICITUD=idSol);
                set dias=(select dias_del_evento(idSol));
                IF (select compararEventos(idEspacio,horaInicio,horaFinal,tipoRepeticion,fechainEvento,fechaterEvento,dias)) then
				update SOLICITUDES set ID_ESTADO = tipE, OBSERVACIONES_SOLICITUD=obs , FECHA_MODIFICACION=curdate(), USUARIO_MODIFICO=usuario where ID_SOLICITUD=idSol;
				set resul=1;
                else
                set resul=-6;
                end if;
      	elseif tipE=3  and (SELECT ID_TIPOUSUARIO FROM USUARIOS WHERE USUARIOINSTITUCIONAL=usuario)=2 then
				update SOLICITUDES set ID_ESTADO = tipE, OBSERVACIONES_SOLICITUD=obs , FECHA_MODIFICACION=curdate(), USUARIO_MODIFICO=usuario where ID_SOLICITUD=idSol;
                set resul=1;
		elseif tipE=4 then
				IF (SELECT USUARIOINSTITUCIONAL FROM SOLICITUDES WHERE ID_SOLICITUD=idSol)=usuario THEN
					update SOLICITUDES set ID_ESTADO = tipE, OBSERVACIONES_SOLICITUD=obs , FECHA_MODIFICACION=curdate(), USUARIO_MODIFICO=usuario where ID_SOLICITUD=idSol;
                    set resul=1;
                else 
					set resul=-4;
                end if;
        else 
        set resul=-3;        
        end if;
		
RETURN resul;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `compararEventos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` FUNCTION `compararEventos`(idEspacio int, horaInicio time, horaFinal time, tipoRepeticion int, fechainEvento date, fechaterEvento date, dias varchar(10)) RETURNS tinyint(1)
BEGIN
	declare esInsertable boolean;
    declare contada int;
    set esInsertable = true;

	if tipoRepeticion != 3 then

        select count(*) into contada from EVENTOS 
		natural join SOLICITUDES
		natural join DIAS_DE_SEMANA_EVENTOS
		WHERE  ID_ESTADO = 1
		AND ID_ESPACIO = idEspacio
		AND dias REGEXP CONCAT('[', ID_DIA , ']') 
		AND (HORA_INICIOEVENTO > horaInicio and HORA_INICIOEVENTO < horaFinal
		or HORA_FINALEVENTO > horaInicio and HORA_FINALEVENTO < horaFinal
        or horaInicio > HORA_INICIOEVENTO and horaInicio < HORA_FINALEVENTO
        or horaFinal > HORA_INICIOEVENTO and horaFinal < HORA_FINALEVENTO
		or HORA_INICIOEVENTO = horaInicio and HORA_FINALEVENTO = horaFinal)
        AND (
        (FECHA_EVENTO BETWEEN fechainEvento and fechaterEvento)
		or (FECHA_TERMINA BETWEEN fechainEvento  and fechaterEvento)
        or (
			(ID_REPETICION != 3 
            and (
            (fechainEvento BETWEEN FECHA_EVENTO and FECHA_TERMINA) 
            or (fechaterEvento BETWEEN FECHA_EVENTO and FECHA_TERMINA)
            or (FECHA_EVENTO BETWEEN fechainEvento and fechaterEvento)
            or (FECHA_TERMINA BETWEEN fechainEvento and fechaterEvento)
            ))
			OR 
			(ID_REPETICION = 3 
            and ((fechainEvento BETWEEN FECHA_EVENTO and FECHA_TERMINA) and (fechaterEvento BETWEEN FECHA_EVENTO and FECHA_TERMINA))
			and (Horarios_Tics_y_Laboratorios.Eventoentrefechas(idEspacio, fechainEvento, fechaterEvento, horaInicio, horaFinal,dias))
			)
		)
        );
	else
        
        select count(*) into contada from EVENTOS 
		natural join SOLICITUDES
		natural join DIAS_DE_SEMANA_EVENTOS
		WHERE  ID_ESTADO = 1
		AND ID_ESPACIO = idEspacio
		AND dias REGEXP CONCAT('[', ID_DIA , ']') 
		and HORA_INICIOEVENTO = horaInicio
		and HORA_FINALEVENTO = horaFinal
		and ((ID_REPETICION != 3 AND (
        (fechainEvento BETWEEN FECHA_EVENTO  and FECHA_TERMINA)
		or (fechaterEvento BETWEEN FECHA_EVENTO  and FECHA_TERMINA )
        or (FECHA_EVENTO BETWEEN fechainEvento and fechaterEvento) 
        or (FECHA_TERMINA BETWEEN fechainEvento and fechaterEvento)
		OR (((fechainEvento BETWEEN FECHA_EVENTO and FECHA_TERMINA) and (fechaterEvento BETWEEN FECHA_EVENTO and FECHA_TERMINA))
				and ( 
				((MONTH(FECHA_EVENTO) = MONTH(FECHA_TERMINA) and year(FECHA_EVENTO) = year(FECHA_TERMINA)) 
						AND (WEEK(fechainEvento, 0) - WEEK(DATE_SUB(fechainEvento, INTERVAL DAYOFMONTH(fechainEvento) - 1 DAY), 0) + 1) between (WEEK(FECHA_EVENTO , 0) - WEEK(DATE_SUB(fechaterEvento , INTERVAL DAYOFMONTH(fechaterEvento ) - 1 DAY), 0) + 1) and (WEEK(fechaterEvento, 0) - WEEK(DATE_SUB(fechaterEvento, INTERVAL DAYOFMONTH(fechaterEvento) - 1 DAY), 0) + 1)
					) or (
						(MONTH(FECHA_TERMINA) > MONTH(FECHA_EVENTO) and year(FECHA_TERMINA) = year(FECHA_EVENTO)) 
                        and (week(FECHA_TERMINA) - week(FECHA_EVENTO) >= 3 
                        or (WEEK(fechainEvento, 0) - WEEK(DATE_SUB(fechainEvento, INTERVAL DAYOFMONTH(fechainEvento) - 1 DAY), 0) + 1)  = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) 
                        or (WEEK(fechaterEvento, 0) - WEEK(DATE_SUB(fechaterEvento, INTERVAL DAYOFMONTH(fechaterEvento) - 1 DAY), 0) + 1)  = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) 
                        or (WEEK(DATE_ADD(fechainEvento,INTERVAL 1 DAY), 0) - WEEK(DATE_SUB(fechainEvento, INTERVAL DAYOFMONTH(fechainEvento) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
                        )							
                    )  or (
						(year(FECHA_TERMINA) > year(FECHA_EVENTO)) 
						and (53 - week(FECHA_EVENTO) + week(FECHA_TERMINA) >= 3
                        or (WEEK(fechainEvento, 0) - WEEK(DATE_SUB(fechainEvento, INTERVAL DAYOFMONTH(fechainEvento) - 1 DAY), 0) + 1)  = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) 
                        or (WEEK(fechaterEvento, 0) - WEEK(DATE_SUB(fechaterEvento, INTERVAL DAYOFMONTH(fechaterEvento) - 1 DAY), 0) + 1)  = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) 
						or (WEEK(DATE_ADD(fechainEvento,INTERVAL 1 DAY), 0) - WEEK(DATE_SUB(fechainEvento, INTERVAL DAYOFMONTH(fechainEvento) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)	                    
                        )
					) 
				)
			)
		))
        or (ID_REPETICION = 3 and(
		((fechainEvento BETWEEN FECHA_EVENTO  and FECHA_TERMINA)
		or (fechaterEvento BETWEEN FECHA_EVENTO  and FECHA_TERMINA )
        or (FECHA_EVENTO BETWEEN fechainEvento and fechaterEvento) 
        or (FECHA_TERMINA BETWEEN fechainEvento and fechaterEvento)) and (
			(WEEK(fechainEvento, 0) - WEEK(DATE_SUB(fechainEvento, INTERVAL DAYOFMONTH(fechainEvento) - 1 DAY), 0) + 1)  = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
        )
			
        )
			
        )
        );
        

	end if;
    
    if contada > 0 then 
			set esInsertable = false;
            RETURN esInsertable;
	end if;
    
    
    
RETURN esInsertable;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `dias_del_evento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` FUNCTION `dias_del_evento`(idSolicitud int) RETURNS char(255) CHARSET utf8mb4
BEGIN
	DECLARE resul varchar(255);
    DECLARE resul2 varchar(255);
    DECLARE TOTAL INT;
    DECLARE i int;   
  
	DECLARE cursor_resultado CURSOR FOR select ID_DIA from  EVENTOS as even,
	SOLICITUDES as sol, DIAS_DE_SEMANA_EVENTOS as diaE WHERE 
	sol.ID_EVENTO=even.ID_EVENTO and
	diaE.ID_EVENTO=even.ID_EVENTO and
	ID_SOLICITUD=idSolicitud;
    
    OPEN cursor_resultado;
    set i = 0;
    set TOTAL = 0;   
    set resul='';
    
    select count(*) into TOTAL from (select ID_DIA from  EVENTOS as even,
	SOLICITUDES as sol, DIAS_DE_SEMANA_EVENTOS as diaE WHERE 
	sol.ID_EVENTO=even.ID_EVENTO and
	diaE.ID_EVENTO=even.ID_EVENTO and
	ID_SOLICITUD=idSolicitud) as a;
    
     while i < TOTAL DO 
		FETCH cursor_resultado INTO resul2;
        set resul=(SELECT concat(resul,',',resul2));     
        set i = i+1;
      end while;
      
     CLOSE cursor_resultado;
	   
RETURN resul;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `Eventoentrefechas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` FUNCTION `Eventoentrefechas`(idEspacio int,fechabuscar date, fechatermina date,  horaInicio time, horaFinal time, dias varchar(10)) RETURNS int
BEGIN
	DECLARE hayEventoEsedia boolean;
	DECLARE A INT;
    DECLARE RES boolean;
    Set A = 0;
    Set res = false;
    
    
    
    while fechabuscar <= fechatermina do
		
  select (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) into A from EVENTOS 
	natural join SOLICITUDES
    natural join DIAS_DE_SEMANA_EVENTOS
    WHERE ID_ESTADO = 1 
    and ID_ESPACIO = idEspacio
    and ID_DIA = dayofweek(fechabuscar)
    and fechabuscar BETWEEN FECHA_EVENTO and FECHA_TERMINA
    AND (HORA_INICIOEVENTO > horaInicio and HORA_INICIOEVENTO < horaFinal
		or HORA_FINALEVENTO > horaInicio and HORA_FINALEVENTO < horaFinal
        or horaInicio > HORA_INICIOEVENTO and horaInicio < HORA_FINALEVENTO
        or horaFinal > HORA_INICIOEVENTO and horaFinal < HORA_FINALEVENTO
		or HORA_INICIOEVENTO = horaInicio and HORA_FINALEVENTO = horaFinal)
    and (
    (ID_REPETICION = 3 
    and (
    (
    (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) < (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = 1
    and dayofweek(FECHA_EVENTO) < dayofweek( fechabuscar - interval (day(fechabuscar)-1) day)  
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)+1
    ) or 
    (
    (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) < (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = 1
    and dayofweek(FECHA_EVENTO) >= dayofweek( fechabuscar - interval (day(fechabuscar)-1) day)  
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    ) or
    (
    (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) < (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) > 1
    and 
    ( 
    (
    dayofweek(FECHA_EVENTO) < dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) >= dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-1
    ) or 
    (
    dayofweek(FECHA_EVENTO) < dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) < dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )or 
    (
    dayofweek(FECHA_EVENTO) >= dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) < dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (
    (
    (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)+1
    ) or (
    (dayofweek(FECHA_EVENTO) > dayofweek(LAST_DAY(fechabuscar)))
    and (
    (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)+1
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )
    )
    
    )
    )
    or 
    (
    dayofweek(FECHA_EVENTO) >= dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) >= dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )
    )
    ) or 
    (
	(WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (dayofweek(FECHA_EVENTO) > dayofweek(LAST_DAY(fechabuscar)))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-1
    ) or 
    (
	(WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (dayofweek(FECHA_EVENTO) <= dayofweek(LAST_DAY(fechabuscar)))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )
    or 
    (
	(WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) > (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and 
    (
    (
    dayofweek(FECHA_EVENTO) <= dayofweek(LAST_DAY(fechabuscar)) 
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-1
    ) or 
    (
    dayofweek(FECHA_EVENTO) > dayofweek(LAST_DAY(fechabuscar)) 
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-2
    ) 
    )
    ) 
    
    )
    )
    );
    
		if A != 0 and dias REGEXP CONCAT('[', dayofweek(fechabuscar), ']') then
			return A;
        else
			Set A = 0;
        end if;
        
		set fechabuscar = DATE_ADD(fechabuscar, interval 1 day);   
    End while;
    
    return A;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Actualizar_Agregar_Inv` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Actualizar_Agregar_Inv`(IN ID_ESPACIO2 int, IN USUARIO CHAR(255), IN ID_INV INT, IN NOMBRE CHAR(255), IN DESCRIPCIONS CHAR(255))
BEGIN
	
    
    IF (SELECT ID_TIPOUSUARIO FROM USUARIOS WHERE USUARIOINSTITUCIONAL=usuario)=2 THEN
				IF ID_INV = -1 THEN
				INSERT INTO INVENTARIOS (ID_ESPACIO,NOMBREATRIBUTO,DESCRIPCION,VIVO_INV) values(ID_ESPACIO2,NOMBRE,DESCRIPCIONS,TRUE);
				ELSE 
					IF(SELECT VIVO FROM ESPACIOS where ID_ESPACIO=ID_ESPACIO2)=1 THEN
						UPDATE INVENTARIOS SET NOMBREATRIBUTO =NOMBRE , DESCRIPCION = DESCRIPCIONS  WHERE id_inventario=ID_INV;						
					END IF; 
				END IF;  
	END IF;  
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CrearCod` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `CrearCod`(IN UserU char(255), IN Cod char(255))
BEGIN
	INSERT INTO CODIGOS_SEGURIDAD( `CODIGO_SEGURIDAD`, `FECHA_DE_CREACION_CODIGO`,`USUARIOINSTITUCIONAL`,`utilizado_codigo`) VALUES (Cod, NOW(),UserU,0);	
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `espacio_especifico_estadistica` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `espacio_especifico_estadistica`(IN fecha char(12), IN tipo_de_espacio int)
BEGIN
SELECT espa.NOMBRE_ESPACIO, COUNT(espa.NOMBRE_ESPACIO) AS Cantidad 
FROM 
SOLICITUDES AS sol, 
ESPACIOS AS espa, 
TIPO_ESPACIOS AS t_esp
WHERE FECHA_SOLICITUD REGEXP fecha and  
espa.ID_TIPOESPACIO=tipo_de_espacio and
 sol.ID_ESPACIO=espa.ID_ESPACIO and 
 espa.ID_TIPOESPACIO= t_esp.ID_TIPOESPACIO 
 GROUP BY espa.NOMBRE_ESPACIO
 ORDER BY Cantidad;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `espacio_general_estadistica` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `espacio_general_estadistica`(IN fecha char(12))
BEGIN
SELECT t_esp.NOMBRE_TIPOESPACIO,COUNT(t_esp.NOMBRE_TIPOESPACIO) AS Cantidad 
FROM SOLICITUDES AS sol, ESPACIOS AS espa, TIPO_ESPACIOS AS t_esp 
WHERE FECHA_SOLICITUD REGEXP fecha AND
sol.ID_ESPACIO=espa.ID_ESPACIO AND
espa.ID_TIPOESPACIO=t_esp.ID_TIPOESPACIO
GROUP BY t_esp.NOMBRE_TIPOESPACIO
ORDER BY Cantidad;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `infoporSolicitud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `infoporSolicitud`(IN id_solicitud int)
BEGIN
	SELECT even.FECHA_EVENTO,even.FECHA_TERMINA, even.HORA_INICIOEVENTO, even.HORA_FINALEVENTO, rept.NOMBRE_REPETICION,
			esp.NOMBRE_ESPACIO, mot.NOMBRE_MOTIVO, concat(edi.ID_EDIFICIO,' - ',edi.NOMBRE_EDIFICIOS), esp.NUM_ESPACIO, even.OBSERVACIONES
    FROM SOLICITUDES as sol,
    EVENTOS as even,
    EDIFICIOS as edi,
    MOTIVOS_EVENTOS as mot,
    TIPODEREPETICION as rept,
    ESPACIOS as esp
    WHERE sol.ID_SOLICITUD=id_solicitud
    and sol.ID_EVENTO=even.ID_EVENTO
    and sol.ID_ESPACIO=esp.ID_ESPACIO
    and even.ID_MOTIVO=mot.ID_MOTIVO
    and esp.ID_EDIFICIO=edi.ID_EDIFICIO
    and even.ID_REPETICION=rept.ID_REPETICION;
   
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InfoporTipodeEspacio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `InfoporTipodeEspacio`(IN ID_TIPOESPACIO integer)
BEGIN
  select distinct  esp.ID_ESPACIO,  esp.NOMBRE_ESPACIO,  esp.NUM_ESPACIO, concat(edi.id_edificio, ' ', edi.NOMBRE_EDIFICIOS) as edificio, CASE WHEN us.id_tipousuario='4' THEN per.NOMBRE_PERSONA ELSE ' ' END AS 'nombre' , CASE WHEN esp.ACTIVO=0 THEN 'No disponible' ELSE 'En funcionamiento' END AS 'ESTADO' from ESPACIOS as espa, 
    ESPACIOS as esp, 
    TIPO_ESPACIOS as tesp, 
    PERSONA as per, 
    EDIFICIOS as edi,
    USUARIOS as us
    where esp.id_edificio=edi.id_edificio
    and esp.ID_TIPOESPACIO=tesp.ID_TIPOESPACIO
    and esp.ID_PERSONA=per.ID_PERSONA
    and per.usuarioinstitucional=us.usuarioinstitucional
    and esp.ID_TIPOESPACIO = ID_TIPOESPACIO
    and esp.VIVO = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InforporEspacio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `InforporEspacio`(IN ID_ESPACIO integer)
BEGIN
select distinct  esp.ID_ESPACIO,  esp.NOMBRE_ESPACIO,  esp.NUM_ESPACIO, edi.NOMBRE_EDIFICIOS, edi.id_edificio, CASE WHEN us.id_tipousuario='4' THEN per.NOMBRE_PERSONA ELSE ' ' END AS 'nombre', CASE WHEN us.id_tipousuario='4' THEN per.USUARIOINSTITUCIONAL ELSE ' ' END AS 'correo'  , CASE WHEN esp.ACTIVO=0 THEN 'Inactivo' ELSE 'Activo' END AS 'ESTADO', esp.CAPACIDAD,  tesp.NOMBRE_TIPOESPACIO from ESPACIOS as espa, 
		ESPACIOS as esp, 
		TIPO_ESPACIOS as tesp, 
		PERSONA as per, 
		EDIFICIOS as edi,
		USUARIOS as us
		where esp.id_edificio=edi.id_edificio
		and esp.ID_TIPOESPACIO=tesp.ID_TIPOESPACIO
		and esp.ID_PERSONA=per.ID_PERSONA
		and per.usuarioinstitucional=us.usuarioinstitucional
    and esp.ID_ESPACIO=ID_ESPACIO;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Ingresar_Solicitud` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Ingresar_Solicitud`(IN id_repeticion int, IN fecha_evento date, in hora_inicio_Evento time , in hora_final_Evento time, in fecha_termina date, in observaciones_evento varchar(255), in id_motivo int, in usuarioInsitucional char(255), in id_espacio int, in diasRepeticion varchar(10))
BEGIN
	declare ultimoidIngresado int;
	DECLARE x  INT;
    DECLARE tamanio int;
    DECLARE indicedias char;
    
    insert INTO EVENTOS (ID_REPETICION,FECHA_EVENTO,HORA_INICIOEVENTO,HORA_FINALEVENTO,FECHA_TERMINA,OBSERVACIONES,ID_MOTIVO) values(id_repeticion, fecha_evento , hora_inicio_Evento , hora_final_Evento, fecha_termina, observaciones_evento, id_motivo );
    SELECT LAST_INSERT_ID() into ultimoidIngresado;
    insert INTO SOLICITUDES(ID_ESTADO,USUARIOINSTITUCIONAL,ID_EVENTO,ID_ESPACIO,FECHA_SOLICITUD) values(2,usuarioInsitucional,ultimoidIngresado,id_espacio,curdate());
   
	SET x = 1;
    SET tamanio = CHAR_LENGTH(diasRepeticion);
    
	label: LOOP
    
	set indicedias = SUBSTRING(diasRepeticion,x,1);
    
    if indicedias != '0' then
		insert into DIAS_DE_SEMANA_EVENTOS(ID_DIA,ID_EVENTO) values(x,ultimoidIngresado);
	end if;
    
    
    IF x >= tamanio THEN
        LEAVE label;
    END IF;
	set x = x + 1;
	END LOOP label;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Obtener_Horas_espacio` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Obtener_Horas_espacio`(in idEspacio int,in fechabuscar date, in diabuscar int)
BEGIN
	DECLARE hayEventoEsedia boolean;
	DECLARE A INT;
    
    select HORA_INICIOEVENTO,HORA_FINALEVENTO from EVENTOS 
	natural join SOLICITUDES
    natural join DIAS_DE_SEMANA_EVENTOS
    WHERE ID_ESTADO = 1 
    and ID_ESPACIO = idEspacio
    AND ID_DIA = diabuscar
    and fechabuscar BETWEEN FECHA_EVENTO and FECHA_TERMINA
    and (( ID_REPETICION != 3) 
    or 
    (ID_REPETICION = 3 
    and (
    (
    (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) < (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = 1
    and dayofweek(FECHA_EVENTO) < dayofweek( fechabuscar - interval (day(fechabuscar)-1) day)  
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)+1
    ) or 
    (
    (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) < (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = 1
    and dayofweek(FECHA_EVENTO) >= dayofweek( fechabuscar - interval (day(fechabuscar)-1) day)  
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    ) or
    (
    (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) < (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) > 1
    and 
    ( 
    (
    dayofweek(FECHA_EVENTO) < dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) >= dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-1
    ) or 
    (
    dayofweek(FECHA_EVENTO) < dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) < dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )or 
    (
    dayofweek(FECHA_EVENTO) >= dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) < dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (
    (
    (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)+1
    ) or (
    (dayofweek(FECHA_EVENTO) > dayofweek(LAST_DAY(fechabuscar)))
    and (
    (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)+1
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )
    )
    
    )
    )
    or 
    (
    dayofweek(FECHA_EVENTO) >= dayofweek( FECHA_EVENTO - interval (day(FECHA_EVENTO)-1) day)
    and (dayofweek(FECHA_EVENTO) >= dayofweek( fechabuscar - interval (day(fechabuscar)-1) day))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )
    )
    ) or 
    (
	(WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (dayofweek(FECHA_EVENTO) > dayofweek(LAST_DAY(fechabuscar)))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-1
    ) or 
    (
	(WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) = (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and (dayofweek(FECHA_EVENTO) <= dayofweek(LAST_DAY(fechabuscar)))
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)
    )
    or 
    (
	(WEEK(FECHA_EVENTO,0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1) > (WEEK(LAST_DAY(fechabuscar),0) - WEEK(DATE_SUB(LAST_DAY(fechabuscar), INTERVAL DAYOFMONTH(LAST_DAY(fechabuscar)) - 1 DAY), 0) + 1) 
    and 
    (
    (
    dayofweek(FECHA_EVENTO) <= dayofweek(LAST_DAY(fechabuscar)) 
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-1
    ) or 
    (
    dayofweek(FECHA_EVENTO) > dayofweek(LAST_DAY(fechabuscar)) 
    and (WEEK(fechabuscar,0) - WEEK(DATE_SUB(fechabuscar, INTERVAL DAYOFMONTH(fechabuscar) - 1 DAY), 0) + 1) = (WEEK(FECHA_EVENTO, 0) - WEEK(DATE_SUB(FECHA_EVENTO, INTERVAL DAYOFMONTH(FECHA_EVENTO) - 1 DAY), 0) + 1)-2
    ) 
    )
    ) 
    
    )
    )
    );
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `verifCode` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `verifCode`(IN UserU char(255))
BEGIN
select distinct Cs.idCODIGOS_SEGURIDAD, Cs.codigo_seguridad from  
    USUARIOS as US,  
	CODIGOS_SEGURIDAD as Cs
    where US.USUARIOINSTITUCIONAL=Cs.USUARIOINSTITUCIONAL
    and US.USUARIOINSTITUCIONAL=UserU
    and Cs.utilizado_codigo=0
    and DATE_ADD(Cs.Fecha_de_creacion_codigo,INTERVAL 24 HOUR) >= NOW( ) ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Ver_solicitudes_estado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`admin`@`%` PROCEDURE `Ver_solicitudes_estado`( IN USUARIO CHAR(255),IN TIPO_E INT)
BEGIN
	IF(SELECT ID_TIPOUSUARIO FROM USUARIOS WHERE USUARIOINSTITUCIONAL=USUARIO)=2 THEN
			IF(TIPO_E=0) THEN
				Select sol.ID_SOLICITUD, sol.FECHA_SOLICITUD, sol.ID_ESTADO, sol.FECHA_MODIFICACION, sol.USUARIOINSTITUCIONAL, concat(esp.NUM_ESPACIO,' - ',edi.ID_EDIFICIO,' - ',edi.NOMBRE_EDIFICIOS), even.FECHA_EVENTO, even.FECHA_TERMINA, sol.OBSERVACIONES_SOLICITUD
				from SOLICITUDES as sol,
				EVENTOS as even,
				ESPACIOS as esp,
                EDIFICIOS as edi
				WHERE 
				sol.ID_EVENTO=even.ID_EVENTO
				and sol.ID_ESPACIO=esp.ID_ESPACIO
                and esp.ID_EDIFICIO=edi.ID_EDIFICIO;
            ELSE
				Select sol.ID_SOLICITUD, sol.FECHA_SOLICITUD, sol.ID_ESTADO, sol.FECHA_MODIFICACION, sol.USUARIOINSTITUCIONAL, concat(esp.NUM_ESPACIO,' - ',edi.ID_EDIFICIO,' - ',edi.NOMBRE_EDIFICIOS), even.FECHA_EVENTO, even.FECHA_TERMINA, sol.OBSERVACIONES_SOLICITUD
				from SOLICITUDES as sol,
				EVENTOS as even,
				ESPACIOS as esp,
                EDIFICIOS as edi
				WHERE sol.ID_ESTADO=TIPO_E 
				and sol.ID_EVENTO=even.ID_EVENTO
				and sol.ID_ESPACIO=esp.ID_ESPACIO
                and esp.ID_EDIFICIO=edi.ID_EDIFICIO;
			END IF;
	ELSE
			IF(TIPO_E=0) THEN
				Select sol.ID_SOLICITUD, sol.FECHA_SOLICITUD, sol.ID_ESTADO, sol.FECHA_MODIFICACION, sol.USUARIOINSTITUCIONAL, concat(esp.NUM_ESPACIO,' - ',edi.ID_EDIFICIO,' - ',edi.NOMBRE_EDIFICIOS), even.FECHA_EVENTO, even.FECHA_TERMINA, sol.OBSERVACIONES_SOLICITUD
				from SOLICITUDES as sol,
				EVENTOS as even,
				ESPACIOS as esp,
                EDIFICIOS as edi
				WHERE sol.USUARIOINSTITUCIONAL=USUARIO
				and sol.ID_EVENTO=even.ID_EVENTO
				and sol.ID_ESPACIO=esp.ID_ESPACIO
                and esp.ID_EDIFICIO=edi.ID_EDIFICIO;
			ELSE
				Select sol.ID_SOLICITUD, sol.FECHA_SOLICITUD, sol.ID_ESTADO, sol.FECHA_MODIFICACION, sol.USUARIOINSTITUCIONAL, concat(esp.NUM_ESPACIO,' - ',edi.ID_EDIFICIO,' - ',edi.NOMBRE_EDIFICIOS), even.FECHA_EVENTO, even.FECHA_TERMINA, sol.OBSERVACIONES_SOLICITUD
				from SOLICITUDES as sol,
				EVENTOS as even,
				ESPACIOS as esp,
                EDIFICIOS as edi
				WHERE sol.ID_ESTADO=TIPO_E and sol.USUARIOINSTITUCIONAL=USUARIO
				and sol.ID_EVENTO=even.ID_EVENTO
				and sol.ID_ESPACIO=esp.ID_ESPACIO
                and esp.ID_EDIFICIO=edi.ID_EDIFICIO;
			END IF;
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-03 22:11:13
