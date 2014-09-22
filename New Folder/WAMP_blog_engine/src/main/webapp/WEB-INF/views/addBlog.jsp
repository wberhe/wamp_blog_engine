<%-- 
    Document   : addCar
    Created on : Sep 16, 2014, 11:53:45 PM
    Author     : showaibshikdermohammad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Blog</title>
    </head>
    <body>
        <form:form commandName="blog" action="blog" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><form:input  path="name" /> </td>
                </tr>
                <tr>
                    <td>Text:</td>
                    <td><form:textarea path="description" rows="5" cols="40"/></td>
                </tr>
            </table>        
            <input type="submit"/>

        </form:form>
    </body>
</html>
