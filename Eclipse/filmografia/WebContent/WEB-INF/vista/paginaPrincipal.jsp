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
	.container{
	display: block;
		margin-top: 10%;
		text-align:center;
	}
</style>
<title>Filmografía</title>
</head>
<body>
<div class="container">
	<h1>Página principal</h1>
	<c:set var="admin" value="${logged}" /> <!-- This same as your request attribute -->
		<c:choose>
    		<c:when test="${logged == false}">
      	  		<a href="logout" class="btn btn-success">Logout</a>
   		 	</c:when>
   		 <c:otherwise>
      		  <a href="login" class="btn btn-success">Login</a>
    	</c:otherwise>      
</c:choose>
	<a href="info" class="btn btn-warning">Info</a>
	<a href="director" class="btn btn-danger">Búsqueda por director</a>
	<c:set var="admin" value="${logged}" /> <!-- This same as your request attribute -->
		<c:choose>
    		<c:when test="${logged == true}">
      	  		<a href="formulario" class="btn btn-success">Añadir pelicula</a>
   		 	</c:when>
   		 <c:otherwise>
      		  <a href="formulario" class="btn btn-success" style="display:none">Añadir pelicula</a>
    	</c:otherwise>      
</c:choose>
	
	</div>
</body>
</html>