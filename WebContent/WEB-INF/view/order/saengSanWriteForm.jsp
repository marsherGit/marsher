<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page isELIgnored="false"%>
<html>
<head>

<title>발주서 작성</title>
<style>
.orderWrite_form {
	padding: 0 3em;
}

.delivery_table {
	margin-top: 1em;
}
</style>
<script>
	$(document).ready(function() {
		/* main,sub menu 활성화 */
		var main_nav = $(".main_nav>li").eq(0);
		main_nav.addClass("on");
		main_nav.find(".sub_nav>li").eq(0).addClass("on");
		$(".aside-wrapper>.list-group>.list-group-item").eq(0).addClass("on");

	})
	
	$(function() {
        $('#btn-add-row').click(function() {
            $('#mytable > tbody:last').append('<tr><td></td>'
            		+'<td><select class="form-control" name="pro_name"id="pro_name"><option disabled="" selected="">제품 선택</option><option value="탄산">탄산</option><option value="주류">주류</option><option value="쥬스">쥬스</option><option value="우유">우유</option></select></td>'
            		+'<td><select class="form-control" name="pro_container"id="pro_container"><option disabled="" selected="">용기 선택</option><option value="알루미늄캔">알루미늄캔</option><option value="페트병">페트병</option><option value="유리병">유리병</option><option value="우유팩">우유팩</option></select></td>'
					+'<td><input type="text" class="form-control"name="pro_volume" id="pro_volume" style="width: 80px"></td>'
            		+'<td><input type="text" class="form-control" name="o_count" id="o_count" style="width: 80px"></td>'
            		+'<td></td></tr>' );
        });
        $('#btn-delete-row').click(function() {
            $('#mytable > tr ').remove(all);
        });
    });
	

</script>


</head>

<body>
<div class="orderWrite_form">
		<form name="orderWriteForm" method="post" action="<c:url value="/order/orderWritePro" />">
<div class="col-sm-6">
			<input type="hidden" name="o_title" value="">
			<input type="hidden" name="o_sender" value="">
			<input type="hidden" name="deliveryState" value="">
				<table id="dataTables-example_filter" class="alignRight table table-bordered">
					<thead>
						<tr>
							<th width="130" align="center">담당자 서명</th>
							<th width="130" align="center">납기일</th>
							
						</tr>
						
					</thead>
					<tbody>
						<tr>
							<td><input type="file" id="senderSign" name="senderSign"></td>
							<td><input
								class="form-control dateFrm marginForm" type="date"
								name="o_deadline" value="연도-월-일" id="o_deadline"></td>
						</tr>
					</tbody>
				</table>
				</div>
<br>
	
				
				<table id=mytable class="table table-striped table-bordered text-center delivery_table row">
					<thead>
						<tr role="row">
							<th style="width: 50px;" align="center">NO</th>
							<th width="130" align="center">제품명</th>
							<th width="130" align="center">패키지타입</th>
							<th width="130" align="center">용량(mL)</th>
							<th width="130" align="center">수량(EA)</th>
							<th></th>
						</tr>
					</thead>
					<tbody>

						<tr class="orderingPro" role="row">
							<td></td>
							<td><select class="form-control" name="pro_name"
								id="pro_name">
									<option disabled="" selected="">제품 선택</option>
									<option value="탄산">탄산</option>
									<option value="주류">주류</option>
									<option value="쥬스">쥬스</option>
									<option value="우유">우유</option>
							</select></td>
							<td><select class="form-control" name="pro_container"
								id="pro_container">
									<option disabled="" selected="">용기 선택</option>
									<option value="알루미늄캔">알루미늄캔</option>
									<option value="페트병">페트병</option>
									<option value="유리병">유리병</option>
									<option value="우유팩">우유팩</option>
							</select></td>
							<td><input type="text" class="form-control"
								name="pro_volume" id="pro_volume" style="width: 80px"></td>
							<td><input type="text" class="form-control" name="o_count"
								id="o_count" style="width: 80px"></td>
							<td><button id='btn-add-row' type="button"
									class="btn btn-primary btn-xs">추가</button>
								<button id='btn-delete-row' type="button"
									class="btn btn-primary btn-xs">삭제</button></td>


						</tr>
					</tbody>

				</table>
				
				<table id="dataTables-example_filter" class="alignRight table table-bordered">
					<thead>
						<tr>
							<th width="130" align="center">비고</th>
						</tr>
						
					</thead>
					<tbody>
						<tr>
							<td><textarea class="form-control" id="o_note"
									name="o_note"></textarea></td>
						</tr>
					</tbody>
				</table>
	
		</form>
		<br>
		
				
		<div class="row text-center btns">
				<input type="submit" value="등록하기" class="btn btn-primary"> <input
					type="button" value="취소하기" class="btn btn-default"
					onclick="javascript:history.back()">
			</div>
	</div>
</body>

</html>