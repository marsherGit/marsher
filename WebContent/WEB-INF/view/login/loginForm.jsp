<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Marsher :: 로그인</title>
	<!-- Bootstrap Core CSS -->
  <link href="<c:url value="/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="<c:url value="/css/loginForm.css" />" rel="stylesheet">

  <!-- Custom Fonts -->
  <link rel="stylesheet" type="text/css" href="<c:url value="/vendor/nanumfont/nanumfont.css" />" />
	
  <!-- jQuery -->
	<script src="<c:url value="/vendor/jquery/jquery.min.js" />"></script>
	
	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/vendor/bootstrap/js/bootstrap.min.js" />"></script>
		
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  
  <script>
  	function checkIt() {
  		if (!$("#st_id").val()) {
				alert("아이디를 입력해 주세요");
				$("#st_id").focus();
				return false;
			}
			
			if (!$("#passwd").val()) {
				alert("비밀번호를 입력해 주세요");
				$("#passwd").focus();
				return false;
			}
			
			return true;
  	}
  	function checktype() {
  		var check = '${check}';
  		console.log("check="+check); //test
  		switch (check) {
	  	  case '-1' : 
	  		  alert('존재하지 않는 아이디입니다.');
	  	    break;
	  	  case '0' : 
	  			alert('비밀번호를 잘 못 입력하셨습니다.');
	  	    break;
	  	  case '1' : 
	  			alert('로그인타입이 올바르지 않습니다.');
	  	  	break;
	  	} //end switch
  	}
  	
  	$(document).ready(function(){
  		var st_id = $("#st_id").val();
  		if(st_id != ""){
				checktype();
  		}
		})
  </script>
</head>
<body>
	<c:if test="${ memId ne null }">
		<% response.sendRedirect("main"); %>
	</c:if>
	<c:if test="${ memId eq null }">
	<div class="container">
		<div class="login_area row">
			<div class="desktop_img col-sm-5">
				<img src="<c:url value="/images/logo_en.png" />" class="logo" />
				<img src="<c:url value="/images/desktop.png" />" />
			</div>
			
			<form id="loginForm" name="loginForm" action="main" method="post" class="col-sm-7" onsubmit="return checkIt();">
			<div class="row">
				<div class="form-group loginType col-sm-12">
					<label class="radio-inline"><input type="radio" name="logintype" value="store" checked="checked">매장</label>
					<label class="radio-inline"><input type="radio" name="logintype" value="admin">관리자</label>
				</div>
			</div>
			<div class="row">
				<div class="input_area col-sm-8">
					<div class="form-group">
						<c:set var="id" value="${ st_id }" />
						<c:if test="${ id ne null }">
							<input class="form-control" type="text" id="st_id" name="st_id" value="${ id }" placeholder="ID" />
						</c:if>
						<c:if test="${ id eq null }">
							<input class="form-control" type="text" id="st_id" name="st_id" placeholder="ID" />
						</c:if>
					</div>
					<div class="form-group">
						<input class="form-control" type="password" id="passwd" name="passwd" placeholder="Password" />
					</div>
				</div>
				<div class="padding_0 col-sm-4">
					<input type="submit" value="로그인" class="btn btn-info login_btn" />
				</div>
			</div>
			</form>
		</div>
		<!-- 푸터 -->
		<footer class="footer-wrapper">
			<div class="container">
				<div class="footer_content text-center">
					<address>
						<span class="address">주소 : 서울특별시 강남구 역삼동</span>
						<span class="tel">Tel : 1234-5678</span>
						Copyright&copy;2016. <a class="footer_logo" href="<c:url value="/" />">marsher.co.kr</a>. All rights reserved
					</address>
				</div>
			</div>
		</footer>
		<!--// 푸터 -->
	</div>
	</c:if>
	
<!-- jQuery -->
<script src="<c:url value="/vendor/jquery/jquery.min.js" />"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/vendor/bootstrap/js/bootstrap.min.js" />"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value="/js/loginForm.js" />"></script>
</body>
</html>


