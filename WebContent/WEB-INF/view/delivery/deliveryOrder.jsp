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
			main_nav.find(".sub_nav>li").eq(2).addClass("on");
			$(".aside-wrapper>.list-group>.list-group-item").eq(2).addClass("on");
		})
	</script>
	<h1>발주서등록 페이지</h1>
	<p>발주서 입력 폼 구현, 폼 입력하면 미입고현황(리스트)페이지로 이동 </p>
</body>
</html>