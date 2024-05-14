<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : editar
    Created on : 14 may. 2024, 12:12:08
    Author     : illim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .main{
            box-sizing: border-box;
            padding: 2rem;
        }
        .t-titulo{
            
            width: 70rem;
            height: 25px;
        }
        .t-container{
            width: 70rem;
            height: 150px;
        }
        .table{
            width: 90%;
        }
        .m-titulo{
            text-align: center;
        }
    </style>
    <body>
        <div class="main">
            <h1 class="m-titulo"><c:if test="${blog.id == 0}">Nuevo</c:if>
            <c:if test="${blog.id != 0}">Editar</c:if>
                BLOG
            </h1>
            <form action="MainServlet" method="post">
                <input type="hidden" name="id" value="${blog.id}" /> 
                <table class="table" >
                <tr>
                    <td style="text-align: right">Fecha: </td>
                    <td><input type="date" name="fecha" value="${blog.fecha}"/></td>
                </tr>
                <tr>
                    <td style="text-align: right">Titulo: </td>
                    <td><input class="t-titulo" type="text" name="titulo" value="${blog.titulo}"/></td>
                </tr>
                <tr>
                    <td style="text-align: right">Contenido:</td>
                    <td><input class="t-container" type="text" name="contenido" value="${blog.contenido}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" /></td>
                </tr>
            </table>

        </form>
   
        </div>
    </body>
</html>
