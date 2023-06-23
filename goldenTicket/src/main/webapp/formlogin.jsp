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
 <form action="login" method="post">
 
 
  <div class="container11">
 <div class="container1">

<h2 id = "titolo">Login</h2>
	<label for = "Nome utente">Nome utente</label>
    <input type="text" placeholder="Nome utente" name="nomeutente" required>
	<br>
	<br>
	<label for = "Password   ">Password</label> 
    <input type="password" placeholder="Password" name="password" required> 
    <br>
    <button type="submit" class = "bottone"><a href = "../HTML/testlogin.html">LOGIN</a></button>
  <div class="container2">
<h2 id = "titolo">Non sei registrato?</h2>
<label for = "Nome utente">Nome utente</label> 
    <input type="text" placeholder="Nome utente" name="nomeutente1" >
    <br>
	<label for = "Password   ">Password</label>  
    <input type="password" placeholder="Password" name="password1" >
	<br>
	<br>
    <button type = "submit" class ="bottone"><a href = "../HTML/testregistrazione.html">REGISTRATI</a></button>
    <br>
     </div>
  </div>
</form> 
</body>
</html>