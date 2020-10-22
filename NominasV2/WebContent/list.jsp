<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión de empleados</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<div>
		<div class="container">
                      <h1 class="text-center">Gestión de nominas</h1>   
                    </div>
                    <table class="table text-center">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>DNI</th>
                                <th>Sexo</th>
                                <th>Categoría</th>
                                <th>Años</th>
                            </tr>
                        </thead>
                        <tbody>
<c:forEach var="empleado" items="${listaEmpleado}">

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
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
	</div>
</body>
</html>