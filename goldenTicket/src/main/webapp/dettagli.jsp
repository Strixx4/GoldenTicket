<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "com.ant.goldenticket.entities.*" %>
    <% Evento e = (Evento) request.getAttribute("evento"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


</head>

<body>
<a href = "eventi"> ELENCO </a>
<%= e.getNome()%> <br>
<%=	e.getTipologia()%> <br>
<%=	e.getGenere()%>  <br>
<%=e.getData()%><%=e.getGiornoSettimana()%> <%=	e.getOra()%>  <br>
<%=e.getLocalita()%> <br>
<%=e.getLocandina()%> <br>



</body>
</html>