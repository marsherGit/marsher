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
							<li><a href="<c:url value="/message/receiveMsgList" />">쪽지(<span id="msgNew"></span>)</a></li>
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
								<c:if test="${ memId ne 'admin' }">
								<li><a  href="void(0);" onclick="alert('접근 권한이 없습니다'); return false;">생산의뢰서등록</a></li>
								</c:if>
								<c:if test="${ memId eq 'admin' }">
								<li><a href="<c:url value="/order/saengSanWriteForm" />" onClick="return checkPass()">생산의뢰서등록</a></li>
								</c:if>
								<c:if test="${ memId ne 'admin' }">
								<li><a href="void(0);" onclick="alert('접근 권한이 없습니다'); return false;">생산의뢰서조회</a></li>
								</c:if>
								<c:if test="${ memId eq 'admin' }">
								<li><a href="<c:url value="/order/saengSanList" />" onClick="return checkPass()">생산의뢰서조회</a></li>
								</c:if>
								<li><a href="<c:url value="/factory/factoryInfo" />">공장정보</a></li>
								<li><a href="<c:url value="/factory/factoryInputForm" />">공장등록</a></li>
							</ul>
						</li>
						<li>
							<a href="#">재 고</a>
							<ul class="sub_nav">
								<li><a href="<c:url value="/chowonheeView/changgoIGList" />">창고입고</a></li>
								<li><a href="<c:url value="/chowonheeView/changgoCGList" />">창고출고</a></li>
								<li><a href="<c:url value="/chowonheeView/jegoJH" />">재고조회</a></li>
								<li><a href="<c:url value="/chowonheeView/jegoJJ" />">재고조정</a></li>
								<c:if test="${ memId ne 'admin' }">
								<li><a href="<c:url value="/order/orderList?o_sender=${memId}"/>">발주서조회</a></li>
								</c:if>
								<c:if test="${ memId eq 'admin' }">
								<li><a href="<c:url value="/order/allOrders" />">발주서조회</a></li>
								</c:if>
							</ul>
						</li>
						<li>
							<a href="#">유 통</a>
							<ul class="sub_nav">
								<li><a href="<c:url value="/delivery/deliveryInfo" />">배송정보</a></li>
								<li><a href="<c:url value="/delivery/deliveryState" />">배송현황</a></li>
								<li><a href="<c:url value="/order/orderWriteForm" />">발주서등록</a></li>
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
								<li><a href="<c:url value="/chowonheeView/StjegoJH" />">재고조회</a></li>
								<li><a href="<c:url value="/chowonheeView/StjegoJJ" />">재고조정</a></li>
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
				<div class="modal-content manual_modal">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">메뉴얼 - 페이지 안내</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<h5 class="page_title col-md-2">main페이지 :</h5>
							<p class="page_manual col-md-10"> 	
								[header메뉴-상단]<br />
								마이페이지 - 마이페이지로 이동합니다. 매장정보수정과 쪽지를 확인 할 수 있습니다.<br />
								관리자페이지 -  관리자페이지로 이동합니다. 공지사항게시판, 관리자정보 수정, 쪽지 확인을 할 수 있습니다.<br />
								쪽지(1) - 받은쪽지 게시판으로 이동합니다. 확인 안 된 새로운 쪽지가 있다면 옆에 숫자로 표시됩니다.<br />
								공지사항 - 공지사항 리스트로 이동합니다.<br />
								로그아웃 - 로그아웃을 하면 로그인 페이지로 이동합니다.<br />
								메뉴얼 - 각 페이지에 관한 안내서 입니다.<br />
								<br />
								[메인페이지 내용]<br />
								퀵메뉴 아이콘 - 클릭하면 해당 페이지로 이동합니다.<br /> 
								정기배송현황 - 정기적으로 배송되는 물품의 배송현황을 확인 할 수 있습니다.<br />
								배송정보 조회하기 - 발주서번호를 입력하면 배송현황 페이지로 이동합니다.<br />
								캘린더 - 이달의  공지사항을 한 눈에 볼 수 있습니다. 해당 날짜를 클릭하면 하단에 상세내용이 표시됩니다.<br />
								채팅 - 접속한 계정간에 실시간 채팅을 할 수 있습니다.<br />
							</p>
							<h5 class="page_title col-md-2"><span>생산 페이지 :</span><br /><span class="admin">(관리자전용)</span></h5>
							<p class="page_manual col-md-10">
								생산의뢰서 등록 - 창고에서 필요한 제품의 생산을 공장에 의뢰 할 수 있습니다.<br />
								생산의뢰서 조회 - 생산의뢰서를 조회 할 수 있습니다. 생산의뢰서는 PDF 출력이 가능합니다.<br />
								공장정보 - 공장의 정보를 볼 수 있습니다.<br />
								공장등록 - 새로운 공장을 등록 할 수 있는 페이지입니다.<br />
							</p>
							<h5 class="page_title col-md-2"><span>재고 페이지 :</span><br /><span class="admin">(관리자전용)</span></h5>
							<p class="page_manual col-md-10">
								창고입고 - 공장에서 창고로 입고 된 제품을 재고로 등록 할 수 있는 페이지 입니다.<br /> 
								창고출고 - 창고에서 매장으로 출고 된 제품을 등록 할 수 있는 페이지 입니다.<br /> 
								재고조회 - 창고의 재고를 조회 할 수 있습니다. 목록을 엑셀로 출력 할 수 있습니다.<br />
								재고조정 - 창고의 재고수량과 실사재고의 수량이 다를 경우 수정 할 수 있는 페이지 입니다.<br />
								발주서 조회 - 창고에 요청 된 발주서의 목록을 볼 수 있습니다.<br />
							</p>
							<h5 class="page_title col-md-2"><span>유통 페이지 :</span></h5>
							<p class="page_manual col-md-10">
								배송정보 - 요일별 정기배송 물품 소개, 및 담당 기사 님의 정보를 확인 할 수 있습니다.<br /> 
								배송현황 - 요청한 발주서의 배송현황을 확인 할 수 있습니다.<br />
								발주서 등록 - 매장에 필요한 제품을 요청할 수 있는 발주서 입력  페이지 입니다.<br />
								미입고현황 - 요청한 제품 중 배송예정인 발주서의 목록입니다.<br />
							</p>
							<h5 class="page_title col-md-2"><span>제품 페이지 :</span></h5>
							<p class="page_manual col-md-10">
								탄산 - 탄산음료 제품 소개 페이지입니다.<br /> 
								주류 - 주류제품 소개 페이지입니다.<br /> 
								쥬스 - 쥬스제품 소개 페이지입니다.<br /> 
								우유 - 우유제품 소개 페이지입니다.<br /> 
								제품 등록 - 새로운 제품을 등록할 수 있는 페이지입니다. 관리자만 가능합니다.<br />
							</p>
							<h5 class="page_title col-md-2"><span>매장 페이지 :</span></h5>
							<p class="page_manual col-md-10">
								매장찾기 - 가까운 매장을 찾을 수 있도록 매장정보를 볼 수 있습니다.<br />
								재고조회 - 우리 매장의 재고를 조회 할 수 있습니다. 목록을 엑셀로 출력 할 수 있습니다.<br />
								재고조정 - 재고수량과 실사재고의 수량이 다를 경우  수정 할 수 있는 페이지 입니다.<br />
								매장등록 - 새로운 매장을 등록 할 수 있는 페이지입니다. 등록 후 관리자의 승인이 필요합니다.<br />
							</p>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- //Modal -->
	</header>
	<!-- //헤더 -->

<script>
$(document).ready(function(){
	$("#msgNew").load("/Marsher/login/main #mgsNewNum>span");
	});	

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