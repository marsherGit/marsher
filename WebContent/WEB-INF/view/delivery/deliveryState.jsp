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
			main_nav.find(".sub_nav>li").eq(1).addClass("on");
			$(".aside-wrapper>.list-group>.list-group-item").eq(1).addClass("on");
		})
	</script>
	<h1>배송현황 페이지</h1>
	<p>처음 리스트 표시(페이징), 제목 누르면 해당 상세 발주서 페이지로 이동(배송상태 표시), 상세페이지에 수정하기,삭제하기,pdf출력 버튼</p>
</body>
</html>