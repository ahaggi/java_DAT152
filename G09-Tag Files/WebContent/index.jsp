<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dat152" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Eksempel på tag-files</title>
</head>

<body>
	<p>
		<dat152:printHello name="Atle" />
	</p>

	<p>
		1234 is in binary form: 
		<dat152:binary decimalNumber="1234" />
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

</body>
</html>
