<%-- 
    Document   : blogList
    Created on : Sep 20, 2014, 3:19:21 PM
    Author     : MShikder
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog List</title>
    </head>
    <body>
        <h1>All Blog</h1>
        <table width="50%" border="0" cellspacing="1" cellpadding="0">
            <tr>
                <td width="20%">Blog Name</td>
                <td width="50%">Blog Text</td>
                <td width="10%">Modify</td>
                <td width="10%">Delete</td>
                <td width="10%">Status</td>
            </tr>
            <c:if test="${blogList!=null}" >
            <c:forEach var="blog" items="${blogList}">
                <tr>
                    <td>${blog.name}</td>
                    <c:choose>
                        <c:when test="${fn:length(blog.description) > 15}" >
                            <td>${fn:substring(blog.description, 0, 15)}...</td>
                        </c:when>
                        <c:otherwise>
                            <td>${blog.description}</td>
                        </c:otherwise>         
                    </c:choose>
                            
                    <td><a href="blog/${blog.id}">Modify</a></td>
                    <td><a href="blog/delete/${blog.id}">Delete</a></td>
                    <c:if test="${blog.blocked == true}" >
                        <td><a href="blog/enable/${blog.id}">Enable</a></td>
                    </c:if>
                    <c:if test="${blog.blocked == false}" >
                        <td><a href="blog/disable/${blog.id}">Disable</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            </c:if>    
        </table>    
    </body>
</html>