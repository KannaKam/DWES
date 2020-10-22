<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="">
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightblue">
                <a href="/NominasFinalV2/EmpleadoServlet?action=menu" class="text-dark" style="font-size: 25px;">Volver</a>
               
                    <div class="container">
                      <h1 class="text-center">Gestión de nominas</h1>   
                    </div>
                </nav>
            
 
            

                <div class="container ">
                    <h3 class="text-center">Lista de empleados</h3>
                      
                    <hr>
<table class="table table-bordered text-center">
                        <thead class="thead-dark">
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
                                    <td><a href="/NominasFinalV2/EmpleadoServlet?action=editar&dni=${empleado.dni}">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="/NominasFinalV2/EmpleadoServlet?action=eliminar&dni=${empleado.dni}">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
                    </div>
                   </div>
                   
</body>
</html>