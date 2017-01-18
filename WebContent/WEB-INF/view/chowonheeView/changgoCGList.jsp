<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link href="../chocss/bootstrap.min.css" rel="stylesheet">
<title>창 고 출 고</title>

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>



<script>
function stNameCheck(){
	if($("#select option:selected").val() == "매장선택"){
		alert("매장을 선택하지 않았습니다.");
			$("#select").focus();
			return false;
		}
}
</script>
<style>
form {
	display: inline;
}

	.deliveryState_container {padding-top:1em;}
	.state_table {margin-bottom:0.5em;}
	.state_table>tbody>tr>td, .state_table>tbody>tr>th, .state_table>tfoot>tr>td, .state_table>tfoot>tr>th, .state_table>thead>tr>td, .state_table>thead>tr>th {padding:0.5em;}
	.state_table th, .state_table td {text-align:center;}
	.state_table td.text-left {text-align:left;}
	.searchForm {text-align:left; margin-bottom:0.5em;}
	.searchForm>div {padding:0;}
	.searchForm>div>div {padding:0; padding-right:0.5em;}

	.col-md-5{padding:0; width: 180px;}
	.col-md-2{padding:0; width: 150px;}
	.col-md-1{padding:0; width: 100px;}
	.col-xs-1{width: 65px;}
	
		div.container.content_body {
    position: relative;
    width: 800px;
}

	div.button{
	position: relative;
	bottom:5px;
	}
	
</style>
<body>
<br/>

<div class="button">
<center><input type="button" value="등록하기" class="btn btn-warning" onclick="document.location.href='CGjegoDR?pageNum=${currentPage}'"></center>
</div>
<table border="1" cellpadding="0" cellspacing="0" align="center" class="table-striped">
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="50"  >#</td>
      <td align="center"  width="150" >제 목</td>
      <td align="center"  width="150" >출고장소</td>
      <td align="center"  width="150" >입고장소</td>
      <td align="center"  width="150" >등록날짜</td>
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
    <td  width="150" >         
      <a href="CGjegoJH?num=${article.inout_num}&pageNum=${currentPage}">
        ${article.inout_name}</a>
    </td>
    <td align="center"  width="150">${article.inout_sender}</td>
    <td align="center"  width="150">${article.inout_receiver}</td> 
    <td align="center"  width="150"> <fmt:formatDate value="${article.inout_deadline}" type="date" pattern="YYYY/MM/dd HH:mm" /></td>
  </tr>
  </c:forEach>
</table>

<center>
<form onsubmit="return stNameCheck()">
<div class="col-md-5"></div>
<div class="col-md-2">
<select id="select" name="st_name" class="form-control input-sm">
<option value="매장선택">매장선택</option>
<option value="전체" <c:if test="${param.st_name == '전체'}">selected="selected"</c:if>>전체</option>
<c:forEach var="article" items="${stNameList}" varStatus="status">
<c:set var="check" value="${article.st_name}"/>
<option value="${article.st_name}"  <c:if test="${param.st_name == check}">selected="selected"</c:if>>${article.st_name}</option>
</c:forEach> 
</select>
</div>
<div class="col-md-1">
<input type="date" name="dateCheck" class="btn btn-default" style="width:170px; height: 30px;"/>
</div>
<div class="col-xs-1"></div>
<div class="col-md-1">
<input type="submit" name="facName" value="검색" class="btn btn-default" style="width:90px; height: 30px;"/>
</div>
</form>
</center>

<br/><br/>
<center>
	<!-- pagenation -->
	<c:if test="${ count > 0 }">
	<c:set var="pageCount" value="${ count / pageSize + ( count % pageSize == 0 ? 0 : 1) }"/>
  	<c:set var="pageBlock" value="${ 3 }"/>
  	<fmt:parseNumber var="result" value="${ (currentPage % pageBlock == 0 ? currentPage-1 : currentPage) / pageBlock }" integerOnly="true" />
  	<c:set var="startPage" value="${ result * pageBlock + 1 }" />
  	<c:set var="endPage" value="${ startPage + pageBlock - 1 }"/>
  	<c:if test="${ endPage > pageCount }">
        <c:set var="endPage" value="${ pageCount }"/>
  	</c:if>
	<div class="row pagingArea text-center">
		<ul class="pagination pagination-sm">
			<c:if test="${ startPage > pageBlock }">
				<li class="prev"><a href="<c:url value="changgoCGList?pageNum=${ startPage - pageBlock }" />">&lt;&lt;</a></li>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
		  	<li><a href="<c:url value="changgoCGList?pageNum=${ i }" />" class="page${ i }">${ i }</a></li>
		  </c:forEach>
		  <c:if test="${ endPage < pageCount }">
		  	<li class="next"><a href="<c:url value="changgoCGList?pageNum=${ startPage + pageBlock }" />">&gt;&gt;</a></li>
		  </c:if>
		</ul>
	</div>
	</c:if>
</center>
</body>
</html>
