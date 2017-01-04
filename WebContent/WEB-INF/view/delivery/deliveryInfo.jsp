<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<!-- 현재 페이지 메뉴 on -->
	<script>
		$(document).ready(function(){
			/* main,sub menu 활성화 */
			var main_nav = $(".main_nav>li").eq(2);
			main_nav.addClass("on");
			main_nav.find(".sub_nav>li").eq(0).addClass("on");
			$(".aside-wrapper>.list-group>.list-group-item").eq(0).addClass("on");
			
		})
	</script>
	<!-- // 현재 페이지 메뉴 on -->
	
	<style>
		.panel-marsher {border-color:#366886;}
		.panel-marsher .panel-heading {color:#366886; border-color:#366886; background-color:#f8fbfd;}
		.panel-heading {font-size:1.2em; font-weight:bold;}
		.img_area .delivery_img>img {width:100%;}
		.img_area .delivery_name {padding-top:0.5em;}
		.info_area>ul {margin:0; padding:0; list-style:none; padding-left:2em;}
		.info_area>ul>li {position:relative; padding:0.2em 0 0.5em 0.5em;}
		.info_area .info span {display:block; padding-bottom:0.5em;}
		.icon {display:block; position:absolute; top:0; left:-2em; width:1.7em; height:1.7em; background:url("<c:url value="/images/info_icon.png" />") no-repeat; background-size:100%; overflow:hidden;}
		.tel_icon {background-position:0 0;}
		.info_icon {background-position:0 -95px;}
	</style>
	
	<!-- deliveryInfo contents -->
	<c:forEach var="item" items="${ deliveryList }">
	<div class="col-sm-6">
		<div class="panel panel-marsher">
			<div class="panel-heading">${ item.fac_name }</div>
		  <div class="panel-body">
		  	<div class="img_area col-sm-6">
					<div class="delivery_img"><img src="/images/<c:url value="${ item.delivery_img }" />" alt="${ item.delivery_name } 기사님" /></div>
					<div class="delivery_name text-center">${ item.delivery_name } 기사님</div>
				</div>
				<div class="info_area col-sm-6">
					<ul>
						<li class="tel"><span class="icon tel_icon"></span><span>${ item.delivery_tel }</span></li>
						<li class="info"><span class="icon info_icon"></span>
							<span class="delivery_day">매주 ${ item.delivery_day } 배송</span>
							<span class="delivery_item">※ 배송제품</span>
							<c:set var="productList" value="${fn:split(item.fac_product,',')}" />
							<c:forEach var="product" items="${productList}">
							    <span class="delivery_item_list"> - ${ product }</span>
							</c:forEach>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
	<!-- // deliveryInfo contents -->
	