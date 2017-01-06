<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<title>Insert title here</title>
</head>
  <style>
.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
.map_wrap {position:relative;width:100%;height:100px;}
#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:200px;height:280px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
.bg_white {background:#fff;}
#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
#menu_wrap .option{text-align: center;}
#menu_wrap .option p {margin:10px 0;}  
#menu_wrap .option button {margin-left:5px;}
#placesList li {list-style: none;}
#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
#placesList .item span {display: block;margin-top:4px;}
#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
#placesList .item .info{padding:10px 0 10px 55px;}
#placesList .info .gray {color:#8a8a8a;}
#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
#placesList .info .tel {color:#009900;}
#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
#placesList .item .marker_1 {background-position: 0 -10px;}
#placesList .item .marker_2 {background-position: 0 -56px;}
#placesList .item .marker_3 {background-position: 0 -102px}
#placesList .item .marker_4 {background-position: 0 -148px;}
#placesList .item .marker_5 {background-position: 0 -194px;}
#placesList .item .marker_6 {background-position: 0 -240px;}
#placesList .item .marker_7 {background-position: 0 -286px;}
#placesList .item .marker_8 {background-position: 0 -332px;}
#placesList .item .marker_9 {background-position: 0 -378px;}
#placesList .item .marker_10 {background-position: 0 -423px;}
#placesList .item .marker_11 {background-position: 0 -470px;}
#placesList .item .marker_12 {background-position: 0 -516px;}
#placesList .item .marker_13 {background-position: 0 -562px;}
#placesList .item .marker_14 {background-position: 0 -608px;}
#placesList .item .marker_15 {background-position: 0 -654px;}
#pagination {margin:10px auto;text-align: center;}
#pagination a {display:inline-block;margin-right:10px;}
#pagination .on {font-weight: bold; cursor: default;color:#777;}


#st_image {width:300px; margin-top:0.5em;}
#view_area {position:relative; width: 350px; height: 300px; color: black; border: 0px solid black;}
#registerForm .list-group {list-style:none; padding-top:20px;}
#registerForm .list-group>li {margin:1em 0;}
.btns {padding:10%;}
.btns>input {width:6em;}
.guide {font-size:0.8em;}
.nopadding {padding:0; padding-right:1em;}
.padding3em {padding-right:3em;}
</style>

<script>
	function checkIt() {

		var fname = document.getElementById("st_image").value;
		// 파일의 풀 경로를 fname에 변수에 저장 
		var fext = fname.substr(fname.length - 3).toLowerCase();
		// 파일의 풀 경로에서 끝에서 3번째까지의 글자를 잘라 소문자로 변경 후 변수에 저장

		var fname2 = document.getElementById("sign_img").value;
		// 파일의 풀 경로를 fname2에 변수에 저장 
		var fext2 = fname2.substr(fname2.length - 3).toLowerCase();
		// 파일의 풀 경로에서 끝에서 3번째까지의 글자를 잘라 소문자로 변경 후 변수에 저장

		if (document.getElementById('st_id').value == '') {
			alert("매장 아이디를 입력해 주세요");
			return false;
		}
		if (document.getElementById('st_name').value == '') {
			alert("매장명을 입력해 주세요");
			return false;
		}
		if (document.getElementById('st_image').value == '') {
			alert("매장 이미지를 선택해 주세요");
			return false;
		}
		if (document.getElementById('passwd').value == '') {
			alert("비밀번호를 입력해 주세요");
			return false;
		}
		if (document.getElementById('passwd2').value == '') {
			alert("비밀번호 확인을 입력해 주세요");
			return false;
		}
		if (document.getElementById('passwd').value != document
				.getElementById('passwd2').value) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return false;
		}

		if (fext != 'jpg' && fext != 'png' && fext != 'jpeg') {
			alert("매장 이미지의 확장자를 확인해 주세요.");
			return false;
		}

		if (fext2 != 'jpg' && fext2 != 'png' && fext2 != 'jpeg') {
			alert("사인 이미지의 확장자를 확인해 주세요.");
			return false;
		}

		else if (!confirm("매장을 등록하시겠습니까?")) {
			return false;
		} else
			return true;
	}

	function checkfile() {
		var fname = document.getElementById("st_image").value;
		// 파일의 풀 경로를 fname에 변수에 저장 
		var fext = fname.substr(fname.length - 3).toLowerCase();
		// 파일의 풀 경로에서 끝에서 3번째까지의 글자를 잘라 소문자로 변경 후 변수에 저장
		if (fext != 'jpg' && fext != 'png' && fext != 'jpeg') {
			alert("이미지는 jpg, png, jpeg만 업로드 가능합니다.");
			return false;
		}
		return true;
	}

	function checkfile2() {
		var fname2 = document.getElementById("sign_img").value;
		// 파일의 풀 경로를 fname2에 변수에 저장 
		var fext2 = fname2.substr(fname2.length - 3).toLowerCase();
		// 파일의 풀 경로에서 끝에서 3번째까지의 글자를 잘라 소문자로 변경 후 변수에 저장
		if (fext2 != 'jpg' && fext2 != 'png' && fext2 != 'jpeg') {
			alert("이미지는 jpg, png, jpeg만 업로드 가능합니다.");
			return false;
		}
		return true;
	}
