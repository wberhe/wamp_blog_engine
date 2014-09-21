<%-- 
    Document   : addBlogCategory
    Created on : Sep 20, 2014, 8:08:59 PM
    Author     : aalzamer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
        <style>
            .errorBlock{
                color: red;
                border-style: solid;
                border-color: red;
                border-width: 1px;
                padding: 3px;
                background-color: rgb(231, 231, 231);
            }

        </style>
    </head>
    <body>
        <h1>Add Category</h1>
        <form:form modelAttribute="category" action="addBlogCategory">
            <table>
                <tr>
                    <td>Category</td>
                    <td><form:input path="name" /></td>
                    <td><form:errors path="name" cssClass="errorBlock" element="div"/></td>
                </tr>
            </table>
            <form:button name="submit" >Submit</form:button>
        </form:form>
    </body>
</html>
