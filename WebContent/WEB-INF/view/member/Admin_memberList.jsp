<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form method="post" name="AdminUpdateList">

	  <table class="table table-bordered" border="1" width="450">
	  <tr>
	  <th width="70" height="20" style="text-align:center"><h4><B>매장ID</B></h4></th>
	  <th width="100" height="20" style="text-align:center"><h4><B>매장명</B></h4></th>
	  <th width="100" height="20" style="text-align:center"><h4><B>연락처</B></h4></th>
	  <th width="200" height="20" style="text-align:center"><h4><B>주소</B></h4></th>
	  <th width="80" height="20" style="text-align:center"><h4><B>상세정보</B></h4></th>
	  </tr>
	 
	  <c:forEach var="list" items="${showList}">
	  <tr>
	  <th width="70" height="20" style="text-align:center">${list.st_id}</th>
	  <th width="100" height="20" style="text-align:center">${list.st_name}</th>
	  <th width="100" height="20" style="text-align:center">${list.st_tel}</th>
	  <th width="200" height="20" style="text-align:center">${list.st_location}</th>
	  <th width="80" height="20" style="text-align:center"><input type = "button" class="btn btn-info btn-xs" value = "수정" onclick="location.href='/Marsher/member/AdminUpdateForm.do?st_id=${list.st_id}';" /></th>
	  </tr>  
	  
	  </c:forEach>
	  </table>
	</form>


</body>
</html>