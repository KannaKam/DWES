<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de empleados</title>
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
		
		input {
			box-shadow: 5px 5px 10px 0 rgba(0, 0, 0, 0.3);
		}
		
		.error {
			color: red;
		}
	</style>
</head>
<body>
	<div class="container bg-dark text-light p-4 col-12 d-flex justify-content-between align-items-center">
		<h2>Gestion de empleados</h2>
		<a class="btn btn-primary" href="lista">Volver</a>
	</div>
	
	<div class="container pt-5">
		<f:form class="pt-3" action="guardarEmpleado"
			modelAttribute="empleado" method="POST">
			
			<f:hidden path="id" />
			<f:hidden path="nomina.dni"/>
			
			<div class="form-group d-flex flex-column">
				<label>Nombre:</label>
				<div class="d-flex align-items-center">
				<f:input class="ml-3 mr-3" path="nombre"></f:input>
				<f:errors path="nombre" cssClass="error"></f:errors>				
				</div>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Dni:</label>
				<div class="d-flex align-items-center">
				<f:input class="ml-3 mr-3" path="dni"></f:input>
				<f:errors path="dni" cssClass="error"></f:errors>				
				</div>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Sexo:</label>
				<div class="d-flex align-items-center">
				<f:input class="ml-3 mr-3" path="sexo"></f:input>
				<f:errors path="sexo" cssClass="error"></f:errors>				
				</div>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Categoria:</label>
				<div class="d-flex align-items-center">
				<f:input class="ml-3 mr-3" path="categoria"></f:input>
				<f:errors path="categoria" cssClass="error"></f:errors>				
				</div>
			</div>
			<div class="form-group d-flex flex-column">
				<label>Antiguedad:</label>
				<div class="d-flex align-items-center">
				<f:input class="ml-3 mr-3" path="antiguedad"></f:input>
				<f:errors path="antiguedad" cssClass="error"></f:errors>				
				</div>
			</div>

			<input class="btn btn-success mt-3" type="submit" value="Guardar empleado">

		</f:form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>