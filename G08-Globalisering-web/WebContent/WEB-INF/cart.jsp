<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My i18n Application</title>
</head>

<body>
	<p><jsp:include page="../chooseLanguage.jsp" /></p>
	
<%-- 	<fmt:bundle basename="no.hib.dat152.i18n.example.Messages"> prop. filer var i det samme pkg som servlet --%>
	 	<fmt:bundle basename="Messages"> <!-- trenger ikke å gi hele stien hvis filer ligger i src -->
 		<h3>
			<fmt:message key="cart" />
		</h3>
		
		<fmt:message var="gds" key="${goods}" />
		
		<c:choose>
		    <c:when test="${pageContext.response.locale eq 'en_US'}"><!-- en key="rate" må ha en param -->
				<fmt:message var="rate" key="rate" ><fmt:param value="${1}" /></fmt:message>
		    </c:when>
		    <c:when test="${pageContext.response.locale eq 'en_GB'}"><!-- en key="rate" må ha en param -->
				<fmt:message var="rate" key="rate" ><fmt:param value="${2}" /></fmt:message> 
		    </c:when>
		    <c:otherwise>
				<fmt:message var="rate" key="rate" /><!-- alle har ikke param, med unntakk av apptexts_en -->
		    </c:otherwise>
		</c:choose>
<%-- 				<fmt:formatNumber type="currency" value="${qnt * rate}"/>               --%>				
		<p>
		
			<fmt:message key="receipt">
				<fmt:param value="${quantity}" />
				<fmt:param value="${gds}" />
				<fmt:param value="${quantity * price * rate}" />
			</fmt:message>			
			
		</p>

		<p>			
			<fmt:message key="time">
				<fmt:param value="<%= new java.util.Date() %>" />
			</fmt:message>
		</p>	
			
		<p>
			<fmt:formatDate type = "time" value = "<%= new java.util.Date() %>" />
		</p>

	</fmt:bundle>

</body>
</html>
