<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ant.goldenticket.entities.*" %>
<%@ page import="com.ant.goldenticket.*" %>
<% List<String> c = (List<String>)request.getAttribute("listacitta");%>
<% List<String> t = (List<String>)request.getAttribute("listatipologia");%>
<% Map<String, List<String>> z = (Map<String, List<String>>)request.getAttribute("listazone");%>
<% Map<String, List<String>> g = (Map<String, List<String>>)request.getAttribute("listaSG");%>


<% List<Evento> el=  (List<Evento>)request.getAttribute("lNome");%>
<% List<Evento> al=  (List<Evento>)request.getAttribute("lArtista");%>
<% List<Evento> ll=  (List<Evento>)request.getAttribute("lLocalita");%>
<% String controllaLogin = (String) request.getAttribute("controllologin");%>
<!DOCTYPE html>
<html>
	<head>
		<title>GoldenTicket</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" type="image/x-icon" href="/IMG/favicon.jpeg">
		<link rel="stylesheet" href="../CSS/index.css">
		<link rel="stylesheet" href="../CSS/navbar.css">
		<link rel="stylesheet" href="../CSS/card.css">
		<link rel="stylesheet"
			href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
		<script src="../admin/Fileadmin.js"></script>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<Script src="../admin/jqSearchadmin.js"></Script>
	</head>

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
									class="fa fa-group"></i></a>
							</li>
							<li><a href="formnuovoartista">Artista<i
									class="fa fa-group"></i></a>
							</li>
							<li><a href="formnuovolocalita">Localita'<i
									class="fa fa-group"></i></a>
							</li>
							<li><a href="formnuovouser">User</i><i
									class="fa fa-group"></i></a>
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
		<div class="ricerca">
			<!-- Controllo se non esiste nessun risultato-->
			<%if(el.size() == 0 && al.size() == 0 && ll.size() == 0){ %>
				<img src="IMG/notfound.jpg" alt="Pineapple">
			  <p>Non ho trovato nessun risultato per tutti i campi</p>
			  <p>Hai provao a ridurre la ricerca?</p>
			<%} else { %>
				<!-- Qui ho trovato almeno una cosa-->
				<!-- Controllo se esiste almeno una città-->
				<% if(el.size() > 0){ %>
				  <h3 class="hn">EVENTI PER NOME ( <%=el.size() %> )</h3>
				  <div id="listNome" class="context">
				  <%for(Evento e : el){ %>
				  <div class="card">
					<div class="img-card" >
					  <img src="<%=e.getLocandina()%>">
					</div>
					<div class="nome-card">
					  <h1>
						<%=e.getNome()%>
					  </h1>
					</div>
					<div class="paragrafo-card">
					  <p>
						<%=e.getLocalita().getCitta()%><br>
						<%=e.getLocalita().getZona()%><br>
						<%=e.getGiornoSettimana()%>
						<%=e.getData()%>
						alle ore
						<%=e.getOra()%>
					  </p>
					</div>
					<div class="dettagli-card">
					  <a href="dettagli?id=<%=e.getId()%>">DETTAGLI</a>
					</div>
				  </div>
					<%}%>
				  </div>
				<%}%>
			  <!-- Fine controllo città-->
	
			  <!-- Controllo se esiste almeno un artista trovato-->
			  <% if(al.size() > 0){ %>
				<h3 class="ha">EVENTI PER ARTISTA ( <%=al.size() %> )</h3>  
				<div id="listArtista" class ="context">
				  <%for(Evento e : al){ %>
					<div class="card">
					  <div class="img-card" >
						<img src="<%=e.getLocandina()%>">
					  </div>
					  <div class="nome-card">
						<h1>
						  <%=e.getNome()%>
						</h1>
					  </div>
					  <div class="paragrafo-card">
						<p>
						  <%=e.getLocalita().getCitta()%><br>
						  <%=e.getLocalita().getZona()%><br>
						  <%=e.getGiornoSettimana()%>
						  <%=e.getData()%>
						  alle ore
						  <%=e.getOra()%>
						</p>
					  </div>
					  <div class="dettagli-card">
						<a href="dettagli?id=<%=e.getId()%>">DETTAGLI</a>
					  </div>
					</div>
				  <%}%>
				</div>
			  <%}%>
	
			  <!-- Controllo se esiste almeno una citta-->
			  <% if(ll.size() > 0){ %>
				<h3 class="hc">EVENTI PER CITTA ( <%=ll.size() %> )</h3>  
				<div id="listCitta" class="context">
				<%for(Evento e : ll){ %>
				<div class="card">
				  <div class="img-card" >
					<img src="<%=e.getLocandina()%>">
				  </div>
				  <div class="nome-card">
					<h1>
					  <%=e.getNome()%>
					</h1>
				  </div>
				  <div class="paragrafo-card">
					<p>
					  <%=e.getLocalita().getCitta()%><br>
					  <%=e.getLocalita().getZona()%><br>
					  <%=e.getGiornoSettimana()%>
					  <%=e.getData()%>
					  alle ore
					  <%=e.getOra()%>
					</p>
				  </div>
				  <div class="dettagli-card">
					<a href="dettagli?id=<%=e.getId()%>">DETTAGLI</a>
				  </div>
				</div>
				<%}%>
			  </div>
			  <%} %>
	
			  <!-- Fine controllo iniziale-->
			  <%}%>
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
					<a href="https://www.w3schools.com/MySQL/default.asp"
						target="_blank">MySQL</a> <a href="https://spring.io/">Spring</a>
	
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
	<script>nascondi()</script>
</html>
