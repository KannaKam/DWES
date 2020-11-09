<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	}
</style>
<title>Busqueda por director</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-dark">
                <a href="./index.jsp"><img src="back.png"></a>
                </nav>
	<form method="post" action="/CineMVC/ServletPelicula?action=buscar">
	<div class="container">
		Introduzca el nombre y apellido del director.
		<p><input type="text" name="director" class="form-control" required="required"></p>
		<p><input type="submit" value="Buscar películas" class="btn"></p>
	</div>
	</form>
</body>
</html>