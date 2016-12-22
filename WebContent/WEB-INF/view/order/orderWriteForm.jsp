<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>발주서 작성</title>
<!-- Bootstrap Core CSS -->
<link href="/FinalSubin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/FinalSubin/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link href="/FinalSubin/vendor/datatables/css/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="/FinalSubin/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/FinalSubin/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/FinalSubin/vendor/nanumfont/nanumfont.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<form:form commandName="order">

		<div id="wrapper">
			<div id="page-wrapper" style="min-height: 562px;">
				<div class="row">
					<div class="col-lg-12 text-center">
						<h1 class="page-header">발주서 등록</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div id="dataTables-example_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap no-footer">
								<div class="row">
									<div class="col-sm-6">
									<form method="post" enctype="multipart/form-data" action="imgup.jsp">
										<table id="dataTables-example_filter" class="table table-bordered">
											<thead>
												<tr><th style="width: 80px;">담당자 서명</th></tr>
											</thead>
											<tbody>
												<tr><td><input type="file" id="senderSign"></td></tr>
											</tbody>
										</table>
										</form>
									</div>

								</div>
								<div class="row">
									<div class="col-sm-12">
										<table width="100%"
											class="table table-striped table-bordered table-hover dataTable no-footer dtr-inline"
											id="dataTables-example" role="grid"
											aria-describedby="dataTables-example_info"
											style="width: 100%;">
											<thead>
												<tr role="row">
													<th style="width: 50px;">NO</th>
													<th style="width: 150px;">제품번호</th>
													<th style="width: 150px;">제품명</th>
													<th style="width: 150px;">패키지타입</th>
													<th style="width: 100px;">용량</th>
													<th style="width: 100px;">수량(EA)</th>
													<th style="width: 100px;"></th>
												</tr>
											</thead>
											<tbody>

												<tr class="order" role="row">
													<td id="template">1</td>
													<td class="pro_num">A01a</td>
													<td><select class="pro_name"><option>MS콜라</option>
													<option>MS사이다</option><option>MS오렌지</option><option>MS소주</option>
													</select></td>
													<td><select class="pro_container"><option>MS콜라</option>
													<option>MS사이다</option><option>MS오렌지</option><option>MS소주</option></select></td>
													<td><select class="pro_volume"><option>MS콜라</option>
													<option>MS사이다</option><option>MS오렌지</option><option>MS소주</option></select></td>
													<td><input type="text" class="pro_count" style="width:80px"></td>
													<td><button id='btn-add-row' type="button" class="btn btn-primary btn-xs">추가</button>
													<button id='btn-delete-row' type="button" class="btn btn-primary btn-xs">삭제</button></td>


												</tr>
												

												<tr class="order" role="row">
													<td colspan="2">합계</td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td class="o_total">1000</td>
												</tr>
												
												<tr class="order" role="textarea">
													<td>비고</td>
													<td colspan="5"><textarea class="o_note" style="width:800px"></textarea></td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<!-- /#wrapper -->

		<!-- jQuery -->
		<script src="/FinalSubin/vendor/jquery/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="/FinalSubin/vendor/bootstrap/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="/FinalSubin/vendor/metisMenu/metisMenu.min.js"></script>

		<!-- DataTables JavaScript -->
		<script src="/FinalSubin/vendor/datatables/js/jquery.dataTables.min.js"></script>
		<script src="/FinalSubin/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="/FinalSubin/vendor/dataTables-responsive/dataTables.responsive.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="/FinalSubin/js/sb-admin-2.js"></script>

		<script>
			$(document).ready(function() {
				$('#dataTables-example').DataTable({
					responsive : true
				});
			});
		</script>
		
<script>
    $(function() {
        $('#btn-add-row').click(function() {
            var time = new Date().toLocaleTimeString();
            $('#"dataTables-example" > tbody:last').append('<tr><td>1</td><td>' + time + '</td></tr>');
        });
        $('#btn-delete-row').click(function() {
            $('#"dataTables-example" > tr ').remove(all);
        });
    });

</script>
		

	</form:form>

</body>
</html>