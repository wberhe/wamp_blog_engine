<%-- 
    Document   : login
    Created on : Sep 20, 2014, 4:15:49 PM
    Author     : Weldino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form method="post" action="j_spring_security_check">
            User:<input name="j_username"/><br/>
            Password:<input type="password" name="j_password"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
