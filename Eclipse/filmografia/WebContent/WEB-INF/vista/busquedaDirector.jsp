<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	.thead{
		color: #fff;
		background-color:#2e5d94;
	}
	.btn{
		color: #fff;
		background-color:#2e5d94;
		border: 0px;
	}
</style>
<title>Filmograf�a</title>
</head>
<body>
                    <div class="container card col-md-5 justify-content-center">
                    	<form action="lista" method="GET">
                   		 <div class="container">
                   		 <br>
                   		 <h3>Director</h3>
                    		<input type="text" placeholder="Introduce el nombre del director" name="director" class="form-control" required="required" />
                   			<br>
                   			<input type="submit" class="btn btn-warning" value="Mostrar peliculas" />
                   			<br>
                   			<br>
                   		 </div>
						</form>
						 <div>
					</div>
                    
	</div>
</body>
</html>