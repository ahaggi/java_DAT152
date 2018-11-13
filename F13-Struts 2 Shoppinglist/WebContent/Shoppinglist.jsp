<%@ page contentType="text/html"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>

	<p>
		<a href="<s:url action="createitemform"/>">Create Item</a>
	</p>

	<table border=1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Description</th>
		</tr>
		<s:iterator value="items">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="price" /></td>
				<td><s:property value="description" /></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>



