<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ page isELIgnored="false"%>

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
		var main_nav = $(".main_nav>li").eq(2);
		main_nav.addClass("on");
		main_nav.find(".sub_nav>li").eq(2).addClass("on");
		$(".aside-wrapper>.list-group>.list-group-item").eq(2).addClass("on");

	})
	
	$(function() {
        $('#btn-add-row').click(function() {
        	var row = $('#my-tbody tr');
        	var itemTag = "";
        	itemTag += '<tr><td class="no"></td>';
        	itemTag += '<td class="pro_num"></td>';
        	itemTag += '<td><select name="pro_name" class="form-control input-sm pro_name">';
        	itemTag += '<option value="">제품선택</option>';
        	itemTag += '<c:forEach var="pro" items="${products}">';
        	itemTag += '<option value="${ pro.pro_num }" <c:if test="${ pro.pro_num eq productSelect }">selected</c:if>>${ pro.pro_name }</option>';
        	itemTag += '</c:forEach>';
        	itemTag += '</select></td>';
        	itemTag += '<td class="pro_container"></td>';
        	itemTag += '<td class="pro_volume"></td>';
        	itemTag += '<td><input type="text" class="form-control input-sm text-right pro_count" name="pro_count" value="0"></td>';
        	itemTag += '<td></td></tr>';
            
        	$('#mytable > tbody:last').append(itemTag);
        	
        	var i=1;
        	$('#my-tbody tr').each(function(){
        		$(this).find(".no").text(i++);
        	});
        });
        
        var container_list = new Array();
	    	<c:forEach var="pro" items="${products}">
	    		container_list.push("${pro.pro_container}");
	    	</c:forEach>
	    	var volume_list = new Array();
	    	<c:forEach var="pro" items="${products}">
    			volume_list.push("${pro.pro_volume}");
    		</c:forEach>
	    	
        $(document).on("change",".pro_name",function(){
        	var pro_name =  $(this).val();
        	var pro_index = -1;
        	$(this).find("option").each(function(){
        		if($(this).val() == pro_name) pro_index = $(this).index() - 1;
        	});
        	
        	var pro_container = "";
        	if(pro_index >= 0) pro_container = container_list[pro_index];
        	var pro_volume = "";
        	if(pro_index >= 0) pro_volume = volume_list[pro_index];
        	
        	var tdTag = $(this).parents("td").siblings();
        	tdTag.filter(".pro_num").text(pro_name);
        	tdTag.filter(".pro_container").text(pro_container);
        	tdTag.filter(".pro_volume").text(pro_volume);
        });
        
        $(document).on("keyup",".pro_count",function(){
        	var o_count = 0;
        	$(".pro_count").each(function(){
        		console.log($(this).val());
        		o_count += parseInt($(this).val());
        	});
        	$(".o_count").val(o_count);
        });
        
        $(document).on("change",".pro_count",function(){
        	var o_count = 0;
        	$(".pro_count").each(function(){
        		console.log($(this).val());
        		o_count += parseInt($(this).val());
        	});
        	$(".o_count").val(o_count);
        });
        
    });
	
	 function delete_row() {
	   var my_tbody = document.getElementById('my-tbody');
	   if (my_tbody.rows.length < 2) return;
	   // my_tbody.deleteRow(0); // 상단부터 삭제
	   my_tbody.deleteRow( my_tbody.rows.length-1 ); // 하단부터 삭제
	 }
	 
	 function checkIt() {
		 var check = true;
		$(".pro_name").each(function(){
			if ($(this).val() == "") {
				check = false;
				console.log(check);
				alert("품목명을 선택 해 주세요.");
				$(this).focus();
				return false;
			}
		});
		
		if(check){
			$(".pro_count").each(function(){
				if ($(this).val() = 0) {
					check = false;
					alert("수량은 1개 이상 입력해 주세요");
					$(this).focus();
					return false;
				} else if(!$(this).val() || $(this).val() < 0) {
					check = false;
					alert("수량은 1개 이상 입력해 주세요");
					return false;
				}
			});
		}
		
		if(check){
			if (!confirm("발주서를 등록하시겠습니까?")) {
				return false;
			} else {
				return true;
		 	}
		}else {
			return false;
		}
	 }

</script>

<div class="orderWrite_form">
	<form name="orderWriteForm" method="post" action="<c:url value="/order/orderWritePro" />" onsubmit="return checkIt();">
		<input type="hidden" name="o_sender" value="${memId}">
		
		<table id="mytable" class="table table-striped table-bordered text-center delivery_table row">
			<thead>
				<tr role="row">
					<th width="5%" class="text-center">NO</th>
					<th width="15%" class="text-center">제품번호</th>
					<th width="30%" class="text-center">제품명</th>
					<th width="15%" class="text-center">패키지타입</th>
					<th width="12%" class="text-center">용량(mL)</th>
					<th width="12%" class="text-center">수량(EA)</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="my-tbody">
				<tr class="orderingPro" role="row">
					<td class="no">1</td>
					<td class="pro_num"></td>
					<td>
						<select name="pro_name" class="form-control input-sm pro_name">
							<option value="">제품선택</option>
							<c:forEach var="pro" items="${products}">
								<option value="${ pro.pro_num }">${ pro.pro_name }</option>
							</c:forEach>
						</select>
					</td>
					<td class="pro_container"></td>
					<td class="pro_volume"></td>
					<td><input type="text" class="form-control input-sm text-right pro_count" name="pro_count" value="0"></td>
					<td>
						<button id='btn-add-row' type="button" class="btn btn-primary btn-xs">추가</button>
						<button onclick="delete_row()" type="button" class="btn btn-primary btn-xs">삭제</button>
					</td>
				</tr>
			</tbody>
		</table>
				
	<table id="dataTables-example_filter" class="alignRight table table-bordered">
		<tr>
			<td class="text-center">합계</td>
			<td></td>
			<td></td>
			<td><input type="text" class="form-control input-sm text-right o_count" name="o_count" value="0" /></td>
		</tr>
		<tr>
			<th width="20%" class="text-center">납기일</th>
			<td width="30%"><input class="form-control dateFrm marginForm input-sm" type="date" name="o_deadline" value="연도-월-일" id="o_deadline"></td>
			<th width="15%" class="text-center">수신</th>
			<td><input type="text" class="form-control input-sm" name="o_receiver" value="제 1 창고" /></td>
		</tr>
		<tr>
			<th class="text-center">비고</th>
			<td colspan="3"><textarea class="form-control" id="o_note" name="o_note"></textarea></td>
		</tr>
	</table>
	
		
	<br>
		
				
	<div class="row text-center btns">
			<input type="submit" value="등록하기" class="btn btn-primary">
			<input type="button" value="취소하기" class="btn btn-default" onclick="javascript:history.back()">
	</div>
	</form>
</div>