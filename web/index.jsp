<%-- 
    Document   : index
    Created on : 2016/11/19, 下午 06:33:10
    Author     : apple
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="cf.bean.ItemInfo"%>
<%@page import="cf.db.ItemDB"%>
<%@taglib uri="/WEB-INF/tlds/items" prefix="items" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>C & F</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container">
            <div class="row">
                <%
                    ItemDB db = new ItemDB("jdbc:mysql://localhost:3306/ESD_Assignment", "root", "");
                    ArrayList<ItemInfo> items = db.selectAllItem();
                    if (items != null) {
                        for (ItemInfo item : items) {
                            if (item.getItemStatus().equalsIgnoreCase("AVAILABLE")) {
                %>
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <a href="product?action=detail&name=<%=item.getItemName()%>">
                            <img src="img/<%=item.getImg()%>" alt="No image">
                            <div class="caption">
                                <h4 style="white-space: nowrap; text-overflow: ellipsis; overflow:hidden;"><%=item.getItemName()%></h4>
                                <p><%=item.getPrice()%></p>
                            </div>
                        </a>
                    </div>
                </div>
                <%
                            }
                        }
                    }
                %>
            </div>
        </div>
    </body>
</html>
