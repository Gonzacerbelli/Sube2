-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: sube2migration
-- Source Schemata: sube2
-- Created: Fri Jun  1 21:34:51 2018
-- Workbench Version: 6.3.10
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema sube2migration
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `sube2migration` ;
CREATE SCHEMA IF NOT EXISTS `sube2migration` ;

-- ----------------------------------------------------------------------------
-- Table sube2migration.boleto
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`boleto` (
  `idBoleto` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaHora` DATETIME NOT NULL,
  `cerrado` TINYINT(4) NOT NULL,
  `precioFinal` DOUBLE NOT NULL,
  `idViaje` INT(11) NOT NULL,
  `idTransporte` INT(11) NOT NULL,
  `idLinea` INT(11) NOT NULL,
  `idRamal` INT(11) NULL DEFAULT NULL,
  `idEstacion` INT(11) NOT NULL,
  PRIMARY KEY (`idBoleto`),
  UNIQUE INDEX `idBoleto_UNIQUE` (`idBoleto` ASC),
  INDEX `fk_viaje_boleto` (`idViaje` ASC),
  INDEX `fk_transporte_boleto` (`idTransporte` ASC),
  INDEX `fk_linea_boleto` (`idLinea` ASC),
  INDEX `fk_ramal_boleto` (`idRamal` ASC),
  INDEX `fk_estacion_boleto` (`idEstacion` ASC),
  CONSTRAINT `fk_estacion_boleto`
    FOREIGN KEY (`idEstacion`)
    REFERENCES `sube2migration`.`estacion` (`idEstacion`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_linea_boleto`
    FOREIGN KEY (`idLinea`)
    REFERENCES `sube2migration`.`linea` (`idLinea`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ramal_boleto`
    FOREIGN KEY (`idRamal`)
    REFERENCES `sube2migration`.`ramal` (`idRamal`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_transporte_boleto`
    FOREIGN KEY (`idTransporte`)
    REFERENCES `sube2migration`.`transporte` (`idTransporte`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_viaje_boleto`
    FOREIGN KEY (`idViaje`)
    REFERENCES `sube2migration`.`viaje` (`idViaje`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table sube2migration.estacion
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`estacion` (
  `idEstacion` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idLinea` INT(11) NOT NULL,
  PRIMARY KEY (`idEstacion`),
  INDEX `fk_linea2` (`idLinea` ASC),
  CONSTRAINT `fk_linea2`
    FOREIGN KEY (`idLinea`)
    REFERENCES `sube2migration`.`linea` (`idLinea`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 70
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table sube2migration.linea
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`linea` (
  `idLinea` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idTransporte` INT(11) NOT NULL,
  PRIMARY KEY (`idLinea`),
  INDEX `fk_transporte` (`idTransporte` ASC),
  CONSTRAINT `fk_transporte`
    FOREIGN KEY (`idTransporte`)
    REFERENCES `sube2migration`.`transporte` (`idTransporte`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table sube2migration.ramal
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`ramal` (
  `idRamal` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idLinea` INT(11) NOT NULL,
  PRIMARY KEY (`idRamal`),
  INDEX `fk_linea` (`idLinea` ASC),
  CONSTRAINT `fk_linea`
    FOREIGN KEY (`idLinea`)
    REFERENCES `sube2migration`.`linea` (`idLinea`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table sube2migration.ramal_tiene_estacion
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`ramal_tiene_estacion` (
  `idRelacion` INT(11) NOT NULL AUTO_INCREMENT,
  `idRamal` INT(11) NOT NULL,
  `idEstacion` INT(11) NOT NULL,
  `nroEstacion` INT(11) NOT NULL,
  PRIMARY KEY (`idRelacion`),
  UNIQUE INDEX `idRelacion_UNIQUE` (`idRelacion` ASC),
  INDEX `fk_ramal_idx` (`idRamal` ASC),
  INDEX `fk_estacion_idx` (`idEstacion` ASC),
  INDEX `fk_idramal_idx` (`idRamal` ASC),
  INDEX `fk_idestacion_idx` (`idEstacion` ASC),
  CONSTRAINT `fk_idestacion`
    FOREIGN KEY (`idEstacion`)
    REFERENCES `sube2migration`.`estacion` (`idEstacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idramal`
    FOREIGN KEY (`idRamal`)
    REFERENCES `sube2migration`.`ramal` (`idRamal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.seccion
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`seccion` (
  `idSeccion` INT(11) NOT NULL AUTO_INCREMENT,
  `nroSeccion` INT(11) NOT NULL,
  `idTransporte` INT(11) NOT NULL,
  `precio` DOUBLE NOT NULL,
  PRIMARY KEY (`idSeccion`),
  INDEX `fk_transporte_seccion` (`idTransporte` ASC),
  CONSTRAINT `fk_transporte_seccion`
    FOREIGN KEY (`idTransporte`)
    REFERENCES `sube2migration`.`transporte` (`idTransporte`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table sube2migration.tarjeta
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`tarjeta` (
  `idTarjeta` INT(11) NOT NULL AUTO_INCREMENT,
  `numTarjeta` INT(16) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  `activa` BIT(1) NOT NULL,
  `idUsuario` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idTarjeta`),
  UNIQUE INDEX `idTarjeta_UNIQUE` (`idTarjeta` ASC),
  UNIQUE INDEX `numTarjeta_UNIQUE` (`numTarjeta` ASC),
  INDEX `fk_usuario_tarjeta` (`idUsuario` ASC),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `sube2migration`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.transporte
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`transporte` (
  `idTransporte` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idTransporte`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table sube2migration.usuario
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT(8) NOT NULL,
  `pass` VARCHAR(8) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `tarifaSocial` TINYINT(4) NOT NULL,
  `estudiantil` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.viaje
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`viaje` (
  `idViaje` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaHora` DATETIME NOT NULL,
  `idTarjeta` INT(11) NOT NULL,
  PRIMARY KEY (`idViaje`),
  INDEX `fk_tarjeta_viaje` (`idTarjeta` ASC),
  CONSTRAINT `fk_tarjeta_viaje`
    FOREIGN KEY (`idTarjeta`)
    REFERENCES `sube2migration`.`tarjeta` (`idTarjeta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;
