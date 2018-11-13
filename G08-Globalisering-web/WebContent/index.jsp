<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My i18n Application</title>
</head>

<body>
	<p><jsp:include page="chooseLanguage.jsp" /></p>
	
<%-- 	<fmt:bundle basename="no.hib.dat152.i18n.example.Messages"> prop. filer var i det samme pkg som servlet --%>
	 	<fmt:bundle basename="Messages"> <!-- trenger ikke å gi hele stien hvis filer ligger i src -->
 		<h3>
			<fmt:message key="home" />
		</h3>
		<p>
			


		</p>
		<p>
			<a href="weather.jsp"><fmt:message key="todaysWeather" /> </a>
		</p>
		
		<form method="post" action="Cart">
				<fmt:message var="shrt" key="shirt" />
				<fmt:message var="pnt" key="pants" />
				<fmt:message var="sho" key="shoes" />
				<fmt:message var="qnt" key="quantity" />
				<fmt:message var="buy" key="buy" />

				<p><input type="radio" name="goods" value="shirt" checked />${shrt}</p>
				<p><input type="radio" name="goods" value="pants"  />${pnt}</p>
				<p><input type="radio" name="goods" value="shoe"  />${sho}</p>
				<p>${qnt}: <input type="number" name="quantity" min="1" max="5" value="1" /></p>
				<p><input type = "submit" value="${buy}"  /></p>
						
		</form>
	</fmt:bundle>

</body>
</html>
