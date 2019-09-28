<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- set data source --%>

<sql:setDataSource driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu96" user="cs3220stu96"
	password=".ki7x#5L" />


<sql:query var="items">
		
Select * from Menus;
</sql:query>


<sql:query var="orders">
		
Select * from orders2;
</sql:query>

<sql:query var="tables">
		
Select * from tables;
</sql:query>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">



</head>
<body>

	<h1>Admin</h1>

	<br>

	<h3>Table Database</h3>
	<br>

	<table class="table">

		<thead class="thead-dark">
			<tr>
				<%--<th>Modify</th> --%>

				<c:forEach items="${tables.columnNames}" var="col">
					<th><c:out value="${col}" /></th>
				</c:forEach>
			</tr>
		</thead>

		<c:forEach items="${tables.rowsByIndex}" var="row">
			<tr>
				<%-- <td><input type="submit" name="edit" value="edit"></td>--%>
				<c:forEach items="${row}" var="col">
					<td>${col}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<br>

	<h3>Order Database</h3>
	<br>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<%--<th>Modify</th> --%>

				<c:forEach items="${orders.columnNames}" var="col">
					<th><c:out value="${col}" /></th>
				</c:forEach>
			</tr>
		</thead>

		<c:forEach items="${orders.rowsByIndex}" var="row">
			<tr>
				<%-- <td><input type="submit" name="edit" value="edit"></td>--%>
				<c:forEach items="${row}" var="col">
					<td>${col}</td>

				</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<h3>Menu Database</h3>
	<br>

	<table class="table">

		<thead class="thead-dark">

			<tr>
				<%--<th>Modify</th> --%>

				<c:forEach items="${items.columnNames}" var="col">
					<th><c:out value="${col}" /></th>
				</c:forEach>
			</tr>
		</thead>


		<c:forEach items="${items.rowsByIndex}" var="row">
			<tr>
				<%-- <td><input type="submit" name="edit" value="edit"></td>--%>
				<c:forEach items="${row}" var="col">
					<td>${col}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>


	<br>


	<h3>
		Total Cost of The Day:
		<c:out value="${cost}" />
	</h3>
</body>
</html>