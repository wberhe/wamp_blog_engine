<%-- 
    Document   : signup
    Created on : Sep 20, 2014, 4:15:31 PM
    Author     : Weldino
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sign up</title>
        <link href="resources/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <form:form commandName="car" action="addCar" method="post">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr>
                    <td>First Name :</td>
                    <td><form:input path="firstname" /> </td>
                    <td><form:errors path="firstname" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input path="lastname" /> </td>
                    <td><form:errors path="lastname" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Date of Birth :</td>
                    <td><form:input path="dob" /> </td>
                    <td><form:errors path="dob" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><form:input path="email" /> </td>
                    <td><form:errors path="email" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><form:input path="password" /> </td>
                    <td><form:errors path="Password" cssClass="error"/> </td>
                </tr>
            </table>
            <input type="sign up"/>

        </form:form>
    </body>
</html>