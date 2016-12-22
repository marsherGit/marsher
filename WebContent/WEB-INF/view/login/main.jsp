<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	
</script>
<div class="container">
	<h1>Main 페이지 입니다.</h1>
	<c:if test="${ memId != null }">
		<p>${ memId }님 환영합니다.</p>
	</c:if>
</div>