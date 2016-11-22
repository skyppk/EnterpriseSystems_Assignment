<%-- 
    Document   : showItemDetail
    Created on : 2016/11/22, 下午 01:00:13
    Author     : nanasemaru
--%>

<%@page import="cf.bean.ItemInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container">
            <%
                ItemInfo item = (ItemInfo) request.getAttribute("item");
            %>
            <div class="row">
                <div class="col-md-6">
                    <div class="thumbnail">
                            <img class="" src="img/<%=item.getImg()%>" alt="No Image">
                    </div>
                </div>
                    <div class="container">sdgsdg</div>
            </div>
        </div>
    </body>
</html>
