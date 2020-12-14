<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscar películas por director</title>
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
                <a href="paginaPrincipal"><img src="back.png"></a>
                </nav>
	<div>
		<div class="container">
                      <h1 class="text-center">Películas</h1>   
                    </div>
                    <div class="container">
                    <table class="table text-center table-bordered">
                        <thead class="thead">
                            <tr>
								<th>Director</th>
                                <th>Título</th>
                                <th>Fecha</th>
                                <th>Acciones</th>
                                <th colspan="2">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
	<c:forEach var="pelicula" items="${peliculas}">
	
						<c:url var="actualizar" value="actualizar">
						<c:param name="id" value="${pelicula.id}"></c:param>
						</c:url>

					<c:url var="eliminar" value="eliminar">
					<c:param name="id" value="${pelicula.id}"></c:param>
					</c:url>

                                <tr>
                                    <td>
                                        <c:out value="${pelicula.director}" />
                                    </td>
                                    <td>
                                        <c:out value="${pelicula.titulo}" />
                                    </td>
                                    <td>
                                        <c:out value="${pelicula.fecha}" />
                                    </td>
                                    <td colspan="2" id="acc">
                                    	<c:set var="admin" value="${logged}" />
										<c:choose>
								    		<c:when test="${logged == true}">
								      	  		<a href=${actualizar } class="btn btn-warning">Actualizar</a>
								                <a href=${eliminar } class="btn btn-danger" onclick="if (!(confirm('¿Seguro que quieres eliminar a ${pelicula.titulo}?'))) return false">Eliminar</a>
								   		 	</c:when>
								   		 <c:otherwise>
								      		  <a href=${actualizar } class="btn btn-warning" style="display:hidden">Actualizar</a>
								              <a href=${eliminar } class="btn btn-danger" style="display:hidden" onclick="if (!(confirm('¿Seguro que quieres eliminar a ${pelicula.titulo}?'))) return false">Eliminar</a>
								    	</c:otherwise>      
										</c:choose>
                                    
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>

                    </table>
                    </div>
                    
	</div>
</body>
</html>