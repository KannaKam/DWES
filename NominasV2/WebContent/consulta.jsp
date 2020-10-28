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
		background-color:#5BADB2;
	}
	.btn{
		color: #fff;
		background-color:#5BADB2;
	}
</style>
</head>
<body>
	<div>
		<div class="container">
                      <h1 class="text-center">Gestión de nominas</h1>   
                    </div>
                    <div class="container">
                    <table class="table text-center table-bordered">
                        <thead class="thead">
                            <tr>
                                <th>Nombre</th>
                                <th>DNI</th>
                                <th>Sexo</th>
                                <th>Categoría</th>
                                <th>Años</th>
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
                    <a href="/NominasV2/ServletEmpleado?action=mostrarEditar" class="btn">Editar empleado</a>
                    </div>
                    
	</div>
</body>
</html>