<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");
	if (id == null) {
%><jsp:forward page="templateTest.jsp">
	<jsp:param name="CONTENTPAGE" value="changeNotMember.jsp" />
</jsp:forward>
<%
	} else {
%><jsp:forward page="templateTest.jsp">
<jsp:param name="CONTENTPAGE" value="changeMember.jsp" />
</jsp:forward>
<%
	}
%>