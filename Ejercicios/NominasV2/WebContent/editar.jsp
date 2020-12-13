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
<title>Editar empleado</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark">
                <a href="/NominasV2/ServletEmpleado?action=form"><img src="back.png"></a>
                </nav>
<div class="container card col-md-5 justify-content-center">
	<h1 class="text-center">Editar empleado</h1>
	<form method="post" action="/NominasV2/ServletEmpleado?action=submit">
	<div class="container">
		<fieldset class="form-group">
			<label>Nombre</label>
			<input type="text"
			value="<c:out value='${empleado.nombre}' />" class="form-control"
			name="nombre" required="required"
			>
		</fieldset>
		<fieldset class="form-group">
			<label>DNI</label>
			<input readonly type="text"
			value="<c:out value='${empleado.dni}' />" class="form-control"
			name="dni" required="required"
			>
		</fieldset>
		<fieldset class="form-group">
			<label>Sexo</label>
			<input pattern="[HM]{1}" type="text"
			value="<c:out value='${empleado.sexo}' />" class="form-control"
			name="sexo" required="required"
			>
		</fieldset>
		<fieldset class="form-group">
			<label>Categoría</label>
			<input pattern="^(?:[1-9]|0[1-9]|10)$" type="text"
			value="<c:out value='${empleado.categoria}' />" class="form-control"
			name="categoria" required="required"
			>
		</fieldset>
		<fieldset class="form-group">
			<label>Años</label>
			<input pattern="[0-9]{1-2}" type="text"
			value="<c:out value='${empleado.anyos}' />" class="form-control"
			name="anyos" required="required"
			>
		</fieldset>
		<a href="/NominasV2/ServletEmpleado?action=form" class="btn">Editar</a>
	</div>
	</form>
	</div>
</body>
</html>