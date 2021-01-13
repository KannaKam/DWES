<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Access Denied</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
		<style type="text/css">
		body {
		background-color: lightyellow;
		}
		a {
		border-radius: 3px;
		box-shadow: 7px 7px 10px 0 rgba(0, 0, 0, 0.3);
		}
	</style>
</head>
<body>

	<div
		class="container bg-dark text-light p-4 col-12 d-flex justify-content-between align-items-center">
		<h2>Error: Accesso Denegado</h2>
	</div>
	
	<br>
	<div class="container">
	<h5>El usuario '<s:authentication property="principal.username"/>' no tiene permitido el acceso a esta funcionalidad.</h5>
	<br>
	<h5>Le recodamos que su rol/roles es/son: <s:authentication property="principal.authorities"/></h5>
	
	<hr>
	
	<a class="btn btn-dark" href="paginaPrincipal">Pagina principal</a>
	
	</div>

</body>
</html>