<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>
 

<style>
	.noticContent {padding:2em 23%;}
	.content_body { width:100%;} 
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
	
	<div class="noticContent">
		<div class="container">
	<table class="table table-responsive table-bordered notice_content_table" style="width:600px">
				<tr>
					<th width="15%" bgcolor="F9F9F9" style="text-align:center;"><font color="366886">표시날짜</font></th>
					<td width="35%">${ notice.calendar_date }</td>
					<th width="15%"bgcolor="F9F9F9" style="text-align:center;"><font color="366886">등록날짜</font></th>
					<td width="35%">${ notice.no_date }</td>
				</tr>
				<tr>
					<th bgcolor="F9F9F9" style="text-align:center;"><font color="366886">제   목</font></th>
					<td colspan="3">${ notice.no_title }</td>
				</tr>
				<tr>	
			    <td colspan="4" height="200" >${ notice.no_content }</td>
				</tr>
					</table>   
		</div>
		<c:if test="${ memId eq 'admin'  }">
		<div style="text-align:left" >　
				<a href="<c:url value="/notice/noticeDeletePro?no_num=${ notice.no_num }" />" class="btn btn-danger" onclick="return deleteCheck();">삭제</a>	　　　　　　　　　　　　　
				<input type="button" class="btn btn-warning" value="수정하기" OnClick="window.location='<c:url value="/notice/noticeUpdateForm?no_num=${ notice.no_num }" />'">
		  		<input type="button" class="btn btn-default" value="목록보기" OnClick="window.location='<c:url value="/notice/noticeList?pageNum=${pageNum}" />'">
		</div>
		</c:if> 
		<c:if test="${ memId ne 'admin'  }"> 
		<div style="text-align:center" >　 
		<input type="button" class="btn btn-default" value="목록보기" OnClick="window.location='<c:url value="/notice/noticeList?pageNum=${pageNum}" />'">　
		</div>
		</c:if>
   </div>