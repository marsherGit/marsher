<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>변 경 사 항 조 회</title>
<link href="../chocss/bootstrap.min.css" rel="stylesheet">
</head>
<style>
		div.container.content_body {
    position: relative;
    width: 800px;
}


 input[type=text] {
 padding: 5px;
 text-align: center;
 margin: 0px;
 padding-left: 40px;
 padding-right: 40px;
}

	div.col-xs-1{padding:0; width: 100px;}
	div.col-xs-2{padding:0; width: 50px;}
	div.col-xs-3{padding:0; width: 160px;}
	div.col-xs-4{
	padding:0; width: 235px;
	bottom:5px;
	}
	div.col-xs-5{padding:0; width: 55px;}
	div.col-md-1{padding:0; width: 15px;}
	div.col-md-2{padding:0; width: 45px;}
</style>
<body>
<br/>
<form action="jegoJJListJHPro?num=${index}" method="post">
<table border="1" cellpadding="0" cellspacing="0" align="center" border="1" class="table-striped">
    <tr>
      <td align="center"  width="50"  >No</td>
      <td align="center"  width="200" >제품번호</td>
      <td align="center"  width="200" >실사재고</td>
      <td align="center"  width="200" >재고수량</td>
    </tr>

   <c:forEach var="article" items="${JJListgetContents}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
	<td align="center" width="200"><input type="text" name="pro_num" id=pro_num  class="btn btn-default" value="${article.pro_num}" style="text-align:center;" readonly/></td>
	<td align="center"  width="200"><input type="text" name="real_stockAmount" class="btn btn-default" id="real_stockAmount" value="${article.real_stockAmount}" style="text-align:center;" readonly/></td>
	<td align="center"  width="200"><input type="text" name="old_stockAmount" class="btn btn-default" id="old_stockAmount" value="${article.old_stockAmount}" style="text-align:center;" readonly/></td>
  </tr>
  </c:forEach>
  
     <tr>
      <td align="center"  width="250"  colspan="2">조정날짜</td>
       <c:forEach var="article" items="${JJListgetContents}"  begin="0" end="0">
      <td align="center" width="200" colspan="2"><fmt:formatDate value="${article.mod_regdate}" type="date" pattern="YYYY/MM/dd HH:mm" /></td>
      </c:forEach>
    </tr>
</table>
<center>
<input type="button" value="뒤로가기" class="btn btn-default" onclick="document.location.href='javascript:history.go(-1)'">  
<input type="submit" value="복원" class="btn btn-default">  
</center>
</form>
</body>
</html>