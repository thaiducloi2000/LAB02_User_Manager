<%-- 
    Document   : login
    Created on : Jun 3, 2021, 4:25:29 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="CSS/login.css">
        <title>Login page</title>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <form action="login" method="POST">
	  <input type="text" id="login" class="fadeIn second" name="userID" value="" placeholder="login" /><br/>
	  <input type="password"  id="password" class="fadeIn third" name="password" value="" placeholder="password" /><br/>
	  <input type="submit" class="fadeIn fourth" name="action" value="Login" />
                </form>
            </div>
        </div>
    </body>
</html>
