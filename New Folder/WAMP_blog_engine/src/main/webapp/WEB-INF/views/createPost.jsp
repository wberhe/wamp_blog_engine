<%-- 
    Document   : createPost
    Created on : Sep 20, 2014, 6:09:18 PM
    Author     : priya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new post</title>
    </head>
    <body>
        <form action="posts" method="post" >

            <h1>Create new post</h1>

            <table>
              
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" /> </td>
                </tr>
                <tr>
                    <td>Model:</td>
                    <td><input type="text" name="body" /> </td>
                </tr>


            </table>
            <input type="submit"/>

        </form>
    </body>
</html>
