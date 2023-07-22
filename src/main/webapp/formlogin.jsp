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
<link rel="stylesheet" href="../CSS/login.css">
</head>
<body>
	<div class="container">
		<form action="login" method="post">
			<a class="bottone" id="home"href="/">HOME</a>
			<h2 id="titolo">LOGIN</h2>
			Username<input type="text" placeholder="username" name="username"><br><br>
			Password <input type="password" placeholder="Password" name="password"> <br> <br>
			<input type="submit" class="bottone" value="LOGIN"><br><br>
			<a id="passwordsma" href="formuser">Hai dimenticato la password?</a><br><br>
			Non hai un account?       <a class="bottone" href="formregistra">REGISTRATI</a>
		</form>
	</div>
	

</body>
</html>