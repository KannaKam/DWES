<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Gestionar empleado</title>
<style>
	.thead{
		color: #fff;
		background-color:#5BADB2;
	}
	.btn{
		color: #fff;
		background-color:#5BADB2;
	}
</style>
</head>
<body>
	<form method="post" action="/NominasV2/ServletEmpleado?action=gestionar">
	<div class="container">
		Introduzca el DNI del empleado.
		<p><input type="text" name="dni" class="form-control" required="required"></p>
		<p><input type="submit" value="Buscar empleado" class="btn"></p>
	</div>
	</form>
</body>
</html>