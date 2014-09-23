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
        <title>${Blog.name}</title>
    </head>
    <body>
        <h1>${Blog.name}</h1>
    <sec:authorize access="hasRole('ROLE_BLOGGER')">
        <a href="../follow/${loggedUser.id}/${Blog.id}"> Follow</a>
        <a href="../unfollow/${loggedUser.id}/${Blog.id}"> Unfollow</a>
    </sec:authorize>
    <h3>Posts in this blog:</h3>

    <table width="100%" border="0" cellspacing="1" cellpadding="0">
        <tr>
            <td></td>
            <c:choose>
                <c:when test="${blogger.id==author.id}">
                    <td><a href="../newpost/${Blog.id}">create new post</a></td></tr>
                </c:when>

        </c:choose>

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
                <c:choose>
                    <c:when test="${blogger.id==author.id}">
                        <td><a href="../editPost/${post.id}"> edit post</a></td>  
                    </c:when>

                </c:choose>

            </tr>  
            <tr></tr>
            <tr></tr>
        </c:forEach>
    </table>
    <c:choose>
        <c:when test="${blogger.id==author.id}">
            <h3>Your drafts:</h3>
            <table>
                <c:forEach var="draft" items="${drafts}">
                    <tr>
                        <td>${draft.title}</td>
                        <td><a href="../editPost/${draft.id}"> edit draft</a></td>    
                    </tr>

                </c:forEach>
            </table>
        </c:when>

    </c:choose>


</body>
</html>
