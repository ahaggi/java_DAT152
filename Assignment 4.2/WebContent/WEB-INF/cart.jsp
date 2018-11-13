<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:bundle basename="apptexts">

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="cart"/></title>
</head>
<body>

<style>

table {
	border-collapse: collapse;
}

th, td {
	padding: 0.25rem;
}

</style>

<p><jsp:include page="lib/chooseLanguage.jsp" /></p>

	<h1>
		<fmt:message key="cart" />
	</h1>

	<table border="1">
		<tr>
			<th><fmt:message key="name"/></th>
			<th><fmt:message key="shortDescription"/></th>
			<th><fmt:message key="price"/></th>
			<th><fmt:message key="quantity"/></th>
			<th><fmt:message key="total"/></th>
		</tr>
		<fmt:message var="cr" key="conversionRate" />
		<c:forEach items="${cart}" var="item">
		<tr>
			<td>${item.product.name}</td>
			<td>${item.product.description.text}</td>
			<td><fmt:formatNumber type="currency" value="${item.product.price * cr}"/></td>
			<td>${item.quantity}</td>
			<td><fmt:formatNumber type="currency" value="${item.totalPrice * cr}"/></td>
		</tr>
		</c:forEach>
		<tr>
			<th colspan="4" style="text-align:right"><fmt:message key="totalAmount"/></th>
			<th><fmt:formatNumber type="currency" value="${total * cr}"/></th>
		</tr>
	</table>

	<a href="home">Home</a>
	<a href="products"><fmt:message key="products" /></a>
	
	<p>${Utility.copyright("HVL", 2012)}</p>
</body>
</html>

</fmt:bundle>