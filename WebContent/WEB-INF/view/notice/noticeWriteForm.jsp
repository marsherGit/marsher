<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>

<style>
	#writeform th { text-align:center; }
</style>

<form method="post" name="writeform" id="writeform" action="noticeWritePro">
	
	<div class="form-group">
	<table width="800" border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<th class="control-label col-sm-1">표시날짜</th>
			<td class="col-sm-5"><input type="date" class="form-control" name="calendar_date" id="calendar_date" ></td>
		</tr>	
		<tr>
			<th class="control-label col-sm-1">제   목</th>
			<td class="col-sm-5"><input type="text" class="form-control" name="no_title" id="no_title"></td>
		</tr>	
		<tr>
		    <th class="control-label col-sm-1">내   용</td>
		    <td class="col-sm-5"><textarea name="no_content" id="no_content" rows="13" cols="40" class="form-control"></textarea> </td>
		</tr>
		</table>   
		</div>
		<div style="text-align:center" >
				<input type="submit" class="btn btn-info" value="등록" > 
		  		<input type="reset" class="btn btn-warning" value="다시작성">
		  		<input type="button" class="btn btn-default" value="목록보기" OnClick="window.location='<c:url value="/notice/noticeList" />'">
		</div>
	
</form>     