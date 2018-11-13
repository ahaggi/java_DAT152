<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Datakomponenten AS</title>
</head>
<body>
	<p><jsp:include page="chooseLanguage.jsp"/></p>
	<h1>Datakomponenten AS</h1>
	<img src="img/home.jpg">
	<fmt:bundle basename="apptexts">
	<p>
		<fmt:message key="greeting"/>
		<a href="productsServlet"><fmt:message key="products"/></a>
	</p>
	</fmt:bundle>
</body>
</html>