<%-- 
    Document   : resumen
    Created on : 9 feb. 2021, 12:53:47
    Author     : David
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
        <script>tinymce.init({selector:'textarea'});</script>
    </head>
    <body>
        <h1>Mensaje a alumnos</h1>
         <%
        String grupoSeleccionado = (String)request.getAttribute("grupo");
        ArrayList<Alumno> alumnosSeleccionados = (ArrayList<Alumno>) request.getAttribute("alumnosSeleccionados");
        %>
        <div class="container">
            <div class="row">
                <div class="col-mb">
                    <h3>Grupo Seleccionado <%=grupoSeleccionado%></h3>
                    <form action="servletGestion" method="post">
                        <table class="table">
                            <tr>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Email</th>
                            </tr>
                                <%for(Alumno a: alumnosSeleccionados){%>
                            <tr>
                                <td><%= a.getNombre() %></td>
                                <td><%= a.getApellidos() %></td>
                                <td><%= a.getEmail() %></td>
                            </tr>
                            <%}%>
                        </table><br> 
                        <b>Mensaje:</b><textarea class="form-control" name="mensaje"></textarea><br>
                        <input class="brn btn-primary" type="submit" value="Enviar">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
