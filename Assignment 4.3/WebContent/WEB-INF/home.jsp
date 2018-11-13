<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="dat152-utils" prefix="utils" %>

<fmt:bundle basename="apptexts">
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Datakomponenten AS</title>
</head>
<body>
	<p><jsp:include page="lib/chooseLanguage.jsp"/></p>
	<h1>Datakomponenten AS</h1>
	<img src="img/home.jpg">
	
	<p>
		<fmt:message key="greeting"/>
		<a href="products"><fmt:message key="products"/></a>
	</p>
	
	
	<p><utils:copyright since="2014">Høgskolen på Vestlandet</utils:copyright></p>
</body>
</html>
</fmt:bundle>