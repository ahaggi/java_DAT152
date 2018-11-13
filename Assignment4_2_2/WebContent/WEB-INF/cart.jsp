<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:bundle basename="apptexts"> <!--  -->


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="cart"/></title>

<style>

table {
	border-collapse: collapse;
}

th, td {
	padding: 0.25rem;
}

</style>

</head>
<body>




<p><jsp:include page="chooseLanguage.jsp" /></p>

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
		
		<c:forEach items="${products}" var="item">
		<tr>
			<td>${item.name}</td>
			<td>${item.description.text}</td>
			<td><fmt:formatNumber type="currency" value="${item.price * cr}"/></td>
			<td> ${cart.cartItems[item.id]}  </td>
			<td><fmt:formatNumber type="currency" value="${cart.getTotalPriceForEachItem(item.id) * cr}"/></td>
 		</tr>
		</c:forEach>

		<tr>
			<th colspan="4" style="text-align:right"><fmt:message key="totalAmount"/></th>
			<th><fmt:formatNumber value="${cart.totalPrice* cr}" type="currency"/></th>
		</tr>
		
	</table>

	<a href="homeServlet">Home</a>
	<a href="productsServlet"><fmt:message key="products" /></a>
	
	<p>${Utility.copyright("HVL", 2012)}</p>
</body>
</html>

</fmt:bundle>