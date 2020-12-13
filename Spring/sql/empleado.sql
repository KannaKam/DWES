-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-12-2020 a las 09:04:04
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--

--

-- --------------------------------------------------------

--

--
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `categoria` int DEFAULT NULL,
  `antiguedad` int DEFAULT NULL,
  `idNomina` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NOMINA_idx` (`idNomina`),
  CONSTRAINT `FK_NOMINA` FOREIGN KEY (`idNomina`) REFERENCES `nomina` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleado` (`id`, `nombre`, `dni`, `sexo`, `categoria`, `antiguedad`, `idNomina`) VALUES
(1, 'James Cosling', '32000032G', 'H', 9, 7, 1),
(2, 'Ada Lovelace', '32000031R', 'F', 1, 1, 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
