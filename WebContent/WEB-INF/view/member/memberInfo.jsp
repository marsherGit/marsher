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

<table width="800" border="0" cellspacing="0" cellpadding="0" align="center"> 
  <tr>
    <td align="center" width="400" align="center"><img src='/Marsher/images/${member.st_image}' width='400' height='300'></td>
    <td align="center" width="400" align="center"><h2>Marsher - ${member.st_name}</h2><br><br>
  ☎ ${member.st_tel}<br>
 ☞  ${member.st_location}</td>
   </tr>
  </table>

</form>   
</body>
</html>