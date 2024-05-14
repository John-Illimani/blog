<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 14 may. 2024, 12:11:49
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
        .titulo{
            font-weight: bold;
            font-size: 1.5rem;

            text-align: center;
            align-items: center;
        }
        .t-button {
            text-align: right; /* Alinea el contenido a la derecha */
        }

        .t-button a {
            display: inline-block;
            padding: 8px 12px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }

        .t-button a:hover {
            background-color: #0056b3;
        }


    </style>
    <body>
        <div style="padding: 2rem">
            <div class="titulo">
                <h1>Blog de Tecnología</h1>
                <h2>Autor: John Limber Illimani Choqueta</h2>
            </div>


            <div class="t-button"> 
                <p><a href="MainServlet?action=add">Nuevo</a> </p>
            </div>
            <div>



            </div>





            <c:forEach var="item" items="${blogs}">

                <ul style="list-style-type: none;">
                    <li style="font-weight: bold; font-size: 2rem">${item.titulo}</li><br>
                    <li>${item.fecha}</li><br>
                    
                    <li>${item.contenido}</li>
                    <li style="text-align: right"><a href="MainServlet?action=edit&id=${item.id}">Editar</a> 
                        <a href="MainServlet?action=delete&id=${item.id}" onclick="return(confirm("esta seguro?"))" >Eliminar</a></li>
                    
                </ul>
                        <hr style="width: 20%; height: 2px; background-color: black; border-radius: 40rem ">


            </c:forEach>
        </div>

    </body>
</html>
