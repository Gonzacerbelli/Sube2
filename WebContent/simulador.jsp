<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUBE - Sistema Único de Boleto Electrónico</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/sube.css">
</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>

	
	
	<form>
	 
	  <div class="container" style="margin-top:100px;">

		  <div class="row" style="margin-top:35px;font-size:14pt;">
		  
			  <div class="container" style="height:100px;margin-bottom:50px;">
			  
			  	<h1 class="h2">Simulador</h1>
			  
	            <table class="tablaTarjeta">
		            <tr style="font-size:14pt;">
		            	<td>
		            		<span>Transporte</span>
		            	</td>
		            	<td>
		            		<span>Línea</span>
		            	</td>
		            	<td>
		            		<span>Ramal</span>
		            	</td>
		            </tr>
		            <tr>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectTransporte">
						      <option>Colectivo</option>
						      <option>Subte</option>
						      <option>Tren</option>
						    </select>
		            	</td>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectLinea">
						      <option>1</option>
						      <option>2</option>
						      <option>3</option>
						      <option>4</option>
						      <option>5</option>
						    </select>
		            	</td>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectRamal">
						      <option>1</option>
						      <option>2</option>
						      <option>3</option>
						      <option>4</option>
						      <option>5</option>
						    </select>
		            	</td>
		            </tr>
	            </table>
	          </div>
		  
		  </div>
		  <div class="row">
		  
		 	 <div class="container" style="height:100px;margin-bottom:20px;">
			  
	            <table class="tablaTarjeta">
		            <tr style="font-size:14pt;">
		            	<td>
		            		<span>Estación</span>
		            	</td>
		            	<td>
		            		<span>Tarifa</span>
		            	</td>
		            	<td>
		            		<span>Fecha y hora</span>
		            	</td>
		            </tr>
		            <tr>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectEstacion">
						      <option>1</option>
						      <option>2</option>
						      <option>3</option>
						      <option>4</option>
						      <option>5</option>
						    </select>
		            	</td>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectTarifa">
						      <option>1</option>
						      <option>2</option>
						      <option>3</option>
						      <option>4</option>
						      <option>5</option>
						    </select>
		            	</td>
		            	<td style="padding-right:30px;">
		            		<input id="inputFechaHora" name="inputFechaHora" type="date" class="form-control" style="width:100%;">
		            	</td>
		            </tr>
	            </table>
	          </div>
		  
		  	
		  
		  </div>
		  
		  <div class="row">
		  	<div class="col-6">
		  		<a href="home.jsp"><button type="button" class="btn btn-primary">Atrás</button></a>
		  	</div>
		  	<div class="col-6">
		  		<button type="button" class="btn btn-primary" style="float:right;margin-right:30px;">Viajar</button>
		  	</div>
		  </div>
	  </div>
	</form>
	

</body>
</html>