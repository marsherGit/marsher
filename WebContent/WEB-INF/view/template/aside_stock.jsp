<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- aside -->
	<aside class="aside-wrapper">
		<div class="list-group">
<a class="list-group-item" href="<c:url value="/chowonheeView/changgoIGList" />">창고입고</a>
			<a class="list-group-item" href="<c:url value="/chowonheeView/changgoCGList" />">창고출고</a>
			<a class="list-group-item" href="<c:url value="/chowonheeView/jegoJH" />">재고조회</a>
			<a class="list-group-item" href="<c:url value="/chowonheeView/jegoJJ" />">재고조정</a>
			<a class="list-group-item" href="<c:url value="/" />">발주서조회</a>
		</div>
	</aside>
	<!--// aside -->