<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supplier Page</title>
</head>
<body>

<h3><center>Manage Supplier</center></h3>	
<hr>

<form action="">

<input type ="text" name="id">
<input type ="text" name="name">
<input type ="text" name="address">
<input type ="submit" value ="Create">


</form>


	<!--${supplierList}  -->



	<table border="2">

		<thead>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Address</td>
				<td>Action</td>

			</tr>
		</thead>

		<c:forEach var="supplier" items="${supplierList}">

			<tr>
				<td>${supplier.id}</td>
				<td>${supplier.name}</td>
				<td>${supplier.address}</td>
				<td> <a href="/manage_supplier_edit"> Edit</a>  |  <a href="/manage_supplier_delete"> Delete</a></td>
			</tr>
				</c:forEach>
	</table>


	<br>
	<br>





</body>
</html>