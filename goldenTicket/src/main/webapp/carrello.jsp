<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ant.goldenticket.entities.*"%>
<%@ page import="com.ant.goldenticket.*"%>

<%
List<String> c = (List<String>) request.getAttribute("listacitta");
%>
<%
List<String> t = (List<String>) request.getAttribute("listatipologia");
%>
<%
Map<String, List<String>> z = (Map<String, List<String>>) request.getAttribute("listazone");
%>
<%
Map<String, List<String>> g = (Map<String, List<String>>) request.getAttribute("listaSG");
%>

<%
List<Biglietto> biglietti = (List<Biglietto>) request.getAttribute("listabiglietti");
%>
<%
String controllaLogin = (String) request.getAttribute("controllologin");
%>

<!DOCTYPE html>
<html>

  <head>
      <title>GoldenTicket</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="icon" type="image/x-icon" href="/IMG/favicon.jpeg">
      <link rel="stylesheet" href="../CSS/index.css">
      <link rel="stylesheet" href="../CSS/navbar.css">
      <link rel="stylesheet" href="../CSS/carrello.css">
      <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css">
      <script src="File.js"></script>
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
            <li><a href="/"><i class="fa fa-single fa-home"></i></a></li>
            <!--/ home -->
            <!-- about -->
            <!-- Città  -->
            <li aria-haspopup="true"><a>Citta'<i
                class="fa fa-indicator fa-chevron-down"></i></a>
              <div class="grid-container3">
                <ul>
                  <!-- FOR PER STAMPARE NOMI CITTA'-->
                  <%
                  for (String citta : c) {
                  %>
                  <li><a href="leggicitta?citta=<%=citta%>"></i><%=citta%><i
                      class="fa fa-group"></i><i
                      class="fa fa-indicator fa-chevron-right"></i></a>
                    <div class="grid-container3">
                      <ul>
                        <%
                        for (String zone : z.get(citta)) {
                        %>
                        <li aria-haspopup="true"><a
                          href="leggizone?citta=<%=citta%>&zona=<%=zone%>"><%=zone%></a> <%
                         }
                         %></li>
                      </ul>
                    </div></li>
                  <%
                  }
                  %>
                </ul>
              </div></li>
            <!--/ about -->
            <!-- Tipologia -->
            <li aria-haspopup="true"><a href="#">Tipologia<i
                class="fa fa-indicator fa-chevron-down"></i></a>
              <div class="grid-container3">
                <ul>
                  <!-- FOR PER STAMPARE NOMI CITTA'-->
                  <%
                  for (String tipologia : t) {
                  %>
                  <li><a href="leggitipologia?tipologia=<%=tipologia%>"><%=tipologia%><i
                      class="fa fa-group"></i><i
                      class="fa fa-indicator fa-chevron-right"></i></a>
                    <div class="grid-container3">
                      <ul>
  
                        <%
                        for (String genere : g.get(tipologia)) {
                        %>
                        <li aria-haspopup="true"><a
                          href="leggigenere?tipologia=<%=tipologia%>&genere=<%=genere%>"><%=genere%></a> <%
                         }
                         %></li>
                      </ul>
                    </div></li>
                  <%
                  }
                  %>
                </ul>
              </div></li>
            <!--/ news -->
            <!-- eventi -->
            <li><a href="eventi">Eventi</a></li>
  
            <div class="navbar">
              <div class="search-container">
                <form action="ricerca" method="get">
                  <input type="text" placeholder="Nome,Artista,Citta'..."
                    name="search">
                  <button type="submit">
                    <i class="fa fa-search"></i>
                  </button>
                </form>
              </div>
              <div class="login">
                <div class="search-container">
                  <%if(controllaLogin != null){%>
                  <form action="carrello" method="get">
                    <button type="submit">
                      <i class="fas fa-shopping-cart"></i>
                    </button>
                  </form>
                  <a href="acquisti" id="" type="submit">ACQUISTI</a> <a href="logout"
                    id="logout" type="submit">ESCI</a>
                </div>
              </div>
        <% }else {%>
          <form action="carrello" method="get">                  
            <button type="submit"><i class="fas fa-shopping-cart"></i></button>
          </form>  
          <a href="formlogin" id="login" type="submit">LOGIN</a>      
        <%} %>
            </div>
  
          </ul>
        </div>
      </div>
      <!--B-->
      <div id="context_carrello">
      <br><br>
        Prezzo: <output id="prezzo"> </output> Euro
        <form action="checkout" method="get">
          <%for(Biglietto b : biglietti) {%>
          <div class="card_biglietto">
            <div class="img_biglietto">
              <img src="<%=b.getEvento().getLocandina()%>" id="locandina">
            </div>

            <div class="info_biglietto">
              <p>Evento: <%=b.getEvento().getNome()%></p>
              <span>Data: <%=b.getEvento().getData() %></span>
              <p>Orario: <%=b.getEvento().getOra() %></p>
              <span>Fila: <%=b.getFila() %></span>
              <span>Posto: <%=b.getPosto() %></span>
              <span>Prezzo: <%=b.getPrezzo() %></span>
            </div>

            <div class="link_biglietto">
              <a href="eliminadacarrello?id=<%=b.getId()%>">ELIMINA</a>
              <label for="a-<%=b.getId()%>">Compra</label>
              <input type="radio" name="a-<%=b.getId()%>" onchange="aggiornaP(<%=b.getPrezzo()%>);stampaP()">
            </div>
          </div>
			    <%} %>
		  <br>
          <input type="reset" value="pulisci" onclick="pulisciP();stampaP()">
          <input type="submit" value="checkOut" style="left: 50%;">
        </form>
    </div>
    
      <div class="footer">
        <div id="linguaggi">
          <h2>Tecnologie Utilizzate</h2> 
          <h4>FRONT-END</h4>
          <a href="https://www.w3schools.com/html/default.asp" target="_blank">HTML</a>
          <a href="https://www.w3schools.com/cs/default.asp" target="_blank">CSS</a>
          <a href="https://www.w3schools.com/js/default.asp" target="_blank">JavaScript</a>
        </div>

</div>
</body>
<script>
	stampaP()
</script>
</html>
