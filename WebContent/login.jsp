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
<link href="css/signin.css" rel="stylesheet">

<script src="js/jquery-3.3.1.js"></script>

<script type="text/javascript">

	$(document).ready(function(){
			
		$(document).on('click','#btnIngresa', function(){
			
			$.ajax({
				method:"POST",
				url: "Login",
				data: {"dni" : $('#inputDni').val(), "pass" : $('#inputPass').val()},
				async: false
			}).done(function(data){
				//hacer algo
				console.log(data);
			});
			
		});
		
	});//fin ready

</script>

</head>
<body>
	<div class="container">
	<form class="form-signin" action="/Sube/Login" method="GET">
      <img class="mb-4" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Iniciar sesión</h1>
      <label class="sr-only">DNI</label>
      <input type="number" id="inputDni" class="form-control" placeholder="DNI" required autofocus>
      <label id="inputPass" class="sr-only">Contraseña</label>
      <input type="password" id="inputContrasena" class="form-control" placeholder="Contraseña" required>
      <button class="btn btn-lg btn-primary btn-block" id="btnIngresa" type="submit">Ingresá</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
    </form>
    </div>
</body>
</html>