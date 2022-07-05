<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer list Update </title>
</head>
<body>
    <h1 style="background-color:#32CD32;" align="center"> CUSTOMER RELATIONSHIP MANAGEMENT </h1>
    <h2>Save Customer</h2> 
	<form action="save" method="post">
		<table>
			<tr>
				<td>FirstName</td>
				<td><input type="text" value="${customer.firstName}"
					name="firstName" /></td>
			</tr>
			<tr>
			<tr>
				<td>LastName</td>
				<td><input type="text" value="${customer.lastName}"
					name="lastName" /></td>
			</tr>
			<tr>
			<tr>
				<td>Email</td>
				<td><input type="text" value="${customer.email}"
					name="email" /></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="hidden" value="${customer.id}"
					name="id" /><input type="submit" /></td>
			</tr>
			<tr>
				<td><a href="list">Back to List</a></td>
			</tr>

		</table>
	</form>
</body>
</html>