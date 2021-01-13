<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Gestion de Empleados</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: lightyellow;
}

a, input {
	border-radius: 3px;
	box-shadow: 7px 7px 10px 0 rgba(0, 0, 0, 0.3);
}

h3 {
	border-radius: 5px;
}
</style>
</head>
<body>

	<div
		class="container bg-dark text-light p-4 col-12 d-flex justify-content-between align-items-center">
		<h2>
			<s:authentication property="principal.username" />
		</h2>
		<a class="btn btn-primary" href="paginaPrincipal">Volver</a>
	</div>
	<div
		class="d-flex justify-content-center align-items-center flex-column mt-5">
		<f:form class="d-flex align-items-center" action="sueldo"
			method="POST">
			<input type="submit" class="btn btn-success text-light"
				value="Buscar sueldo:" />
			<input type="text" placeholder="Introduce el dni" name="dni"
				class="form-control ml-3" />
		</f:form>
		<div class="d-flex flex-column mt-3">
			<c:if test="${nombre != null && sueldo != null}">
				<table class="table table-striped table-dark overflow-auto">
					<thead class="thead-light text-dark modal-body">
						<tr class="lead text-center">
							<th>Nombre</th>
							<th>Sueldo</th>
						</tr>
					</thead>
					<tbody>
						<tr class="lead text-center">
							<td>${nombre}</td>
							<td>${sueldo}</td>
						</tr>
					</tbody>
				</table>
			</c:if>
		</div>
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
