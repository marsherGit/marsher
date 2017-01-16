<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- aside -->
	<aside class="aside-wrapper">
		<div class="list-group">
			<c:if test="${ memId ne 'admin' }">
			<a class="list-group-item" href="void(0);" onclick="alert('접근 권한이 없습니다'); return false;">생산의뢰서등록</a>
			</c:if>
			<c:if test="${ memId eq 'admin' }">
			<a class="list-group-item" href="<c:url value="/order/saengSanWriteForm" />">생산의뢰서등록</a>
			</c:if>
			<c:if test="${ memId ne 'admin' }">
			<a class="list-group-item" href="void(0);" onclick="alert('접근 권한이 없습니다'); return false;">생산의뢰서조회</a>
			</c:if>
			<c:if test="${ memId eq 'admin' }">
			<a class="list-group-item" href="<c:url value="/order/saengSanList" />">생산의뢰서조회</a>
			</c:if>
			<a class="list-group-item" href="<c:url value="/factory/factoryInfo" />">공장정보</a>
			<a class="list-group-item" href="<c:url value="/factory/factoryInputForm" />">공장등록</a>
			
		</div>
	</aside>
	<!--// aside -->