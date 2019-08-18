<%-- 
    Document   : test
    Created on : 7 janv. 2019, 08:29:25
    Author     : p1702401
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%!
            String nom = "Euh c'est comme un private String";
        %>
        <%
            int i = 5;
            out.println("La valeur de i est : " + i + "\n");
            session.setAttribute("pseudo", "test");
            out.println("Vous êtes connectés en tant que : " + session.getAttribute("pseudo") + "\n");
        %>
    </body>
</html>
