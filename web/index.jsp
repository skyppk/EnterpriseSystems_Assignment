<%-- 
    Document   : index
    Created on : 2016/11/19, 下午 06:33:10
    Author     : apple
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="userInfo" class="cf.bean.UserInfo" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <% if (userInfo.getLoginId()==null||userInfo.getLoginId().equals("")) {%>
            <a href="registration.jsp">Registration</a>
            <a href="login.jsp">Login</a>
        <% } else { %>
        Welcome, <%=userInfo.getUserName()%><p>
        <form method="post" action="login">
            <input type="hidden" name="action" value="logout">
            <input type="submit" value="Logout" name="logoutButton">
        </form>
        <% } %>
    </body>
</html>
