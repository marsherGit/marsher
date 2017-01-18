<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String cp = request.getContextPath(); //첫번째 경로를 가져온다
request.setCharacterEncoding("UTF-8"); 
%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('img').click(function(){
       var lastItemNo = $("#table tr:eq(0)").next().attr("class").replace("jegoDRtable","");
       
       var newjegoDRtable = $("#table tr:eq(1)").clone();
       newjegoDRtable.removeClass();
       newjegoDRtable.addClass("jegoDRtable"+(parseInt(lastItemNo)+1));
       $("#table tr:eq(0)").after(newjegoDRtable);
   
       
       var number=$("#number:last").val(); 
       number = $("#number:last").val(parseInt(number)+1);
       
       
       var pro_num=$("#pro_num:last").val();
       pro_num=$("#pro_num:last").val("");
       var pro_container=$("#pro_container:last").val();
       pro_container=$("#pro_container:last").val("");
       var pro_volume=$("#pro_volume:last").val();
       pro_volume=$("#pro_volume:last").val("");    
       var pro_count=$("#pro_count:last").val();
       pro_count=$("#pro_count:last").val("0");     
       var pro_remark=$("#pro_remark:last").val();
       pro_remark=$("#pro_remark:last").val("없음");
       
       
       for(var i=2;i<=$("#table tr:eq(0)").next().attr("class").replace("jegoDRtable","");i++){
      	 /* alert(i); */
       var name = ".jegoDRtable"+i+" #select";
	   var name1 = ".jegoDRtable"+i+" #select option:selected";
       var name2 = ".jegoDRtable"+i+" #pro_num";
       var name3 = ".jegoDRtable"+i+" #pro_container";
       var name4 = ".jegoDRtable"+i+" #pro_volume";
       $(name).change(function(){
    	   if ($(name1).val() == "선택"){	 
    			var url="<%=cp%>/chowonheeView/ajax/jegoDR";
         		var pro_name ="pro_name="+data; 
         		$.ajax({
         			type:"post"
         			,url:url	
         			,data:pro_name
         			,dataType:"json"
         			,success:function(args){ //args는 원하는 이름으로 대체가능
         			  /* alert("가져온 데이터 입니다 . "+args.data.pro_num); */
         				 $(name2).val("");
         				 $(name3).val("");
         				 $(name4).val("");
          			}
          		});
    	   }
    		if ($(name1).val() != "선택"){  
     			var data = $(name1).val();
     	/* 	  alert(data1); */
     		} 
      	
     		 var url="<%=cp%>/chowonheeView/ajax/jegoDR";
     		 var pro_name ="pro_name="+data;  
     		 
     		$.ajax({
     			type:"post"
     			,url:url	
     			,data:pro_name
     			,dataType:"json"
     			,success:function(args){ //args는 원하는 이름으로 대체가능
     			  /* alert("가져온 데이터 입니다 . "+args.data.pro_num); */
     				 $(name2).val(args.data.pro_num);
     				 $(name3).val(args.data.pro_container);
     				 $(name4).val(args.data.pro_volume);
			
      			}
      		});
     	 });   
       }
       
       
       
    });
    
  	$('img').mousedown(function() {
  		$(this).css("opacity", 0.5);
  	});
  	
  	$('img').mouseup(function() {
  		$(this).css("opacity", 1);
  	});
  	


  	 $(".jegoDRtable1 #select").change(function(){
  	   if ($(".jegoDRtable1 #select option:selected").val() == "선택"){	 
			var url="<%=cp%>/chowonheeView/ajax/jegoDR";
    		var pro_name ="pro_name="+data;  
    		$.ajax({
    			type:"post"
    			,url:url	
    			,data:pro_name
    			,dataType:"json"
    			,success:function(args){ //args는 원하는 이름으로 대체가능
    			  /* alert("가져온 데이터 입니다 . "+args.data.pro_num); */
    				 $(".jegoDRtable"+1+" #pro_num").val("");
    				 $(".jegoDRtable"+1+" #pro_container").val("");
    				 $(".jegoDRtable"+1+" #pro_volume").val("");
     			}
     		});
	   }
  		 
  		 if ($(".jegoDRtable1 #select option:selected").val() != "선택"){  
 			var data = $(".jegoDRtable1 #select option:selected").val();
 	/* 	  alert(data1); */
 		} 
  	
 		 var url="<%=cp%>/chowonheeView/ajax/jegoDR";
 		 var pro_name ="pro_name="+data;  
 		 
 		$.ajax({
 			type:"post"
 			,url:url	
 			,data:pro_name
 			,dataType:"json"
 			,success:function(args){ //args는 원하는 이름으로 대체가능
 			  /* alert("가져온 데이터 입니다 . "+args.data.pro_num); */
 				 $(".jegoDRtable1 #pro_num").val(args.data.pro_num);
 				 $(".jegoDRtable1 #pro_container").val(args.data.pro_container);
 				 $(".jegoDRtable1 #pro_volume").val(args.data.pro_volume);

  			}
  		});
 	 });   
  	 
  	 
     
  	 
  	 		 
  	$(".jegoDRtable1 #pro_count").change(function(){
  		var total1 = 0;
  		total1 = parseInt($(".jegoDRtable1 #pro_count").val());
  		
  		var url="<%=cp%>/chowonheeView/ajax/jegoDR1";
		var pro_count ="pro_count="+total1;  
		 
		$.ajax({
			type:"post"
			,url:url	
			,data:pro_count
			,dataType:"json"
			,success:function(args){ //args는 원하는 이름으로 대체가능
			  /* alert("가져온 데이터 입니다 . "+args.data.pro_num); */
				 $("#total").val(args.data);
 			}
 		});
  	});
  		
  	 
  	 
  	 
	 
  	$('img').click(function(){
  	 for(var i=1;i<=$("#table tr:eq(0)").next().attr("class").replace("jegoDRtable","");i++){
  		 
  		var name = ".jegoDRtable"+i+" #pro_count";
  		var name2 = "total"+i;
  		
  		$(name).change(function(){
  			var total = 0;
  			
  			for(var i=1;i<=$("#table tr:eq(0)").next().attr("class").replace("jegoDRtable","");i++){
  			var name = ".jegoDRtable"+i+" #pro_count";	
  			total+=parseInt($(name).val());
  			
  			}
  			
  			var url="<%=cp%>/chowonheeView/ajax/jegoDR1";
  			var pro_count ="pro_count="+total;  
  			 
  			$.ajax({
  				type:"post"
  				,url:url	
  				,data:pro_count
  				,dataType:"json"
  				,success:function(args){ //args는 원하는 이름으로 대체가능
  				  /* alert("가져온 데이터 입니다 . "+args.data.pro_num); */
  					 $("#total").val(args.data);
  	 			}
  	 		});
  			
  		
  		});
  		
  	 }
  	});
    

  	
});
</script>
<script>
	function check(){
  		for(var i=1;i<=$("#table tr:eq(0)").next().attr("class").replace("jegoDRtable","");i++){
  			var name = ".jegoDRtable"+i+" #select option:selected";
  			var name2 = ".jegoDRtable"+i+" #select";
  			/* alert($(name).val()); */
  			if ($(name).val() == "선택"){
  				alert(i+"번 제품명을 선택하지 않았습니다.");
  				$(name2).focus();
  				return false;
  			}
  			if($("#select1 option:selected").val() == "선택"){
  				alert("출고장소를 선택하지 않았습니다.");
  				$("#select1").focus();
  				return false;
  			}
  			var name3=".jegoDRtable"+i+" #pro_count";
  			if($(name3).val() == 0){
  				alert(i+"번 수량을 입력하지 않았습니다.");
  				$(name3).focus();
  				return false;
  			}
  			var name3=".jegoDRtable"+i+" select";
  			for(var j=1;j<=$("#table tr:eq(0)").next().attr("class").replace("jegoDRtable","");j++){
  				var name4=".jegoDRtable"+j+" select";
  				
   				 if(i!=j){
  					if($(name3).val()==$(name4).val()){
  						alert(j+"번 제품명이 중복됩니다.");
  						$(name4).focus();
  						return false;
  					}
  				} 
  			}
  			
  			
  			
  		}
  	}
