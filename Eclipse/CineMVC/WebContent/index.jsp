<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Gestión películas</title>
</head>
<body>
	<div>
		<div class="container">
            <p>Gestión de películas</p>   
        </div>
        <div class="container">
           <a href="/CineMVC/ServletPelicula?action=mostrar" class="btn">Info</a>
           <a href="/CineMVC/ServletPelicula?action=form" class="btn">Buscar por director</a>
           <a href="/CineMVC/ServletPelicula?action=login" class="btn">Login</a>
	</div>
</body>
</html>