<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- aside -->
	<aside class="aside-wrapper">
		<div class="list-group">
			<a class="list-group-item" href="<c:url value="/login/adminpage" />">관리자정보수정</a>
			<a class="list-group-item" href="<c:url value="/login/AdminUpdateList.do" />">매장정보수정</a>
			<a class="list-group-item" href="<c:url value="/" />">공장정보수정</a>
			<a class="list-group-item" href="<c:url value="/" />">배송정보수정</a>
			<a class="list-group-item" href="<c:url value="/" />">받은쪽지</a>
			<a class="list-group-item" href="<c:url value="/" />">보낸쪽지</a>
		</div>
	</aside>
	<!--// aside -->
