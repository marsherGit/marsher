<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>발주서 조회</title>
<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link href="../vendor/datatables/css/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="../vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/nanumfont/nanumfont.css" rel="stylesheet"
	type="text/css">

</head>
<body>
	<form:form commandName="order">

		<div id="wrapper">
			<div id="page-wrapper" style="min-height: 562px;">
				<div class="row">
					<div class="col-lg-12">
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div id="dataTables-example_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap no-footer">
								<div class="row">
									<div class="col-sm-6">

										<div>
											<button type="button" class="btn btn-default">PDF 출력</button>
											<button type="button" class="btn btn-default">목록보기</button>
										</div>



										<div class="o_sender" id="o_sender">
											<label>수신: </label> <label>제 1 창고</label>
										</div>
										<div class="o_receiver" id="o_receiver">
											<label>발신: </label> <label>Marsher-강남점</label>
										</div>
										<div class="o_title" id="o_title">
											<label>제목: </label> <label>MS콜라 외 2개 발주서</label>
										</div>


									</div>
									<div class="col-sm-6">
										<table id="dataTables-example_filter"
											class="table table-bordered">
											<thead>
												<tr>
													<th>담당자</th>
													<th>관리자</th>
													<th>사 장</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td><img src="../images/signature.gif" width="40"
														height="40" /></td>
													<td><button type="button"
															class="btn btn-primary btn-xs">check</button></td>
													<td></td>
												</tr>
											</tbody>
										</table>

										<div class="o_num" id="o_num">
											<label>발주번호: </label> <label>16121001</label>
										</div>

										<div class="o_deadline" id="o_deadline">
											<label>납기일: </label> <label>2016-12-14</label>
										</div>
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
												</tr>
											</thead>
											<tbody>

												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												
												<tr class="order" role="row">
													<td >1</td>
													<td class="pro_num">A01a</td>
													<td class="pro_name">MS콜라</td>
													<td class="pro_container">알루미늄캔</td>
													<td class="pro_volume">200mL</td>
													<td class="pro_count">200</td>

												</tr>
												
												<tr class="order" role="row">
													<td>합계</td>
													<td></td>
													<td></td>
													<td></td>
													<td class="o_total">1000</td>
												</tr>
												
												<tr class="order" role="textarea">
													<td>비고</td>
													<td class="o_note" colspan="4">위와 같이 발주하오니 납기일 내에 납품하여 주시기 바랍니다.</td>
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
		<script src="../vendor/jquery/jquery.min.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

		<!-- Metis Menu Plugin JavaScript -->
		<script src="../vendor/metisMenu/metisMenu.min.js"></script>

		<!-- DataTables JavaScript -->
		<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
		<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="../vendor/dataTables-responsive/dataTables.responsive.js"></script>

		<!-- Custom Theme JavaScript -->
		<script src="../js/sb-admin-2.js"></script>

		<script>
			$(document).ready(function() {
				$('#dataTables-example').DataTable({
					responsive : true
				});
			});
		</script>

	</form:form>

</body>
</html>