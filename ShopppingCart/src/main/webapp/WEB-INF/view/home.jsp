<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:#FFDAB9">
<h2><center> Shopping Cart <center></center></h2>
<center>${msg}</center>

<center>${role}</center>

<center>${successMessage}</center>
<center>${errorMessage}</center>
${loginMessage}
<hr>

<jsp:include page="CategoryMenu.jsp"></jsp:include><br>


<c:if test="${isAdmin==true }">
<jsp:include page="Admin/AdminHome.jsp"></jsp:include><br>
</c:if>


<c:if test="${empty loginMessage}">
<a href="login"> Login </a></br>
<a href="register">Register</a> 
</c:if>

<c:if test="${hasClickedLogin==true}">
<jsp:include page="Login.jsp"></jsp:include><br>
</c:if>

<c:if test="${not empty errorMessage}">    
<jsp:include page="Login.jsp"></jsp:include><br>
</c:if>


<!-- <a href="register"> Registration </a></br> -->
<c:if test="${hasClickedRegistration==true}">
<jsp:include page="registration.jsp"></jsp:include><br>
</c:if>


<c:if test="${not empty loginMessage}">
<a href="logout">Logout </a></br>
</c:if>

<c:if test="${isAdmin = false }">
<a href="mycart">My Carts </a></br>
</c:if>



</body>
</html>