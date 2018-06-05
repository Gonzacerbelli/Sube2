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


      <div class="container marketing">
      
      <hr class="featurette-divider">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4">
          	<a href="administrar.jsp" style="text-decoration:none;">
            	<img class="rounded-circle" src="data:;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            </a>
            <h2>Administrar <br>tarjetas</h2>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <a href="recargar.jsp" style="text-decoration:none;">
            	<img class="rounded-circle" src="data:;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            </a>
            <h2>Recarga</h2>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <a href="reportes.jsp" style="text-decoration:none;">
            	<img class="rounded-circle" src="data:;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            </a>
            <h2>Reportes</h2>
          </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->
        <br><br>
        <div class="row">
          <div class="col-lg-4">
            <a href="simulador.jsp" style="text-decoration:none;">
            	<img class="rounded-circle" src="data:;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            </a>
            <h2>Simulador</h2>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <a href="terminal.jsp" style="text-decoration:none;">
            	<img class="rounded-circle" src="data:;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="Generic placeholder image" width="140" height="140">
            </a>
            <h2>Terminal de<br>consultas</h2>
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