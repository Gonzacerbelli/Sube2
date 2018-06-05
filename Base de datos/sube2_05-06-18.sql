-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: sube2migration
-- Source Schemata: sube2
-- Created: Tue Jun  5 10:45:43 2018
-- Workbench Version: 6.3.10
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema sube2migration
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `sube2migration` ;
CREATE SCHEMA IF NOT EXISTS `sube2migration` ;

-- ----------------------------------------------------------------------------
-- Table sube2migration.beneficio
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`beneficio` (
  `idbeneficio` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idbeneficio`),
  UNIQUE INDEX `idbeneficio_UNIQUE` (`idbeneficio` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.boleto
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`boleto` (
  `idBoleto` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaHora` DATETIME NOT NULL,
  `precioFinal` DOUBLE NOT NULL,
  `idViaje` INT(11) NOT NULL,
  `idTransporte` INT(11) NOT NULL,
  `idLinea` INT(11) NOT NULL,
  `idEstacion` INT(11) NULL DEFAULT NULL,
  `idTarifa` INT(11) NOT NULL,
  `idRamal` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idBoleto`),
  UNIQUE INDEX `idBoleto_UNIQUE` (`idBoleto` ASC),
  INDEX `fk_viaje_boleto` (`idViaje` ASC),
  INDEX `fk_transporte_boleto` (`idTransporte` ASC),
  INDEX `fk_linea_boleto` (`idLinea` ASC),
  INDEX `fk_estacion_boleto` (`idEstacion` ASC),
  INDEX `fk_tarifa_boleto_idx` (`idTarifa` ASC),
  INDEX `fk_ramal_boleto_idx` (`idRamal` ASC),
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
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarifa_boleto`
    FOREIGN KEY (`idTarifa`)
    REFERENCES `sube2migration`.`tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
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
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

-- ----------------------------------------------------------------------------
-- Table sube2migration.descuento
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`descuento` (
  `idDescuento` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `porcentaje` FLOAT NOT NULL,
  PRIMARY KEY (`idDescuento`),
  UNIQUE INDEX `idDescuento_UNIQUE` (`idDescuento` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

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
-- Table sube2migration.movimiento
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`movimiento` (
  `idMovimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `idTipoMovimiento` INT(11) NOT NULL,
  `detalle` VARCHAR(45) NULL DEFAULT NULL,
  `fechaHora` DATE NOT NULL,
  `valor` DOUBLE NOT NULL,
  `idTarjeta` INT(11) NOT NULL,
  PRIMARY KEY (`idMovimiento`),
  UNIQUE INDEX `idMovimiento_UNIQUE` (`idMovimiento` ASC),
  INDEX `fk_movimiento_tarjeta_idx` (`idTarjeta` ASC),
  INDEX `fk_movimiento_tipo_idx` (`idTipoMovimiento` ASC),
  CONSTRAINT `fk_movimiento_tarjeta`
    FOREIGN KEY (`idTarjeta`)
    REFERENCES `sube2migration`.`tarjeta` (`idTarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimiento_tipo`
    FOREIGN KEY (`idTipoMovimiento`)
    REFERENCES `sube2migration`.`tipomovimiento` ()
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

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
-- Table sube2migration.red_sube
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`red_sube` (
  `idRedSube` INT(11) NOT NULL,
  `numeroDescuento` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `porcentaje` FLOAT NOT NULL,
  PRIMARY KEY (`idRedSube`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.tarifa
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`tarifa` (
  `idTarifa` INT(11) NOT NULL AUTO_INCREMENT,
  `idTransporte` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `cantEstaciones` INT(11) NULL DEFAULT NULL,
  `monto` DOUBLE NOT NULL,
  PRIMARY KEY (`idTarifa`),
  UNIQUE INDEX `idtarifa_UNIQUE` (`idTarifa` ASC),
  INDEX `fk_transporte_idx` (`idTransporte` ASC),
  CONSTRAINT `fk_transporte_tarifa`
    FOREIGN KEY (`idTransporte`)
    REFERENCES `sube2migration`.`transporte` (`idTransporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

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
-- Table sube2migration.tipomovimiento
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`tipomovimiento` (
  `idTipoMovimiento` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoMovimiento`),
  UNIQUE INDEX `idtipoMovimiento_UNIQUE` (`idTipoMovimiento` ASC))
ENGINE = InnoDB
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
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.usuario_tiene_beneficio
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`usuario_tiene_beneficio` (
  `idRelacion` INT(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` INT(11) NOT NULL,
  `idBeneficio` INT(11) NOT NULL,
  `fechaCobro` DATE NULL DEFAULT NULL,
  `fechaAsignado` DATE NOT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`idRelacion`),
  UNIQUE INDEX `idusuario_tiene_beneficio_UNIQUE` (`idRelacion` ASC),
  INDEX `fk_usuario_utb_idx` (`idUsuario` ASC),
  INDEX `fk_beneficio_utb_idx` (`idBeneficio` ASC),
  CONSTRAINT `fk_beneficio_utb`
    FOREIGN KEY (`idBeneficio`)
    REFERENCES `sube2migration`.`beneficio` (`idbeneficio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_utb`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `sube2migration`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.usuario_tiene_descuento
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`usuario_tiene_descuento` (
  `idRelacion` INT(11) NOT NULL AUTO_INCREMENT,
  `idUsuario` INT(11) NOT NULL,
  `idDescuento` INT(11) NOT NULL,
  `activo` BIT(1) NOT NULL,
  `fechaAsignado` DATE NOT NULL,
  PRIMARY KEY (`idRelacion`),
  UNIQUE INDEX `idusuario_tiene_descuento_UNIQUE` (`idRelacion` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

-- ----------------------------------------------------------------------------
-- Table sube2migration.viaje
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `sube2migration`.`viaje` (
  `idViaje` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaHora` DATETIME NOT NULL,
  `idTarjeta` INT(11) NOT NULL,
  `cantBoletos` INT(11) NOT NULL,
  PRIMARY KEY (`idViaje`),
  INDEX `fk_tarjeta_viaje` (`idTarjeta` ASC),
  CONSTRAINT `fk_tarjeta_viaje`
    FOREIGN KEY (`idTarjeta`)
    REFERENCES `sube2migration`.`tarjeta` (`idTarjeta`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;
SET FOREIGN_KEY_CHECKS = 1;
