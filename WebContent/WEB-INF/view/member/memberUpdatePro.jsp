<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${check==1}">
성공
<meta http-equiv="Refresh" content="0;/Marsher/member/updateForm.do?st_id=${st_id}" >
</c:if>
<c:if test="${check!=1}">
실패
<br>
<a href="javascript:history.go(-1)">[글수정 폼으로 돌아가기]</a>
</c:if>

<%-- <meta http-equiv="Refresh" content="0;/Marsher/member/updateForm.do?st_id=${st_id}" > --%>