<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- aside -->
	<aside class="aside-wrapper">
		<div class="list-group">
			<a class="list-group-item" href="<c:url value="/product/productSoda" />">탄산</a>
			<a class="list-group-item" href="<c:url value="/product/productDrink" />">주류</a>
			<a class="list-group-item" href="<c:url value="/product/productJuice" />">쥬스</a>
			<a class="list-group-item" href="<c:url value="/product/productMilk" />">우유</a>
			<a class="list-group-item" href="<c:url value="/product/authorityCheck" />">제품등록</a>
		</div>
	</aside>
	<!--// aside -->