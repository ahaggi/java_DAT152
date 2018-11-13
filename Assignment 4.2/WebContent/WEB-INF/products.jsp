<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<fmt:bundle basename="apptexts">
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="products" /></title>
</head>
<body>
	<p><jsp:include page="lib/chooseLanguage.jsp" /></p>
	<h1>
		<fmt:message key="products" />
	</h1>

	<form action="cart" method="post">
	<table>
		<c:forEach items="${products}" var="product">
			<tr>
				<td><img src="img/gpu.png" width="300px"></td>
				<td>
					<table style="margin-left: 1rem">
						<tr>
							<td><fmt:message key="name" />: ${product.name}</td>
						</tr>
						<tr>
							<fmt:message var="cr" key="conversionRate" />
							<td><fmt:message key="price" />: <fmt:formatNumber type="currency" value="${product.price * cr}"/></td>
						</tr>
						<tr>
							<td><fmt:message key="description" />:
								${product.description.text}</td>
						</tr>
						<tr>
							<td>
								<button type="submit" name="productId" value="${product.id}">
									<fmt:message key="addToCart"/>
								</button>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
	</form>

	<a href="home">Home</a>
	<a href="cart"><fmt:message key="cart" /></a>
</body>
</html>
</fmt:bundle>