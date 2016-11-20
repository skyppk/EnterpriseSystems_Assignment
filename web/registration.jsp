<%-- 
    Document   : Registration
    Created on : 2016/11/19, 下午 08:43:59
    Author     : nanasemaru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <!--        <style>
                    div,h2 {
                        margin: 10px;
                        width: 100%;
                    }
                    input:not([type=radio]):not([type=submit]):not([type=reset]) {
                        width: 100%;
                        border: 1px solid black;
                        height: 20px;
                    }
                    label {
                        text-align: left;
                        display: inline-block;
                        width: 100%;
                    }
                    #form {
                        margin:0 auto;
                        width: 50%;
                    }
                </style>-->
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div class="container">
            <h2>Registration Form</h2>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form method="post" action="registration">
                        <div style="text-align: right;">*Required</div>
                        <div class="form-group">
                            <label for="username">*Name:</label>
                            <input type="text" class="form-control" id="username" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="sex">*Sex:</label><br>
                            <input type="radio" name="sex" value="M" checked> Male
                            <input type="radio" name="sex" value="F"> Female
                        </div>
                        <div class="form-group">
                            <label for="tel">*Telephone Number:</label>
                            <input type="tel" class="form-control" id="tel" name="tel" required>
                        </div>
                        <div class="form-group">
                            <label for="email">*Email:</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="address">*Delivery Address:</label>
                            <input type="address" class="form-control" id="address" name="address" required>
                        </div>
                        <div class="form-group">
                            <label for="birthday">Birthday:</label>
                            <input type="date" class="form-control" id="birthday" name="birthday">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>