<%@page import="com.emergentes.modelo.Categorias"%>
<%@page import="java.util.List"%>
<%
Categorias categorias=(Categorias)request.getAttribute("categorias"); 
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo registro de Categoria</h1>
        <form action="CategoriasController" method="post">
            <input type="hidden" name="id" value="${categorias.id}">
            <table>
                <tr>
                    <td>Categoria:</td>
                    <td><input type="text" name="categoria" value="${categorias.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"></td>
                </tr>     
            </table>
        </form>
    </body>
</html>
