<%-- 
    Document   : home
    Created on : Sep 22, 2014, 8:03:21 PM
    Author     : priya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <table>
   
      
                    <td>

                        <c:forEach var="post" items="${posts}">
                    <tr>${post.title}</tr>
                    <tr>${post.body}</tr>
                </c:forEach>

            </td>
          
            
            </table>
    </body>
</html>
