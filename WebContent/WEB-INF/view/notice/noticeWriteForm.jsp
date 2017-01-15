<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>

<style>
	.noticeWirteForm {padding:0 20%;}
</style>



<script>
	function checkIt() {

		if (document.getElementById('no_title').value == '') {
			alert("제목을 입력해 주세요");
			return false;
		}
		if (document.getElementById('no_content').value == '') {
			alert("내용을 입력해 주세요");
			return false;
		}

		else if (!confirm("공지를 등록하시겠습니까?")) {
			return false;
		} else
			return true;
	}
	
	</script>
<div class="noticeWirteForm container">
<form method="post" name="writeform" id="writeform" action="noticeWritePro" onsubmit="return checkIt()">
	
	<div class="form-group">
	<table class="table table-striped table-bordered text-center" width="700"> 
		<tr>
			<th class="control-label col-sm-1" style="text-align:center;">표시날짜</th>
			<td class="col-sm-6"><input type="date" class="form-control" name="calendar_date" id="calendar_date" ></td>
		</tr>	
		<tr>
			<th class="control-label col-sm-1" style="text-align:center;">제   목</th>
			<td class="col-sm-6"><input type="text" class="form-control" name="no_title" id="no_title"></td>
		</tr>	
		<tr>
		    <th class="control-label col-sm-1" style="text-align:center;">내   용</td>
		    <td class="col-sm-6"><textarea name="no_content" id="no_content" rows="13" cols="40" class="form-control"></textarea> </td>
		</tr>
		</table>   
		</div>
		<div style="text-align:right" >
				<input type="submit" class="btn btn-info" value="등록" >
		  		<input type="reset" class="btn btn-warning" value="다시작성">　　　　　　　　　　　　 　 　　　
		  		<input type="button" class="btn btn-default" value="목록보기" OnClick="window.location='<c:url value="/notice/noticeList" />'">
		</div>
</form>     
</div>