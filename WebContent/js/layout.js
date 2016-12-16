$(document).ready(function(){
	
	/* 서브메뉴 */
	$(".main_nav > li").hover(function(event){
		var tg = $(this);
		var sub_menu = tg.next('ul');
		tg.addClass('active');
		sub_menu.removeClass('active');
	},function(event){
		$('.main_nav>li').removeClass('active');
		//$(".sub_nav").removeClass('active');
	});
	
});