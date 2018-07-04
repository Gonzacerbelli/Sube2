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
	
	var materialBarras,barrasOptions,dataBarras;
	var dataTorta,optionsTorta,chartTorta;
	
	function graficoTorta() {
		dataTorta = new google.visualization.DataTable();
		dataTorta.addColumn('string', 'Transporte');
		dataTorta.addColumn('number', 'Cantidad');
	
	  optionsTorta = {
	    pieHole: 0.4,
	    chartArea: {left:0,top:10,width:'100%',height:'90%'},
	    legend: 'labeled'
	  };
	
	  chartTorta = new google.visualization.PieChart(document.getElementById('grafico1'));
	  chartTorta.draw(dataTorta, optionsTorta);
	}
	
	function graficoBarras() {
		
		dataBarras = new google.visualization.DataTable();
		dataBarras.addColumn('string', '');
		dataBarras.addColumn('number', 'Cantidad');
		
		barrasOptions = {
			legend: {position: 'none'},
		    bars: 'horizontal'
		};
		materialBarras = new google.charts.Bar(document.getElementById('grafico2'));
		materialBarras.draw(dataBarras, barrasOptions);
	}

	$(document).ready(function(){
		
		cargarTarjetas();
		setTimeout(function(){$('#btnReporte').trigger('click');},1500);


		$(document).on('click','#btnReporte',function(){
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
					"accion" : "traerTarjetaActiva"
					},
				async: true,
				processData: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					if(obj.status=="ok")
					{
						$('#numTarjeta').val(obj.tarjetas);
					}
					if(obj.status=="error")
					{

					}
					
				}
			});//fin ajax
		}//fin cargarTarjetas

		
		function cargarMovimientos(){
			//traigo transportes grafico torta
			var promise = $.ajax({
				method:"POST",
				url: "/Sube/Movimientos",
				data: {
					"accion" : "traerCantidadTransporte",
					"numTarjeta" : $('#numTarjeta').val(), 
					"fechaDesde" : $('#fechaDesde').val(),
					"fechaHasta" : $('#fechaHasta').val(),
					"tipo" : $('#inputTipo').val(),
					"medio" : $('#inputMedio').val()
					},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					if(obj.status=="ok")
					{
						dataTorta = new google.visualization.DataTable();
						dataTorta.addColumn('string', 'Transporte');
						dataTorta.addColumn('number', 'Cantidad');
						
						dataTorta.addRow(["Colectivo",Number(obj.colectivo)]);
						dataTorta.addRow(["Subte",Number(obj.subte)]);
						dataTorta.addRow(["Tren",Number(obj.tren)]);
						chartTorta.draw(dataTorta, optionsTorta);
					}
					if(obj.status=="error")
					{
						$('#bodyTableMovimientos').html('<p>'+ obj.error + '</p>');
					}
				}
			});//fin transportes grafico torta
			
			
			//traigo lineas grafico barra
			promise.then(function(){
				$.ajax({
					method:"POST",
					url: "/Sube/Movimientos",
					data: {
						"accion" : "traerCantidadMedios",
						"numTarjeta" : $('#numTarjeta').val(), 
						"fechaDesde" : $('#fechaDesde').val(),
						"fechaHasta" : $('#fechaHasta').val(),
						"tipo" : $('#inputTipo').val(),
						"medio" : $('#inputMedio').val()
						},
					async: true,
					success: function (data) {
						var obj = JSON.parse(data);
						console.log(obj);
						if(obj.status=="ok")
						{
							dataBarras = new google.visualization.DataTable();
							dataBarras.addColumn('string', '');
							dataBarras.addColumn('number', 'Cantidad');
							
							for (var j = 0; j < Object.keys(obj).length; j++) {
								if(Object.keys(obj)[j].toString() != "status"){
									dataBarras.addRow( [Object.keys(obj)[j].toString(), Number( obj[Object.keys(obj)[j].toString()] )] );
								}
							}
							materialBarras.draw(dataBarras, barrasOptions);
						}
						if(obj.status=="error")
						{
							$('#bodyTableMovimientos').html('<p>'+ obj.error + '</p>');
						}
					}
				});//fin transportes grafico torta
			});
		}//fin cargarMovimientos
		/*
		function cargarInputs(){
			//cargo opciones de selects
			$.ajax({
				method:"POST",
				url: "/Sube/Movimientos",
				data: {
					"accion" : "traerSelects",
					"numTarjeta" : $('#numTarjeta').val(), 
					"fechaDesde" : $('#fechaDesde').val(),
					"fechaHasta" : $('#fechaHasta').val()
					},
				async: true,
				success: function (data) {
					var obj = JSON.parse(data);
					console.log(obj);
					if(obj.status=="ok")
					{
						$('#tipoMovimiento > option').remove();
						for (var i = 0; i < obj.tipoMovimientos.length; i++) {
							$('#tipoMovimiento').append('<option>'+obj.tipoMovimientos[i]+'</option>');
						}
					}
					if(obj.status=="error")
					{
						
					}
					
				}
			});//fin ajax
		}//fin cargar inputs
		*/
		
	});//fin ready

</script>

</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>
	
	<div class="container" style="margin-top:100px;">
      <div class="row">
		
          <div class="container" style="height:100px;margin-bottom:100px;">
          	<h1 class="h2">Reportes</h1>
          	<input type="hidden" id="numTarjeta">
            <table class="tablaMovimientos">
	            <tr style="font-size:14pt;">
	            	<td style="width:25%;">
	            		<span>Fecha desde</span>
	            	</td>
	            	<td style="width:25%;">
	            		<span>Fecha hasta</span>
	            	</td>
	            	<td style="width:25%;">
	            		<span>Tipo de Movimiento</span>
	            	</td>
	            	<td style="width:12.5%;">
	            	</td>
	            	<td style="width:12.5%;">
	            	</td>
	            </tr>
	            <tr class="border-top">
	            	<td style="width:25%;padding-right:30px;">
	            		<input id="fechaDesde" type="date" class="form-control">
	            	</td>
	            	<td style="width:25%;padding-right:30px;">
	            		<input id="fechaHasta" type="date" class="form-control">
	            	</td>
	            	<td style="width:25%;padding-right:30px;">
	            		<select id="tipoMovimiento" class="form-control">
	            			<option>Uso de Transporte</option>
	            		</select>
	            	</td>
	            	<td style="width:25%;text-align:right;">
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
      
    </div>
	
	
	<footer class="container border-top" style="margin-top:100px;">
        <p class="float-right"><a href="home.jsp">Volver atrás</a></p>
        <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
    </footer>
	
</body>
</html>