<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.delivery_list {padding:0 3em;}
	.delivery_table {margin-top:1em;}
</style>

<script>
	function deleteCheck(){
		if(!confirm("삭제하시겠습니까?")) {
			return false;
		} else {
			return true;
		}
	}
	$(document).ready(function(){
		/* 서브메뉴 활성화 */
		$(".user_nav>li:eq(0)>a").addClass("active");
		$(".aside-wrapper>.list-group>.list-group-item").eq(3).addClass("on");
	})
</script>

<div class="delivery_list">
	<div class="row text-right">
		<span><a href="<c:url value="/login/admin_deliveryInputForm" />" class="btn btn-sm btn-info">배송기사 추가하기</a></span>
	</div>
	<table class="table table-striped table-bordered text-center delivery_table row">
		<thead>
			<tr>
				<th class="text-center">#</th>
				<th class="text-center">이름</th>
				<th class="text-center">연락처</th>
				<th class="text-center">담당제품</th>
				<th class="text-center">배송요일</th>
				<th class="text-center">수정</th>
				<th class="text-center">삭제</th>
			</tr>
		</thead>
		<c:if test="${ delivery_list eq null }">
			<tr>
				<td colspan="7">등록 된 기사가 없습니다.</td>
			<tr>
		</c:if>
		<c:if test="${ delivery_list ne null }">
		<c:forEach var="item" items="${ delivery_list }">
			<tr>
				<td>${ item.delivery_num }</td>
				<td>${ item.delivery_name }</td>
				<td>${ item.delivery_tel }</td>
				<td>${ item.fac_product }</td>
				<td>${ item.delivery_day }</td>
				<td><a href="<c:url value="/login/admin_deliveryUpdateForm?delivery_num=${ item.delivery_num }" />" class="btn btn-warning btn-sm">수정</a></td>
				<td><a href="<c:url value="/login/admin_deliveryDelete?delivery_num=${ item.delivery_num }" />" class="btn btn-danger btn-sm" onclick="return deleteCheck();">삭제</a></td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</div>