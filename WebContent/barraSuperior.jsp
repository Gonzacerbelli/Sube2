<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<script src="js/jquery-3.3.1.js"></script>

	<script type="text/javascript">
	
		$(document).ready(function(){
			
			if(window.location.href != "http://localhost:8080/Sube/"){
				$('.ingresaBarraSuperior').hide();
			}
							
			
		});//fin ready
	
	</script>

	<header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark" style="heigth:80px;">
      	<div class="container" style="display:block;">
      		<img class="logoSube" src="images/logo_sube.png">
      	
        	<a class="btn btn-primary ingresaBarraSuperior" href="login.jsp" role="button">Ingresá</a></p>
         
         </div>
          
      </nav>
    </header>
    
    <br><br>