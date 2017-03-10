<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
</head>
<body style="background-color:#FFDAB9">

<hr>
	<!--  Add 3 links -->
	<a href="manage_categories">Manage Categories</a>
	<br>
	<a href="manage_suppliers">Manage Supplier</a>
	<br>
	<a href="manage_products">Manage Products</a>

	<c:if test="${isUserClickedCategories == true}">
		<jsp:include page="Category.jsp"></jsp:include>

	</c:if>

	<c:if test="${isUserClickedSuppliers == true}">

		<jsp:include page="Supplier.jsp"></jsp:include>

	</c:if>

	<c:if test="${isUserClickedProducts == true}">

		<jsp:include page="Product.jsp"></jsp:include>

	</c:if>
</body>
</html>