<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ant.goldenticket.entities.*"%>
<%@ page import="com.ant.goldenticket.*"%>
<%
List<Biglietto> lb = (List<Biglietto>) request.getAttribute("listabiglietti");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/">HOME</a>
	<%
	for (Biglietto b : lb) {
	%>
	<%=b.toString()%>
	<%
	}
	%>
</body>
</html>