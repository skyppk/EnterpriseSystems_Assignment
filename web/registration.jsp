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
        </style>
    </head>
    <body>
        <div id="form">
            <h2>Registration Form</h2>
            <form method="post" action="registration">
                <div style="text-align: right;">*Required</div>
                <div>
                    <label for="username">Name *</label>
                    <input type="text" name="username" required>
                </div>
                <div>
                    <label for="sex">Sex *</label>
                    <input type="radio" name="sex" value="M" checked>Male
                    <input type="radio" name="sex" value="F">Female
                </div>
                <div>
                    <label for="tel">Telephone Number *</label>
                    <input type="tel" name="tel" required>
                </div>
                <div>
                    <label for="email">Email *</label>
                    <input type="email" name="email" required>
                </div>
                <div>
                    <label for="address">Delivery Address *</label>
                    <input type="text" name="address" required>
                </div>
                <div>
                    <label for="birthday">Birthday</label>
                    <input type="date" name="birthday">
                </div>
                <div>
                    <input type="submit" style="width: 50%"><input type="reset" style="width: 50%">
                </div>
            </form>
        </div>
    </body>
</html>