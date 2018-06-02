REM Workbench Table Data copy script
REM Workbench Version: 6.3.10
REM 
REM Execute this to copy table data from a source RDBMS to MySQL.
REM Edit the options below to customize it. You will need to provide passwords, at least.
REM 
REM Source DB: Mysql@127.0.0.1:3306 (MySQL)
REM Target DB: Mysql@127.0.0.1:3306


@ECHO OFF
REM Source and target DB passwords
set arg_source_password=
set arg_target_password=

IF [%arg_source_password%] == [] (
    IF [%arg_target_password%] == [] (
        ECHO WARNING: Both source and target RDBMSes passwords are empty. You should edit this file to set them.
    )
)
set arg_worker_count=2
REM Uncomment the following options according to your needs

REM Whether target tables should be truncated before copy
REM set arg_truncate_target=--truncate-target
REM Enable debugging output
REM set arg_debug_output=--log-level=debug3


REM Creation of file with table definitions for copytable

set table_file="%TMP%\wb_tables_to_migrate.txt"
TYPE NUL > "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`boleto`	`sube2migration`	`boleto`	`idBoleto`	`idBoleto`	`idBoleto`, `fechaHora`, `cerrado`, `precioFinal`, `idViaje`, `idTransporte`, `idLinea`, `idRamal`, `idEstacion` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`ramal`	`sube2migration`	`ramal`	`idRamal`	`idRamal`	`idRamal`, `nombre`, `idLinea` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`estacion`	`sube2migration`	`estacion`	`idEstacion`	`idEstacion`	`idEstacion`, `nombre`, `idLinea` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`tarjeta`	`sube2migration`	`tarjeta`	`idTarjeta`	`idTarjeta`	`idTarjeta`, `numTarjeta`, `saldo`, `activa`, `idUsuario` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`ramal_tiene_estacion`	`sube2migration`	`ramal_tiene_estacion`	`idRelacion`	`idRelacion`	`idRelacion`, `idRamal`, `idEstacion`, `nroEstacion` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`usuario`	`sube2migration`	`usuario`	`idUsuario`	`idUsuario`	`idUsuario`, `nombre`, `apellido`, `dni`, `pass`, `email`, `tarifaSocial`, `estudiantil` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`viaje`	`sube2migration`	`viaje`	`idViaje`	`idViaje`	`idViaje`, `fechaHora`, `idTarjeta` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`linea`	`sube2migration`	`linea`	`idLinea`	`idLinea`	`idLinea`, `nombre`, `idTransporte` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`seccion`	`sube2migration`	`seccion`	`idSeccion`	`idSeccion`	`idSeccion`, `nroSeccion`, `idTransporte`, `precio` >> "%TMP%\wb_tables_to_migrate.txt"
ECHO `sube2`	`transporte`	`sube2migration`	`transporte`	`idTransporte`	`idTransporte`	`idTransporte`, `nombre` >> "%TMP%\wb_tables_to_migrate.txt"


wbcopytables.exe ^
 --mysql-source="root@127.0.0.1:3306" ^
 --target="root@127.0.0.1:3306" ^
 --source-password="%arg_source_password%" ^
 --target-password="%arg_target_password%" ^
 --table-file="%table_file%" --thread-count=%arg_worker_count% ^
 %arg_truncate_target% ^
 %arg_debug_output%

REM Removes the file with the table definitions
DEL "%TMP%\wb_tables_to_migrate.txt"


