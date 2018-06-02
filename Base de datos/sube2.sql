-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2018 a las 02:11:08
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sube2`
--

create database sube2;

use sube2;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleto`
--

CREATE TABLE `boleto` (
  `idBoleto` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `cerrado` tinyint(4) NOT NULL,
  `precioFinal` double NOT NULL,
  `idViaje` int(11) NOT NULL,
  `idTransporte` int(11) NOT NULL,
  `idLinea` int(11) NOT NULL,
  `idRamal` int(11) NOT NULL,
  `idEstacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estacion`
--

CREATE TABLE `estacion` (
  `idEstacion` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idRamal` int(11) DEFAULT NULL,
  `idLinea` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estacion`
--

INSERT INTO `estacion` (`idEstacion`, `nombre`, `idRamal`, `idLinea`) VALUES
(1, 'Pza. Constitución', 3, 1),
(2, 'Hipólito Yrigoyen', 3, 1),
(3, 'D. Santillán Y M. Kosteki', 3, 1),
(4, 'Gerli', 3, 1),
(5, 'Lanús', 3, 1),
(6, 'Remedios de Escalada', 3, 1),
(7, 'Banfield', 3, 1),
(8, 'Lomas de Zamora', 3, 1),
(9, 'Temperley', 3, 1),
(10, 'Adrogué', 3, 1),
(11, 'Burzaco', 3, 1),
(12, 'Longchamps', 3, 1),
(13, 'Glew', 3, 1),
(14, 'Guernica', 3, 1),
(15, 'Alejandro Korn', 3, 1),
(52, 'Plaza de Mayo', NULL, 2),
(53, 'Perú', NULL, 2),
(54, 'Piedras', NULL, 2),
(55, 'Lima', NULL, 2),
(56, 'Sáenz Peña', NULL, 2),
(57, 'Congreso', NULL, 2),
(58, 'Pasco', NULL, 2),
(59, 'Alberti', NULL, 2),
(60, 'Plaza Miserere', NULL, 2),
(61, 'Loria', NULL, 2),
(62, 'Castro Barros', NULL, 2),
(63, 'Río de Janeiro', NULL, 2),
(64, 'Acoyte', NULL, 2),
(65, 'Primera Junta', NULL, 2),
(66, 'Puan', NULL, 2),
(67, 'Carabobo', NULL, 2),
(68, 'San José de Flores', NULL, 2),
(69, 'San Pedrito', NULL, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea`
--

CREATE TABLE `linea` (
  `idLinea` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idTransporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `linea`
--

INSERT INTO `linea` (`idLinea`, `nombre`, `idTransporte`) VALUES
(1, 'Roca', 3),
(2, 'A', 2),
(3, 'B', 2),
(4, '74', 1),
(5, '79', 1),
(6, '160', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ramal`
--

CREATE TABLE `ramal` (
  `idRamal` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idLinea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ramal`
--

INSERT INTO `ramal` (`idRamal`, `nombre`, `idLinea`) VALUES
(1, 'Pza. Constitución - La Plata', 1),
(2, 'Pza. Constitución - Ezeiza/Cañuelas', 1),
(3, 'Pza. Constitución - Glew/A. Korn', 1),
(4, 'Pza. Constitución - Bosques por Quilmes', 1),
(5, 'A', 4),
(6, 'B', 4),
(7, 'A', 5),
(8, 'B', 5),
(9, 'C', 5),
(10, 'A', 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `seccion` (
  `idSeccion` int(11) NOT NULL,
  `nroSeccion` int(11) NOT NULL,
  `idTransporte` int(11) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `seccion` (`idSeccion`, `nroSeccion`, `idTransporte`, `precio`) VALUES
(1, 1, 1, 10),
(2, 2, 1, 10.5),
(3, 3, 1, 10.75),
(4, 4, 1, 10.75),
(5, 5, 1, 11.25),
(6, 6, 1, 11.25),
(7, 7, 1, 11.25),
(8, 8, 1, 11.25),
(9, 9, 1, 11.25),
(10, 10, 1, 11.75),
(11, 1, 3, 2.75),
(12, 2, 3, 4),
(13, 3, 3, 5.5),
(14, 1, 2, 12.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `idTarjeta` int(11) NOT NULL,
  `numTarjeta` int(16) NOT NULL,
  `saldo` double NOT NULL,
  `activa` tinyint(4) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`idTarjeta`, `numTarjeta`, `saldo`, `activa`, `idUsuario`) VALUES
(1, 123456789, 15, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transporte`
--

CREATE TABLE `transporte` (
  `idTransporte` int(11) NOT NULL,
  `nombre` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `transporte`
--

INSERT INTO `transporte` (`idTransporte`, `nombre`) VALUES
(1, 'Colectivo'),
(2, 'Subte'),
(3, 'Tren');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int(8) NOT NULL,
  `pass` varchar(8) NOT NULL,
  `email` varchar(45) NOT NULL,
  `tarifaSocial` tinyint(4) NOT NULL,
  `estudiantil` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `dni`, `pass`, `email`, `tarifaSocial`, `estudiantil`) VALUES
(1, 'Gonzalo', 'Cerbelli', 39281276, '12345678', 'gonza.cerbelli@gmail.com', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viaje`
--

CREATE TABLE `viaje` (
  `idViaje` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `idTarjeta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `boleto`
--
ALTER TABLE `boleto`
  ADD PRIMARY KEY (`idBoleto`),
  ADD KEY `fk_viaje_boleto` (`idViaje`),
  ADD KEY `fk_transporte_boleto` (`idTransporte`),
  ADD KEY `fk_linea_boleto` (`idLinea`),
  ADD KEY `fk_ramal_boleto` (`idRamal`),
  ADD KEY `fk_estacion_boleto` (`idEstacion`);

--
-- Indices de la tabla `estacion`
--
ALTER TABLE `estacion`
  ADD PRIMARY KEY (`idEstacion`),
  ADD KEY `fk_linea2` (`idLinea`),
  ADD KEY `fk_ramal` (`idRamal`);

--
-- Indices de la tabla `linea`
--
ALTER TABLE `linea`
  ADD PRIMARY KEY (`idLinea`),
  ADD KEY `fk_transporte` (`idTransporte`);

--
-- Indices de la tabla `ramal`
--
ALTER TABLE `ramal`
  ADD PRIMARY KEY (`idRamal`),
  ADD KEY `fk_linea` (`idLinea`);

--
-- Indices de la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD PRIMARY KEY (`idSeccion`),
  ADD KEY `fk_transporte_seccion` (`idTransporte`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`idTarjeta`),
  ADD UNIQUE KEY `idTarjeta_UNIQUE` (`idTarjeta`),
  ADD UNIQUE KEY `numTarjeta_UNIQUE` (`numTarjeta`),
  ADD KEY `fk_usuario_tarjeta` (`idUsuario`);

--
-- Indices de la tabla `transporte`
--
ALTER TABLE `transporte`
  ADD PRIMARY KEY (`idTransporte`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`),
  ADD UNIQUE KEY `dni_UNIQUE` (`dni`);

--
-- Indices de la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD PRIMARY KEY (`idViaje`),
  ADD KEY `fk_tarjeta_viaje` (`idTarjeta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `boleto`
--
ALTER TABLE `boleto`
  MODIFY `idBoleto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estacion`
--
ALTER TABLE `estacion`
  MODIFY `idEstacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `linea`
--
ALTER TABLE `linea`
  MODIFY `idLinea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `ramal`
--
ALTER TABLE `ramal`
  MODIFY `idRamal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `seccion`
--
ALTER TABLE `seccion`
  MODIFY `idSeccion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `idTarjeta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `transporte`
--
ALTER TABLE `transporte`
  MODIFY `idTransporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `viaje`
--
ALTER TABLE `viaje`
  MODIFY `idViaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `boleto`
--
ALTER TABLE `boleto`
  ADD CONSTRAINT `fk_estacion_boleto` FOREIGN KEY (`idEstacion`) REFERENCES `estacion` (`idEstacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_linea_boleto` FOREIGN KEY (`idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ramal_boleto` FOREIGN KEY (`idRamal`) REFERENCES `ramal` (`idRamal`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_transporte_boleto` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_viaje_boleto` FOREIGN KEY (`idViaje`) REFERENCES `viaje` (`idViaje`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `estacion`
--
ALTER TABLE `estacion`
  ADD CONSTRAINT `fk_linea2` FOREIGN KEY (`idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ramal` FOREIGN KEY (`idRamal`) REFERENCES `ramal` (`idRamal`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `linea`
--
ALTER TABLE `linea`
  ADD CONSTRAINT `fk_transporte` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ramal`
--
ALTER TABLE `ramal`
  ADD CONSTRAINT `fk_linea` FOREIGN KEY (`idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD CONSTRAINT `fk_transporte_seccion` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD CONSTRAINT `fk_tarjeta_viaje` FOREIGN KEY (`idTarjeta`) REFERENCES `tarjeta` (`idTarjeta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
