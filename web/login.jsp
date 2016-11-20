<%-- 
    Document   : login
    Created on : 2016/11/20, 下午 01:55:45
    Author     : nanasemaru
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            div,h2 {
                margin: 10px;
                width: 100%;
            }
            input {
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
            <h2>Login</h2>
            <form method="post" action="login">
                <input type="hidden" name="action" value="authenticate">
                <div>
                    <label for="username">Login ID</label>
                    <input type="text" name="username" required>
                </div>
                <div>
                    <label for="password">Password</label>
                    <input type="password" name="password" required>
                </div>
                <div>
                    <input type="submit">
                </div>
            </form>
        </div>
    </body>
</html>
