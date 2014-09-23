<%-- 
    Document   : editPost
    Created on : Sep 21, 2014, 3:44:25 PM
    Author     : priya
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit post</h1>

        <form action="../editPost/${post.id}" method="post" >

            <table>
                <a href="../deletePost/${post.id}">delete post</a>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" value="${post.title}"/> </td>
                </tr>
                <tr>
                    <td>Body:</td>
                    <td><textarea name="body" rows="5" cols="40" >${post.body}</textarea></td>
                </tr>
                <tr>
                    <td>Save Draft</td>
                    <td><input type="checkbox" name="draft" value="${post.draft}"></td>
                </tr>

                <tr>
                    <td>Categories</td>
                    <td>
                        <select name= "categories" size="10" multiple="true">
                            <c:forEach var="category" items="${post.categories}">
                                <option value="${category.name}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <td>Add categories</td>
                    <td>
                        <select name= "allcategories" size="10" multiple="true">
                            <c:forEach var="category" items="${allcategories}">
                                <option value="${category.name}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Tags</td>
                    <td>
                        <select name= "postTags" size="10" multiple="true">
                            <c:forEach var="tag" items="${post.postTags}">
                                <option value="${tag.name}">${tag.name}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <td>Add tags</td>
                    <td>
                        <select name= "alltags" size="10" multiple="true">
                            <c:forEach var="tag" items="${alltags}">
                                <option value="${tag.name}">${tag.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>

            </table>

            <input type="submit" value="save"/>

        </form>
    </body>
</html>
