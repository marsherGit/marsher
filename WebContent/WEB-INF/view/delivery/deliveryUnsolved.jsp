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
			main_nav.find(".sub_nav>li").eq(3).addClass("on");
			$(".aside-wrapper>.list-group>.list-group-item").eq(3).addClass("on");
		})
	</script>
	<h1>미입고현황 페이지</h1>
	<p>레이아웃은 배송현황(deliveryState)와 동일, 배송대기중 상태인 리스트만 출력, 제목 클릭시 상세페이지로 이동</p>
</body>
</html>