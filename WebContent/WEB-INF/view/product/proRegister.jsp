<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<style>
	#pro_image  {width:300px; margin-top:0.5em;}
	#view_area {position:relative; width: 350px; height: 300px; color: black; border: 0px solid black;}
	.list-group {list-style:none;}
	.list-group>li {margin:1em 0;}
	.btns {padding:10%;}
	.btns>input {width:6em;}
</style>

<script>
	$(document).ready(function() {

		var main_nav = $(".main_nav>li").eq(3);
		main_nav.addClass("on");
		main_nav.find(".sub_nav>li").eq(4).addClass("on");
		$(".aside-wrapper>.list-group>.list-group-item").eq(4).addClass("on");
	})
</script>

<script>
	function checkIt() {

		var fname = document.getElementById("pro_image").value;
		var fext = fname.substr(fname.length - 3).toLowerCase();
		

		if (document.getElementById('pro_bcategory').value == '') {
			alert("품목명을 선택해 주세요");
			return false;
		}
		if (document.getElementById('pro_name').value == '') {
			alert("제품명을 입력해 주세요");
			return false;
		}
		if (document.getElementById('pro_calorie').value == '') {
			alert("칼로리를 입력해 주세요");
			return false;
		}
		if (document.getElementById('pro_volume').value == '') {
			alert("용량을 입력해 주세요");
			return false;
		}
		if (document.getElementById('pro_container').value == '') {
			alert("패키지 타입을 선택해 주세요");
			return false;
		}
		if (document.getElementById('pro_cPrice').value == '') {
			alert("제품원가를 입력해 주세요");
			return false;
		}
		if (document.getElementById('pro_uPrice').value == '') {
			alert("판매단가를 입력해 주세요");
			return false;
		}
		if (document.getElementById('pro_properStock').value == '') {
			alert("적정재고를 입력해 주세요");
			return false;
		}
		if (document.getElementById('pro_image').value == '') {
			alert("제품 이미지를 선택해 주세요");
			return false;
		}
		if (fext != 'jpg' && fext != 'png' && fext != 'jpeg') {
			alert("제품 이미지의 확장자를 확인해 주세요.");
			return false;
		}
		else if (!confirm("제품을 등록하시겠습니까?")) {
			return false;
		} else
			return true;
	}

	function checkfile() {
		var fname = document.getElementById("pro_image").value;
		// 파일의 풀 경로를 fname에 변수에 저장 
		var fext = fname.substr(fname.length - 3).toLowerCase();
		// 파일의 풀 경로에서 끝에서 3번째까지의 글자를 잘라 소문자로 변경 후 변수에 저장
		if (fext != 'jpg' && fext != 'png' && fext != 'jpeg') {
			alert("이미지는 jpg, png, jpeg만 업로드 가능합니다.");
			return false;
		}
		return true;
	}
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
	<form method="post" name="productForm" action="proRegisterPro.do"
		onsubmit="return checkIt()" class="form-horizontal">
		<input type="hidden" id="pro_num" name="pro_num"/>
		
		<div class="col-sm-6" id='View_area' class="form-group">
	  <label for="pro_image">사진이미지 업로드</label>
	  <img id="UploadedImg" src="<c:url value="/images/no-img.png" />" border="0" width="300" height="250" onclick="fncProductFile()">
	  <input type="file" id="pro_image" name="pro_image" onchange="previewImage(this,'View_area'),checkfile()" class="form-control">
	</div>
	<div class="col-sm-6">
		<ul class="list-group row">
			<li class="form-group"><label for="pro_bcategory" class="control-label col-sm-3">품목명</label>
				<div class="col-sm-9">
						<select id="pro_bcategory" name="pro_bcategory"
							class="form-control" />
						<option selected="" hidden="" value="">::: 품목명 :::</option>
						<option value="A">탄산</option>
						<option value="B">주류</option>
						<option value="C">쥬스</option>
						<option value="D">우유</option>
						</select>
				</div>
			</li>
			
			<li class="form-group"><label for="pro_name" class="control-label col-sm-3">제품명</label><div class="col-sm-9"><input id="pro_name" name="pro_name" class="form-control" /></div></li>
			<li class="form-group"><label for="pro_calorie" class="control-label col-sm-3">칼로리</label><div class="col-sm-9"><input id="pro_calorie" name="pro_calorie" class="form-control" /></div></li>
			<li class="form-group"><label for="pro_volume" class="control-label col-sm-3">용량</label><div class="col-sm-9"><input id="pro_volume" name="pro_volume" class="form-control" /></div></li>
			
			<li class="form-group">
				<label for="pro_container" class="control-label col-sm-3">패키지타입</label>
				<div class="col-sm-9">
					<select id="pro_container" name="pro_container" class="form-control">
					<option selected="" hidden="" value="">::: 패키지타입 :::</option>
									<option value="알류미늄캔">알류미늄캔</option>
									<option value="페트병">페트병</option>
									<option value="유리병">유리병</option>
									<option value="종이팩">종이팩</option>		
					</select>
				</div>
			</li>
			
			<li class="form-group"><label for="pro_cPrice" class="control-label col-sm-3">제품원가</label><div class="col-sm-9"><input id="pro_cPrice" name="pro_cPrice" class="form-control" /></div></li>
			<li class="form-group"><label for="pro_uPrice" class="control-label col-sm-3">판매단가</label><div class="col-sm-9"><input id="pro_uPrice" name="pro_uPrice" class="form-control" /></div></li>
			<li class="form-group"><label for="pro_properStock" class="control-label col-sm-3">적정재고</label><div class="col-sm-9"><input id="pro_properStock" name="pro_properStock" class="form-control" /></div></li>
			
			
		</ul>
		<div class="row text-center btns">
			<input type="submit" value="등록하기" class="btn btn-info">
			<input type="button" value="취소" class="btn btn-default" onclick="javascript:history.back()">
		</div>
	</div>

	</form>
	</div>
	