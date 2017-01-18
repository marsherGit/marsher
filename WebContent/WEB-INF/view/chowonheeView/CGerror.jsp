<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
 /*    var pro_num = document.getElementById("notPro_num"); */
    
    
    var length=$("#notPro_numLength").val();
    
    var message ="해당제품이 입력한 개수 만큼 창고에 입고되지 않았습니다.\n";
 
  /*   var proname = document.getElementsByName("pro_name");
    */
      for(var i=0;i<document.getElementById("pro_name").options.length;i++){
    	message += document.getElementById("pro_name").options[i].value+", ";
	}	 
    /* var x = document.getElementById("pro_name").options.length; */
/*   var x = document.getElementById("pro_name").options[0].value;
    alert(x) */
      
     alert(message.slice(0,-2)); 
	 
});
</script>
</head>
<body>
	<select id="pro_name" style="display:none">
	<c:forEach var="notPro_num" items="${notPro_num}" varStatus="status">
	<option value="${notPro_num}" id="notPro_num" class="notPro_num" name="notPro_num"></option>
	</c:forEach>
	</select>
</body>
</html>

<meta http-equiv="Refresh" content="0;url=CGjegoDR" >


