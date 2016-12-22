<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- aside -->
	<aside class="aside-wrapper">
		<div class="list-group">
			<a class="list-group-item" href="<c:url value="/WEB-INF/view/member/memberInfo" />">매장찾기</a>
			<a class="list-group-item" href="<c:url value="/" />">재고조회</a>
			<a class="list-group-item" href="<c:url value="/" />">재고조정</a>
			<a class="list-group-item" href="<c:url value="/WEB-INF/view/member/Register.do" />">매장등록</a>
		</div>
	</aside>
	<!--// aside -->