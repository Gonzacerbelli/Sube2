<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/sube.css">
</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>

	<form class="form-horizontal">
	<fieldset>
	
	<!-- Form Name -->
	<legend>Simulador</legend>
	
	<!-- Select Basic -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="selectTransporte">Transporte</label>
	  <div class="col-md-4">
	    <select id="selectTransporte" name="selectTransporte" class="form-control">
	    </select>
	  </div>
	</div>
	
	<!-- Select Basic -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="selectLinea">Línea</label>
	  <div class="col-md-4">
	    <select id="selectLinea" name="selectLinea" class="form-control">
	    </select>
	  </div>
	</div>
	
	<!-- Select Basic -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="selectRamal">Ramal</label>
	  <div class="col-md-4">
	    <select id="selectRamal" name="selectRamal" class="form-control">
	    </select>
	  </div>
	</div>
	
	<!-- Select Basic -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="selectEstacion">Estacion</label>
	  <div class="col-md-4">
	    <select id="selectEstacion" name="selectEstacion" class="form-control">
	    </select>
	  </div>
	</div>
	
	<!-- Select Basic -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="selectTarifa">Tarifa</label>
	  <div class="col-md-4">
	    <select id="selectTarifa" name="selectTarifa" class="form-control">
	    </select>
	  </div>
	</div>
	
	<!-- Text input-->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="inputFechaHora">Fecha y hora</label>  
	  <div class="col-md-4">
	  <input id="inputFechaHora" name="inputFechaHora" type="date" placeholder="" class="form-control input-md">
	    
	  </div>
	</div>
	
	<!-- Button -->
	<div class="form-group">
	  <label class="col-md-4 control-label" for="buttonApoyarTarjeta"></label>
	  <div class="col-md-4">
	    <button id="buttonApoyarTarjeta" name="buttonApoyarTarjeta" class="btn btn-primary">Viajar</button>
	  </div>
	</div>
	
	</fieldset>
	</form>
	

</body>
</html>