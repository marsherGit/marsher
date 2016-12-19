<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>창 고 입 고</title>
<p><center>창 고 입 고</center></p>
<center>(공장에서 생산 된 제품을 창고의 재고로 입력하는 양식페이지 입니다.)</center>
</head>
<body>
<br/>
<table border="1" width="1000" cellpadding="0" cellspacing="0" align="center">
    <tr height="30" bgcolor="${value_c}">
      <td align="center"  width="50"  >No</td>
      <td align="center"  width="100" >제품번호</td>
      <td align="center"  width="250" >제품명</td>
      <td align="center"  width="200" >용 기</td>
      <td align="center"  width="150" >용량(ml)</td>
      <td align="center"  width="150" >수량(EA)</td>
      <td align="center"  width="150" >출고장소</td>
      <td align="center"  width="150" >입고장소</td>
      <td align="center"  width="50" ></td>
    </tr>

<select>
  <option value="volvo">Volvo</option>
  <option value="saab">Saab</option>
  <option value="opel">Opel</option>
  <option value="audi">Audi</option>
</select>
</table>
</body>
</html>