<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>



<script>
	function deleteCheck(){
		if(!confirm("공지를 삭제하시겠습니까?")) {
			return false;
		} else {
			return true;
		}
	}
</script>
	
	<div class="container" style="width:650px">
	<table class="table table-responsive table-bordered notice_content_table" >
				<tr>
					<th width="15%" bgcolor="#D9EDF7" style="text-align:center;"><font color="366886">표시날짜</font></th>
					<td width="35%">${ notice.calendar_date }</td>
					<th width="15%"bgcolor="#D9EDF7" style="text-align:center;"><font color="366886">등록날짜</font></th>
					<td width="35%">${ notice.no_date }</td>
				</tr>
				<tr>
					<th bgcolor="#D9EDF7" style="text-align:center;"><font color="366886">제   목</font></th>
					<td colspan="3">${ notice.no_title }</td>
				</tr>
				<tr>	
			    <td colspan="4" height="200" >${ notice.no_content }</td>
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
   