<%-- 
    Document   : post
    Created on : Sep 20, 2014, 6:14:40 PM
    Author     : priya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post</title>
    </head>
    <body>
        <form action="../viewPost/${post.id}" method="post" >
            <a href="../postList">view Blog</a>
            <table>

                <tr>
                    <td>Title:</td>
                    <td>${post.title}</td>
                </tr>
                <tr>
                    <td>Body:</td>
                    <td>${post.body}</td>
                </tr>

                <tr>
                    <td>Categories</td>
                    <td>

                <c:forEach var="category" items="${post.categories}">
                    <option value="${category.name}">${category.name}</option>
                </c:forEach>

                </td>

                </tr>

                <tr>
                    <td>Tags</td>
                    <td>

                <c:forEach var="tag" items="${post.postTags}">
                    <option value="${tag.name}">${tag.name}</option>
                </c:forEach>

                </td>


                </tr>
               
                <tr>
                    <td>Comments</td>
                 

                <c:forEach var="comment" items="${comments}">
                <tr>
                    <td>${comment.commentAuthor.firstname}</td>
                    <td>${comment.comment}</td>
                   
                </tr>
               
            </c:forEach>
                     
              
            
                        
                </tr>    

               

                <tr>

                    <td><input type="text" name="tempComment" /> </td>
                    <td><input type="submit" value="post"/> </td>

                </tr>
               

            </table>

        </form>
    </body>
</html>
