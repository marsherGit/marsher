<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Title</title>
</head>
<body>
	<script>
		$(document).ready(function(){
			var main_nav = $(".main_nav>li").eq(2);
			main_nav.addClass("on");
			main_nav.find(".sub_nav>li").eq(0).addClass("on");
			$(".aside-wrapper>.list-group>.list-group-item").eq(0).addClass("on");
		})
	</script>
	<h1>배송정보 페이지</h1>
	<p>배송기사정보 페이지 동적구현. 이동없이 정보만 표시.</p>
</body>
</html>