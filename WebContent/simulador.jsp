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
	 
	  <div class="container" style="margin-top:3%;margin-left:20%;width:60%;padding-left:15%;">
	  
		  <h2>Simulador</h2>

		  <div class="row" style="margin-top:35px;">
		  
		  	<div class="col-4">
		  		<div class="form-group">
				    <label for="exampleSelect1">Transporte</label>
				    <select class="form-control" id="selectTransporte">
				      <option>Colectivo</option>
				      <option>Subte</option>
				      <option>Tren</option>
				    </select>
				</div>
		  	</div>
		  	<div class="col-4">
		  		<div class="form-group">
				    <label for="exampleSelect1">Línea</label>
				    <select class="form-control" id="selectLinea">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </select>
				</div>
		  	</div>
		  
		  </div>
		  <div class="row">
		  
		  	<div class="col-4">
		  		<div class="form-group">
				    <label for="exampleSelect1">Ramal</label>
				    <select class="form-control" id="selectRamal">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </select>
				</div>
		  	</div>
		  	<div class="col-4">
		  		<div class="form-group">
				    <label for="exampleSelect1">Estación</label>
				    <select class="form-control" id="selectEstacion">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </select>
				  </div>
		  	</div>
		  
		  </div>
		  <div class="row">
		  
		  	<div class="col-4">
		  		<div class="form-group">
				    <label for="exampleSelect1">Tarifa</label>
				    <select class="form-control" id="selectTarifa">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </select>
			  	</div>
		  	</div>
		  	<div class="col-4">
				<div class="form-group">
				    <label class="control-label" for="inputFechaHora">Fecha y hora</label>
				    <input id="inputFechaHora" name="inputFechaHora" type="date" class="form-control" style="width:100%;">
				</div>
		  	</div>
		  
		  </div>
		  
		  <div class="row">
		  	<a href="home.jsp"><button type="button" class="btn btn-primary" style="margin-left:15px;clear:left;">Atrás</button></a>
		  	<button type="button" class="btn btn-primary" style="float:right;">Viajar</button>
		  </div>
	  </div>
	</form>
	

</body>
</html>