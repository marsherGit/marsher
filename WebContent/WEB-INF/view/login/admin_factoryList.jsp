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
		$(".aside-wrapper>.list-group>.list-group-item").eq(2).addClass("on");
	})
</script>

<div class="delivery_list">
	<div class="row text-right">
		<span><a href="<c:url value="/factory/factoryInputForm" />" class="btn btn-sm btn-info">공장 추가하기</a></span>
	</div>
	<table class="table table-striped table-bordered text-center delivery_table row">
		<thead>
			<tr>
				<th class="text-center">#</th>
				<th class="text-center">공장이름</th>
				<th class="text-center">주   소</th>
				<th class="text-center">연락처</th>
				<th class="text-center">생산제품</th>
				<th class="text-center">수정</th>
				<th class="text-center">삭제</th>
			</tr>
		</thead>
		<c:if test="${ factory_list eq null }">
			<tr>
				<td colspan="7">등록 된 공장이 없습니다.</td>
			<tr>
		</c:if>
		<c:if test="${ factory_list ne null }">
		<c:forEach var="item" items="${ factory_list }">
			<tr>
				<td>${ item.fac_id }</td>
				<td>${ item.fac_name }</td>
				<td>${ item.fac_location }</td>
				<td>${ item.fac_tel }</td>
				<td>${ item.fac_product }</td>
				<td><a href="<c:url value="/login/admin_factoryUpdateForm?fac_id=${ item.fac_id }" />" class="btn btn-warning btn-sm">수정</a></td>
				<td><a href="<c:url value="/login/admin_factoryDelete?fac_id=${ item.fac_id }" />" class="btn btn-danger btn-sm" onclick="return deleteCheck();">삭제</a></td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</div>