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

		/*
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
	            	if(obj.permiso == '' || obj.permiso == null){n
						window.location = 'login.jsp';
					}else if(obj.permiso == 'Empleado'){
						window.location = 'home.jsp';
					}
				}
			}
		});//fin ajax
	}//fin function
	
	controlarUsuario();
	
		*/
		
		cargarTarjetas();
		cargarSaldoFecha();
		cargarMovimientos();

		$(document).on('change','#selectTarjetas',function(){
			if($('#selectTarjeta').val() != ""){
				$('#btnBuscar').removeAttr("disabled");
				cargarSaldoFecha();
			}
			else{
				$('#btnBuscar').prop("disabled","disabled");
			}
		});//fin change

		$(document).on('click','#btnBuscar',function(){
			if($('#selectTarjeta').val() != ""){
				cargarMovimientos();
			}
			
		});//fin change


		function cargarTarjetas(){
			//paso los datos seleccionados a la accion viajar
			$.ajax({
				method:"POST",
				url: "/Sube/Movimientos",
				data: {
					"accion" : "traerTarjetas"
					},
				async: true,
				processData: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					if(obj.status=="ok")
					{
						for (var i = 0; i < obj.tarjetas.length; i++) {
							$('#selectTarjetas').append('<option id="' + obj.tarjetas[i] + '">' + obj.tarjetas[i] + '</option>');
						}
					}
					if(obj.status=="error")
					{

					}
					
				}
			});//fin ajax
		}//fin cargarTarjetas

		
		function cargarMovimientos(){
			//paso los datos seleccionados a la accion viajar
			$.ajax({
				method:"POST",
				url: "/Sube/Movimientos",
				data: {
					"accion" : "traerMovimientos",
					"numTarjeta" : $('#selectTarjetas :selected').attr('id'), 
					"fechaDesde" : $('#inputFechaDesde').val(),
					"fechaHasta" : $('#inputFechaHasta').val(),
					"tipo" : $('#inputTipo').val(),
					"medio" : $('#inputMedio').val()
					},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					if(obj.status=="ok")
					{
						$('#bodyTableMovimientos').html(' ');
						for (var i = 0; i < obj.movimientos.length; i++) {
							$('#bodyTableMovimientos').append('<tr id="registro'+i+'"></tr>');
							
							$('#registro' + i).append('<td>'+ obj.movimientos[i].fechaHora + '</td>');
							$('#registro' + i).append('<td>'+ obj.movimientos[i].tipo + '</td>');
							$('#registro' + i).append('<td>'+ obj.movimientos[i].medio + '</td>');
							$('#registro' + i).append('<td>'+ obj.movimientos[i].detalle + '</td>');
							$('#registro' + i).append('<td>'+ obj.movimientos[i].valor + '</td>');
						}
					}
					if(obj.status=="error")
					{
						$('#bodyTableMovimientos').html('<p>'+ obj.error + '</p>');
					}
					
					
				}
			});//fin ajax
		}//fin cargarMovimientos

		function cargarSaldoFecha(){
			//paso los datos seleccionados a la accion viajar
			$.ajax({
				method:"POST",
				url: "/Sube/Movimientos",
				data: {
					"accion" : "traerSaldoFecha",
					"numTarjeta" : $('#selectTarjetas :selected').val()
					},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					if(obj.status=="ok")
					{
						$('#spanSaldoFecha').html('<td> $ ' + obj.saldo + '<br> al ' + obj.fechaHora + '</td>');
					}
					if(obj.status=="error")
					{
						$('#spanSaldoFecha').html('<td>' + ' ? ' + '</td>'); //TODO que hacer si no se encuentra el saldo
					}
					
					
				}
			});//fin ajax
		}//fin cargarSaldoFecha

		
		
		
	});//fin ready

</script>

</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>
	
	<div class="container" style="margin-top:100px;">
      <div class="row">
		
		  <div class="container" style="height:100px;margin-bottom:100px;">
		  
		  	<h1 class="h2">Administrar tarjeta</h1>
		  
            <table class="tablaTarjeta">
	            <tr style="font-size:14pt;">
	            	<td>
	            		<span>Tarjeta</span>
	            	</td>
	            	<td style="text-align:center;">
	            		<span>Saldo</span>
	            	</td>
	            	<td>
	            		<span>Dar de baja por:</span>
	            	</td>
	            </tr>
	            <tr class="border-top">
	            	<td>
	            		<select id="selectTarjetas" class="form-control"><option></option></select>
	            	</td>
	            	<td style="text-align:center;">
	            		<span id="spanSaldoFecha"></span>
	            	</td>
	            	<td>
	            		<select class="form-control">
	            			<option>Pérdida</option>
	            			<option>Robo</option>
	            			<option>Rotura</option>
	            		</select>
	            	</td>
	            </tr>
            </table>
          </div>
          
          <div class="container" style="height:100px;margin-bottom:60px;">
          	
          	<h1 class="h2">Movimientos</h1>
            
            <table class="tablaMovimientos">
	            <tr style="font-size:14pt;">
	            	<td style="width:20%;">
	            		<span>Fecha desde</span>
	            	</td>
	            	<td style="width:20%;">
	            		<span>Fecha hasta</span>
	            	</td>
	            	<td style="width:20%;">
	            		<span>Tipo de Movimiento</span>
	            	</td>
	            	<td style="width:20%;">
	            		<span>Medio</span>
	            	</td>
	            	<td style="width:10%;">
	            	</td>
	            	<td style="width:10%;">
	            	</td>
	            </tr>
	            <tr class="border-top">
	            	<td style="width:20%;padding-right:30px;">
	            		<input id="fechaDesde" type="date" class="form-control">
	            	</td>
	            	<td style="width:20%;padding-right:30px;">
	            		<input id="fechaHasta" type="date" class="form-control">
	            	</td>
	            	<td style="width:20%;padding-right:30px;">
	            		<input class="form-control" id="inputTipo">
	            	</td>
	            	<td style="width:20%;padding-right:30px;">
	            		<input class="form-control" id="inputMedio">
	            	</td>
	            	<td style="width:10%;text-align:center;">
	            		<input type="button" class="btn btn-primary" id="btnBuscar" value="&nbsp;Buscar&nbsp;">
	            	</td>
	            </tr>
            </table>
          </div>
          
		
          <div class="table-responsive container" style="overflow:auto;height:500px;margin-bottom:100px;">
            <table class="table table-striped table-sm">
              <thead>
                <tr>
                  <th>Fecha y Hora</th>
                  <th>Tipo</th>
                  <th>Medio</th>
                  <th>Detalle</th>
                  <th>Valor</th>
                </tr>
              </thead>
              <tbody id="bodyTableMovimientos">
			  </tbody>
            </table>
          </div>
      </div>
    </div>
	
	
	<footer class="container border-top">
        <p class="float-right"><a href="home.jsp">Volver atrás</a></p>
        <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
	
</body>
</html>