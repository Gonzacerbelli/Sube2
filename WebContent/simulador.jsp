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
		
		function controlarUsuario(){
			$.ajax({
				method:"POST",
				url: "/Sube/Usuario",
				data: {"accion" : "verificarUsuario"},
				async: true,
				success: function (data) {
					if(data == '' || data == 'null'){
						window.location = 'login.jsp';
					}else{
						var obj = JSON.parse(data);
		            	if(obj.permiso == '' || obj.permiso == null){
							window.location = 'login.jsp';
						}else if(obj.permiso == 'Empleado'){
							window.location = 'home.jsp';
						}
					}
				}
			});//fin ajax
		}//fin function
		
		controlarUsuario();
		
		
		cargarTransportes();

		$(document).on('change','#selectTransporte',function(){
			cargarLineas();
			cargarTarifas();
		});

		$(document).on('change','#selectLinea',function(){
			if($('#selectLinea').val() != ""){
				cargarRamales();
				cargarEstacionesLinea();
			}
		});//fin change

		$(document).on('change','#selectTarifa',function(){
			if($(this).val() == ""){
				$('#divMensaje').html('<p style="line-height:150px;height:100%;">Indique su destino.</p>');
			}else{
				$('#divMensaje').html('<p style="line-height:75px;height:100%;">Tarifa a cobrar: ' + $(this).val() + '.<br>Apoye su tarjeta.</p>');
			}
		});

		$(document).on('change','#selectRamal',function(){
			if($('#selectRamal').val() != ""){
				cargarEstacionesRamal()
			}
		});//fin change

		$(document).on('click','#btnViajar',function(){
			viajar();
		});
		
		
		
		
		/*FUNIONES*/
		
		function cargarTransportes(){
			//cargar lista de transportes
			$.ajax({
				method:"POST",
				url: "/Sube/Simulador",
				data: {"accion" : "traerTransportes"},
				async: false,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					$('#selectTransporte').find('option').remove();
					$('#selectTransporte').append('<option></option>');
					for (var i = 0; i < obj.transportes.length; i++) {
						$('#selectTransporte').append('<option id="'+ obj.transportes[i].idTransporte +'">'+obj.transportes[i].nombre+'</option>');
					}
					if(obj.transportes.length > 0)
					{
						$('#selectTransporte').removeAttr("disabled");
					}
					else
					{
						$('#selectTransporte').prop('disabled','disabled');
					}
					
				}
			});//fin ajax
		}
		
		function cargarTarifas(){
			//cargo lista de tarifas
			$.ajax({
				method:"POST",
				url: "/Sube/Simulador",
				data: {"accion" : "traerTarifas", "idTransporte" : $('#selectTransporte :selected').attr('id')},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					$('#selectTarifa').find('option').remove();
					$('#selectTarifa').append('<option></option>');
					for (var i = 0; i < obj.tarifas.length; i++) {
						$('#selectTarifa').append('<option id="'+ obj.tarifas[i].idTarifa +'">'+obj.tarifas[i].monto+'</option>');
					}
					if(obj.tarifas.length > 0)
					{
						$('#selectTarifa').removeAttr("disabled");
					}
					else
					{
						$('#selectTarifa').prop('disabled','disabled');
					}
				}
			});//fin ajax
		}//fin cargarTarifas
		
		function cargarLineas(){
			//cargo lista de lineas
			desactivarRamales();
			desactivarEstaciones();
			$.ajax({
				method:"POST",
				url: "/Sube/Simulador",
				data: {"accion" : "traerLineas", "idTransporte" : $('#selectTransporte :selected').attr('id')},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					$('#selectLinea').find('option').remove();
					$('#selectLinea').append('<option></option>');
					for (var i = 0; i < obj.lineas.length; i++) {
						$('#selectLinea').append('<option id="'+ obj.lineas[i].idLinea +'">'+obj.lineas[i].nombre+'</option>');
					}
					if(obj.lineas.length > 0)
					{
						$('#selectLinea').removeAttr("disabled");
					}
					else
					{
						$('#selectLinea').prop('disabled','disabled');
					}
				}
			});//fin ajax
		}//fin cargarLineas
		
		function cargarRamales(){
			//cargo lista de ramales
			desactivarEstaciones();
			$.ajax({
				method:"POST",
				url: "/Sube/Simulador",
				data: {"accion" : "traerRamales", "idLinea" : $('#selectLinea :selected').attr('id')},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					$('#selectRamal').find('option').remove();
					$('#selectRamal').append('<option></option>');
					for (var i = 0; i < obj.ramales.length; i++) {
						$('#selectRamal').append('<option id="'+ obj.ramales[i].idRamal +'">'+obj.ramales[i].nombre+'</option>');
					}
					if(obj.ramales.length > 0)
					{
						$('#selectRamal').removeAttr("disabled");
					}
					else
					{
						$('#selectRamal').prop('disabled','disabled');
					}
					
				}
			});//fin ajax
		}//fin cargarRamales
		
		function cargarEstacionesLinea(){
			//cargo lista de estaciones
			$.ajax({
				method:"POST",
				url: "/Sube/Simulador",
				data: {"accion" : "traerEstacionesLinea", "idLinea" : $('#selectLinea :selected').attr('id')},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					$('#selectEstacion').find('option').remove();
					$('#selectEstacion').append('<option></option>');
					for (var i = 0; i < obj.estaciones.length; i++) {
						$('#selectEstacion').append('<option id="'+ obj.estaciones[i].idEstacion +'">'+obj.estaciones[i].nombre+'</option>');
					}
					if(obj.estaciones.length > 0)
					{
						$('#selectEstacion').removeAttr("disabled");
					}
					else
					{
						$('#selectEstacion').prop('disabled','disabled');
					}
					
				}
			});//fin ajax
		}//fin cargarEstacionesLinea
		
		
		function cargarEstacionesRamal(){
			console.log($('#selectRamal :selected').attr('id'));
			//cargo lista de estaciones
			$.ajax({
				method:"POST",
				url: "/Sube/Simulador",
				data: {"accion" : "traerEstacionesRamal", "idRamal" : $('#selectRamal :selected').attr('id')},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					$('#selectEstacion').find('option').remove();
					$('#selectEstacion').append('<option></option>');
					for (var i = 0; i < obj.estaciones.length; i++) {
						$('#selectEstacion').append('<option id="'+ obj.estaciones[i].idEstacion +'">'+obj.estaciones[i].nombre+'</option>');
					}
					if(obj.estaciones.length > 0)
					{
						$('#selectEstacion').removeAttr("disabled");
					}
					else
					{
						$('#selectEstacion').prop('disabled','disabled');
					}
					
				}
			});//fin ajax
		}//fin cargarEstacionesRamal

		function desactivarTarifas()
		{
			$('#selectTarifa').prop('disabled','disabled');
		}

		function desactivarLineas()
		{
			$('#selectLinea').prop('disabled','disabled');
		}

		function desactivarRamales()
		{
			$('#selectRamal').prop('disabled','disabled');
		}

		function desactivarEstaciones()
		{
			$('#selectEstacion').prop('disabled','disabled');
		}
		
		function viajar(){
			//paso los datos seleccionados a la accion viajar
			$.ajax({
				method:"POST",
				url: "/Sube/Simulador",
				data: {"accion" : "viajar",
						"idTransporte" : $('#selectTransporte :selected').attr('id'),
					 	"idLinea" : $('#selectLinea :selected').attr('id'),
					   	"idEstacion" : $('#selectEstacion :selected').attr('id'),
					    "idRamal" : $('#selectRamal :selected').attr('id'),
					    "idTarifa" : $('#selectTarifa :selected').attr('id'),
					    "fechaHora" : $('#inputFechaHora').val(),
					    },
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					if(obj.status == "error") 
					{
						$('#divMensaje').html('<p style="color:red">'+ obj.mensaje +'</p>');
					}
					if(obj.status == "ok")
					{
						$('#divMensaje').html('<p style="color:green">'+ obj.mensaje+'</p>');
						$('#divMensaje').append('<p style="color:green"> Cobrado: '+ obj.valorCobrado+'</p>');
						$('#divMensaje').append('<p style="color:green"> Saldo: '+ obj.saldo+'</p>');
					}
				}
			});//fin ajax
		}//fin viajar
		
		
		
	});//fin ready

</script>

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
		            		<span>Fecha y hora</span>
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
		            		<input id="inputFechaHora" name="inputFechaHora" type="datetime-local" class="form-control" style="width:100%;">
		            		
		            	</td>
		            	<td style="padding-right:30px;">
		            		<select class="form-control" id="selectTransporte">
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
		  		<button type="button" id="btnViajar" class="btn btn-primary" style="float:right;margin-right:30px;">Viajar</button>
		  	</div>
		  </div>
		  
		  
		  <div class="row" style="margin-bottom:100px;">
		  	<div class="col-8 container border" id="divMensaje" style="height:150px;text-align:center;font-size:18pt;">
		  		<p style="line-height:150px;height:100%;">Indique su destino.</p>
		  	</div>
		  </div>
		  
	  </div>
	</form>
	
	<footer class="container border-top">
      <p class="float-right"><a href="home.jsp">Volver atrás</a></p>
      <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
	

</body>
</html>