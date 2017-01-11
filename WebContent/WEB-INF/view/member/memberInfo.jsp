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
 <style>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:100px;}
</style>

<body>
	<form>
		<div class="container" style='position: relative; width: 900px;'>


			<ul class="nav nav-tabs store_list">
				<c:forEach var="list" items="${showList}">
					<li><a data-toggle="tab" href="#${list.st_id}">${list.st_name}</a></li>
				</c:forEach>
			</ul>





			<div class="tab-content store_tab">

				<c:forEach var="list" items="${showList}">

					<div id="${list.st_id}" class="tab-pane fade" style="width: 950px;">
						<div style='width: 400px;' class="col-sm-3">
							<table width="400" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="400" align="center"><img
										src='/Marsher/images/${list.st_image}' width='400'
										height='300'></td>
								<tr>
							</table>
						</div>
						<div style='width: 550px;' class="col-sm-8">
							<table width="550">
								<tr height="10">
								</tr>

								<tr width="550" height="10">
									<h2 align="center">Marsher - ${list.st_name}</h2>
								</tr>

								<tr>
									<td width="100" align="center" height="100"><img
										src='/Marsher/images/info_icon.png'></td>
									<td width="450" height="100"><br> ${list.st_tel}<br>
										<br> <br> ${list.st_location} 　<input type="button"
										class="btn btn-info btn-xs" value="지도보기" onClick="#"
										data-toggle="modal" data-target="#${list.st_id}_modal">
										<br> <br> <br> <br> <br> <br> <br></td>
								</tr>

							</table>
						</div>

					</div>
				</c:forEach>

				<!-- Modal -->
				<c:forEach var="list" items="${showList}">
					<div id="${list.st_id}_modal" class="modal fade" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">상세위치</h4>
								</div>
								<div class="modal-body text-center"
									style='position: relative; width: 500px; height: 450px'>
									<div class="row">
										<div class="map_wrap">
											<div class="col-sm-5" id="map_${list.st_id}"
												style="width: 120%; height: 400%; position: relative; overflow: hidden;"></div>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">닫기</button>
								</div>
							</div>
						</div>

					</div>
			</div>
			<!-- //Modal -->
			</c:forEach>
		</div>
	


	</form>
</body>
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=c5ff64021ed9a7304443cc9800c1442d&libraries=services"></script>
<c:forEach var="list" items="${showList}"> 
<script>
$('#${list.st_id}_modal').on('shown.bs.modal', function() { 
var mapContainer_${list.st_id} = document.getElementById('map_${list.st_id}'), // 지도를 표시할 div 
    mapOption_${list.st_id} = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map_${list.st_id} = new daum.maps.Map(mapContainer_${list.st_id}, mapOption_${list.st_id}); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder_${list.st_id} = new daum.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder_${list.st_id}.addr2coord('${list.st_location}', function(status, result) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords_${list.st_id} = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker_${list.st_id} = new daum.maps.Marker({
            map: map_${list.st_id},
            position: coords_${list.st_id}
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow_${list.st_id} = new daum.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;"> ${list.st_name}</div>'
        });
        infowindow_${list.st_id}.open(map_${list.st_id}, marker_${list.st_id});

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map_${list.st_id}.setCenter(coords_${list.st_id});
    } 
});  
}); 

</script>
</c:forEach>
<script>
$(document).ready(function(){
	var st_id = '${st_id}';
	var index = parseInt(st_id.substring(st_id.length-1)) -1;

	$(".nav-tabs>li").eq(index).addClass("active");
	$(".tab-content>div").eq(index).addClass("in active");
	
	var main_nav = $(".main_nav>li").eq(4);
	main_nav.addClass("on");
	main_nav.find(".sub_nav>li").eq(0).addClass("on");
	$(".aside-wrapper>.list-group>.list-group-item").eq(0).addClass("on");
	
})

</script>
</html>