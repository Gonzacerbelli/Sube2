<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet" href="css/sube.css">

<title>SUBE - Sistema �nico de Boleto Electr�nico</title>

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
					console.log("a");
					if(data == '' || data == 'null'){
						window.location = 'login.jsp';
					}else{
						var obj = JSON.parse(data);
						console.log(obj);
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
		
		function objMovimientos(){
			return '<div class="col-lg-4"><a href="movimientos.jsp" style="text-decoration:none;"><img class="rounded-circle" src="images/movimientos.png" alt="Generic placeholder image" width="140" height="140"></a><h2>Movimientos</h2></div>';
		}
		
		function objReportes(){
			return '<div class="col-lg-4"><a href="reporte.jsp" style="text-decoration:none;"><img class="rounded-circle" src="images/reportes.png" alt="Generic placeholder image" width="140" height="140"></a><h2>Reportes</h2></div>';
		}
		
		function objSimulador(){
			return '<div class="col-lg-4"><a href="simulador.jsp" style="text-decoration:none;"><img class="rounded-circle" src="images/simulador.png" alt="Generic placeholder image" width="140" height="140"></a><h2>Simulador</h2></div>';
		}
		
		function objTerminal(){
			return '<div class="col-lg-4"><a href="terminal.jsp" style="text-decoration:none;"><img class="rounded-circle" src="images/terminal_consulta.png" alt="Generic placeholder image" width="140" height="140"></a><h2>Terminal de<br>consultas</h2></div>';
		}
		
		function objRecarga(){
			return '<div class="col-lg-4"><a href="recargar.jsp" style="text-decoration:none;"><img class="rounded-circle" src="images/recarga.png" alt="Generic placeholder image" width="140" height="140"></a><h2>Recarga</h2></div>';
		}
		
		
	});//fin ready

</script>

</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>
	<!-- 
	<div id="carga" style="position:absolute;background-color:#000;opacity:1;top:0;left:0;right:0;bottom:0;z-index:9999;">
		<div style="width:150px;height:150px;position:relative;left:50%;top:50%;margin:-50px 0 0 -50px;background: url(images/carga.gif) no-repeat center 0;"></div>
	</div>
	 -->
    <main role="main">

      <div class="container marketing" style="text-align:center;">
      
      <hr class="featurette-divider">

        <!-- Three columns of text below the carousel -->
        <div id="row1" class="row" style="margin-top:60px;">
        </div>
        <br><br>
        <div id="row2" class="row">
        </div><!-- /.row -->

		<hr class="featurette-divider">

      </div><!-- /.container -->


      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"><a href="index.jsp">Salir</a></p>
        <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
    </main>

</body>
</html>