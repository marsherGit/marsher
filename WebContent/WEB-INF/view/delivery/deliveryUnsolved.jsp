<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<!-- deliveryUnsolved Contents -->
<style>
	.deliveryState_container {padding-top:1em;}
	.state_table {margin-bottom:0.5em;}
	.state_table>tbody>tr>td, .state_table>tbody>tr>th, .state_table>tfoot>tr>td, .state_table>tfoot>tr>th, .state_table>thead>tr>td, .state_table>thead>tr>th {padding:0.5em;}
	.state_table th, .state_table td {text-align:center;}
	.state_table td.text-left {text-align:left;}
	.searchForm {text-align:left; margin-bottom:0.5em;}
	.searchForm>div {padding:0;}
	.searchForm>div>div {padding:0; padding-right:0.5em;}
</style>

<script>
	//load
	function loadList(evt) {
		var url = "/Marsher_prototype/delivery/deliveryUnsolved";
		var productSelect = $(".searchForm select[name='productSelect']").val();
		var storeSelect = $(".searchForm select[name='storeSelect']").val();
		var daySelect = $(".searchForm select[name='daySelect']").val();
		var searchText = $(".searchForm ipnut[name='searchText']").val();
		
		$.ajax({
			url:url,
			type:"post",
			data:{
					"productSelect":productSelect,
					"storeSelect":storeSelect,
					"daySelect":daySelect,
					"searchText":searchText,
			},
			datatype:"json",
			success:function(data) {
				
			},
			error:function(xhr, textStatus, errorThrown) {
				
			}
		});
		
	}
	
	$(document).ready(function(){
		var main_nav = $(".main_nav>li").eq(2);
		main_nav.addClass("on");
		main_nav.find(".sub_nav>li").eq(3).addClass("on");
		$(".aside-wrapper>.list-group>.list-group-item").eq(3).addClass("on");
		
		var pageNumClass = ".page"+'${currentPage}';
		var pageLink = $(".pagination>li>a");
		pageLink.filter(pageNumClass).parent("li").addClass("active");
		
		
		//search
		$("#search_btn").click(function(e){
			e.preventDefault();
			//loadList(e);
			console.log(2);
			$("form[name='stateSearchForm']").submit();
		});
		
	
	}) //end ready
</script>

<div class="deliveryState_container">
	<!-- search -->
	<div class="row searchArea">
		<div class="col-sm-3"></div>
		<form name="stateSearchForm" action="<c:url value="/delivery/deliveryUnsolved" />" method="post">
			<input type="hidden" name="st_id" value="${ memId }" />
			<div class="form-group searchForm col-sm-9">
				<div class="col-sm-8">
					<div class="col-sm-4">
						<select name="productSelect" class="form-control input-sm">
							<option value="">- 품목검색 -</option>
							<c:forEach var="pro" items="${products}">
								<option value="${ pro.pro_num }" <c:if test="${ pro.pro_num eq productSelect }">selected</c:if>>${ pro.pro_name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select name="storeSelect" class="form-control input-sm">
							<option value="">- 요청매장검색 -</option>
							<c:forEach var="st" items="${stores}">
								<option value="${ st.st_id }" <c:if test="${ st.st_id eq storeSelect }">selected</c:if>>${ st.st_name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<select name="daySelect" class="form-control input-sm">
							<option value="0">- 요일선택 -</option>
							<option value="7">일주일이내</option>
							<option value="3">3일이내</option>
							<option value="1">1일이내</option>
						</select>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="col-sm-10">
						<input type="text" id="search_input" name="searchText" class="form-control input-sm" placeholder="검색어를 입력해 주세요." />
					</div>
					<div class="col-sm-2">
						<a id="search_btn" href="#" class="btn btn-info btn-sm">검색</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<!-- list -->
	<div class="row listArea">
		<table class="state_table table table-striped table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>제&nbsp;&nbsp;&nbsp;&nbsp;목</th>
					<th>입고장소</th>
					<th>등록일</th>
					<th>납기일</th>
					<th>배송상태</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${ count <= 0 }">
				<tr>
					<td colspan="6">등록 된 발주서가 없습니다.</td>
				</tr>
				</c:if>
				<c:if test="${ count > 0 }">
					<c:forEach var="item" items="${ articleList }">
					<tr>
						<td>${ item.o_ref }</td>
						<td class="text-left"><a href="<c:url value="/order/orderContent?o_ref=${ item.o_ref }" />">${ item.o_title }</a></td>
						<td>${ item.o_sender }</td>
						<td><fmt:formatDate value="${ item.o_regdate }" pattern="yyyy/MM/dd"/></td>
						<td><fmt:formatDate value="${ item.o_deadline }" pattern="yyyy/MM/dd"/></td>
						<td>${ item.deliverystate }</td>
					</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	
	<!-- pagenation -->
	<c:if test="${ count > 0 }">
	<c:set var="pageCount" value="${ count / pageSize + ( count % pageSize == 0 ? 0 : 1) }"/>
  <c:set var="pageBlock" value="${ 3 }"/>
  <fmt:parseNumber var="result" value="${ (currentPage % pageBlock == 0 ? currentPage-1 : currentPage) / pageBlock }" integerOnly="true" />
  <c:set var="startPage" value="${ result * pageBlock + 1 }" />
  <c:set var="endPage" value="${ startPage + pageBlock - 1 }"/>
  <c:if test="${ endPage > pageCount }">
    <c:set var="endPage" value="${ pageCount }"/>
  </c:if>
	<div class="row pagingArea text-center">
		<ul class="pagination pagination-sm">
			<c:if test="${ startPage > pageBlock }">
				<li class="prev"><a href="<c:url value="/delivery/deliveryUnsolved?pageNum=${ startPage - pageBlock }&productSelect=${ productSelect }&storeSelect=${ storeSelect }&searchText=${ searchText }&daySelect=${ daySelect }" />">&lt;&lt;</a></li>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
		  	<li><a href="<c:url value="/delivery/deliveryUnsolved?pageNum=${ i }&productSelect=${ productSelect }&storeSelect=${ storeSelect }&searchText=${ searchText }&daySelect=${ daySelect }" />" class="page${ i }">${ i }</a></li>
		  </c:forEach>
		  <c:if test="${ endPage < pageCount }">
		  	<li class="next"><a href="<c:url value="/delivery/deliveryUnsolved?pageNum=${ startPage + pageBlock }&productSelect=${ productSelect }&storeSelect=${ storeSelect }&searchText=${ searchText }&daySelect=${ daySelect }" />">&gt;&gt;</a></li>
		  </c:if>
		</ul>
	</div>
	</c:if>
</div>
<!-- // deliveryUnsolved Contents -->
