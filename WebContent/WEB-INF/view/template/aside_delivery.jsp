<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- aside -->
	<aside class="aside-wrapper">
		<div class="list-group">
			<a class="list-group-item" href="<c:url value="/delivery/deliveryInfo" />">배송정보</a>
			<a class="list-group-item" href="<c:url value="/delivery/deliveryState" />">배송현황</a>
			<a class="list-group-item" href="<c:url value="/order/orderWriteForm" />">발주서등록</a>
			<a class="list-group-item" href="<c:url value="/delivery/deliveryUnsolved" />">미입고현황</a>
		</div>
	</aside>
	<!--// aside -->