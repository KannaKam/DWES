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
	.form-control{
		width:30%
	}
</style>
<title>Login</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark">
                <a href="./index.jsp"><img src="back.png"></a>
                <div class="container">
                <h2 class="text-center">Introduzca su usuario y contraseña</h2>
                </div>
                </nav>
	<form method="post" action="/CineMVC/ServletEmpleado?action=log&nombre=${admin.nombre}&password=${admin.pass}">
	<div class="container">
		<p>Usuario<input type="text" name="usuario" class="form-control" required="required"></p>
		<p>Contraseña<input type="password" name="pass" class="form-control" required="required"></p>
		<p><input type="submit" value="Entrar" class="btn"></p>
	</div>
	</form>
</body>
</html>