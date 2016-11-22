<%@page import="cf.bean.OrderDetails"%>
<%@page import="cf.bean.ShoppingCart"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container">
            <h2>Registration Form</h2>
            <div class="panel panel-default">
                <div class="panel-body">
                    <%
                        Cookie[] cookies = request.getCookies();
                        Cookie cookie = null;
                        for(int i = 0; i < cookies.length; i++) { 
                            if(cookies[i].getName().equals("shoppingCart")){
                                cookie = cookies[i];
                                break;
                            }
                        }  
                        if(cookie!=null){
                            ShoppingCart cart = new ShoppingCart();
                            byte[] valueDecoded= Base64.getDecoder().decode(cookie.getValue());
                            String decoded = new String(valueDecoded);
                            JSONArray arr = new JSONArray(decoded);
                            for(int i =0;i<arr.length();i++){
                                JSONObject obj = arr.getJSONObject(i);
                                OrderDetails item = new OrderDetails(
                                        obj.getString("itemId"),
                                        obj.getString("itemName"),
                                        obj.getInt("quantity"),
                                        obj.getDouble("itemPrice"),
                                        obj.getDouble("itemPrice")*obj.getInt("quantity")
                                );
                                cart.getCart().add(item);
                                
                            }
                        }
                      %> 
                </div>
            </div>
        </div>
    </body>
</html>