</script>
<script>
	$(document)
			.ready(
					function() {
						var fileTarget = $('.filebox .upload-hidden');

						fileTarget.on('change', function() {
							if (window.FileReader) {
								// 파일명 추출
								var filename = $(this)[0].files[0].name;
							}

							else {
								// Old IE 파일명 추출
								var filename = $(this).val().split('/').pop()
										.split('\\').pop();
							}
							;

							$(this).siblings('.upload-name').val(filename);
						});

						//preview image 
						var imgTarget = $('.preview-image .upload-hidden');

						imgTarget
								.on(
										'change',
										function() {
											var parent = $(this).parent();
											parent.children('.upload-display')
													.remove();

											if (window.FileReader) {
												//image 파일만
												if (!$(this)[0].files[0].type
														.match(/image\//))
													return;

												var reader = new FileReader();
												reader.onload = function(e) {
													var src = e.target.result;
													parent
															.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
												}
												reader
														.readAsDataURL($(this)[0].files[0]);
											}

											else {
												$(this)[0].select();
												$(this)[0].blur();
												var imgSrc = document.selection
														.createRange().text;
												parent
														.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

												var img = $(this).siblings(
														'.upload-display')
														.find('img');
												img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\""
														+ imgSrc + "\")";
											}
										});
					});
</script>




<script language="javascript">
	function previewImage(targetObj, View_area) {
		var preview = document.getElementById(View_area); //div id
		var ua = window.navigator.userAgent;

		//ie일때(IE8 이하에서만 작동)
		if (ua.indexOf("MSIE") > -1) {
			targetObj.select();
			try {
				var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
				var ie_preview_error = document
						.getElementById("ie_preview_error_" + View_area);

				if (ie_preview_error) {
					preview.removeChild(ie_preview_error); //error가 있으면 delete
				}

				var img = document.getElementById(View_area); //이미지가 뿌려질 곳

				//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
				img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"
						+ src + "', sizingMethod='scale')";
			} catch (e) {
				if (!document.getElementById("ie_preview_error_" + View_area)) {
					var info = document.createElement("<p>");
					info.id = "ie_preview_error_" + View_area;
					info.innerHTML = e.name;
					preview.insertBefore(info, null);
				}
			}
			//ie가 아닐때(크롬, 사파리, FF)
		} else {
			var files = targetObj.files;
			for (var i = 0; i < files.length; i++) {
				var file = files[i];
				var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
				if (!file.type.match(imageType))
					continue;
				var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
				if (prevImg) {
					preview.removeChild(prevImg);
				}
				var img = document.createElement("img");
				img.id = "prev_" + View_area;
				img.classList.add("obj");
				img.file = file;
				img.style.width = '300px';

				preview.appendChild(img);
				if (window.FileReader) { // FireFox, Chrome, Opera 확인.
					var reader = new FileReader();
					reader.onload = function(e) {
						$('#UploadedImg').attr('src', e.target.result);
					}

					reader.readAsDataURL(file);
				} else { // safari is not supported FileReader
					//alert('not supported FileReader');
					if (!document.getElementById("sfr_preview_error_"
							+ View_area)) {
						var info = document.createElement("p");
						info.id = "sfr_preview_error_" + View_area;
						info.innerHTML = "not supported FileReader";
						preview.insertBefore(info, null);
					}
				}

			}
		}
	}

	
</script>

<div class="container text-left row" style='position:relative; width: 900px;'>
	<form method="post" id="registerForm" name="registerForm" action="registerPro.do"
		onsubmit="return checkIt()">
		<div class="col-sm-5" id='View_area' class="form-group">
			<label for="st_image">사진이미지 업로드</label> <img id="UploadedImg"
				src="<c:url value="/images/no-img.png" />" border="0"
				width="300" height="250" onclick="fncProductFile()"> <input
				type="file" id="st_image" name="st_image"
				onchange="previewImage(this,'View_area'),checkfile()"
				class="form-control">
		</div>
		<div class="col-sm-7">
			<ul class="list-group row">
				<li class="form-group row"><label for="st_id"
					class="control-label col-sm-3">매장아이디</label>
				<div class="col-sm-9">
						<input id="st_id" name="st_id" class="form-control" />
					</div></li>
				<li class="form-group row"><label for="passwd"
					class="control-label col-sm-3">비밀번호</label>
				<div class="col-sm-9">
						<input type="password" id="passwd" name="passwd" class="form-control" />
					</div></li>
				<li class="form-group row"><label for="passwd2"
					class="control-label col-sm-3">비밀번호 확인</label>
				<div class="col-sm-9">
						<input type="password" id="passwd2" name="passwd2" class="form-control" />
					</div></li>
				<li class="form-group row"><label for="st_name"
					class="control-label col-sm-3">매장명</label>
				<div class="col-sm-9">
						<input id="st_name" name="st_name" class="form-control" />
					</div></li>
				<li class="form-group row"><label for="st_tel"
					class="control-label col-sm-3">연락처</label>
				<div class="col-sm-9">
						<input id="st_tel" name="st_tel" class="form-control" />
					</div></li>
				<li class="form-group row"><label for="st_location"
					class="control-label col-sm-3">주소</label>
				<div class="col-sm-9 padding3em">
						<div class="col-sm-10 nopadding"><input id="st_location" name="st_location" class="st_location form-control" placeholder="검색할 주소를 입력하세요"/></div>
						<div class="col-sm-2 nopadding">
						<input type="button" class="btn btn-warning" value="위치검색" onClick="#, searchPlaces(); return false;" data-toggle="modal"
							data-target="#location_modal"></div>
					</div></li>
				<li class="form-group row"><label for="sign_img"
					class="control-label col-sm-3">사인 등록</label>
				<div class="col-sm-9">
						<input type="file" id="sign_img" name="sign_img" onchange="checkfile2()"
							class="form-control" />
					</div></li>
			</ul>
			<div class="row text-center btns">
				<input type="submit" value="등록하기" class="btn btn-info"> <input
					type="button" value="취소" class="btn btn-default"
					onclick="javascript:history.back()">
			</div>
		</div>

	</form>
</div>


	<!-- Modal -->
	<div id="location_modal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">주소검색</h4>
				</div>
				<div class="modal-body text-center" style='position: relative; width: 500px; height:450px'>
				<div class="row">
					<div class="map_wrap">
						<div class="col-sm-5" id="map"
							style="width: 120%; height: 400%; position: relative; overflow: hidden;"></div>
							<div class="col-sm-4" id="menu_wrap" class="bg_white">
							
							<hr>
							<ul id="placesList"></ul>
							<div id="pagination"></div>
						</div>
						
						</div>
						
						
						
					</div>
				</div>
					<div class="modal-footer">
						<button type="button" id="Save" class="btn btn-default"
							onClick="Save()" data-dismiss="modal">등록</button>
						<button type="button" class="btn btn-default"
							data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>		

		</div>
	</div>
	<!-- //Modal -->




<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=c5ff64021ed9a7304443cc9800c1442d&libraries=services"></script>
<script>
$('#location_modal').on('shown.bs.modal', function() {
	// 모달 내 검색버튼을 자바스크립트에서 구현
	/* $('#Search').click(function() {
	searchPlaces();
	return false;
	});  */
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new daum.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new daum.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new daum.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

   var keyword = document.getElementById('st_location').value;

  if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('주소 검색 키워드를 입력해주세요');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(status, data, pagination) {
    if (status === daum.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data.places);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === daum.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === daum.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new daum.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new daum.maps.LatLng(places[i].latitude, places[i].longitude),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i], marker); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title, address) {
            daum.maps.event.addListener(marker, 'mouseover', function() {
                displayInfowindow(marker, title);
            });

            daum.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });

            
       // 목록 클릭 시 선택한 마커를 중심좌표로 이동하고 배경화면 색상 넣기
			itemEl.onclick = function() {
				displayInfowindow(marker, title);					
				map.setCenter(marker.getPosition());
				$('.item').css('background-color','#F3F2F2');
				$(this).css('background-color','#C5E4E6');
				placeTitle = title;
				placeAdr = address;		
				$('#text3').html(title);
			};
			// 확인버튼 클릭 시  주소 가져오기 
			
			
			$('#Save').click(function() {
								    					   
			    $('#st_location').val(placeAdr);
		     	    
			  });
			
			


            
            
        })(marker, places[i].title, places[i].address);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.title + '</h5>';

    if (places.newAddress) {
        itemStr += '    <span>' + places.newAddress + '</span>' +
                    '   <span class="jibun gray">' +  places.address  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new daum.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new daum.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new daum.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new daum.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}
 
});
</script>
<script>
	$(document).ready(function() {

		var main_nav = $(".main_nav>li").eq(4);
		main_nav.addClass("on");
		main_nav.find(".sub_nav>li").eq(3).addClass("on");
		$(".aside-wrapper>.list-group>.list-group-item").eq(3).addClass("on");
		$(".navbar-right>li>a").removeClass("active");
	})
</script>
