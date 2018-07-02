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

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">

	google.charts.load("current", {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(graficoTorta);
	google.charts.setOnLoadCallback(graficoBarras);
	google.charts.setOnLoadCallback(graficoLinea);
	
	function graficoTorta() {
	  var data = google.visualization.arrayToDataTable([
	    ['Task', 'Hours per Day'],
	    ['Work',     11],
	    ['Eat',      2],
	    ['Commute',  2],
	    ['Watch TV', 2],
	    ['Sleep',    7]
	  ]);
	
	  var options = {
	    pieHole: 0.4,
	    chartArea: {left:0,top:10,width:'100%',height:'90%'},
	    legend: 'labeled'
	  };
	
	  var chart = new google.visualization.PieChart(document.getElementById('grafico1'));
	  chart.draw(data, options);
	}
	
	function graficoBarras() {
		/*
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Transporte');
		data.addColumn('number', 'Cantidad');
		
		for (var i = 0; i < obj.length; i++) {
			data.addRow( [Object.keys(obj[i]).toString()], Number( r[i] [Objects.keys(r[i]).toString()] ) );
		}
		*/
		
		 var data = google.visualization.arrayToDataTable([
		    ['', 'Cantidad'],
		    ['Línea 51', 15],
		    ['Roca', 5],
		    ['Línea A', 1],
		    ['Línea 160', 12],
			['Línea 79', 8]
		]);
		
		var materialOptions = {
			legend: {position: 'none'},
		    bars: 'horizontal'
		};
		var materialChart = new google.charts.Bar(document.getElementById('grafico2'));
		materialChart.draw(data, materialOptions);
	}
	
	function graficoLinea() {
		var data = google.visualization.arrayToDataTable([
	      ['Year', 'Sales', 'Expenses'],
	      ['2004',  1000,      400],
	      ['2005',  1170,      460],
	      ['2006',  660,       1120],
	      ['2007',  1030,      540]
	    ]);

	    var options = {
	      legend: {position: 'none'},
	      chartArea: {left:45,top:30,width:'100%',height:'60%'},
	    };

	    var chart = new google.visualization.LineChart(document.getElementById('grafico3'));

	    chart.draw(data, options);
	}

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
          	<h1 class="h2">Reportes</h1>
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
	            		<select id="tipoMovimiento" class="form-control">
	            			<option>Uso de transporte</option>
	            			<option>Carga</option>
	            			<option>RED SUBE 1</option>
	            		</select>
	            	</td>
	            	<td style="width:20%;padding-right:30px;">
	            		<select id="medio" class="form-control">
	            			<option>Uso de transporte</option>
	            			<option>Carga</option>
	            			<option>RED SUBE 1</option>
	            		</select>
	            	</td>
	            	<td style="width:20%;text-align:right;">
	            		<input type="button" class="btn btn-primary" id="btnReporte" value="Reporte">
	            	</td>
	            </tr>
            </table>
          </div>
          
      </div>
      
      
      <div class="row border-bottom" style="margin-bottom:20px;">
        <div class="col-6" id="tituloGrafico1" style="font-size:14pt;">Transporte</div>
        <div class="col-6" id="tituloGrafico2" style="font-size:14pt;padding-left:50px;">Medio</div>
      </div>
      
      <div class="row" style="margin-bottom:100px;">
      	<div class="col-6 grafico" id="grafico1" style="height:350px;padding-right:50px;"></div>
        <div class="col-6 grafico" id="grafico2" style="height:350px;padding-left:50px;"></div>
      </div>
      
      <div class="row border-bottom" style="margin-bottom:20px;">
        <div class="col-12" id="tituloGrafico1" style="font-size:14pt;">Gasto</div>
      </div>
      
      <div class="row">
      	<div class="col-12 grafico" id="grafico3" style="height:350px;"></div>
      </div>
      
    </div>
	
	
	<footer class="container border-top" style="margin-top:100px;">
        <p class="float-right"><a href="home.jsp">Volver atrás</a></p>
        <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
	
</body>
</html>