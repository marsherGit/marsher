<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<title>Insert title here</title>
</head>

<script type="text/javascript">
function deleteCheck(){
	if(!confirm("제품을 삭제하시겠습니까?" )) {
		return false;
	} else {
		return true;
	}
}
	$(document).ready(function() {

		var main_nav = $(".main_nav>li").eq(3);
		main_nav.addClass("on");
		main_nav.find(".sub_nav>li").eq(3).addClass("on");
		$(".aside-wrapper>.list-group>.list-group-item").eq(3).addClass("on");
	})
</script>

<body>
	<div>
		<form class="form-horizontal" method="post">
			<ul id="milkList" class="col-md-12">
				<%-- <c:if test="${count == 0}">
<table width="700" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center">
      관련 제품이 없습니다.
    </td>
  </tr>
</table>
</c:if> --%>

			<c:if test="${count > 0}">
				<c:forEach var="milkList" items="${milkList}">

					<ul class="col-md-3" value="${milkList.pro_name}"
						style="text-align: center;">

						<table id="product" style="margin: auto; text-align: center;"
							border="1px" bordercolor="6D98B4" onClick="#" data-toggle="modal"
							data-target="#${milkList.pro_num}">
							<tr>
								<td><img src="/Marsher/images/${milkList.pro_image}"
									style="width: 200px; height: 210px;" /><br /> <strong>${milkList.pro_name}</strong><br />
									(${milkList.pro_container} - ${milkList.pro_volume}ml)<br />
									${milkList.pro_calorie} kcal</td>
							</tr>

						</table>
					</ul>

				</c:forEach>
				</c:if>
			</ul>
		</form>
	</div>

	<c:if test="${count > 8}">
		<c:set var="pageCount"
			value="${count / pageSize + ( count % pageSize == 0 ? 0 : 1)}" />
		<c:set var="pageBlock" value="${5}" />
		<fmt:parseNumber var="result" value="${currentPage / 5}"
			integerOnly="true" />
		<c:set var="startPage" value="${result * 5 + 1}" />
		<c:set var="endPage" value="${startPage + pageBlock-1}" />
		<c:if test="${endPage > pageCount}">
			<c:set var="endPage" value="${pageCount}" />
		</c:if>

		<center>
			<c:if test="${startPage > 5}">
				<a href="productMilk.do?pageNum=${startPage - 5 }">이전</a>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="productMilk.do?pageNum=${i}">[${i}]</a>
			</c:forEach>

			<c:if test="${endPage < pageCount}">
				<a href="productMilk.do?pageNum=${startPage + 5}">다음</a>
			</c:if>
	</c:if>

	</center>

	<c:forEach var="milkList" items="${milkList}">
		<!-- Modal -->
		<div id="${milkList.pro_num}" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">우유 - 제품 소개</h4>
					</div>
					<div class="modal-body text-center">
						<div class="text-center">

							<div>
								<div class="container text-left"
									style='position: relative; width: 900px;'>
									<div class="row">
										<div class="col-sm-4"
											style='position: relative; width: 350px; height: 300px; color: black; border: 0px solid black; dispaly: inline;'>
											<label for="pro_image">제품 사진</label> <img style='cursor: hand'
												src="/Marsher/images/${milkList.pro_image}"
												align="absMiddle" border="0" width="280" height="250"
												id="UploadedImg">
										</div>
										<div class="col-sm-4" style='width: 500px; padding: 35px'>
											<table class="table table-bordered">
												<tr>
													<td class="text-center"><strong>상품번호</strong></td>
													<td>${milkList.pro_num}</td>
												</tr>
												<tr>
													<td class="text-center"><strong>상품명</strong></td>
													<td>${milkList.pro_name}</td>
												</tr>
												<tr>
													<td class="text-center"><strong>용량</strong></td>
													<td>${milkList.pro_volume}ml</td>
												</tr>
												<tr>
													<td class="text-center"><strong>패키지타입</strong></td>
													<td>${milkList.pro_container}</td>
												</tr>
												<tr>
													<td class="text-center"><strong>칼로리</strong></td>
													<td>${milkList.pro_calorie}kcal</td>
												</tr>
											</table>
											<div class="row text-right">
											<c:if test="${ memId eq 'admin' }"> 	
											<a href="<c:url value="/product/milkDeletePro.do?pro_num=${milkList.pro_num}"/>" class="btn btn-danger btn-sm" onclick="return deleteCheck();">제품삭제</a>								
											</c:if>
											</div>
										</div>

									</div>

								</div>
								<br>
							</div>

						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- //Modal -->
	</c:forEach>
</body>
</html>