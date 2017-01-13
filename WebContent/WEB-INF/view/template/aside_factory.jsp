<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- aside -->
	<aside class="aside-wrapper">
		<div class="list-group">
			<a class="list-group-item" href="<c:url value="/order/saengSanWriteForm" />">생산의뢰서등록</a>
			<a class="list-group-item" href="<c:url value="/order/saengSanList" />">생산의뢰서조회</a>
			<a class="list-group-item" href="<c:url value="/factory/factoryInfo" />">공장정보</a>
			<a class="list-group-item" href="<c:url value="/factory/factoryInputForm" />">공장등록</a>
		</div>
	</aside>
	<!--// aside -->