<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>   
<%Map<String,String> us=(Map<String,String>)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<title>GoldenTicket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="/IMG/favicon.jpeg">
<link rel="stylesheet" href="../CSS/login.css">
</head>
<body>
	<div class="container">
		<form action="cambiapassword" method="post">
			<a class="bottone" id="home"href="/">HOME</a>
			<h2 id="titolo">CAMBIA PASSWORD</h2>
			Username<input type="text" value="<%=us.get("username")%>" name="username" readonly><br>
			Nuova Password <input type="text" placeholder="Password" name="password"> <br> <br>
			<input type="submit" class="bottone" value="CAMBIA"><br><br>
			
		</form>
	</div>
	

</body>
</html>