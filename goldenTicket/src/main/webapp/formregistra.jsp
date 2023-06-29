<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GoldenTicket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="/IMG/favicon.jpeg">
<script src="File.js"></script>
</head>
<body>
	<a href="/">HOME</a>
	<form action="registrati" method="post">
		<h2 id="titolo">Non sei registrato?</h2>
		Nome utente <input type="text" placeholder="Nome utente"
			name="username" id="u"><br> Password <input type="password"
			placeholder="Password" name="password" id="p"><br> <br> <input
			type="submit" class="bottone" value="REGISTRATI" onclick="controlregistra()"> <br>
	</form>
</body>
</html>