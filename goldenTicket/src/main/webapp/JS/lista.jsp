+<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "java.util.*" %>
    <%@page import = "com.ant.goldenticket.entities.*" %>
    <%List<Evento> eventi = 
    	(List<Evento>)request.getAttribute("elenco");%>
    	
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
</head>
<body>

<!-- elenco degli eventi -->
<%for(Evento e: eventi){ %>
	<%e.getNome(); %> <br>
	<%e.getTipologia(); %> <br>
	<%e.getGenere(); %> <br>
	<%e.getData(); %> <br>
	<%e.getGiornoSettimana(); %> <br>
	<%e.getOra(); %> <br>
	<%e.getLocandina(); %> <br>
	<%e.getArtisti(); %> <br>
	<%
	
	<a href = >
	
</body>
</html>
	
</body>
</html>