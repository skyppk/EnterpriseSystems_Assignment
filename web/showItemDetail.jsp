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
        <title>C & F</title>
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
                    <label for="quantity">Quantity: </label>
                    <div class="input-group col-xs-3">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default" id="decrease">
                                <span>-</span>
                            </button>
                        </div>
                        <input type="number" class="form-control" id="quantity" name="quantity" value="1" min="1">
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button" id="increase">+</button>
                        </span>
                    </div>
                    <p></p>
                    <button type="button" class="btn btn-default btn-block">Add to cart</button>                    
                </div>
            </div>
        </div>

        <script>
            $('#increase').click(function () {
                var num = parseInt($('#quantity').val());
                $('#quantity').val(num + 1);
            });
            $('#decrease').click(function () {
                var num = parseInt($('#quantity').val());
                if (num > 1) {
                    $('#quantity').val(num - 1);
                }
            });
        </script>
    </body>
</html>
