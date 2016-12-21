$(document).ready(function(){
	
	/* 서브메뉴 */ 
	$(".main_nav>li").hover(function(event){
		var tg = $(this);
		var sub_back = $('.sub_back');
		tg.addClass('active');
		sub_back.addClass('active');
	},function(event){
		$(this).removeClass('active');
		$('.sub_back').removeClass('active');
	});
	
});