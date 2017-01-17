<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>


<c:if test="${memId=='admin'}">
<meta http-equiv="Refresh" content="0;/Marsher/product/proRegister" >
</c:if>
<c:if test="${memId!='admin'}">

<div class="table table-bordered" style="margin:0 auto;align:center; text-align:center; width:530px; height:180px; padding:50px">
<table>
<h5><strong>접근할 수 있는 권한이 없습니다.</strong></h5></br>
<input class="btn btn-info btn-sm" type="button" onclick="document.location.href='/Marsher/login/main'" value="뒤로가기"> 
</table>
</div>

<!-- <script>
history.go(-1);
</script> -->
<!-- <meta http-equiv="Refresh" content="0;url=javascript:history.go(-1)" > -->
</c:if>
