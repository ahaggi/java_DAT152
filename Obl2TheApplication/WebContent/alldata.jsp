<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<h3>Users</h3>
			<table>
	
	<c:forEach var="user" items="${allUsers}">
		<tr> 
		<td> ${user.username}</td> 
		<td> ${user.passhash}</td> 
		<td> ${user.firstname}</td> 
		<td> ${user.lastname}</td> 
		<td> ${user.mobilephone}</td> 
		</tr>	 
	</c:forEach>
	</table>
	<br>
	<p><a href="searchpage">Back to Main search page</a></p>
	<p><b>You are logged in as ${user.username}. <a href="logout">Log out</a></b></p>
</body>
</html>