<%-- 
    Document   : search
    Created on : Jun 3, 2021, 4:25:56 PM
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
        <title>Search Page</title>
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
	  <form action="search">
	      <input type="text" name="search" placeholder="Enter User Name" value="${param.search}"/>
	      <input type="submit" name="action" value="Search"/><br/>
	  </form>
                </div>
                <c:if test="${sessionScope.LIST_USER !=null}">
	  <c:if test="${not empty sessionScope.LIST_USER}">
	      <c:if test="${sessionScope.LIST_ROLE !=null}">
	          <c:if test="${not empty sessionScope.LIST_ROLE}">
	              <form action="select">	  	              
		<select name="role" value="${param.role}">
		    <option >All</option>
		    <c:forEach var="roleID" items="${sessionScope.LIST_ROLE}">
		        <option>${roleID}</option>
		    </c:forEach>
		</select>
		<button name="action" value="${role}">SELECT</button>    
	              </form>
	          </c:if>
	      </c:if>
	      <div class="col-md-12">
	          <div class="table-responsive">
	              <table class="table">
		<thead>
		    <tr>
		        <th>No</th>
		        <th>Image</th>
		        <th>User Name</th>
		        <th>Phone Number</th>
		        <th>Role</th>
		    </tr>
		</thead>
		<tbody>
		    <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_User}">
		        <tr>
		            <td>${counter.count}</td>
		            <td>
		                <img src="${user.img}"  alt="User Avatar" width="100" height="50" >		
		            </td>
		            <td>${user.userName}</td>
		            <td>${user.phoneNo}</td>
		            <td>${user.roleID}</td>
		            <c:if test="${sessionScope.USER.roleID == 'ADM' && sessionScope.USER.userID != user.userID}">
		        <form action="delete">
		            <td>
		                <input type="hidden" name="userID" value="${user.userID}">
		                <input type="submit" name="action" value="Delete">
		            </td>
		        </form>	          
		    </c:if>
		    <c:if test="${sessionScope.USER.roleID == 'ADM' && user.roleID == 'SUB' && sessionScope.USER.userID != user.userID}">	          
		        <td>
		            <c:url var="update" value="update.jsp">
		                <c:param name="userID" value="${user.userID}"> </c:param>
		                <c:param name="userName" value="${user.userName}"> </c:param>
		                <c:param name="phoneNo" value="${user.phoneNo}"> </c:param>
		                <c:param name="roleID" value="${user.roleID}"> </c:param>
		                <c:param name="img" value="${user.img}"> </c:param>
		            </c:url>
		            <a href="${update}">Update</a>
		        </td>
		    </c:if>
		    <c:if test="${sessionScope.USER.roleID == 'ADM' && user.roleID == 'SUB' && sessionScope.USER.userID != user.userID}">	          
		        <td>
		            <form action="addPromotion">
		                <input type="hidden" name="userID" value="${user.userID}">
		                <input type="submit" name="action" value="Add_Promotion">
		            </form>			  		
		        </td>
		    </c:if>
		    </tr>
		</c:forEach>
		</tbody>
	              </table>
	          </div>
	      </div>
	  </c:if>
                </c:if> 
            </div>
        </div>
    </body>
</html>
