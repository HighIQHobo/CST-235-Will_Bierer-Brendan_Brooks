jQuery(document).ready(function($){
	$("#login-section").mouseover(function(){
		$(".register-form").hide();
		$(this).animate({backgroundColor: "#ff0000" });
		$(".login-form").slideDown(1000, "swing").delay(1000);
	});
	
	$("#login-section").mouseout(function(){
		$(this).animate({backgroundColor: "#000000" });
	});
	
	
	$("#register-section").mouseover(function(){
		$(".login-form").hide();
		$(this).animate({backgroundColor: "#ff0000" });
		$(".register-form").slideDown(1000, "swing").delay(1000);
	});
	
	$("#register-section").mouseout(function(){
		$(this).animate({backgroundColor: "#000000" });
	});
	
	$(".register-form").mouseover(function(){
		$(".login-form").hide();
	});
	
	$(".login-form").mouseover(function(){
		$(".register-form").hide();
	});
	
	$("#addLobbyBtn").click(function(){
		$("#addLobby").fadeToggle();
	});
});