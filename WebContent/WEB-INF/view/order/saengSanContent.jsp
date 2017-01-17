<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>생산의뢰서 조회</title>
</head>
<style>
.pull-right {
  float: right !important;
}
</style>
<script>
$(document).ready(function(){
	var main_nav = $(".main_nav>li").eq(0);
	main_nav.addClass("on");
	main_nav.find(".sub_nav>li").eq(1).addClass("on");
	$(".aside-wrapper>.list-group>.list-group-item").eq(1).addClass("on");
})
</script>
<body>
	<form:form commandName="order">

<div class="col-sm-6">
		<div>
			<a href="<c:url value="/order/saengSanList" />"class="btn btn-default">목록보기</a>			
		</div>
		<br>


		<div class="o_sender" id="o_sender">
			<label>수신: </label> <label>${ordering.o_sender}</label>
		</div>
		<div class="o_receiver" id="o_receiver">
			<label>발신: </label> <label>${ordering.o_receiver}</label>
		</div>
		<div class="o_title" id="o_title">
			<label>제목: </label> <label>${ordering.o_title}</label>
		</div>
</div>

		<div class="col-sm-6">
			<table id="dataTables-example_filter"
				class="alignRight table table-bordered">
				<thead>
					<tr>
						<th class="text-center">담당자</th>
						<th class="text-center">관리자</th>
						<th class="text-center">사 장</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><img src="../images/sign.png" width="40"
							height="40" /></td>
						<td></td>
							
						<td></td>
					</tr>
				</tbody>
			</table>

			<div class="o_num" id="o_num">
				<label>발주번호: </label> <label>${ordering.o_ref}</label>
			</div>

			<div class="o_deadline" id="o_deadline">
				<label>납기일: </label> <label><fmt:formatDate value="${ ordering.o_deadline }" pattern="yyyy/MM/dd"/></label>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-12">
			<form:form commandName="proList">
				<table
					class="table table-striped table-bordered text-center orderContent row">
					<thead>
						<tr>
							<th class="text-center" style="width: 50px;">NO</th>
							<th class="text-center" style="width: 150px;">제품명</th>
							<th class="text-center" style="width: 150px;">패키지타입</th>
							<th class="text-center" style="width: 100px;">용량</th>
							<th class="text-center" style="width: 100px;">수량(EA)</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${fn:length(proList)>0 }">
								<!-- 제품 리스트  -->
								<c:forEach items="${proList }" var="proList"> 

						            <tr class="proList" role="row">
										<td align="center">${proList.o_reStep}</td>
										<td align="center">${proList.pro_name}</td>
										<td align="center">${proList.pro_container}</td>
										<td align="center">${proList.pro_volume}</td>
										<td align="center">${proList.pro_count}</td>
									</tr>

								</c:forEach>
							</c:when>
						</c:choose>

						<tr class="order" role="row">
							<td>합계</td>
							<td></td>
							<td></td>
							<td></td>
							<td class="o_count">${ordering.o_count}</td>
						</tr>

						<tr class="order" role="textarea">
							<td>비고</td>
							<td class="o_note" colspan="4">${ordering.o_note}</td>
						</tr>

					</tbody>
				</table>
				</form:form>
			</div>
		</div>

		<!-- /#wrapper -->




	</form:form>

</body>
</html>