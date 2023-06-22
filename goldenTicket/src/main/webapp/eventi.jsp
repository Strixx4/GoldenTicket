<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.util.*" %>
    <%@page import = "com.ant.goldenticket.entities.*" %>
    <%List<Evento> eventi = 
    	(List<Evento>)request.getAttribute("eventi");%>
    	
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
</head>
<body>

<!-- elenco degli eventi -->
<%for(Evento e: eventi){ %>
	<%=e.getNome() %> 
	<%=e.getData()%>
	<%=e.getGiornoSettimana()%>
	<%= e.getOra()%> <br>
	<%=e.getLocandina()%> <br>
	<%}%>
</body>
</html>
	