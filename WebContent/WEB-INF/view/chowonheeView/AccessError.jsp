<%-- <%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
     alert("접근 권한이 없습니다."); 	 
/*      history.go(-1);  */
});
</script>
</head>
<body>

</body>
</html>

<meta http-equiv="Refresh" content="0;url=/Marsher/login/main" > --%>

<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>


<c:if test="${memId=='admin'}">
<meta http-equiv="Refresh" content="0;changgoIGList" >
</c:if>
<c:if test="${memId!='admin'}">

<div class="table table-bordered" style="margin:0 auto;align:center; text-align:center; width:530px; height:180px; padding:50px">
<table>
<h5><strong>접근할 수 있는 권한이 없습니다.</strong></h5></br>
<input class="btn btn-info btn-sm" type="button" onclick="javascript:history.go(-1);" value="뒤로가기"> 
</table>
</div>

<!-- <script>
history.go(-1);
</script> -->
<!-- <meta http-equiv="Refresh" content="0;url=javascript:history.go(-1)" > -->
</c:if>


