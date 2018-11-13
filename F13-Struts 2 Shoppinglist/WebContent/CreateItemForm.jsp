<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>

	<s:form action="createItemSave" validate="true">
		<p>
			Id
			<s:property value="id" />
			<input type="hidden" name="id" value="<s:property value="id"/>" />
		</p>
		<s:textfield label="Name" name="name" />
		<s:textfield label="Price" name="price" />
		<s:textfield label="Description" name="description" />
		<s:submit value="Save" />
	</s:form>

</body>
</html>
