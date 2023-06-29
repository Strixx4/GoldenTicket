$(document).ready(function(){
    $(".hn").click(function(){
      $("#listNome").toggle(1000);
    }); 
  });

$(document).ready(function(){
    $(".ha").click(function(){
      $("#listArtista").toggle(1000);
    }); 
  });
$(document).ready(function(){
    $(".hc").click(function(){
      $("#listCitta").toggle(1000);
    }); 
  });
  
  $('.formArtista').submit(function(){
	  if($('.nominativo')=="")
	  return false;
  })