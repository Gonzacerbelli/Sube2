-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2018 a las 20:26:40
-- Versión del servidor: 10.1.32-MariaDB
-- Versión de PHP: 7.2.5

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `beneficio`
--

CREATE TABLE `beneficio` (
  `idbeneficio` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `beneficio`
--

INSERT INTO `beneficio` (`idbeneficio`, `nombre`, `valor`) VALUES
(6, 'Boleto Estudiantil', 300),
(7, 'Boleto Estudiantil', 300),
(8, 'Boleto Estudiantil', 300),
(9, 'Boleto Estudiantil', 300),
(10, 'Boleto Estudiantil', 300),
(11, 'Boleto Estudiantil', 300),
(12, 'Boleto Estudiantil', 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boleto`
--

CREATE TABLE `boleto` (
  `idBoleto` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `precioFinal` double NOT NULL,
  `idViaje` int(11) NOT NULL,
  `idTransporte` int(11) NOT NULL,
  `idLinea` int(11) NOT NULL,
  `idEstacion` int(11) DEFAULT NULL,
  `idTarifa` int(11) NOT NULL,
  `idRamal` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `boleto`
--

INSERT INTO `boleto` (`idBoleto`, `fechaHora`, `precioFinal`, `idViaje`, `idTransporte`, `idLinea`, `idEstacion`, `idTarifa`, `idRamal`) VALUES
(1, '2018-06-04 00:01:46', 6.5, 1, 1, 1, NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuento`
--

CREATE TABLE `descuento` (
  `idDescuento` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `porcentaje` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estacion`
--

CREATE TABLE `estacion` (
  `idEstacion` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `idLinea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estacion`
--

INSERT INTO `estacion` (`idEstacion`, `nombre`, `idLinea`) VALUES
(1, 'Pza. Constitución', 1),
(2, 'Hipólito Yrigoyen', 1),
(3, 'D. Santillán Y M. Kosteki', 1),
(4, 'Gerli', 1),
(5, 'Lanús', 1),
(6, 'Remedios de Escalada', 1),
(7, 'Banfield', 1),
(8, 'Lomas de Zamora', 1),
(9, 'Temperley', 1),
(10, 'Adrogué', 1),
(11, 'Burzaco', 1),
(12, 'Longchamps', 1),
(13, 'Glew', 1),
(14, 'Guernica', 1),
(15, 'Alejandro Korn', 1),
(52, 'Plaza de Mayo', 2),
(53, 'Perú', 2),
(54, 'Piedras', 2),
(55, 'Lima', 2),
(56, 'Sáenz Peña', 2),
(57, 'Congreso', 2),
(58, 'Pasco', 2),
(59, 'Alberti', 2),
(60, 'Plaza Miserere', 2),
(61, 'Loria', 2),
(62, 'Castro Barros', 2),
(63, 'Río de Janeiro', 2),
(64, 'Acoyte', 2),
(65, 'Primera Junta', 2),
(66, 'Puan', 2),
(67, 'Carabobo', 2),
(68, 'San José de Flores', 2),
(69, 'San Pedrito', 2);

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
(6, '160', 1),
(7, 'Sarmiento', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--

CREATE TABLE `movimiento` (
  `idMovimiento` int(11) NOT NULL,
  `idTipoMovimiento` int(11) NOT NULL,
  `detalle` varchar(45) DEFAULT NULL,
  `fechaHora` date NOT NULL,
  `valor` double NOT NULL,
  `idTarjeta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Estructura de tabla para la tabla `ramal_tiene_estacion`
--

CREATE TABLE `ramal_tiene_estacion` (
  `idRelacion` int(11) NOT NULL,
  `idRamal` int(11) NOT NULL,
  `idEstacion` int(11) NOT NULL,
  `nroEstacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ramal_tiene_estacion`
--

INSERT INTO `ramal_tiene_estacion` (`idRelacion`, `idRamal`, `idEstacion`, `nroEstacion`) VALUES
(1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `red_sube`
--

CREATE TABLE `red_sube` (
  `idRedSube` int(11) NOT NULL,
  `cantidadBoletos` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `porcentaje` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `red_sube`
--

INSERT INTO `red_sube` (`idRedSube`, `cantidadBoletos`, `descripcion`, `porcentaje`) VALUES
(1, 1, 'RED SUBE 1', 50),
(2, 2, 'RED SUBE 2', 75),
(3, 3, 'RED SUBE 3', 75),
(4, 4, 'RED SUBE 4', 75),
(5, 5, 'RED SUBE 5', 75);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `idTarifa` int(11) NOT NULL,
  `idTransporte` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `cantEstaciones` int(11) DEFAULT NULL,
  `monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tarifa`
--

INSERT INTO `tarifa` (`idTarifa`, `idTransporte`, `nombre`, `cantEstaciones`, `monto`) VALUES
(1, 1, 'Minimo', 1, 6.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--

CREATE TABLE `tarjeta` (
  `idTarjeta` int(11) NOT NULL,
  `numTarjeta` int(16) NOT NULL,
  `saldo` double NOT NULL,
  `activa` bit(1) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tarjeta`
--

INSERT INTO `tarjeta` (`idTarjeta`, `numTarjeta`, `saldo`, `activa`, `idUsuario`) VALUES
(1, 123456789, 15, b'1', 1),
(2, 1234, 0, b'0', NULL),
(5, 1235, 0, b'0', NULL),
(7, 1236, 0, b'0', NULL),
(10, 1237, 0, b'0', NULL),
(11, 1238, 0, b'0', NULL),
(14, 1239, 0, b'0', NULL);

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
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombre`, `apellido`, `dni`, `pass`, `email`) VALUES
(1, 'Gonzalo', 'Cerbelli', 39281276, '12345678', 'gonza.cerbelli@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_tiene_beneficio`
--

CREATE TABLE `usuario_tiene_beneficio` (
  `idRelacion` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idBeneficio` int(11) NOT NULL,
  `fechaCobro` date DEFAULT NULL,
  `fechaAsignado` date NOT NULL,
  `activo` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario_tiene_beneficio`
--

INSERT INTO `usuario_tiene_beneficio` (`idRelacion`, `idUsuario`, `idBeneficio`, `fechaCobro`, `fechaAsignado`, `activo`) VALUES
(1, 1, 6, '2018-06-05', '2018-06-05', b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_tiene_descuento`
--

CREATE TABLE `usuario_tiene_descuento` (
  `idRelacion` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idDescuento` int(11) NOT NULL,
  `activo` bit(1) NOT NULL,
  `fechaAsignado` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viaje`
--

CREATE TABLE `viaje` (
  `idViaje` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `idTarjeta` int(11) NOT NULL,
  `cantBoletos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `viaje`
--

INSERT INTO `viaje` (`idViaje`, `fechaHora`, `idTarjeta`, `cantBoletos`) VALUES
(1, '2018-06-04 00:00:52', 1, 0),
(2, '2018-06-04 00:01:46', 1, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `beneficio`
--
ALTER TABLE `beneficio`
  ADD PRIMARY KEY (`idbeneficio`),
  ADD UNIQUE KEY `idbeneficio_UNIQUE` (`idbeneficio`);

--
-- Indices de la tabla `boleto`
--
ALTER TABLE `boleto`
  ADD PRIMARY KEY (`idBoleto`),
  ADD UNIQUE KEY `idBoleto_UNIQUE` (`idBoleto`),
  ADD KEY `fk_viaje_boleto` (`idViaje`),
  ADD KEY `fk_transporte_boleto` (`idTransporte`),
  ADD KEY `fk_linea_boleto` (`idLinea`),
  ADD KEY `fk_estacion_boleto` (`idEstacion`),
  ADD KEY `fk_tarifa_boleto_idx` (`idTarifa`),
  ADD KEY `fk_ramal_boleto_idx` (`idRamal`);

--
-- Indices de la tabla `descuento`
--
ALTER TABLE `descuento`
  ADD PRIMARY KEY (`idDescuento`),
  ADD UNIQUE KEY `idDescuento_UNIQUE` (`idDescuento`);

--
-- Indices de la tabla `estacion`
--
ALTER TABLE `estacion`
  ADD PRIMARY KEY (`idEstacion`),
  ADD KEY `fk_linea2` (`idLinea`);

--
-- Indices de la tabla `linea`
--
ALTER TABLE `linea`
  ADD PRIMARY KEY (`idLinea`),
  ADD KEY `fk_transporte` (`idTransporte`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`idMovimiento`),
  ADD UNIQUE KEY `idMovimiento_UNIQUE` (`idMovimiento`),
  ADD KEY `fk_movimiento_tarjeta_idx` (`idTarjeta`),
  ADD KEY `fk_movimiento_tipo_idx` (`idTipoMovimiento`);

--
-- Indices de la tabla `ramal`
--
ALTER TABLE `ramal`
  ADD PRIMARY KEY (`idRamal`),
  ADD KEY `fk_linea` (`idLinea`);

--
-- Indices de la tabla `ramal_tiene_estacion`
--
ALTER TABLE `ramal_tiene_estacion`
  ADD PRIMARY KEY (`idRelacion`),
  ADD UNIQUE KEY `idRelacion_UNIQUE` (`idRelacion`),
  ADD KEY `fk_ramal_idx` (`idRamal`),
  ADD KEY `fk_estacion_idx` (`idEstacion`),
  ADD KEY `fk_idramal_idx` (`idRamal`),
  ADD KEY `fk_idestacion_idx` (`idEstacion`);

--
-- Indices de la tabla `red_sube`
--
ALTER TABLE `red_sube`
  ADD PRIMARY KEY (`idRedSube`);

--
-- Indices de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`idTarifa`),
  ADD UNIQUE KEY `idtarifa_UNIQUE` (`idTarifa`),
  ADD KEY `fk_transporte_idx` (`idTransporte`);

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
-- Indices de la tabla `usuario_tiene_beneficio`
--
ALTER TABLE `usuario_tiene_beneficio`
  ADD PRIMARY KEY (`idRelacion`),
  ADD UNIQUE KEY `idusuario_tiene_beneficio_UNIQUE` (`idRelacion`),
  ADD KEY `fk_usuario_utb_idx` (`idUsuario`),
  ADD KEY `fk_beneficio_utb_idx` (`idBeneficio`);

--
-- Indices de la tabla `usuario_tiene_descuento`
--
ALTER TABLE `usuario_tiene_descuento`
  ADD PRIMARY KEY (`idRelacion`),
  ADD UNIQUE KEY `idusuario_tiene_descuento_UNIQUE` (`idRelacion`);

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
-- AUTO_INCREMENT de la tabla `beneficio`
--
ALTER TABLE `beneficio`
  MODIFY `idbeneficio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `boleto`
--
ALTER TABLE `boleto`
  MODIFY `idBoleto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `descuento`
--
ALTER TABLE `descuento`
  MODIFY `idDescuento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `estacion`
--
ALTER TABLE `estacion`
  MODIFY `idEstacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `linea`
--
ALTER TABLE `linea`
  MODIFY `idLinea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `idMovimiento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ramal`
--
ALTER TABLE `ramal`
  MODIFY `idRamal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `ramal_tiene_estacion`
--
ALTER TABLE `ramal_tiene_estacion`
  MODIFY `idRelacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `red_sube`
--
ALTER TABLE `red_sube`
  MODIFY `idRedSube` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  MODIFY `idTarifa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `idTarjeta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

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
-- AUTO_INCREMENT de la tabla `usuario_tiene_beneficio`
--
ALTER TABLE `usuario_tiene_beneficio`
  MODIFY `idRelacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario_tiene_descuento`
--
ALTER TABLE `usuario_tiene_descuento`
  MODIFY `idRelacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `viaje`
--
ALTER TABLE `viaje`
  MODIFY `idViaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `boleto`
--
ALTER TABLE `boleto`
  ADD CONSTRAINT `fk_estacion_boleto` FOREIGN KEY (`idEstacion`) REFERENCES `estacion` (`idEstacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_linea_boleto` FOREIGN KEY (`idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ramal_boleto` FOREIGN KEY (`idRamal`) REFERENCES `ramal` (`idRamal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tarifa_boleto` FOREIGN KEY (`idTarifa`) REFERENCES `tarifa` (`idTarifa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_transporte_boleto` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_viaje_boleto` FOREIGN KEY (`idViaje`) REFERENCES `viaje` (`idViaje`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `estacion`
--
ALTER TABLE `estacion`
  ADD CONSTRAINT `fk_linea2` FOREIGN KEY (`idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `linea`
--
ALTER TABLE `linea`
  ADD CONSTRAINT `fk_transporte` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `fk_movimiento_tarjeta` FOREIGN KEY (`idTarjeta`) REFERENCES `tarjeta` (`idTarjeta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ramal`
--
ALTER TABLE `ramal`
  ADD CONSTRAINT `fk_linea` FOREIGN KEY (`idLinea`) REFERENCES `linea` (`idLinea`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ramal_tiene_estacion`
--
ALTER TABLE `ramal_tiene_estacion`
  ADD CONSTRAINT `fk_idestacion` FOREIGN KEY (`idEstacion`) REFERENCES `estacion` (`idEstacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idramal` FOREIGN KEY (`idRamal`) REFERENCES `ramal` (`idRamal`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD CONSTRAINT `fk_transporte_tarifa` FOREIGN KEY (`idTransporte`) REFERENCES `transporte` (`idTransporte`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario_tiene_beneficio`
--
ALTER TABLE `usuario_tiene_beneficio`
  ADD CONSTRAINT `fk_beneficio_utb` FOREIGN KEY (`idBeneficio`) REFERENCES `beneficio` (`idbeneficio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_utb` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD CONSTRAINT `fk_tarjeta_viaje` FOREIGN KEY (`idTarjeta`) REFERENCES `tarjeta` (`idTarjeta`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
