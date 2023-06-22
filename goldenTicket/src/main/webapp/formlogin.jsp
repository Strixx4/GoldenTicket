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
<h1>Login</h1>
  <div class="container">
  
    <label for="Nome utente"><b>Nome utente</b></label>
    <input type="text" placeholder="Nome utente" name="nomeutente" required>
	<br>
	<br>
	<br>
    <label for="Password"><b>Password</b></label>
    <input type="password" placeholder="Password" name="password" required>

<br>
<br>
<br>
    <button type="submit">LOGIN</button>
    
    
  </div>
</form> 
</body>
</html>