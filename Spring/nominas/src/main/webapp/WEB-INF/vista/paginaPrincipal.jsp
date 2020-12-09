<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión de empleados</title>
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
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
				<c:forEach var="empleado" items="${listaEmpleado}">
				
						<c:url var="actualizar" value="actualizar">
						<c:param name="empleadoId" value="${empleado.id}"></c:param>
						</c:url>

					<c:url var="eliminar" value="eliminar">
						<c:param name="empleadoId" value="${empleado.id}"></c:param>
					</c:url>

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
                                    <a href="${actualizar}" class="btn btn-warning">Actualizar</a>
                                    </td>
									<td>
									<a href="${eliminar}" class="btn btn-danger" onclick="if (!(confirm('¿Seguro que quieres eliminar a ${empleado.nombre}?'))) return false">Eliminar</a>
									</td>
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
                    <a href="" class="btn">Gestionar empleados</a>
                    </div>
                    
	</div>
</body>
</html>