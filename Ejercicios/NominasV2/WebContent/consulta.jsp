<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestionar empleado</title>
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
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark">
                <a href="/NominasV2/ServletEmpleado?action=form"><img src="back.png"></a>
                </nav>
	<div>
		<div class="container">
                      <h1 class="text-center">Gesti�n de nominas</h1>   
                    </div>
                    <div class="container">
                    <table class="table text-center table-bordered">
                        <thead class="thead">
                            <tr>
                                <th>Nombre</th>
                                <th>DNI</th>
                                <th>Sexo</th>
                                <th>Categor�a</th>
                                <th>A�os</th>
                                <th>Salario</th>
                            </tr>
                        </thead>
                        <tbody>
                                <tr>
                                    <td>
                                        <c:out value="${empleado.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.dni}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.sexo}" />
                                    </td>
                                    <td>
                                        <c:out value="${empleado.anyos}" />
                                    </td>
                                     <td>
                                        <c:out value="${empleado.categoria}" />
                                    </td>
                                    <td>
                                    	<c:out value="${nomina.sueldo}" />
                                    </td>
                                </tr>
                            </tbody>

                    </table>
                    <form method="post" action="/NominasV2/ServletEmpleado?action=editar&dni=${empleado.dni}">
						<div class="container">
						<p><input type="submit" value="Editar empleado" class="btn"></p>
						</div>
                    </form>
                    </div>
                    
	</div>
</body>
</html>