<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
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
		
		h3, a {
		border-radius: 3px;
		box-shadow: 7px 7px 10px 0 rgba(0, 0, 0, 0.3);
		}
	</style>
</head>
<body>
	<div class="container bg-dark text-light p-4 col-12 d-flex justify-content-between align-items-center">
		<h2><s:authentication property="principal.username"/></h2>
		<a class="btn btn-primary" href="paginaPrincipal">Volver</a>
	</div>

	<div class="container pt-5">
	<s:authorize access="hasAnyRole('MANAGER','ADMIN')">
	<a href="formulario" class="btn btn-success btn-lg mt-5 mb-3">Insertar</a>	
	</s:authorize>
	
		<table class="table table-striped table-dark overflow-auto">
			<thead class="thead-light text-dark modal-body">
				<tr class="lead text-center">
					<th>Nombre</th>
					<th>Dni</th>
					<th>Sexo</th>
					<th>Categoria</th>
					<th>Antiguedad</th>
					<s:authorize access="hasAnyRole('MANAGER','ADMIN')">
					<th>Actualizar</th>
					</s:authorize>
					<s:authorize access="hasRole('ADMIN')">
					<th>Eliminar</th>
					</s:authorize>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="empleado" items="${empleados}">

					<c:url var="actualizar" value="actualizar">
						<c:param name="empleadoId" value="${empleado.id}"></c:param>
					</c:url>

					<c:url var="eliminar" value="eliminar">
						<c:param name="empleadoId" value="${empleado.id}"></c:param>
					</c:url>

					<tr class="lead text-center">
						<td>${empleado.nombre}</td>
						<td>${empleado.dni}</td>
						<td>${empleado.sexo}</td>
						<td>${empleado.categoria}</td>
						<td>${empleado.antiguedad}</td>
						<s:authorize access="hasAnyRole('MANAGER','ADMIN')">
						<td><a href="${actualizar}" class="btn btn-warning">Actualizar</a></td>
						</s:authorize>
						<s:authorize access="hasRole('ADMIN')">
						<td><a href="${eliminar}" class="btn btn-danger" onclick="if (!(confirm('¿Seguro que quieres eliminar a ${empleado.nombre}?'))) return false">Eliminar</a></td>
						</s:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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