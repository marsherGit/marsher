<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jstl/fmt_rt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<style>
.msg_content {
	padding: 0 3em;
}

.delivery_table {
	margin-top: 1em;
}
</style>
<script>
function deleteCheck(){
	if(!confirm("�����Ͻðڽ��ϱ�?")) {
		return false;
	} else {
		return true;
	}
}
$(document).ready(function(){
	/* ����޴� Ȱ��ȭ */
	$(".user_nav>li:eq(0)>a").addClass("active");
	$(".aside-wrapper>.list-group>.list-group-item").eq(4).addClass("on");
})
</script>
<body>
	<div class="msg_content">
			<table
				class="table table-striped table-bordered text-center delivery_table row">
					<tr>
						<td align="center" width="70">������</td>
						<td align="center" width="165" align="center">${msg.re_sender}</td>
						<td align="center" width="70">�߼۳�¥</td>
						<td align="center" width="165" align="center"><fmt:formatDate value="${ msg.re_regdate }" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<td align="center" width="70">�޴���</td>
						<td align="center" width="165" align="center">${msg.re_receiver}</td>
						<td align="center" width="70">����Ȯ��</td>
						<td align="center" width="165" align="center">${msg.re_checkDate}</td>
					</tr>
					<tr>
						<td align="center" width="70">�� ��</td>
						<td align="center" width="330" align="center" colspan="3">${msg.re_title}</td>
					</tr>
					<tr>
						<td align="left" width="375"  height="13" colspan="4" ><pre>${msg.re_content}</pre></td>
					</tr>
			</table>
			<br>
			<div class="row text-center btns">
			<a
				href="<c:url value="/message/deleteReceive?re_num=${msg.re_num}&pageNum=${pageNum}" />"
				class="btn btn-outline btn-primary" onclick="return deleteCheck();" > �����ϱ�</a>&nbsp;<a
				href="<c:url value="/message/writeMsgForm.do?num=${msg.re_num}" />"
				class="btn btn-outline btn-primary"> �����ϱ�</a>&nbsp;<a
				href="<c:url value="/message/receiveMsgList.do?pageNum=${pageNum}" />"
				class="btn btn-outline btn-primary"> �������</a>
				</div>
	</div>
</body>
</html>