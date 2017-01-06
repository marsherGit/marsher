<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Insert title here</title>
</head>
<style>
	.delivery_list {padding:0 3em;}
	.delivery_table {margin-top:1em;}
</style>

<script type="text/javascript">
	function deleteCheck(){
		if(!confirm("매장을 삭제하시겠습니까?" )) {
			return false;
		} else {
			return true;
		}
	}
	$(document).ready(function(){
		/* 서브메뉴 활성화 */
		$(".user_nav>li:eq(0)>a").addClass("active");
		$(".aside-wrapper>.list-group>.list-group-item").eq(1).addClass("on");
	})
</script>

<body>

	<form method="post" name="AdminUpdateList">

	 <div class="Admin_memberList">
	
	<table class="table table-striped table-bordered text-center Admin_memberList_table row">
		<thead>
			<tr>
				<th class="text-center">매장ID</th>
				<th class="text-center">매장명</th>
				<th class="text-center">연락처</th>
				<th class="text-center">주소</th>
				<th class="text-center">상세정보</th>
				<th class="text-center">삭제</th>
			</tr>
		</thead>
		<c:if test="${ showList eq null }">
			<tr>
				<td colspan="7">등록 된 매장이 없습니다.</td>
			<tr>
		</c:if>
		<c:if test="${ showList ne null }">
		<c:forEach var="list" items="${showList}">
			<tr>
				<td>${list.st_id}</td>
				<td>${list.st_name}</td>
				<td>${list.st_tel}</td>
				<td>${list.st_location}</td>
				<td><a href="<c:url value="/login/AdminUpdateForm.do?st_id=${list.st_id}" />" class="btn btn-warning btn-sm">수정</a></td>
				<td><a href="<c:url value="/login/AdminDeletePro.do?st_id=${list.st_id}" />" class="btn btn-danger btn-sm" onclick="return deleteCheck();">삭제</a></td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
</div>
	</form>

</body>
</html>