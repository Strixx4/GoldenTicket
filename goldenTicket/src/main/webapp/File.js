/* When the user clicks on the button,
toggle between hiding and showing the dropdown content 
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}*/
function nascondi(){
  		 document.getElementById("listNome").style.display = "none";
  		 document.getElementById("listArtista").style.display = "none";
  		 document.getElementById("listCitta").style.display = "none";
}

function controlRegistra(){
	let lu = document.getElementById("u").value.length;
	let lp = document.getElementById("p").value.length;
	if (lu < 1 || lu > 50) {
		alert("campo scorretto");
	}
	if (lp < 1 || lp > 16) {
		alert("campo scorretto");
	}
}