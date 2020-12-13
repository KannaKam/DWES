<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión de empleados</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style>
	body {
		background-image: url(fondo.png);
		background-repeat: no-repeat;
		text-align: center;
		color: white;
	}
	p{
		margin-top:20%;
		font-size: 500%;
		color: #2e5d94;
	}
		
</style>
</head>
<body>
	<div>
		<div class="container">
            <p>Gestión de nóminas</p>   
        </div>
           <a href="/NominasV2/ServletEmpleado?action=mostrar">Consulta</a>
	</div>
</body>
</html>