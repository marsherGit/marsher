<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>창 고 재 고조 회</title>
<link href="../chocss/bootstrap.min.css" rel="stylesheet">

</head>
<style>
		div.container.content_body {
    position: relative;
    width: 800px;
}
</style>
<body>
<br/>
    
<table border="1" cellpadding="0" cellspacing="0" align="center" border="1" class="table-striped">
    <tr bgcolor="${value_c}">
      <td align="center"  width="50"  >No</td>
      <td align="center"  width="100" >제품번호</td>
      <td align="center"  width="100" >제품명</td>
      <td align="center"  width="100" >용 기</td>
      <td align="center"  width="100" >용량(ml)</td>
      <td align="center"  width="100" >수량(EA)</td>
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
	<td align="center" width="100" >${article.pro_num}</td>
	<td align="center"  width="100">${article.pro_name}</td>
	<td align="center"  width="100">${article.pro_container}</td>
    <td align="center"  width="100">${article.pro_volume}</td>
    <td align="center" width="100" >${article.pro_count}</td>
  </tr>
  </c:forEach>
  
  <tr>
  <td  width="150"  colspan="2" align="center">합 계</td>
  <td align="center"  width="300" colspan="3"></td>
  <td align="center" width="100" readonly>${inoutBoard.total}</td>
  </tr>
  
  <tr>
  <td  width="150" align="center" colspan="2">출고장소</td>
  <td align="center" width="400" name="inout_sender" colspan="4" readonly>${inoutBoard.inout_sender}</td>
  </tr>
     
  <tr>
  <td  width="150" align="center" colspan="2">입고장소</td>
  <td align="center" width="400" name="inout_receiver" colspan="4" readonly>${inoutBoard.inout_receiver}</td>
  </tr>  
  
  <tr>
  <td  width="150" align="center" colspan="2">등록날짜</td>
  <td align="center" width="400" name="inout_deadline" colspan="4" readonly><fmt:formatDate value="${inoutBoard.inout_deadline}" type="date" pattern="YYYY/MM/dd HH:mm" /></td>
  </tr>  
     
  <tr>
  <td width="50" height="150" align="center">비 고</td>
  <td colspan="5"><textarea class="btn btn-default" name=comment rows="5" cols="100" readonly>${inoutBoard.inout_note}</textarea></td>
  </tr>
</table>
<center>
<input type="button" value="뒤로가기" onclick="document.location.href='javascript:history.go(-1)'" class="btn btn-default">  
</center>
</body>
</html>