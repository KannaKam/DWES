<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        </head>

        <body>

            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightblue">
                <a href="/NominasFinalV2/EmpleadoServlet?action=lista" class="text-dark" style="font-size: 25px;">Volver</a>
               
                    <div class="container">
                      <h1 class="text-center">Gestión de nominas</h1>   
                    </div>
                </nav>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <h2>Nuevo empleado</h2>

                        

                        <fieldset class="form-group">
                            <label>Nombre</label> <input type="text"   required="required">
                        </fieldset>

						<fieldset class="form-group">
                            <label>DNI</label> <input type="text" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Sexo</label> <input type="text"  required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Categoría</label> <input type="text" ">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Años</label> <input type="text">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                        
                    </div>
                </div>
            </div>
        </body>

        </html>