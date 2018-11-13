<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="dat152-libs" prefix="dat152"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<dat152:printHelloWorld />
	</p>

	<p>
	
		<dat152:tempConverting temp="290" scale="celsius" />
	</p>
	<p>
		1234 binary is 
		<dat152:binary decimalNumber="1234" />
		<br/>
		Ved bruk av el
		<c:set var="el_var" value="1234" />
		<dat152:binary decimalNumber="${el_var}" />
		<br/>
		Ved bruk av scriplet, 
		<%int x = 1234;%>
		<dat152:binary decimalNumber="<%=x%>" />        <font color ="red">                  fordi rtexprvalue=true i dat152.tld</font>
		
	</p>

	<p>
		1234 octale is 
		<dat152:octal decimalNumber="1234" />
	</p>

	<dat152:uppercase>
		<h1>This is the header</h1>
		<p>This is a text</p>
		<p>
			<b>This is a text in bold</b>
		</p>
	</dat152:uppercase>

	<p>
		<dat152:box color="red"> Heia Brann </dat152:box>
	</p>
	<p>
		<dat152:headertag headerSize="1"> Heia Brann </dat152:headertag>
		<dat152:headertag headerSize="2"> Heia Brann </dat152:headertag>
		<dat152:headertag headerSize="3"> Heia Brann </dat152:headertag>
	</p>
	
</body>
</html>
