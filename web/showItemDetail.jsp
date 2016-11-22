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
                        <img src="img/<%=item.getImg()%>" alt="No Image">
                    </div>
                </div>
                <div class="col-md-offset-7">
                    <h2><%=item.getItemName()%></h2>
                    <blockquote>
                        <p>Designed by <%=item.getDesignerName()%></p>
                    </blockquote>
                    <p class="lead">$ <%=item.getPrice()%></p>
                    <p></p>
                    Description:
                    <p class="lead"><%=item.getDescriptions()%></p>
                    Quantity:
                    <div class="input-group col-xs-3">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default">
                                <span>-</span>
                            </button>
                        </div>
                        <input type="number" class="form-control" name="x" value="1">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button">+</button>
                        </span>
                    </div>
                    <p></p>
                    <button type="button" class="btn btn-default btn-block">Add to cart</button>
                </div>
            </div>
        </div>
    </body>
</html>
