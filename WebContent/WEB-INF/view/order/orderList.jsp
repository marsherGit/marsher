<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<title>발주서 list</title>
</head>


<body>

	<div class="orderList">
		
		<table
			class="table table-striped table-bordered text-center orderList row">
			<thead>
				<tr>
					<th class="text-center">#</th>
					<th class="text-center">제 목</th>
					<th class="text-center">입고장소</th>
					<th class="text-center">등록일</th>
					<th class="text-center">납기일</th>
					<th class="text-center">배송상태</th>
				</tr>
			</thead>
			<c:if test="${ orderList eq null }">
				<tr>
					<td colspan="6">요청된 발주서가 없습니다.</td>
				<tr>
			</c:if>
			<c:if test="${ orderList ne null }">
				<c:forEach var="ordering" items="${orderList}">
					<tr>
						<td>${ordering.o_ref}</td>
						<td><a href="<c:url value="/order/orderContent?o_ref=${ordering.o_ref}"/>">${ordering.o_title}</a></td>
						<td>${ordering.o_sender}</td>
						<td><fmt:formatDate value="${ ordering.o_regdate}" pattern="yyyy/MM/dd"/></td>
						<td><fmt:formatDate value="${ ordering.o_deadline }" pattern="yyyy/MM/dd"/></td>
						<td>${ordering.deliveryState}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>

<script>
	$(document).ready(function() {
		$(".nav-tabs>li:first-child").addClass("active");
		$(".tab-content>div:first-child").addClass("in active");

		var main_nav = $(".main_nav>li").eq(1);
		main_nav.addClass("on");
		main_nav.find(".sub_nav>li").eq(4).addClass("on");
		$(".aside-wrapper>.list-group>.list-group-item").eq(4).addClass("on");
	})
</script>

</html>