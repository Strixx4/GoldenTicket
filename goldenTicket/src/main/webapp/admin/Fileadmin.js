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
function nascondi() {
	document.getElementById("listNome").style.display = "none";
	document.getElementById("listArtista").style.display = "none";
	document.getElementById("listCitta").style.display = "none";
}

function controlArtista() {
	let lnom = document.getElementById("nom").value.length;
	if (lnom < 1 || lnom > 100) {
		alert("campo scorretto");
	}
}
function controlUser() {
	let lu = document.getElementById("u").value.length;
	let lp = document.getElementById("p").value.length;
	if (lu < 1 || lu > 50) {
		alert("campo scorretto");
	}
	if (lp < 1 || lp > 16) {
		alert("campo scorretto");
	}
}
function controlLocalita() {
	let c = document.getElementById("c").value.length;
	let z = document.getElementById("z").value.length;
	let p = document.getElementById("p").value;
	let i = document.getElementById("i").value.length;
	if (i < 1 && i > 100)
		alert("campo scorretto");
	if (c < 1 && c > 50)
		alert("campo scorretto");
	if (z < 1 && z > 20)
		alert("campo scorretto");
	if (isNan(p))
		alert("campo scorretto");
	if (!isNaN(p)) {
		if (p < 0) {
			alert("campo scorretto");
		}
	}
}

function controlEvento() {
	let n = document.getElementById("n").value.length;
	let t = document.getElementById("t").value.length;
	let g = document.getElementById("g").value.length;
	let d = document.getElementById("d").value.length;
	let gs = document.getElementById("gs").value.length;
	let o = document.getElementById("o").value.length;
	let l = document.getElementById("l").value.length;
	let c = document.getElementById("c").value.length;
	let z = document.getElementById("z").value.length;
	let a = document.getElementById("a").value;

	if (c < 1 && c > 50)//
		alert("campo scorretto");
	if (z < 1 && z > 20)//
		alert("campo scorretto");
	if (n < 1 && n > 100)//
		alert("campo scorretto");
	if (t < 1 && t > 40)//
		alert("campo scorretto");
	if (g < 1 && g > 30)//
		alert("campo scorretto");
	if (d < 10)
		alert("campo scorretto");
		
	if (gs < 1 && gs > 30)
		alert("campo scorretto");
	if (o < 1 && o > 10)
		alert("campo scorretto");
	if (l < 1 && z > 300)
		alert("campo scorretto");
	if (a.length < 1)
		alert("campo scorretto");
	let ar = a.split(",");
	for(let i = 0;i<ar.length;i++){
		if(s<1 || s >100){
			alert("campo scorretto");
		}
	}

}
