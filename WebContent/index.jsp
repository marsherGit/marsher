<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Marsher :: 로그인</title>
</head>
<body>
	<c:if test="${ memId ne null }">
		<% response.sendRedirect("login/main"); %>
	</c:if>
	<c:if test="${ memId eq null }">
		<% response.sendRedirect("login/login"); %>
	</c:if>
</body>
</html>