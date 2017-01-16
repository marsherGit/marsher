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
		var url="<%=cp%>/chowonheeView/ajax/jegoJH1";
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
	
	    var y = document.getElementsByClassName("totalStockAmountStore");
	    var x = document.getElementsByClassName("pro_name");
 	    for(var i=0;i<x.length;i++){
	    		x[i].style.color='#ffffff';
	    		x[i].style.background='#000000';
	    		y[i].style.color='#ffffff';
	    		y[i].style.background='#000000';
	    }

		
	var pro_num = $("input[name='pro_num']");
 	var pro_bcategory = $("input[name='pro_bcategory']");
 	var pro_name = $("input[name='pro_name']");
 	var pro_container = $("input[name='pro_container']");
 	var pro_volume = $("input[name='pro_volume']");
 	var pro_cPrice = $("input[name='pro_cPrice']");
 	var pro_uPrice = $("input[name='pro_uPrice']");
 	var totalStockAmountStore = $("input[name='totalStockAmountStore']");
 	var totalStockAmount = $("input[name='totalStockAmount']");
 	var properStock = $("input[name='properStock']");
 	var pro_remark = $("input[name='pro_remark']");
 	
 	var jegoProNum = new Array();
 	for(var i=0; i<pro_num.length; i++)
 	{
 	  jegoProNum[i] = pro_num.eq(i).val();
 	}
 	
 	/* 
 	var jegoJJList = new Array();
 	   for(var i=0;i<x.length;i++){
 	   
 		  jegoJJList.get(i)=
 	   }
 	   */  
/*  	    
 	  changoIGBoard[] changoIGBoard=new changoIGBoard[10];
		
		for(int i=0;i<changoIGBoard.length;i++){
			changoIGBoard[i] = new changoIGBoard();
			List<Object> list=new ArrayList<Object>();
			list.set(i, changoIGBoard[i]);
			
		}
 	    
 	     */
 	    
 	    
 	     /*
 	     리퀘스트 겟어트리뷰트로 하나하나 리스트에 저장한다음
    	메서드
	 리퀘스트 겟세션

          세션어트리뷰트로 이름가지오기
 	     */
	    $("tr#check").click(function(){        
 	    	if($(this).css("background-color")!='rgb(70, 130, 180)'|| $(this).css("background-color")=='rgb(255, 255, 255)'){
 	    		
 	    		$(this).css("background-color","SteelBlue");
 				
 	    	}else{
 	    	$(this).css("background-color","white");

 	    	}
 	    }); 
 	     
 	     
	});
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
</style>
<title>재 고 조 회</title>
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

	div.col-xs-1{padding:0; width: 100px;}
	div.col-xs-2{padding:0; width: 50px; bottom:2px;}
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
<center>

<%--     선택 된 매장 : ${st_id}<br/> --%>

<form onsubmit="return fummocCheck()">
<div class="row">
<div class="col-md-1"></div>
<div class="col-xs-1">
<input type="button" id="excel" value="엑셀저장" style="width:100px;" class="btn btn-warning" onclick="document.location.href='<c:url value='/download/pageRanks?totalstore=${totalstore}&totalchango=${totalchango}&totalappropriate=${totalappropriate}&st_id=${st_id}'/>'">
</div>

<div class="col-md-2"></div>
<div class="col-xs-1">
<select id="select" name="st_id" class="form-control input-sm">
	<option value="${selectListStores.st_name}"  <c:if test="${param.st_id == check}">selected="selected"</c:if>>${selectListStores.st_name}</option>
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
<input type="submit" value="검색" class="btn btn-default" style="width:50px;"/>
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
<table border="1" cellpadding="0" cellspacing="0" align="center" border="1" class="table-striped">
    <tr bgcolor="${value_c}">
      <td align="center"  width="90"  >No</td>
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
      <td align="center"  width="90" >비고</td>
    </tr>

   <c:forEach var="article" items="${JHandJJList}">
   <tr height="30" id="check">
    <td align="center"  width="90" >
  <c:out value="${number}"/>
  <c:set var="number" value="${number - 1}"/>
</td>
	<td align="center" width="90" >
	<input type="text" style="text-align:center; width:90px;" id="pro_num" name="pro_num" class="pro_num btn btn-default" value="${article.pro_num}" readonly/>
	</td>
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
    <input type="text" style="text-align:center; width:90px;" id="pro_volume" name="pro_volume" class="pro_volume btn btn-default" value="${article.pro_volume}" readonly/>
    </td>
    <td align="center" width="90" >
    <input type="text" style="text-align:center; width:90px;" id="pro_cPrice" name="pro_cPrice" class="pro_cPrice btn btn-default" value=" ${article.pro_cPrice}" readonly/>
    </td>
    <td align="center" width="90" >
     <input type="text" style="text-align:center; width:90px;" id="pro_uPrice" name="pro_uPrice" class="pro_uPrice btn btn-default" value="${article.pro_uPrice}" readonly/>
    </td>
    <td align="center" width="90" >
    <input type="text" style="text-align:center; width:90px;" id="totalStockAmountStore" name="totalStockAmountStore" class="totalStockAmountStore btn btn-default" value="${article.totalStockAmountStore}" readonly/>
    </td>
    <td align="center" width="90" >
    <input type="text" style="text-align:center; width:90px;" id="totalStockAmount" name="totalStockAmount" class="totalStockAmount btn btn-default" value="${article.totalStockAmount}" readonly/>
    </td>
    <td align="center" width="90" >
    <input type="text" style="text-align:center; width:90px;" id="properStock" name="properStock" class="properStock btn btn-default" value="${article.pro_properStock}" readonly/>
    </td>
    <td align="center" width="90" > <input type="text" style="text-align:center; width:90px;" id="pro_remark" name="pro_remark" class="pro_remark btn btn-default" value="${article.pro_remark}" readonly/></td>
  </tr>
  </c:forEach>
    
  <tr>
  <td width="180" align="center" colspan="2">합 계</td>
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
  </tr>
</table>
</c:if>
</body>
</html>