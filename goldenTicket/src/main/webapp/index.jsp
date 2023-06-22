<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.ant.goldenticket.entities.*" %>
<% List<String> c = (List<String>)request.getAttribute("listacitta");%>
<% List<String> t = (List<String>)request.getAttribute("listageneri");%>
<% Map<String, List<String>> z = (Map<String, List<String>>)request.getAttribute("listazone");%>
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
      <script src="../JS/File.js"></script>
  </head>

  <body>

    <div id="container">
      <div class="header">
        <img src="../IMG/golden-ticket.png" id="logo">
        <h1>Golden Ticket</h1>
        <img src="../IMG/golden-ticket.png" id="logo">      
      </div>
        
      <!-- mega menu -->
      <ul class="sky-mega-menu sky-mega-menu-anim-flip sky-mega-menu-response-to-icons">
        <!-- home -->
        <li>
          <a href="/"><i class="fa fa-single fa-home"></i></a>
        </li>
        <!--/ home -->
        <!-- Città -->
        <li aria-haspopup="true">
          <a>Citt�<i class="fa fa-indicator fa-chevron-down"></i></a>
          <div class="grid-container3">
            <ul>
              <!-- FOR PER STAMPARE NOMI CITTA'-->
            <% for(String citta : c){%>
            	<li><a href="leggicitta?citta=<%=citta%>"></i><%=citta%><i class="fa fa-group"></i><i class="fa fa-indicator fa-chevron-right"></i></a>
                <div class="grid-container3">
                  <ul>

                    <% for(String zone : z.get(citta)){ %>
                    <li aria-haspopup="true">
                      <a href="leggicitta?citta=<%=citta%>;leggizona?zone=<%=zone%>"><i class="fa fa-female"></i><%=zone%></a>
                      <%} %>
                    </li>
                  </ul>
                </div>
              </li>
            <%}%>           
            </ul>
          </div>
        </li>
        <!--/ Città -->

        <!-- Tipologia -->
        <li aria-haspopup="true">
          <a href="#">Tipologia<i class="fa fa-indicator fa-chevron-down"></i></a>
          <div class="grid-container3">
            <ul>
              <!-- FOR PER STAMPARE NOMI CITTA'-->
            <% for(String l : t){%>
            	<li><a href="leggigenere?genere=<%=l%>"></i><%=l%></a></li>
            <%}%>
            </ul>
          </div>
        </li>
        
          <div class="navbar"> 
            <div class="search-container">
              <form action="" method="get">
                <input type="text" placeholder="Search.." name="search">
                <button type="submit"><i class="fa fa-search"></i></button>
              </form>
               
            </div>
            <div class="login">
              <a href="formlogin.jsp" id="login" type="submit">LOGIN</a>
            </div>
          </div>
        <!--/ contacts -->
      </ul>
      <!--/ mega menu -->
    </div>

      <div class="context">
        
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
          <h2>La Societ�</h2>
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