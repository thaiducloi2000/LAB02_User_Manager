<%-- 
    Document   : create_account
    Created on : Jun 9, 2021, 7:10:36 PM
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
        <title>Create Page</title>
    </head>
    <body>
    <c:if test="${sessionScope.USER !=null && sessionScope.USER.roleID =='ADM'}">
        <c:if test="${not empty sessionScope.USER}">
            <div class="wrapper fadeInDown">
                <div id="formContent">
	  <form action="create">
	      <input type="text"  placeholder="User ID" class="fadeIn second" name="userID" value="" required="true"><br/>
	      <input type="text" placeholder="User Name" class="fadeIn third" name="userName" value="" required="true"><br/>
	      <input type="password"  class="fadeIn fourth" placeholder="password" name="password" value="" ><br/>
	      <input type="text" placeholder="Phone Number" class="fadeIn five" name="phoneNo" value="" required="true">
	      <select class="fadeIn six" name="roleID" value="">
	          <option>SUB</option>
	          <option>ADM</option>
	      </select><br/>
	      <input type="file" name="img" accept=".jpg, .png" > <br/>          
	      <input type="submit" name="action" value="Create">
	  </form>
                </div>
            </div>
        </c:if>
    </c:if>
</body>
</html>
