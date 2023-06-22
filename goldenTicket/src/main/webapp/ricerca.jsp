<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.ant.goldenticket.entities.*" %>
<% List<Evento> el=  (List<Evento>)request.getAttribute("lNome");%>
<% List<Evento> al=  (List<Evento>)request.getAttribute("lArtista");%>
<% List<Evento> ll=  (List<Evento>)request.getAttribute("lLocalita"); %>
<!DOCTYPE html>
<html>
  <head>
      <title>GoldenTicket</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>DropDown Menu</title>
      <link rel="icon" type="image/x-icon" href="/IMG/favicon.jpeg">
      <link rel="stylesheet" href="../CSS/index.css">
      <link rel="stylesheet" href="../CSS/navbar.css">
      <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
      <script src="File.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
      <Script src="jqSearch.js"></Script>
  </head>

  <body>

    <div id="container">
      <div class="header">
        <img src="../IMG/golden-ticket.png" id="logo">
        <h1>Golden Ticket</h1>
        <img src="../IMG/golden-ticket.png" id="logo">      
      </div>
        
      <div id="megamenu">
        <!-- mega menu -->
        <div class="caselle-sinistra">
          <ul class="sky-mega-menu sky-mega-menu-anim-flip sky-mega-menu-response-to-icons">
            <!-- home -->
            <li>
              <a href="/"><i class="fa fa-single fa-home"></i></a>
            </li>
            

          <div class="navbar"> 
            <div class="search-container">
              <form action="">
                <input type="text" placeholder="Search.." name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
              </form>
               
            </div>
            <div class="login">
              <a href="../HTML/index.html" id="login" type="submit">LOGIN</a>
            </div>
          </div>
          <!--/ contacts -->
        </ul>
      </div>
        <!--/ mega menu -->
      </div>

      <div class="context">
      <!-- INSERISCI QUI -->
      <h3 class="hn">EVENTI PER NOME ( <%=el.size() %> )</h3>
      <div id="listNome">
          <%for(Evento e : el){ %>
          <div class="n">
          	<a href="dettagli?id=<%=e.getId()%>"><%=e.getNome()%></a>
          </div>
          <%}%>
        </div>
      <h3 class="ha">EVENTI PER ARTISTA ( <%=al.size() %> )</h3>  
      <div id="listArtista">
          <%for(Evento e : al){ %>
          <div class="a">
          	<a href="dettagli?id=<%=e.getId()%>"><%=e.getNome()%></a>
          </div>
          <%}%>
          </div>
      <h3 class="hc">EVENTI PER CITTA ( <%=ll.size() %> )</h3>  
      	<div id="listCitta">
          <%for(Evento e : ll){ %>
          <div class="c">
          	<a href="dettagli?id=<%=e.getId()%>"><%=e.getNome()%></a>
          	</div>
          <%}%>
          </div>
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
            <a href="https://www.w3schools.com/MySQL/default.asp" target="_blank">MySQL</a>
            <a href="https://spring.io/">Spring</a>
          
        </div>
        
        <div id="societa">
          <h2>La Società </h2>
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
  	<script>nascondi();</script>
</html>
