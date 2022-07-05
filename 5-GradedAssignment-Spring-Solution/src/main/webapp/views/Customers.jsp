<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>

<style>
table {
	background: white;
}
</style>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

</head>
<script type="text/javascript">
function confirmDelete(){
	var del=confirm("Do you really want to delete")
	if(del){
		alert("del confirmed")
		window.document.myForm.action="test.jsp"
        window.document.myForm.submit()
	}
	else{
		alert("del cancelled")
	}
}
</script>
<body>
	
	<h1 style="background-color: #32CD32;" align="center">CUSTOMER RELATIONSHIP MANAGEMENT</h1>

	<table align="left">
		<tr>
			<td><a href="addCustomer?id=-1"><input type="button"
					value="Add Customer" /></a></td>

		</tr>
	</table>
	<form action="search" method="post">
		<table align="center" weight="70%" height="70%">
			<tr>
				<td><input type="text" name="firstName"
					placeholder="Search By firstName" /></td>
				<td colspan="2"><input type="submit" value="search"></td>
			</tr>
			<tr>
		</table>
	</form>

	<h1 style="background-color: #32CD32;" align="center">Display
		Table</h1>



	<table align="center">

		<thead>

			<tr style="background-color: #32CD32">
				<th>id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customer}" var="customer">

				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td colspan="2" align="center">
					<a href="addCustomer?id=${customer.id}">Update|</a>
				    <a href="deleteCustomer?id=${customer.id}"  onclick="confirmDelete()">|Delete</a>
				    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<script>
$( "tr:even" ).css( "background-color", "#BDBCBC" );
</script>
</body>
</html>
