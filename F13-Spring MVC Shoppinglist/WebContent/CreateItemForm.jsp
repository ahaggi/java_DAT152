<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

	<form action="createitemsave.do" method="post">
		<p>
			Id ${id} <input type="hidden" name="id" value="${id}" />
		</p>
		<p>
			Name <input type="text" name="name" value="" />
		</p>
		<p>
			Price <input type="text" name="price" value="" />
		</p>
		<p>
			Description <input type="text" name="description" value="" />
		</p>
		<p>
			<input type="submit" name="saveitembutton" value="save" />
		</p>
	</form>

</body>
</html>
