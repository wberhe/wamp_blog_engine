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
        <form:form commandName="user" action="addUser" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>First Name :</td>
                    <td><form:input type="text" path="firstname" /> </td>
                    <td><form:errors path="firstname" cssClass="error" /> </td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input type="text" path="lastname" /> </td>
                    <td><form:errors path="lastname" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Date of Birth :</td>
                    <td><form:input type="date" path="dob" /> </td>
                    <td><form:errors path="dob" cssClass="error"/> </td>
                </tr>
                <tr>
                    <td>Picture :</td> 
                    <td><input type="file" name="file"   /> </td>
                </tr>
                <tr>
                    <td>Email :</td>
                    <td><form:input type="text" path="email" /> </td>
                    <td><form:errors path="email" cssClass="error"/> </td>
                </tr>
            </table>
                <form:hidden path="userCredential.username" /> 
                <form:hidden path="userCredential.password" /> 
                <form:hidden path="userCredential.confirmpassword" /> 
                <form:hidden path="userCredential.previledge" /> 
           <form:button >Sign up</form:button>

        </form:form>
    </body>
</html>