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
							//ocultar elementos home
							$('#carga').hide();
							$('#row1').html(objRecarga());
						}else if(obj.permiso == 'Usuario'){
							//ocultar elementos home
							$('#carga').hide();
							$('#row1').html(objMovimientos()+' '+objSimulador()+' '+objTerminal());
						}else if(obj.permiso == 'Administrador'){
							//ocultar carga
							$('#carga').hide();
							$('#row1').html(objMovimientos()+' '+objSimulador()+' '+objTerminal());
							$('#row2').html(objReportes()+' '+objRecarga());
						}
					}
				}
			});//fin ajax
		}//fin function
		
		controlarUsuario();
		
	});//fin ready

</script>

</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>
	
	<div class="container" style="margin-top:100px;">
      <div class="row">
		
		  <div class="container" style="height:100px;margin-bottom:100px;">
		  
		  	<h1 class="h2">Terminal de consultas</h1>
		  
            <table class="tablaTarjeta">
	            <tr style="font-size:14pt;">
	            	<td>
	            		<span>Tarjeta</span>
	            	</td>
	            	<td style="text-align:center;">
	            		<span>Saldo</span>
	            	</td>
	            	<td>
	            		<span>Tarifa Social Federal</span>
	            	</td>
	            </tr>
	            <tr class="border-top">
	            	<td>
	            		<input id="inputTarjeta" name="inputTarjeta" type="number" class="form-control" style="width:100%;">
	            	</td>
	            	<td style="text-align:center;">
	            		<span>$ -11,65<br>al 29/03/2018 21:29</span>
	            	</td>
	            	<td>
	            		<input id="inputTarifaSocial" type="button" class="form-control btn-primary" style="width:100%;" value="Solicitar">
	            	</td>
	            </tr>
            </table>
          </div>
          
      </div>
      
       <div class="row" style="margin-bottom:50px;">
			<div class="col-8 container border" id="divMensaje" style="height:150px;text-align:center;font-size:18pt;">
				<p style="line-height:150px;height:100%;"></p>
		 	</div>
	   </div>
      
    </div>
    
   
	
	
	<footer class="container border-topr">
        <p class="float-right"><a href="home.jsp">Volver atrás</a></p>
        <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
	
</body>
</html>