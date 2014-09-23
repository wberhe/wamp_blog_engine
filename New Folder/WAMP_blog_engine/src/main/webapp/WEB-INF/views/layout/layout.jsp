<%-- 
    Document   : layout
    Created on : Sep 21, 2014, 11:25:10 PM
    Author     : showaibshikdermohammad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
     
<html>
    <head>
        <title>WAMP Blog Engine</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <link href="/Wamp/resources/common_style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="container">
            <tiles:insertAttribute name="header" />
            <div class="clear"></div>
            <tiles:insertAttribute name="navigation" />
            <div id="content">
                <!--<h2>Header</h2>-->
                <tiles:insertAttribute name="body" />
            </div>

            <div id="bottom">
                <!--
              <h2>Services</h2>
              <p><img class="imgleft" src="../resources/images/orb.png" alt="" /> text.. </p>
                 --> 
            </div>

            <div class="clear"></div>
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>         