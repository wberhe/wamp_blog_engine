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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form:form modelAttribute="category">
            <form:input path="name" />
            <form:errors path="name" cssClass="errorBlock" element="div"/>
            
        </form:form>
    </body>
</html>
