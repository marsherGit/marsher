<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>

<body>
<form>
  <div class="container" style='position:relative; width: 900px; '>
 
  
	  <ul class="nav nav-tabs">
	  <c:forEach var="list" items="${showList}">
	    <li><a data-toggle="tab" href="#${list.st_id}">${list.st_name}</a></li>
	</c:forEach>
	  </ul>
 
 
 
 
 	    
	  <div class="tab-content">
	  
	  <c:forEach var="list" items="${showList}">
	  
	  	<div id="${list.st_id}" class="tab-pane fade" style="width: 950px;">
	  		<div style='width:400px;' class="col-sm-3">
	  		<table width="400" border="0" cellspacing="0" cellpadding="0"> 
				<tr>
				  <td width="400" align="center"><img src='/Marsher/images/${list.st_image}' width='400' height='300'></td>				  
				  <tr>				  
			</table>
			</div>
			<div style='width: 550px;' class="col-sm-8">
				 <table width="550">
				 <tr height="10">　</tr>
				 
				    <tr width="550" height="10"><h2 align="center">Marsher - ${list.st_name}　　　　　</h2></tr>
					 
					 <tr>
					  <td width="100" align="center" height="100"> <img src='/Marsher/images/info_icon.png'></td>
						<td width="450" height="100"><br> ${list.st_tel}<br><br><br>
						     ${list.st_location}<br><br><br><br><br><br><br>	</td>			     
	 				</tr>
	 				
				</table>
			</div>
	  	</div>
	  	</c:forEach>
	
	  </div>
	  
	  
	  
  </div>

</form>   
</body>

<script>
$(document).ready(function(){
	$(".nav-tabs>li:first-child").addClass("active");
	$(".tab-content>div:first-child").addClass("in active");
})
</script>
</html>