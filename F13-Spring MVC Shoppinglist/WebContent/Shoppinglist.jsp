<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<p><a href="createitemform.do">Create item</a></p>

<table border=1>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Price</th>
		<th>Description</th>
	</tr>
	<c:forEach var="item" items="${items}">
		<tr>
			<td>${item.id}</td>
			<td>${item.name}</td>
			<td>${item.price}</td>
			<td>${item.description}</td>
			<td><a href="viewitem.do?id=${item.id}">View item</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
