
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Libros"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
List<Libros> libros=(List<Libros>)request.getAttribute("libros"); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LIBROS</h1>
                <h2>ESTUDIANTE: GUSTAVO FRANCO RUIZ NINA</h2>
        <p><a href="LibrosController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Disponible</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${libros}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.disponible}</td>
                    <td>${item.categoria}</td>                  
                    <td><a href="LibrosController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="LibrosController?action=delete&id=${item.id}">Eliminar</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
