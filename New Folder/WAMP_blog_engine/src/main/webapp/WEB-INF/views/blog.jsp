<%-- 
    Document   : blog
    Created on : Sep 21, 2014, 10:45:34 AM
    Author     : priya
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog page</title>
    </head>
    <body>
        <h3>Posts in this blog:</h3>
        <table>
            <tr>
                <td></td>
                <td><a href="../newpost/${Blog.id}">create new post</a></td></tr>
            <tr></tr>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.title}</td>
                    <td><a href="../viewPost/${post.id}"> view post</a></td>  
                </tr>
                <tr>
                    <td>${post.body}</td>
                </tr> 
                <tr>
                    <td><a href="../editPost/${post.id}"> edit post</a></td>                  
                </tr>  
                <tr></tr>
                <tr></tr>
            </c:forEach>
        </table>
       
        <h3>Drafts in this blog:</h3>
        <table>
            <c:forEach var="draft" items="${drafts}">
                <tr>
                    <td>${draft.title}</td>
                   <td><a href="../editPost/${draft.id}"> edit draft</a></td>    
                </tr>
               
            </c:forEach>
        </table>
      
    </body>
</html>
