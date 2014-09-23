<%-- 
    Document   : blogList
    Created on : Sep 20, 2014, 3:19:21 PM
    Author     : MShikder
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <h2>All Blog</h2>
        <table width="100%" border="0" cellspacing="1" cellpadding="0">
            <tr bgcolor="#ABB2BA">
                <td width="20%">Blog Name</td>
                <td width="50%">Blog Text</td>
              
                <td width="10%">Modify</td>
                <td width="10%">Delete</td>
                <td width="10%">Status</td>
            </tr>
            <c:if test="${blogList!=null}" >
            <c:forEach var="blog" items="${blogList}">
                <tr bgcolor="#D1D5DA">
                    <td> <a href="postList/${blog.id}">${blog.name}</a></td>
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
                <tr></tr>
                <tr></tr><tr></tr><tr></tr><tr></tr>
                
            </c:if>    

                
        </table>    
   
         <a href="addBlog">Create Blog</a>
    </body>
</html>

        </table>

