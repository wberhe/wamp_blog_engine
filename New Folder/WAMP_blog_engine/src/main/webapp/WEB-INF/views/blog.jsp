<%-- 
    Document   : blog
    Created on : Sep 21, 2014, 10:45:34 AM
    Author     : priya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
	<c:forEach var="post" items="${posts}">
	<tr>
		<td>${post.title}</td>
		
	</tr>
	</c:forEach>
	</table>
        
        <a href="newpost">create new post</a>
    </body>
</html>
