<%-- 
    Document   : view_promotion
    Created on : Jun 10, 2021, 8:49:51 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="CSS/main.css">
        <title>Promotion List</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="search.jsp">User Manager</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="nav navbar-nav menu">
	  <li class="nav-item">
	      <c:url var="update" value="update.jsp">
	          <c:param name="userID" value="${sessionScope.USER.userID}"> </c:param>
	          <c:param name="userName" value="${sessionScope.USER.userName}"> </c:param>
	          <c:param name="phoneNo" value="${sessionScope.USER.phoneNo}"> </c:param>
	          <c:param name="roleID" value="${sessionScope.USER.roleID}"> </c:param>
	          <c:param name="img" value="${sessionScope.USER.img}"> </c:param>
	      </c:url>
	      <a class="nav-link link" href="${update}">Update</a>
	  </li>
	  <c:if test="${sessionScope.USER.roleID =='ADM'}">
	      <li class="nav-item">
	          <a class="nav-link" href="create_account.jsp">Create User</a>
	      </li>
	  </c:if>
	  <c:if test="${sessionScope.USER.roleID =='ADM'}">
	      <li class="nav-item">
	          <c:url var="viewPromotion" value="viewPromotion"></c:url>
	          <a class="nav-link" href="${viewPromotion}">View Promotion</a>
	      </li>
	  </c:if>
	  <li class="nav-item">
	      <c:url var="logout" value="logout"></c:url>
	      <a class="nav-link" href="${logout}">Logout</a>
	  </li>
                </ul>
            </div>
            <h1>Hello ${sessionScope.USER.userName}</h1>
        </nav>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="col-md-12">
	  <div class="table-responsive">
	      <table class="table">
	          <thead>
	              <tr>
		<th>No</th>
		<th>Last Update</th>
		<th>Add Day</th>
		<th>Last Promotion Rank</th>
		<th>Promotion Rank</th>
		<th>User Name</th>
	              </tr>
	          </thead>
	          <tbody>
	              <c:forEach var="promotion" varStatus="counter" items="${sessionScope.LIST_PROMOTION}">
		<tr>
		    <td>${counter.count}</td>
		    <td>${promotion.lastUpdate}</td>
		    <td>${promotion.addDay}</td>
		    <td>${promotion.lastPromotion}</td>
	              <form action="updatePromotion">
		<td>
		    <select name="promotionID" value="${param.promotionID}">
		        <option >${promotion.promotionID}</option>
		        <option>R1</option>
		        <option>R2</option>
		        <option>R3</option>
		        <option>R4</option>
		        <option>R5</option>
		        <option>R6</option>
		        <option>R7</option>
		        <option>R8</option>
		        <option>R9</option>
		        <option>R10</option>
		    </select>
		</td>
		<td>${promotion.userID}</td>
		<td>
		    <input type="hidden" name="userID" value="${promotion.userID}">
		    <input type="hidden" name="promotionID" value="${promotionID}">
		    <input type="hidden" name="lastPromotion" value="${promotion.promotionID}">
		    <input type="submit" name="action" value="Update Promotion">
		</td>
	              </form>
	              <form action="deletePromotion">
		<td>
		    <input type="hidden" name="userID" value="${promotion.userID}">
		    <input type="submit" name="action" value="Delete Promotion">
		</td>
	              </form>                
	              </tr>
	          </c:forEach>
	          </tbody>
	      </table>
	  </div>
                </div>
            </div>
        </div>
    </body>
</html>
