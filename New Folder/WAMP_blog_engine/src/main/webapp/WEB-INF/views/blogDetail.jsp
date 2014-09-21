<%-- 
    Document   : addCar
    Created on : Sep 16, 2014, 11:53:45 PM
    Author     : showaibshikdermohammad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Blog</title>
    </head>
    <body>
	<form action="../blog/${blog.id}" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${blog.name}"/> </td>
		</tr>
		<tr>
			<td>Text:</td>
                        <td><textarea name="description" rows="5" cols="40">${blog.description}</textarea></td>
		</tr>
        </table>        
	<input type="submit"  value="update" />
	
	</form>
</body>
</html>
