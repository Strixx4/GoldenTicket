<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<head>
<link rel="stylesheet" href="../CSS/login.css">
</head>
<body>
 <form action="login" method="post">
 
 
  <div class="container11">
 <div class="container1">

<h1 id = "titolo">Login</h1>
	<label for = "Nome utente">Nome utente</label>
	<br>
    <input type="text" placeholder="Nome utente" name="nomeutente" required>
	<br>
	<br>
	<label for = "Password">Password</label> 
	<br>
    <input type="password" placeholder="Password" name="password" required> 
    <br>
    <button type="submit" class = "bottone">LOGIN</button>
 </div>
 <br>
  <div class="container2">
<h1 id = "titolo">Non sei registrato?</h1>
<label for = "Nome utente">Nome utente</label> 
<br>
    <input type="text" placeholder="Nome utente" name="nomeutente1" >
	<br>
	<br>
	<label for = "Password">Password</label>  
	<br>
    <input type="password" placeholder="Password" name="password1" >
	<br>
    <button type = "submit" class ="bottone">REGISTRATI</button>
     </div>
  </div>
</form> 
</body>
</html>