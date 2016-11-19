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
        <style>
            div {
                margin: 10px;
                width: 50%;
            }
            input {
                width: 100%;
            }
            label {
                text-align: left;
            }
            form {
                vertical-align: middle;
            }
        </style>
    </head>
    <body>
        <h2>Registration Form</h2>
        <form method="post" action="registration">
            <div style="text-align: right;">*Required</div>
            <div>
                <label for="username">Name *</label><br>
                <input type="text" name="username" required>
            </div>
            <div>
                <label for="sex">Sex *</label><br>
                <input type="radio" name="sex" value="M" checked>Male
                <input type="radio" name="sex" value="F">Female
            </div>
            <div>
                <label for="tel">Telephone Number *</label><br>
                <input type="tel" name="tel" required>
            </div>
            <div>
                <label for="email">Email *</label><br>
                <input type="email" name="email" required>
            </div>
            <div>
                <label for="address">Delivery Address *</label><br>
                <input type="text" name="address" required>
            </div>
            <div>
                <label for="birthday">Birthday</label><br>
                <input type="date" name="birthday">
            </div>
            <div>
                <input type="submit" style="width: 50%"><input type="reset" style="width: 50%">
            </div>
        </form>
    </body>
</html>
