<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>

<style>
	.noticeWirteForm {padding:0 20%;}
</style> 

<div class="noticeWirteForm container">
<form method="post" name="updateform" id="updateform" action="noticeUpdatePro?no_num=${no_num}">
	
	<div class="form-group">
	<table class="table table-striped table-bordered text-center" width="700">
		<tr>
			<th class="control-label col-sm-1" style="text-align:center;">표시날짜</th>
			<td class="col-sm-5"><input type="date" class="form-control" name="calendar_date" id="calendar_date" value="${ notice.calendar_date }" ></td>
		</tr>	
		<tr>
			<th class="control-label col-sm-1" style="text-align:center;">제   목</th>
			<td class="col-sm-5"><input type="text" class="form-control" name="no_title" id="no_title" value="${ notice.no_title }"></td>
		</tr>	
		<tr>
		    <th class="control-label col-sm-1" style="text-align:center;">내   용</td>
		    <td class="col-sm-5"><textarea name="no_content" id="no_content" rows="13" cols="40" class="form-control">${ notice.no_content }</textarea> </td>
		</tr>
		</table>   
		</div>
		<div style="text-align:right">  
				<input type="submit" class="btn btn-info" value="수정" > 
		  		<input type="reset" class="btn btn-warning" value="다시작성">　　　　　　　　　　　　　　 　 　　　
		  		<input type="button" class="btn btn-default" value="취소" OnClick="javascript:history.back()">
		</div>
	
</form>     
</div>