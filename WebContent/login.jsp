<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SUBE - Sistema �nico de Boleto Electr�nico</title>
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
				url: "/Sube/Login",
				data: {"dni" : $('#inputDni').val(), "pass" : $('#inputPass').val()},
				async: true,
				success: function (data) {
	            	if(data=='True'){
						window.location = "home.jsp";
					}else{
						$('#divError').html(data);
					}
				}
			});//fin ajax
			
		});//fin click btnIngresa
		
	});//fin ready

</script>

</head>
<body>
	<div class="container">
	<form class="form-signin" method="POST" action="/Sube/Login">
      <h1 class="h3 mb-3 font-weight-normal">Iniciar sesi�n</h1>
      <input type="number" id="inputDni" class="form-control" placeholder="DNI" required autofocus>
      <input type="password" id="inputPass" class="form-control" placeholder="Contrase�a" required>
      <button class="btn btn-lg btn-primary btn-block" id="btnIngresa" type="button">Ingres�</button>
      <div id="divError" style="margin-top:30px;text-align:center; width:100%;color:red;height:20px;"></div>
      <p class="mt-5 mb-3 text-muted">&copy; 2018</p>
    </form>
    </div>
</body>
</html>