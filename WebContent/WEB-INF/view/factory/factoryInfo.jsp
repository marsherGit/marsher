<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<!-- 현재 페이지 메뉴 on -->
	<script>
		$(document).ready(function(){
			/* main,sub menu 활성화 */
			var main_nav = $(".main_nav>li").eq(0);
			main_nav.addClass("on");
			main_nav.find(".sub_nav>li").eq(2).addClass("on");
			$(".aside-wrapper>.list-group>.list-group-item").eq(2).addClass("on");
			$(".factory_nav>ul>li").eq(0).addClass("active");
			$(".factory_content .tab-pane").eq(0).addClass("in active");
			
		})
	</script>
	<!-- // 현재 페이지 메뉴 on -->
	
	<style>
		
		.factory_nav .nav {color:#366886; border-color:#366886;}
		.factory_nav .nav>li>a {border-color:#366886; background-color:#f8fbfd;}
		.factory_nav .nav>li.active>a, .factory_nav .nav>li.active>a:focus, .factory_nav .nav>li.active>a:hover {border-color:#366886; background-color:#fff; border-bottom-color:transparent;}
		.factory_nav .nav>li>a:hover {background-color:#f8fbfd;}
		.factory_nav .nav>li {color:#366886; border-color:#366886;}
		.factory_content {padding:3em;}
		.factory_content .tab-pane {}
		.title {font-size:1.2em; font-weight:bold; background-color:#f8fbfd; margin-bottom:1em; margin-left:15px; padding:0.5em; border-left:0.7em solid #eee;}
		.img_area .fac_image {width:370px; height:270px;}
		.img_area .fac_image>img {width:100%; height:100%;}
		.img_area .fac_name {padding-top:0.5em;}
		.info_area>ul {margin:0; padding:0; list-style:none; padding-left:2em;}
		.info_area>ul>li {position:relative; padding:0.2em 0 0.5em 0.5em;}
		.info_area .info span {display:block; padding-bottom:0.5em;}
		.icon {display:block; position:absolute; top:0; left:-2em; width:1.7em; height:1.7em; background:url("<c:url value="/images/info_icon.png" />") no-repeat; background-size:100%; overflow:hidden;}
		.tel_icon {background-position:0 0;}
		.location_icon {background-position:0 -47px;}
		.info_icon {background-position:0 -95px;}
	</style>
	
	<!-- factoryInfo contents -->
	<div class="factory_nav">
		<ul class="nav nav-tabs">
		<c:forEach var="item" items="${ factoryList }">
			<li><a data-toggle="tab" href="#fac_${ item.fac_id }">${ item.fac_name }</a></li>
		</c:forEach>
		</ul>
	</div>
	
	<div class="factory_content tab-content">
	<c:forEach var="item" items="${ factoryList }">
		<div id="fac_${ item.fac_id }" class="tab-pane fade">
			<div class="title">${ item.fac_name }</div>
		  <div class="article">
		  	<div class="img_area col-sm-6">
					<c:if test="${ item.fac_image eq null }">
						<div class="fac_image"><img src="<c:url value="/images/no-img.png" />" alt="${ item.fac_name }" /></div>
					</c:if>
					<c:if test="${ item.fac_image ne null }">
						<div class="fac_image"><img src="<c:url value="/saveFile/${ item.fac_image }" />" alt="${ item.fac_name }" /></div>
					</c:if>
				</div>
				<div class="info_area col-sm-6">
					<ul>
						<li class="tel"><span class="icon tel_icon"></span><span>${ item.fac_tel }</span></li>
						<li class="address"><span class="icon location_icon"></span><span>${ item.fac_location }</span></li>
						<li class="info"><span class="icon info_icon"></span>
							<c:if test="${ item.fac_id eq 1 }">
								<c:set var="fac_item" value="탄산음료" />
							</c:if>
							<c:if test="${ item.fac_id eq 2 }">
								<c:set var="fac_item" value="주류" />
							</c:if>
							<c:if test="${ item.fac_id eq 3 }">
								<c:set var="fac_item" value="주스" />
							</c:if>
							<c:if test="${ item.fac_id eq 4 }">
								<c:set var="fac_item" value="우유" />
							</c:if>
							<span class="factory_info">${ fac_item } 제조공장</span>
							<span class="factory_item">※ 생산제품</span>
							<c:set var="productList" value="${fn:split(item.fac_product,',')}" />
							<c:forEach var="product" items="${productList}">
							    <span class="fac_item_list"> - ${ product }</span>
							</c:forEach>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
	<!-- // factoryInfo contents -->
	