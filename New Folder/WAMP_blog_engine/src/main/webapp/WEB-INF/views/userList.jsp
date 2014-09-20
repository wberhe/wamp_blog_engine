<%-- 
    Document   : userList
    Created on : Sep 20, 2014, 4:13:03 PM
    Author     : Weldino
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog engine</title>
    </head>
    <body>
        <h1>Here are all the current users :</h1>
        <table>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.email}</td>
                    <td><a href="users/${car.id}">edit info</a></td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