</script>
<script>
function checkNull() {
    var x = document.getElementsByClassName("pro_remark");
 /*    alert("안녕");
    alert(x.length); */
    for(var i=0;i<x.length;i++){
    	if(x[i].value == ""){
    	x[i].value = "없음";
    	}
    }
}
function checkNull2() {
	var x = document.getElementById("comment");
	if(x.value == ""){
    	x.value = "없음";
    	}
}
</script>
<style>
		div.container.content_body {
    position: relative;
    width: 800px;
}

	header.content-header-wrapper{
	position: relative;
	left:50px;
	}
</style>
<title>창 고 입 고</title>
<link href="../chocss/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br/>
<form method="post" name="jegoDR" action="jegoDRPro" onsubmit="return check()">
<table id="table" name="table" border="1" cellpadding="0" cellspacing="0" align="center" border="1" class="table-striped">
    <tr bgcolor="${value_c}">
      <td align="center"  width="50"  >No</td>
      <td align="center"  width="100" >제품번호</td>
      <td align="center"  width="100" >제품명</td>
      <td align="center"  width="100" >용 기</td>
      <td align="center"  width="100" >용량(ml)</td>
      <td align="center"  width="100" >수량(EA)</td>
      <td align="center"  width="100" >비고</td>
      <td align="center"  width="50" ></td>
    </tr>

   <tr class="jegoDRtable1">    
    <td align="center"  width="50" >
  <input type="text"  style="text-align:center;" id="number" class="btn btn-default" name="number" value="1" readonly/>
	</td>
	<td align="center" width="100" ><input type="text" style="text-align:center; width:100px;" id="pro_num" class="btn btn-default" name="pro_num" value="${product.pro_num}" readonly/></td>
	<td align="center"  width="100">
	<select id="select" style="width:100px;" name="pro_name" id="pro_name" class="form-control input-sm">
	<option>선택</option>
	<c:forEach var="article" items="${articleList}" varStatus="status">
	<option value="${article.pro_name}">${article.pro_name}</option>
	</c:forEach>
	</select> 
	</td>
	
	
	<td align="center"  width="100" name="pro_container"><input type="text" style="text-align:center; width:100px;" class="btn btn-default" id="pro_container" name="pro_container" value="${product.pro_container}" readonly/></td>
    <td align="center"  width="100" name="pro_volume" ><input type="text" style="text-align:center; width:100px;" class="btn btn-default" id="pro_volume" name="pro_volume" value="${product.pro_volume}" readonly/></td>
    <td align="center" width="100" name="pro_count"><input type="number" style="text-align:right; width:100px;" class="btn btn-default" id="pro_count" name="pro_count" value="0" min="0"/></td>
	<td align="center" width="100" name="pro_remark"><input type="text" style="text-align:right; width:100px;" id="pro_remark" name="pro_remark" class="pro_remark btn btn-default" value="없음" onfocus="this.value=''" onfocusout="checkNull()"/></td>
    <td align="center"  width="50" />
  </tr>

	

   <tr class="plus">
    <td align="center"  width="50" ></td>
	<td align="center" width="100" ></td>
	<td align="center"  width="100"></td>
	<td align="center"  width="100"></td>
    <td align="center"  width="100"></td>
    <td align="center" width="100" ></td>
    <td align="center" width="100" ></td>
    <td align="center"  width="50" ><img src="../choimg/plus.PNG" id="img" alt="plusimage" width="19"></td>
  </tr>

  <tr>
  <td  width="150"  colspan="2" align="center">합 계</td>
  <td align="center"  width="300" colspan="3"></td>
  <td align="center" width="100"><input type="text" style="text-align:center; width:100px;" class="btn btn-default" id="total" name="total" value="0" readonly/></td>
  <td align="center" width="100" ></td>
  <td align="center"  width="50" />
  </tr>
    
  <tr>
  <td  width="150" align="center" colspan="2">출고장소</td>
        <td align="center" width="150" name="inout_sender" colspan="4">
  	    <select id="select1" style="width:400px;" name="fac_name" class="form-control input-sm">
		<option>선택</option>
		<c:forEach var="chango" items="${changoList}" varStatus="status">
		<option value="${chango.fac_name}">${chango.fac_name}</option>
		</c:forEach>
		</select> 
   	</td>
  <td align="center" width="100"></td>
  <td align="center" width="50" ></td>
  </tr>  
    
  <tr>
  <td width="50" height="100" align="center">비 고</td>
  <td colspan="7"><textarea id="comment" class="btn btn-default" name="comment" rows="7" cols="100" onfocus="this.value=''" value="없음" onfocusout="checkNull2()">없음</textarea></td>
  </tr>

</table>
<center>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;
<input type="submit" value="등록하기" class="btn btn-default">
<input type="reset" value="취소하기" class="btn btn-default" onclick="document.location.href='jegoDR'">   
<input type="button" value="뒤로가기" class="btn btn-default" onclick="document.location.href='changgoIGList'">
</center>  
</form>
</body>
</html>