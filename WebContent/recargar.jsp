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

<script src="js/jquery-3.3.1.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		
	});//fin ready

</script>

</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>

	 <div class="container" style="margin-top:100px;">

		  <div class="row" style="margin-top:35px;font-size:14pt;">
		  
			  <div class="container" style="height:100px;margin-bottom:50px;">
			  
			  	<h1 class="h2">Recarga</h1>
			  
	            <table class="tablaTarjeta">
		            <tr style="font-size:14pt;">
		            	<td>
		            		<span>Tarjeta</span>
		            	</td>
		            	<td>
		            		<span>Transporte</span>
		            	</td>
		            	<td>
		            		
		            		<span>Tarifa</span>
		            	</td>
		            </tr>
		            <tr>
		            	<td style="padding-right:30px;">
		            		<input id="inputTarjeta" name="inputTarjeta" type="number" class="form-control" style="width:100%;">
		            		
		            	</td>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectTransporte">
		            		  <option></option>
						      <option>Colectivo</option>
						      <option>Subte</option>
						      <option>Tren</option>
						    </select>
		            	</td>
		            	<td style="padding-right:30px;">
						    <select class="form-control" id="selectTarifa" disabled>
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
		            		<span id="camposLinea">Línea</span>
		            	</td>
		            	<td>
		            		<span id="camposRamal">Ramal</span>
		            	</td>
		            	<td>
		            		<span id="camposEstacion">Estación</span>
		            	</td>
		            </tr>
		            <tr>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectLinea" disabled>
		            		</select>
		            	</td>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectRamal" disabled>
		            		</select>
		            	</td>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectEstacion" disabled>
		            		</select>
		            	</td>
		            </tr>
	            </table>
	          </div>
		  
		  	
		  
		  </div>
		  
		  <div class="row" style="margin-bottom:20px;">
		  	<div class="col-6">
		  		<a href="home.jsp"><button type="button" class="btn btn-primary">Atrás</button></a>
		  	</div>
		  	<div class="col-6">
		  		<button type="button" class="btn btn-primary" style="float:right;margin-right:30px;">Viajar</button>
		  	</div>
		  </div>
		  
		  
		  <div class="row">
		  	<div class="col-8 container border" id="divMensaje" style="height:150px;text-align:center;font-size:18pt;">
		  		<p style="line-height:150px;height:100%;">Indique su destino.</p>
		  	</div>
		  </div>
		  
	  </div>

</body>
</html>