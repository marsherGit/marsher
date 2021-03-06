<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<style>
	#delivery_file {width:300px; margin-top:0.5em;}
	#View_area {padding-left:5em; padding-top:1em;}
	#UploadedImg {margin-left:2em;}
	.list-group {list-style:none; padding-top:50px;}
	.list-group>li {margin:1em 0;}
	.btns {padding:10%;}
	.btns>input {width:6em;}
	.guide {font-size:0.8em;}
</style>

<!-- validator -->
<script>
	function checkIt(){
		if (!$("#delivery_name").val()) {
			alert("이름을 입력해 주세요");
			$("#delivery_name").focus();
			return false;
		}
		
		if (!$("#delivery_tel").val()) {
			alert("연락처를 입력해 주세요");
			$("#delivery_tel").focus();
			return false;
		}
		
		if (!$("#delivery_day").val()) {
			alert("배송요일을 입력해 주세요");
			$("#delivery_day").focus();
			return false;
		}
		
		if (!$("#fac_id").val()) {
			alert("담당공장을 입력해 주세요");
			$("#fac_id").focus();
			return false;
		}
		
		else if (!confirm("새로운 기사님을 등록하시겠습니까?")) {
			return false;
		} else
			return true;
	}
</script>

<script>
	/* 서브메뉴 활성화 */
	$(document).ready(function(){
		$(".user_nav>li:eq(0)>a").addClass("active");
		$(".aside-wrapper>.list-group>.list-group-item").eq(3).addClass("on");
	})
	
	/* 이미지 확장자 체크 */
	function checkfile() {
		var fname = document.getElementById("delivery_file").value; //파일의 풀 경로
		var fext = fname.substr(fname.length - 3).toLowerCase(); //확장자
		if (fext != 'jpg' && fext != 'png' && fext != 'jpeg') {
			alert("이미지는 jpg, png, jpeg만 업로드 가능합니다.");
			return false;
		}
		return true;
	}
</script>
<script>
	$(document).ready(function() {
		/* file name */
		var fileTarget = $('.filebox .upload-hidden');

		fileTarget.on('change', function() {
			if (window.FileReader) {
				// 파일명 추출
				var filename = $(this)[0].files[0].name;
			} else {
				// Old IE 파일명 추출
				var filename = $(this).val().split('/').pop().split('\\').pop();
			}

			$(this).siblings('.upload-name').val(filename);
		});

		/* preview image */
		var imgTarget = $('.preview-image .upload-hidden');

		imgTarget.on('change',function() {
			var parent = $(this).parent();
			parent.children('.upload-display').remove();

			if (window.FileReader) {
				//image 파일만
				if (!$(this)[0].files[0].type.match(/image\//))
					return;

				var reader = new FileReader();
				reader.onload = function(e) {
					var src = e.target.result;
					parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img src="'+src+'" class="upload-thumb"></div></div>');
				}
				reader .readAsDataURL($(this)[0].files[0]);
			} else {
				$(this)[0].select();
				$(this)[0].blur();
				var imgSrc = document.selection.createRange().text;
				parent.prepend('<div class="upload-display"><div class="upload-thumb-wrap"><img class="upload-thumb"></div></div>');

				var img = $(this).siblings('.upload-display').find('img');
				img[0].style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enable='true',sizingMethod='scale',src=\"" + imgSrc + "\")";
			}
		});
	});
</script>

<!-- 미리보기 이미지 표시 -->
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
<form action="<c:url value="/login/admin_deliveryInput" />" onsubmit="return checkIt()" class="form-horizontal" enctype="multipart/form-data" method="post">
	<div class="col-sm-6" id='View_area' class="form-group">
	  <div><label for="delivery_file">사진이미지 업로드</label></div>
	  <img id="UploadedImg" src="<c:url value="/images/no-img.png" />" class="img-circle" border="0" width="250" height="250" onclick="fncProductFile()">
	  <input type="file" id="delivery_file" name="delivery_file" onchange="previewImage(this,'View_area'),checkfile()" class="form-control">
	</div>
	<div class="col-sm-6">
		<ul class="list-group row">
			<li class="form-group"><label for="delivery_name" class="control-label col-sm-3">이  름</label><div class="col-sm-9"><input id="delivery_name" name="delivery_name" class="form-control" /></div></li>
			<li class="form-group"><label for="delivery_tel" class="control-label col-sm-3">연락처</label><div class="col-sm-9"><input id="delivery_tel" name="delivery_tel" class="form-control" /></div></li>
			<li class="form-group"><label for="delivery_day" class="control-label col-sm-3">배송요일</label><div class="col-sm-9"><input id="delivery_day" name="delivery_day" class="form-control" /></div></li>
			<li class="form-group">
				<label for="fac_id" class="control-label col-sm-3">담당공장</label>
				<div class="col-sm-9">
					<select id="fac_id" name="fac_id" class="form-control">
						<c:forEach var="factory" items="${factorys}">
							<option value="${ factory }">제 ${ factory } 공장</option>
						</c:forEach>
					</select>
				</div>
			</li>
		</ul>
		<div class="row text-center btns">
			<input type="submit" value="등록하기" class="btn btn-warning">
			<input type="button" value="취소" class="btn btn-default" onclick="javascript:history.back()">
		</div>
	</div>
</form >
</div>

</body>

</html>