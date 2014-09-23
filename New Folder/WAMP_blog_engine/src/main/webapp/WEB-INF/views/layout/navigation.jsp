<%-- 
    Document   : navigation
    Created on : Sep 21, 2014, 11:45:19 PM
    Author     : showaibshikdermohammad
--%>
<%@taglib  prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <div id="sidebar">
    <h2>Navigate</h2>
    <div class="navlist">
      <ul>
        <li><a href="/Wamp/blog">Blog List</a></li>
        <sec:authorize access="hasRole('ROLE_BLOGGER')">
        <li><a href="/Wamp/addBlog">Create Blog</a></li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="/Wamp/settings">Admin user</a></li>
        </sec:authorize>
        <li><a href="/Wamp/j_spring_security_logout">Logout</a>  </li>
      </ul>
    </div>
  </div>

