<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>

<style>
	.sendMsg_list {padding:0 3em;}
	.delivery_table {margin-top:1em;}
</style>
<script>
$(document).ready(function(){
	/* 서브메뉴 활성화 */
	$(".user_nav>li:eq(0)>a").addClass("active");
	$(".aside-wrapper>.list-group>.list-group-item").eq(2).addClass("on");
})
</script>
<div class="sendMsg_list">
	<div class="row text-right">
		<span><a href="<c:url value="/message/writeMsgForm" />" class="btn btn-sm btn-info">쪽지쓰기</a></span>
	</div>
	<table class="table table-striped table-bordered text-center delivery_table row">
		<thead>
			<tr>
				<th class="text-center">#</th>
				<th class="text-center">제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</th>
				<th class="text-center" width="130">받는이</th>
				<th class="text-center" width="130">보낸날짜</th>
				<th class="text-center">수신확인</th>
			</tr>
		</thead>
		<c:if test="${ sendMsgList eq null }">
			<tr>
				<td colspan="7">보낸 쪽지가 없습니다.</td>
			<tr>
		</c:if>
		<c:if test="${ sendMsgList ne null }">
		<c:forEach var="msg" items="${ sendMsgList }">
		<c:if test="${ memId == msg.se_sender }">
			<tr>
				<td><c:out value="${number}"/> 
 				 <c:set var="number" value="${number - 1}"/></td>
				<td align="left"><a href="<c:url value="/message/sendMsgContent?num=${msg.num}&pageNum=${ currentPage }"/>"> ${msg.se_title}</a></td>
				<td>${ msg.se_receiver }</td>
				<td><fmt:formatDate value="${ msg.se_regdate }" pattern="yyyy/MM/dd"/></td>
				<td><fmt:formatDate value="${ msg.se_checkDate }" pattern="yyyy/MM/dd"/></td>
			</tr>
			</c:if>
		</c:forEach>
		</c:if>
	</table>
</div>



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
				<li class="prev"><a href="<c:url value="sendMsgList.do?pageNum=${ startPage - pageBlock }" />">&lt;&lt;</a></li>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
		  	<li><a href="<c:url value="sendMsgList.do?pageNum=${ i }" />" class="page${ i }">${ i }</a></li>
		  </c:forEach>
		  <c:if test="${ endPage < pageCount }">
		  	<li class="next"><a href="<c:url value="sendMsgList.do?pageNum=${ startPage + pageBlock }" />">&gt;&gt;</a></li>
		  </c:if>
		</ul> 
	</div>
	</c:if>
	