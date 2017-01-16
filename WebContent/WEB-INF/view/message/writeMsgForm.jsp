<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>
 
<style>
.writeMsg_form {
	padding: 0 3em;
}

.delivery_table {
	margin-top: 1em;
}
</style>

<script>
	/* validator */
	function checkIt() {
		if (document.getElementById('se_receiver').value == '') {
			alert("받는 이를 선택해 주세요");
			return false;
		}
		if (document.getElementById('se_title').value == '') {
			alert("제목을 입력해 주세요");
			return false;
		}
		if (document.getElementById('se_content').value == '') {
			alert("내용을 입력해 주세요");
			return false;
		} else if (!confirm("쪽지를 보내시겠습니까?")) {
			return false;
		} else
			return true;
	}
</script>

	<div class="writeMsg_form">
		<form name="writeMsgForm" method="post"
			action="<c:url value="/message/writeMsgPro" />"
			onsubmit="return checkIt()">
			
			<input type="hidden" name="se_sender" value="${memId}">
			<input type="hidden" name="st_id" value="${memId}">
			<table
				class="table table-striped table-bordered text-center delivery_table row">

				<tr>
					<td width="70" align="center">보낸이</td>
					<td width="330" align="left">${memId }</td>
				</tr>
				<tr>
					<td width="70" align="center">받는이</td>
					<td width="330" ><select id="se_receiver" name="se_receiver"
						class="form-control">
							<option disabled="" selected="">수신매장을 선택해주세요</option>
							<option value="manager1">강남 역삼점</option>
							<option value="manager2">춘천 약사명점</option>
							<option value="manager3">대전 은행점</option>
							<option value="manager4">광주 충장로점</option>
							<option value="admin">관리자</option>
					</select></td>
				</tr>
				<tr>
					<td width="70" align="center">제 목</td>
					<td width="330"><input type="text" size="100" maxlength="30" id="se_title"
						name="se_title"></td>
				</tr>
				<tr>
					<td colspan=2><textarea name="se_content" id="se_content" rows="13" cols="100"></textarea></td>
				</tr>
			</table>
			<br>
			<div class="row text-center btns">
				<input type="submit" value="등록하기" class="btn btn-primary"> <input
					type="button" value="취소하기" class="btn btn-default"
					onclick="javascript:history.back()">
			</div>

		</form>
	</div>
