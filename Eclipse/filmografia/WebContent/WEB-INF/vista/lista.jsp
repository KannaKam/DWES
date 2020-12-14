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
		border: 0px;
	}
</style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark">
                <a href="paginaPrincipal">Volver</a>
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
                                
                                <c:set var="admin" value="${logged}" />
										<c:choose>
								    		<c:when test="${logged == true}">
								    		<th colspan="2">Acciones</th>
								      	  		</c:when>
								   		 <c:otherwise>
								      		  <th colspan="2" style="display:none">Acciones</th>
								      		  </c:otherwise>      
										</c:choose>
										
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
                                    
                                    	<c:set var="admin" value="${logged}" />
										<c:choose>
								    		<c:when test="${logged == true}">
								    		<td colspan="2" id="acc">
								      	  		<a href=${actualizar } class="btn btn-warning">Actualizar</a>
								                <a href=${eliminar } class="btn btn-danger" onclick="if (!(confirm('¿Seguro que quieres eliminar a ${pelicula.titulo}?'))) return false">Eliminar</a>
								   		 	 </td>	
								   		 	</c:when>
								   		 <c:otherwise>
								   		 <td colspan="2" id="acc" style="display:none">
								      		  <a href=${actualizar } class="btn btn-warning" style="display:none">Actualizar</a>
								              <a href=${eliminar } class="btn btn-danger" style="display:none" onclick="if (!(confirm('¿Seguro que quieres eliminar a ${pelicula.titulo}?'))) return false">Eliminar</a>
								    	</td>
								    	</c:otherwise>      
										</c:choose>
                                    
                                   
                                </tr>
                                 </c:forEach>
                                 </tbody>
                                 </table>
                                 </div>
                           
                                <div class="container">
                                <div class="container">
                                <form action="listaDirectores" method="GET">
                   			<input type="submit" class="btn btn-success" value="Finalizar" />
                   			</form>
                                </div>
                   		 	<div class="container">
                   			<form action="director" method="GET">
                   			<input type="submit" class="btn btn-success" value="Realizar nueva consulta" />
                   			</form>
                   		 	</div>
                   		 </div>
	</div>
</body>
</html>