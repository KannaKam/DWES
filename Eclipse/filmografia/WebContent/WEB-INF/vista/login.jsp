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
		border: 0px solid;
	}
	input{
		text-align:center;
	}
</style>
<title>Login</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark">
                <a href="paginaPrincipal">Volver</a>
                </nav>
                <div class="container">
                <h1 class="text-center">Login</h1>
                </div>
                <div class="container card col-md-5 justify-content-center">
                <form method="POST" action="login">
                <br>
                <div class="form-group">
                	<label>Usuario:</label>
					<input type="text" name="nombre" required="required">
                </div>
					<div class="form-group">
					<label>Contraseña:</label>
					<input type="password" name="pass" required="required">
					</div>
					<div class="form-group">
                <input class="btn btn-success" type="submit" value="Entrar">
                </div>
				</form>
                </div>
                
				

</body>
</html>