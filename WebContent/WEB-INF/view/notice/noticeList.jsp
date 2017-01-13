<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.noticeList {padding:3em 20%; align:center;}
	.noticeTable {margin:1em auto;}
</style>

<script>
$(document).ready(function(){
	/* 서브메뉴 활성화 */
	$(".user_nav>li:eq(1)>a").addClass("active");
	$(".aside-wrapper>.list-group>.list-group-item").eq(0).addClass("on");
})
</script>

<div class="noticeList container">
	<div class="row text-right">
	<c:if test="${ memId eq 'admin'  }">
		<span><a href="<c:url value="/notice/noticeWriteForm" />" class="btn btn-sm btn-info">공지쓰기</a></span>
	</c:if>
	</div>
	<table class="table table-striped table-bordered text-center noticeTable row">
		<thead>
			<tr>
				<th class="text-center" width="20">#</th>
				<th class="text-center" width="210">제목</th>
				<th class="text-center" width="70">표시날짜</th>
				<th class="text-center" width="70">등록날짜</th>
			</tr>
		</thead>
		<c:if test="${ noticeList eq null }">
			<tr>
				<td colspan="7">등록 된 공지가 없습니다.</td>
			<tr>
		</c:if>
		<c:if test="${ noticeList ne null }">
		<c:forEach var="list" items="${ noticeList }">
			<tr>
				<td>${ list.no_num }</td>
				<td><a href="<c:url value="/notice/noticeContent?no_num=${ list.no_num }&calDate=${ list.calendar_date }&pageNum=${ currentPage }"/>">${ list.no_title }</a></td>
				<td>${ list.calendar_date }</td>				
				<td>${ list.no_date }</td>				
			</tr>
		</c:forEach>
		</c:if>
	</table>

<!-- pagenation -->
	<c:if test="${ count > 0 }">
	<c:set var="pageCount" value="${ count / pageSize + ( count % pageSize == 0 ? 0 : 1) }"/>
  <c:set var="pageBlock" value="${ 10 }"/>
  <fmt:parseNumber var="result" value="${ (currentPage % pageBlock == 0 ? currentPage-1 : currentPage) / pageBlock }" integerOnly="true" />
  <c:set var="startPage" value="${ result * pageBlock + 1 }" />
  <c:set var="endPage" value="${ startPage + pageBlock - 1 }"/>
  <c:if test="${ endPage > pageCount }">
       <c:set var="endPage" value="${ pageCount }"/>
  </c:if>
	<div class="row pagingArea text-center">
		<ul class="pagination pagination-sm">
			<c:if test="${ startPage > pageBlock }">
				<li class="prev"><a href="noticeList?pageNum=${ startPage - pageBlock }">&lt;&lt;</a></li>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
		  	<li><a href="noticeList?pageNum=${ i }" class="page${ i }">${ i }</a></li>
		  </c:forEach>
		  <c:if test="${ endPage < pageCount }">
		  	<li class="next"><a href="noticeList?pageNum=${ startPage + pageBlock }">&gt;&gt;</a></li>
		  </c:if>
		</ul>
	</div>
	</c:if>
</div>