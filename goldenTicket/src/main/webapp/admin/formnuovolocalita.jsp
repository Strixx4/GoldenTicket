<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ant.goldenticket.entities.*"%>
<%@ page import="com.ant.goldenticket.*"%>
<!DOCTYPE html>
<html>
<head>
<title>GoldenTicket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/x-icon" href="/IMG/favicon.jpeg">
<link rel="stylesheet" href="../CSS/index.css">
<link rel="stylesheet" href="../CSS/navbar.css">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
<script src="../admin/Fileadmin.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<Script src="../admin/jqSearchadmin.js"></Script>
<body>
	<div id="container">
		<div class="header">
			<img src="../IMG/golden-ticket.png" id="logo">
			<h1>GoldenTicket</h1>
			<img src="../IMG/golden-ticket.png" id="logo">
		</div>

		<div id="megamenu">
			<!-- mega menu -->
			<div class="caselle-sinistra">
				<ul
					class="sky-mega-menu sky-mega-menu-anim-flip sky-mega-menu-response-to-icons">
					<!-- home -->
					<li><a href="/admin/"><i class="fa fa-single fa-home"></i></a></li>
					<!--/ home -->
					<!-- about -->
					<!-- Città  -->
					<li aria-haspopup="true"><a>NUOVO<i
							class="fa fa-indicator fa-chevron-down"></i></a>
						<div class="grid-container3">
							<ul>
								<!-- FOR PER STAMPARE NOMI CITTA'-->
							
								<li><a href="formnuovoevento">Evento<i
										class="fa fa-group"></i><i
										class="fa fa-indicator fa-chevron-right"></i></a>
								</li>
								<li><a href="formnuovoartista">Artista<i
										class="fa fa-group"></i><i
										class="fa fa-indicator fa-chevron-right"></i></a>
								</li>
								<li><a href="formnuovolocalita">Localita'<i
										class="fa fa-group"></i><i
										class="fa fa-indicator fa-chevron-right"></i></a>
								</li>
								<li><a href="formnuovouser">User</i><i

										class="fa fa-group"></i><i
										class="fa fa-indicator fa-chevron-right"></i></a>
								</li>
							</ul>
						</div></li>
					<!--/ about -->
					<!-- eventi -->
					<li><a href="listaeventi">Eventi</a></li>
					<!-- localita-->
					<li><a href="listalocalita">Localita'</a></li>
					<!-- eventi -->
					<li><a href="listaartisti">Artisti</a></li>
					<!-- users -->
					<li><a href="listauser">Users</a></li>
					
					<div class="navbar">
						<div class="search-container">
							<form action="ricercaadmin" method="get">
								<input type="text" placeholder="Nome,Artista,Citta'..."
									name="search">
								<button type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>				
						<!--SI LOGIN -->
						<div class="login">
							<div class="search-container">
								<a href= "logout" id="logout" type="submit">ESCI</a>
							</div>
						</div>

					</div>
				</ul>
			</div>
		</div>
		<div class="context">
			<form action="nuovolocalita" method="get" style=" display: inline-block;">
				<label for="citta">Citta':</label>
				<input type="text" name="citta" placeholder="CittÃ "><br>
				<label for="zona">Zona:</label>
				<input type="text" name="zona" placeholder="Zona"><br>
				<label for="posti">Posti:</label>
				<input type="text" name="posti" placeholder="Numero posti"><br>
				<label for="indirizzo">Indirizzo:</label>
				<input type="text" name="indirizzo" placeholder="Indirizzo"><br>
				<input type="submit" value="Aggiungi" class="bottone">
			</form>
		</div>

		<div class="footer">
			
			<div id="linguaggi">
				<h2>Tecnologie Utilizzate</h2>
				<h4>FRONT-END</h4>
				<a href="https://www.w3schools.com/html/default.asp" target="_blank">HTML</a>
				<a href="https://www.w3schools.com/cs/default.asp" target="_blank">CSS</a>
				<a href="https://www.w3schools.com/js/default.asp" target="_blank">JavaScript</a>
				<h4>BACK-END</h4>
				<a href="https://www.w3schools.com/java/default.asp" target="_blank">Java</a>
				<a href="https://www.w3schools.com/MySQL/default.asp"target="_blank">MySQL</a> 
				<a href="https://spring.io/"ctarget="_blank">Spring</a>

			</div>

			<div id="societa">
				<h2>La Societa'</h2>
				<li>Andrea Sbabo</li>
				<li>Michele Pasino</li>
				<li>Beatrice Sala</li>
				<li>Samuele Alessandro Di Silvestri</li>
				<li>Bryan Huarcaya</li>
			</div>

			<div id="contatti">
				<h2>Contatti</h2>
				<li>andreasbabo6@gmail.com</li>
				<li>michele.pasino@hotmail.com</li>
				<li>sala.beatrice00@gmail.com</li>
				<li>samueledisilvestri@gmail.com</li>
				<li>bryanhuarcayar@gmail.com</li>
			</div>

		</div>
	</div>
</body>
</html>