<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<form action="updateItemSave" method="post">
    <p>Id ${item.id} <input type="hidden" name="id" value="${item.id}" /> </p>
    <p>Name <input type="text" name="name" value="${item.name}" /> </p>
    <p>Price <input type="text" name="price" value="${item.price}" /> </p>
    <p>Description <input type="text" name="description" 
    		value="${item.description}" /> </p>
    <p><input type="submit" name="saveitembutton" value="save" /> </p>
</form>

</body>
</html>
