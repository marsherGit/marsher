<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<style>
	#fac_file {width:300px; margin-top:0.5em;}
	#View_area {padding-left:5em; padding-top:1em;}
	.list-group {list-style:none; padding-top:50px;}
	.list-group>li {margin:1em 0;}
	.btns {padding:10%;}
	.btns>input {width:6em;}
	.guide {font-size:0.8em;}
</style>
<script>
	function checkIt(){
		if (!$("#fac_name").val()) {
			alert("공장명을 입력해 주세요");
			$("#fac_name").focus();
			return false;
		}
		
		if (!$("#fac_location").val()) {
			alert("공장주소를 입력해 주세요");
			$("#fac_location").focus();
			return false;
		}
		
		if (!$("#fac_tel").val()) {
			alert("연락처를 입력해 주세요");
			$("#fac_tel").focus();
			return false;
		}
		
		if (!$("#fac_product").val()) {
			alert("생산제품을 입력해 주세요");
			$("#fac_product").focus();
			return false;
		}
		
		if(!confirm("공장 정보를 수정하시겠습니까?")) {
			return false;
		} else {
			return true;
		}
	}
</script>
<script>
	/* 서브메뉴 활성화 */
	$(document).ready(function(){
		$(".user_nav>li:eq(0)>a").addClass("active");
		$(".aside-wrapper>.list-group>.list-group-item").eq(2).addClass("on");
	})
	
	/* 사진 이미지 */
	function checkfile() {
		var fname = document.getElementById("fac_file").value; //파일의 풀 경로
		var fext = fname.substr(fname.length - 3).toLowerCase(); //확장자
		if (fext != 'jpg' && fext != 'png' && fext != 'jpeg') {
			alert("이미지는 jpg, png, jpeg만 업로드 가능합니다.");
			return false;
		}
		return true;
	}
</script>
<!-- 이미지 표시 -->
<script>
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
				} //end if
			} //end for
		} //end if
		
	} //end previewImage(targetObj, View_area)
</script>
<!-- // 이미지 표시 -->

<div class="container text-left row" style='position:relative; width: 900px;'>
<form action="<c:url value="/login/admin_factoryUpdate" />" onsubmit="return checkIt()" class="form-horizontal" enctype="multipart/form-data" method="post">
	<div class="col-sm-6" id='View_area' class="form-group">
	  <label for="fac_file">사진이미지 업로드</label>
	  <c:if test="${ command.fac_image eq null }">
	  	<img id="UploadedImg" src="<c:url value="/images/no-img.png" />" border="0" width="300" height="250" onclick="fncProductFile()">
	  </c:if>
	  <c:if test="${ command.fac_image ne null }">
	  	<img id="UploadedImg" src="<c:url value="/saveFile/${command.fac_image}" />" border="0" width="300" height="250" onclick="fncProductFile()">
	  </c:if>
		<input type="file" id="fac_file" name="fac_file" onchange="previewImage(this,'View_area'),checkfile()" class="form-control">
	</div>
	<div class="col-sm-6">
		<ul class="list-group row">
			<li class="form-group"><label for="fac_name" class="control-label col-sm-3">공장명</label><div class="col-sm-9"><input id="fac_name" name="fac_name" value="${command.fac_name}" class="form-control" /></div></li>
			<li class="form-group"><label for="fac_location" class="control-label col-sm-3">주  소</label><div class="col-sm-9"><input id="fac_location" name="fac_location" value="${command.fac_location}" class="form-control" /></div></li>
			<li class="form-group"><label for="fac_tel" class="control-label col-sm-3">연락처</label><div class="col-sm-9"><input id="fac_tel" name="fac_tel" value="${command.fac_tel}" class="form-control" /></div></li>
			<li class="form-group"><label for="fac_product" class="control-label col-sm-3">생산제품</label><div class="col-sm-9"><input id="fac_product" name="fac_product" value="${command.fac_product}" class="form-control" /><span class="text-danger guide">(※ 제품명은 '콤마(,)'로 구분해서 입력 해 주세요.)</span></div></li>
		</ul>
		<div class="row text-center btns">
			<input type="submit" value="수정하기" class="btn btn-warning">
			<input type="button" value="취소" class="btn btn-default" onclick="javascript:history.back()">
		</div>
	</div>
	<input type="hidden" id="fac_id" name="fac_id" value="${ command.fac_id }" />
</form>
</div>
