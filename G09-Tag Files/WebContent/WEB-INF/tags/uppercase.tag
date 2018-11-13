<%@ tag language="java" pageEncoding="UTF-8"%>

<jsp:doBody var="theBody" />

<%
    String bc = (String) jspContext.getAttribute("theBody");
%>

<%=bc.toUpperCase()%>
