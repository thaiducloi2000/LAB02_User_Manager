<%-- 
    Document   : update
    Created on : Jun 6, 2021, 2:06:06 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.USER !=null}">
            <c:if test="${not empty sessionScope.USER}">
                <form action="update">
	  <input type="text"  name="userID" value="${param.userID}" readonly="true"><br/>
	  <input type="text" name="userName" value="${param.userName}" required="true"><br/>
	  <c:if test="${sessionScope.USER.userID == param.userID}">
	      <input type="text" placeholder="password" name="password" value="" ><br/>
	  </c:if>
	  <input type="text" name="phoneNo" value="${param.phoneNo}" required="true">
	  <select name="role" value="${param.role}">
	      <option >${param.roleID}</option>
	      <c:if test="${param.roleID =='ADM'}">
	          <option>SUB</option>
	      </c:if>
	      <c:if test="${param.roleID =='SUB'}">
	          <option>ADM</option>
	      </c:if>
	  </select><br/>
	  <img  src="${param.img}" required="true" width="250" height="125">
	  <br/>
	  <input type="file" name="img" accept=".jpg, .png" > <br/>          
	  <input type="submit" name="action" value="Update">
                </form>
            </c:if>
        </c:if>
    </body>
</html>
