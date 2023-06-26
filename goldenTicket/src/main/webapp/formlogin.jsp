<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<title>GoldenTicket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="/IMG/favicon.jpeg">
</head>
<body>
	<h2>
		<a href="/">HOME</a>
	</h2>
	<form action="login" method="post">
		<h2 id="titolo">Login</h2>
		Nomeutente<input type="text" placeholder="Nome utente" name="username"><br>
		<br> Password <input type="password" placeholder="Password"
			name="password"> <br> <input type="submit"
			class="bottone" value="LOGIN">
	</form>
	<br>
	<h2>
		<a href="formregistra">REGISTRATI</a>
	</h2>
</body>
</html>