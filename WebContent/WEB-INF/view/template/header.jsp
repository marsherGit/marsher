<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- 헤더 -->
	<header class="navbar-wrapper">
		<!-- 메뉴바 -->
		<div class="user_nav_container">
			<div class="container">
				<div class="navbar navbar-static-top" role="navigation">
					<!-- 로고 영역 -->
					<div class="navbar-header">
						<!-- 반응형 메뉴 버튼 -->
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target=".navbar-collapse">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<!--// 반응형 메뉴 버튼 -->
						<!-- 로고 -->
						<a class="navbar-brand" href="<c:url value="/" />">Marsher</a>
						<!--// 로고 -->
					</div>
					<!--// 로고 영역 -->
					
					<!-- 메뉴 영역 -->
					<div class="navbar-collapse collapse">
						<!-- 사용자메뉴 -->
						<ul class="nav navbar-nav navbar-right">
							<c:if test="${ memId ne 'admin' }">
								<li><a href="<c:url value='/login/mypage.do?st_id=${memId}'/>" onClick="return checkPass()">마이페이지</a></li>
							</c:if>
							<c:if test="${ memId eq 'admin' }">
								<li><a href="<c:url value="/login/adminpage" />" onClick="return checkPass()">관리자페이지</a></li>
							</c:if>
							<li><a href="<c:url value="/message/receiveMsgList" />">쪽지</a></li>
							<li><a href="<c:url value="/notice/noticeList" />">공지사항</a></li>
							<!-- Trigger the modal with a button -->
							<li><a href="#" data-toggle="modal" data-target="#logout_modal">로그아웃</a></li>
							<li><a href="#" data-toggle="modal" data-target="#manual_modal">메뉴얼</a></li>
						</ul>
						<!--// 사용자메뉴 -->
					</div>
					<!--// 메뉴 영역 -->
				</div>
			</div>
		</div>
		<!--// 메뉴바 -->
		
		<!-- 메뉴바 -->
		<div class="main_nav_container">
			<div class="container">
				<div class="navbar-collapse collapse">
					<!-- 메인메뉴 -->
					<ul class="nav navbar-nav main_nav">
						<li>
							<a href="#">생 산</a>
							<ul class="sub_nav">
								<li><a href="<c:url value="/" />">생산의뢰서등록</a></li>
								<li><a href="<c:url value="/" />">생산의뢰서조회</a></li>
								<li><a href="<c:url value="/factory/factoryInfo" />">공장정보</a></li>
								<li><a href="<c:url value="/factory/factoryInputForm" />">공장등록</a></li>
							</ul>
						</li>
						<li>
							<a href="#">재 고</a>
							<ul class="sub_nav">
								<li><a href="<c:url value="/" />">창고입고</a></li>
								<li><a href="<c:url value="/" />">창고출고</a></li>
								<li><a href="<c:url value="/" />">재고조회</a></li>
								<li><a href="<c:url value="/" />">재고조정</a></li>
								<li><a href="<c:url value="/" />">발주서조회</a></li>
							</ul>
						</li>
						<li>
							<a href="#">유 통</a>
							<ul class="sub_nav">
								<li><a href="<c:url value="/delivery/deliveryInfo" />">배송정보</a></li>
								<li><a href="<c:url value="/delivery/deliveryState" />">배송현황</a></li>
								<li><a href="<c:url value="/delivery/deliveryOrder" />">발주서등록</a></li>
								<li><a href="<c:url value="/delivery/deliveryUnsolved" />">미입고현황</a></li>
							</ul>
						</li>
						<li>
							<a href="#">제 품</a>
							<ul class="sub_nav">
								<li><a href="<c:url value="/product/productSoda" />">탄산</a></li>
								<li><a href="<c:url value="/product/productDrink" />">주류</a></li>
								<li><a href="<c:url value="/product/productJuice" />">쥬스</a></li>
								<li><a href="<c:url value="/product/productMilk" />">우유</a></li>
								<li><a href="<c:url value="/product/authorityCheck" />">제품등록</a></li>
							</ul>
						</li>
						<li>
							<a href="#">매 장</a>
							<ul class="sub_nav">
								<li><a href="<c:url value="/member/info.do?st_id=manager1" />">매장찾기</a></li>
								<li><a href="<c:url value="/" />">재고조회</a></li>
								<li><a href="<c:url value="/" />">재고조정</a></li>
								<li><a href="<c:url value="/member/register.do" />">매장등록</a></li>
							</ul>
						</li>
					</ul>
					<!--// 메인메뉴 -->
				</div>
			</div>
		</div>
		<div class="sub_back"></div>
		<!--// 메뉴바 -->

		<!-- Modal -->
		<div id="logout_modal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-sm">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">로그아웃</h4>
					</div>
					<div class="modal-body text-center">
						<form id="logout_form" action="<c:url value="/login/logout" />" name="logout_form" method="post">
							<div class="text-center">
								${ memId } 님<br />
								로그아웃 하시겠습니까?<br /><br /><br />
							</div>
							<div class="row modal_login_btns">
								<button type="submit" class="col-sm-6 btn btn-danger">로그아웃</button>
								<button type="button" class="col-sm-6 btn btn-default" data-dismiss="modal">취소하기</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
		<!-- //Modal -->
		
		<!-- Modal -->
		<div id="manual_modal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">메뉴얼 - 페이지 안내</h4>
					</div>
					<div class="modal-body text-center">
						<div class="container">
							<div class="">main페이지 : </div>
							<div class="">[header메뉴-상단]</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- //Modal -->
	</header>
	<!-- //헤더 -->

<script>
	

function checkPass() { 
			  var org_pass = ${passwd};
		      var pass = prompt("비밀번호를 입력하세요."); 
		      if( pass != null) {
		    	  if(org_pass == pass) {		    	  
		    	 
		      }else {
		      alert("비밀번호가 틀렸습니다."); 
		      return false;
		      }      
		     }
		      else {
		   		return false;
		      } 

   } 
	
	
	
</script>