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

<title>SUBE - Sistema Único de Boleto Electrónico</title>

<script src="js/jquery-3.3.1.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
		
		
		
		
		
	});//fin ready

</script>

</head>
<body>

	<%@ include file="/barraSuperior.jsp"%>

    <main role="main">

      <div id="myCarousel" class="carousel slide" data-ride="carousel">
	        <div class="carousel-inner">
	          <div class="carousel-item active">
	          <div class="subeHomeOpaco">
		            <img style="width:100%; height:600px;" src="images/sube_home.jpg" >
		            <div class="container">
		              <div class="carousel-caption text-left">
		                <h1>SUBE</h1>
		                <p>Viajar en el país es cada vez más fácil y accesible.</p>
		                <p><a class="btn btn-lg btn-primary" href="login.jsp" role="button">Ingresá</a></p>
		              </div>
		            </div>
	            </div>
	          </div>
	        </div>
      </div>
		

      <!-- Marketing messaging and featurettes
      ================================================== -->
      <!-- Wrap the rest of the page in another container to center all the content. -->
      
      
      

      <div class="container marketing">
      
      <hr class="featurette-divider">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4">
            <img class="rounded-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            <h2>Tarifa Social</h2>
            <p>En abril de 2016 incorporamos la Tarifa Social Federal, con un descuento de 55% en viajes de trenes y colectivos, para ayudar a quienes más lo necesitan en todo el país.</p>
            <p><a class="btn btn-secondary" href="#" role="button">Ver más &raquo;</a></p>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            <h2>Conseguila</h2>
            <p>Comprá tu tarjeta y usala para viajar en colectivos, trenes y subtes. Además, podés abonar peajes en las autopistas del Área Metropolitana de Buenos Aires (AMBA).</p>
            <p><a class="btn btn-secondary" href="#" role="button">Ver más &raquo;</a></p>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            <h2>Cargala</h2>
            <p>Podés cargarle saldo a tu tarjeta en forma electrónica o presencial.</p><br><br>
            <p><a class="btn btn-secondary" href="#" role="button">Ver más &raquo;</a></p>
          </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->

		<hr class="featurette-divider">

      </div><!-- /.container -->


      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"><a href="#">Volver arriba</a></p>
        <p>&copy; 2018 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
    </main>

</body>
</html>