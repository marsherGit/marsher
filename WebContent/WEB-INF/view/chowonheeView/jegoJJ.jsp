<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String cp = request.getContextPath(); //첫번째 경로를 가져온다
request.setCharacterEncoding("UTF-8"); 
%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$("#select1").change(function(){
		var data = $("#select1 option:selected").val();
		var url="<%=cp%>/chowonheeView/ajax/jegoJJ1";
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
	
	    var x = document.getElementsByClassName("totalStockAmount");
	    var y = document.getElementsByClassName("properStock");

 	    for(var i=0;i<x.length;i++){
	    	/* alert(x[i].value); */
	    	if(parseInt(x[i].value)<parseInt(y[i].value)){
	    		x[i].style.color='#ffffff';
	    		x[i].style.background='#000000';
	    		y[i].style.color='#ff0000';
	    		y[i].style.background='#000000';
	    	}
	    }

/*  	   $('img').click(function(){	 
 		     var image = document.getElementsByClassName("image");
 		 	 var actuality = document.getElementsByClassName("actuality");

 		 		 for(var i=0;i<image.length;i++){
 		 			image[i].click()){
 		 			 actuality[i].setAttribute("type", "number");
 		 			}
 		 		} 
 		 }); */
 	   
   $('img').click(function(){	 
	     var image = document.getElementsByClassName("image");
	 	 var actuality = document.getElementsByClassName("actuality");
	 	 
	 	 var pro_num = document.getElementsByClassName("pro_num")
	 	 var pro_bcategory = document.getElementsByClassName("pro_bcategory");
	 	 var pro_name = document.getElementsByClassName("pro_name");
	 	 var pro_container = document.getElementsByClassName("pro_container");
	 	 var pro_volume = document.getElementsByClassName("pro_volume");
	 	 var pro_cPrice = document.getElementsByClassName("pro_cPrice");
	 	 var pro_uPrice = document.getElementsByClassName("pro_uPrice");
	 	 var totalStockAmountStore = document.getElementsByClassName("totalStockAmountStore");

	 		 for(var i=0;i<image.length;i++){
	 			if(image[i].getAttribute("alt")=="선택된인자"){
	 			 actuality[i].setAttribute("type", "number");
	 			 
	 			pro_num[i].style.color="#ff0000";
	 			pro_bcategory[i].style.color='#ff0000';
	 			pro_name[i].style.color='#ff0000';
	 			pro_container[i].style.color='#ff0000';
	 			pro_volume[i].style.color='#ff0000';
	 			pro_cPrice[i].style.color='#ff0000';
	 			pro_uPrice[i].style.color='#ff0000';
	 			totalStockAmountStore[i].style.color='#ff0000';
	 			}
	 		 } 
	 });
	 
 		 
 	  	$('img').mousedown(function() {
 	  		$(this).css("opacity", 0.5);
 	  		$(this).attr("alt","선택된인자")
 	  	});
 	  	
 	  	$('img').mouseup(function() {
 	  		$(this).css("opacity", 1);
 	  	});
 	  	
 	    $("tr#check").click(function(){        
 	    	if($(this).css("background-color")!='rgb(70, 130, 180)'|| $(this).css("background-color")=='rgb(255, 255, 255)'){
 	    		
 	    		$(this).css("background-color","SteelBlue");
 				
 	    	}else{
 	    	$(this).css("background-color","white");

 	    	}
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
}	
</script>
<style>
form {
	display: inline;
}

input[type=text] {
 padding: 1px;
 text-align: center;
 margin: 5px;
}

	div.col-xs-1{padding:0; width: 100px;}
	div.col-xs-2{padding:0; width: 50px; bottom:2px;}
	div.col-xs-3{padding:0; width: 160px;}
	div.col-xs-4{
	padding:0; width: 235px;
	bottom:5px;
	}
	div.col-xs-5{padding:0; width: 55px;}
	div.col-md-1{padding:0; width: 160px;}
	div.col-md-2{padding:0; width: 160px;}
</style>
<title>재 고 조 정</title>
<link href="../chocss/bootstrap.min.css" rel="stylesheet">

</head>
<style>
		div.container.content_body {
    position: relative;
    width: 800px;
}

header.content-header-wrapper{
	position: relative;
	left: 100px;
}

div.chowonhee{
width:100px;
}
</style>
<body>
<center>

<%--     선택 된 매장 : ${st_id}<br/> --%>

<form onsubmit="return fummocCheck()">  
<div class="row">
<div class="col-md-2"></div>
<div class="col-xs-1">
<select id="select" name="st_id" class="form-control input-sm">
	<option>전체매장</option>
	<c:forEach var="article" items="${selectListStores}" varStatus="status">
	<c:set var="check" value="${article.st_name}"/>
	<option value="${article.st_name}"  <c:if test="${param.st_id == check}">selected="selected"</c:if>>${article.st_name}</option>
	</c:forEach>
</select>
</div>

<div class="col-xs-1">
<select id="select1" name="select1" class="form-control input-sm">
	<option value="품목선택">품목선택</option>
	<option value="전체" <c:if test="${param.select1 == '전체'}">selected="selected"</c:if>>전체</option>
	<c:forEach var="article" items="${selectListItems}" varStatus="status">
	<c:set var="check" value="${article.pro_bcategory}"/>
	<option value="${article.pro_bcategory}" <%-- <c:if test="${param.select1 == check}">selected="selected"</c:if> --%>>${article.pro_bcategory}</option>
	</c:forEach>
</select> 
</div>

<div class="col-xs-1">
<select id="select2" name="select2" class="form-control input-sm" style="width:160px;">	
  <option value="제품명선택">제품명선택(선택사항)</option>
</select>
</div>
<div class="col-xs-5"></div>
<div class="col-xs-4">
<input type="text" id="search" name="search" style="width:230px; height:30px;" class="btn btn-default" placeholder="제품명을 입력해 주세요(선택사항)" />
</div>
<div class="col-xs-2">
<input type="submit" value="검색" class="btn btn-default"  style="width:50px;"/>
</div>
</div>
</form>
</center>

<c:if test="${JHandJJList.size()==0}">
<table width="1000" border="1" cellpadding="0" align="center" cellspacing="0">
  <tr>
    <td align="center">
      검색 결과가 없습니다.
    </td>
  </tr>
</table>
</c:if>
<c:if test="${JHandJJList.size()>0}">
<form action="jegoJJPro">
<table border="1" cellpadding="0" cellspacing="0" align="center" border="1" class="table-striped">
    <tr bgcolor="${value_c}">
      <td align="center"  width="50"  >No</td>
      <td align="center"  width="90"  >제품번호</td>
      <td align="center"  width="90"  >품목</td>
      <td align="center"  width="90" >제품명</td>
      <td align="center"  width="90" >용 기</td>
      <td align="center"  width="90" >용 량(ml)</td>
      <td align="center"  width="90" >제품원가(원)</td>
      <td align="center"  width="90" >판매단가(원)</td>
      <td align="center"  width="90" >매장재고수량</td>
      <td align="center"  width="90" >창고재고수량</td>
      <td align="center"  width="90" >적정재고</td>
      <td align="center"  width="90" >실사재고입력</td>
      <td align="center"  width="90"></td>
      <td align="center"  width="90" >비고</td>
    </tr>

   <c:forEach var="article" items="${JHandJJList}">
   <tr height="30" id="check">
    <td align="center"  width="50" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
	<td align="center" width="90" ><input type="text" style="text-align:center; width:90px;" id="pro_num" name="pro_num" class="pro_num btn btn-default" value="${article.pro_num}" readonly/></td>
	<td align="center"  width="90">
	<input type="text" style="text-align:center; width:90px;" id="pro_bcategory" name="pro_bcategory" class="pro_bcategory btn btn-default" value="${article.pro_bcategory}" readonly/>
	</td>
	<td align="center"  width="90">
	<input type="text" style="text-align:center; width:90px;" id="pro_name" name="pro_name" class="pro_name btn btn-default" value="${article.pro_name}" readonly/>
	</td>
	<td align="center"  width="90">
	<input type="text" style="text-align:center; width:90px;" id="pro_container" name="pro_container" class="pro_container btn btn-default" value="${article.pro_container}" readonly/>
	</td>
    <td align="center"  width="90">
    <input type="text" style="text-align:center; width:90px;" id="pro_volume" name="pro_volume" class="pro_volume btn btn-default" value="  ${article.pro_volume}" readonly/>
    </td>
    <td align="center" width="90" >
     <input type="text" style="text-align:center; width:90px;" id="pro_cPrice" name="pro_cPrice" class="pro_cPrice btn btn-default" value="${article.pro_cPrice}" readonly/>
    </td>
    <td align="center" width="90" >
    <input type="text" style="text-align:center; width:90px;" id="pro_uPrice" name="pro_uPrice" class="pro_uPrice btn btn-default" value="${article.pro_uPrice}" readonly/>
    </td>
    <td align="center" width="90" >
     <input type="text" style="text-align:center; width:90px;" id="totalStockAmountStore" name="totalStockAmountStore" class="totalStockAmountStore btn btn-default" value=" ${article.totalStockAmountStore}" readonly/>
    </td>
    <td align="center" width="90" >
    <input type="text" style="text-align:center; width:90px;" id="totalStockAmount" name="totalStockAmount" class="totalStockAmount btn btn-default" value="${article.totalStockAmount}" readonly/>
    </td>
    <td align="center" width="90" >
    <input type="text" style="text-align:center; width:90px;" id="properStock" name="properStock" class="properStock btn btn-default" value="${article.pro_properStock}" readonly/>
    </td>
    <td align="center"  width="90" onclick="event.cancelBubble=true;">
    <div class="chowonhee">
    <input type="hidden" style="text-align:right; width:90px;" id="actuality" name="actuality" class="actuality btn btn-default" value="" min="0"/>
    </div>
    </td>
    <td align="center"  width="90" onclick="event.cancelBubble=true;"><img src="../choimg/plus.PNG" id="img" name="image" class="image" alt="plusimage" width="19"></td>
    <td align="center" width="90"><input type="text" style="text-align:center; width:90px;" id="pro_remark" name="pro_remark" class="pro_remark btn btn-default" value="${article.pro_remark}" readonly/></td>
  </tr>
  </c:forEach>
    
  <tr>
  <td width="140" align="center" colspan="2">합 계</td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90">${totalstore}</td>
  <td align="center"  width="90">${totalchango}</td>
  <td align="center"  width="90">${totalappropriate}</td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90"></td>
  <td align="center"  width="90"></td>
  </tr>
</table>
<center>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="adjustButton" id="adjustButton" value="조정하기" class="btn btn-default"/>
<input type="button" name="cancelButton" id="cancelButton" value="취소하기" class="btn btn-default" onclick="document.location.href='jegoJJ'"/>
<input type="button" name="changedList" id="changedList" value="변경사항조회" class="btn btn-default" onclick="document.location.href='jegoJJList'"/>
</center>
</form>
</c:if>
</body>
</html>