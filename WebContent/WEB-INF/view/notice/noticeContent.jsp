<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>

<style>
	#writeform th { text-align:center; }
</style>

<script>
	function deleteCheck(){
		if(!confirm("공지를 삭제하시겠습니까?")) {
			return false;
		} else {
			return true;
		}
	}
</script>
	
	<div class="table-responsive">
	<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
		<tr height="20" >
			<th>표시날짜</th>
			<td>${ notice.calendar_date }</td>
			<th>등록날짜</th>
			<td>${ notice.no_date }</td>
		</tr>	
		<tr height="20">
			<th>제   목</th>
			<td >${ notice.no_title }</td>
		</tr>	
		<tr height="200" >
		    <th>내   용</td>
		    <td colspan="2">${ notice.no_content }</td>
		</tr>
		</table>   
		</div>
		<div style="text-align:center" >
				<c:if test="${ memId eq 'admin'  }">
				<input type="button" class="btn btn-warning" value="수정하기" OnClick="window.location='<c:url value="/notice/noticeUpdateForm?no_num=${ notice.no_num }" />'">
				<a href="<c:url value="/notice/noticeDeletePro?no_num=${ notice.no_num }" />" class="btn btn-danger" onclick="return deleteCheck();">삭제</a>				
				</c:if> 
		  		<input type="button" class="btn btn-default" value="목록보기" OnClick="window.location='<c:url value="/notice/noticeList?pageNum=${pageNum}" />'">
		</div>
   