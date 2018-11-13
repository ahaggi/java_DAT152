<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="bgcolor" type="String"%>

<style>
table {
    background-color:${bgcolor};
}
th,td {
    border:1px solid black;
}
</style>

<table>
	<tr>
		<th><h2>
				<br>
				<jsp:doBody />
			</h2></th>
	</tr>
</table>

