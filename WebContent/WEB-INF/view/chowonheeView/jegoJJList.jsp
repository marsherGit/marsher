<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String cp = request.getContextPath(); //첫번째 경로를 가져온다
request.setCharacterEncoding("UTF-8"); 
%>
<html>
<head>
<link href="../chocss/bootstrap.min.css" rel="stylesheet">
<title>실 사 재 고 조 정</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$("#select1").change(function(){
		var data = $("#select1 option:selected").val();
		var url="<%=cp%>/chowonheeView/ajax/jegoJJListJH1";
		var pro_bcategory ="pro_bcategory="+data;  			             
		
		$.ajax({
			type:"post"
			,url:url	
			,data:pro_bcategory
			,dataType:"json"
			,success:function(args){ //args는 원하는 이름으로 대체가능
				 $("#select2 option").each(function() {	
					$("#select2 option:eq(1)").remove();	
				 }); 
				
				 for(var idx=0; idx<args.data.length; idx++) { //size가아닌 length로(길이로 받아온다 길이=개수)
					 $("#select2").append("<option value='"+args.data[idx]+"'>"+args.data[idx]+"</option>");
				 }
			  	}
 			});
 		});
});
</script>
<script>
function fummocCheck(){
	if($("#select1 option:selected").val() == "품목선택"){
		if($("#search").val()==""){
		alert("품목을 선택하지 않았습니다.");
			$("#select1").focus();
			return false;
		}
	}
	if(($("#select1 option:selected").val() != "품목선택")&&($("#select1 option:selected").val() != "전체")){
		if($("#select2 option:selected").val() == "제품명선택"){
			if($("#search").val()==""){
			alert("제품명을 선택하지 않았습니다.");
				$("#select2").focus();
				return false;
			}
		}
	}
}	
</script>
<style>
form {
	display: inline;
}
</style>
<style>
		div.container.content_body {
    position: relative;
    width: 800px;
}

	div.col-md-5{padding:0; width: 100px;}
	div.col-md-2{padding:0; width: 230px;}
	div.col-md-1{padding:0; width: 100px;}
	div.col-xs-1{width: 65px;}
	div.col-md-3{padding:0; width: 140px;}
	div.col-xs-2{padding:0; width: 50px; bottom:2px;}
</style>
<body>
<br/>
<c:if test="${articleList.size()==0}">
<table width="800" border="1" cellpadding="0" align="center" cellspacing="0">
  <tr>
    <td align="center">
      검색 결과가 없습니다.
    </td>
  </tr>
</table>
<br/>
</c:if>
<c:if test="${articleList.size()>0}">
<table border="1" cellpadding="0" cellspacing="0" align="center" class="table-striped">
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="50"  >#</td>
      <td align="center"  width="700" >제 목</td>
      <td align="center"  width="150" >등록날짜</td>
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
    <td  width="700" >         
      <a href="jegoJJListJH?num=${article.mod_number}&pageNum=${currentPage}">${article.title}</a>
    </td>
    <td align="center"  width="150"> <fmt:formatDate value="${article.mod_regdate}" type="date" pattern="YYYY/MM/dd HH:mm" /></td>
  </tr>
  </c:forEach>
</table>
</c:if>

</br>
<center>
<form onsubmit="return fummocCheck()">
<div class="col-md-5"></div>
<div class="col-md-1">
<select id="select1" name="select1" class="form-control input-sm">
	<option value="품목선택">품목선택</option>
	<option value="전체" <c:if test="${param.select1 == '전체'}">selected="selected"</c:if>>전체</option>
	<c:forEach var="article" items="${selectListItems}" varStatus="status">
	<c:set var="check" value="${article.pro_bcategory}"/>
	<option value="${article.pro_bcategory}" <%-- <c:if test="${param.select1 == check}">selected="selected"</c:if> --%>>${article.pro_bcategory}</option>
	</c:forEach>
</select> 
</div>
<div class="col-md-1">
<select id="select2" name="select2" class="form-control input-sm">	
  <option value="제품명선택">제품명선택(선택사항)</option>
</select>
</div>
<div class="col-md-2">
<input type="text" class="btn btn-default" id="search" name="search" style="width:230px; height:30px;" placeholder="제품명을 입력해 주세요(선택사항)"/>
</div>
<div class="col-md-3">
<input type="date" class="btn btn-default" name="dateCheck" style="width:140px; height:30px;"/>
</div>
<div class="col-xs-2">
<input type="submit" class="btn btn-default" value="검색"/>
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
				<li class="prev"><a href="<c:url value="jegoJJList?pageNum=${ startPage - pageBlock }" />">&lt;&lt;</a></li>
			</c:if>
			<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
		  	<li><a href="<c:url value="jegoJJList?pageNum=${ i }" />" class="page${ i }">${ i }</a></li>
		  </c:forEach>
		  <c:if test="${ endPage < pageCount }">
		  	<li class="next"><a href="<c:url value="jegoJJList?pageNum=${ startPage + pageBlock }" />">&gt;&gt;</a></li>
		  </c:if>
		</ul>
	</div>
	</c:if>
</center>
</body>
</html>
