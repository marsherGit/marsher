<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
	#st_image {width:300px; margin-top:0.5em;}
	#view_area {position:relative; width: 350px; height: 300px; color: black; border: 0px solid black;}
	#updateForm .list-group {list-style:none;}
	#updateForm .list-group>li {margin:1em 0;}
	.btns {padding:10%;}
	.btns>input {width:6em;}
	.guide {font-size:0.8em;}
</style>

<script>

function checkIt(){
	
	if(!confirm("관리자 정보를 수정하시겠습니까?")) {
	return false;
	}
	else
		return true;
}
$(document).ready(function(){
	/* 서브메뉴 활성화 */
	$(".user_nav>li:eq(0)>a").addClass("active");
	$(".aside-wrapper>.list-group>.list-group-item").eq(0).addClass("on");
})

</script>
<script>
  function checkfile(){
		    	 var fname = document.getElementById("st_image").value;
		    	 // 파일의 풀 경로를 fname에 변수에 저장 
		    	 var fext = fname.substr(fname.length-3).toLowerCase();
		    	 // 파일의 풀 경로에서 끝에서 3번째까지의 글자를 잘라 소문자로 변경 후 변수에 저장
		    	 if(fext != 'jpg' && fext !='png' && fext !='jpeg'){
		    	 	 alert("이미지는 jpg, png, jpeg만 업로드 가능합니다.");
		    	 	return false;
		    	 }
		    	 return true;
		    	}
		    
		    
		    
		    function checkfile2(){
		    	 var fname2 = document.getElementById("sign_img").value;
		    	 // 파일의 풀 경로를 fname2에 변수에 저장 
		    	 var fext2 = fname2.substr(fname2.length-3).toLowerCase();
		    	 // 파일의 풀 경로에서 끝에서 3번째까지의 글자를 잘라 소문자로 변경 후 변수에 저장
		    	 if(fext2 != 'jpg' && fext2 !='png' && fext2 !='jpeg'){
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
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
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
		for ( var i = 0; i < files.length; i++) {
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
				reader.onload = function (e) {	        	
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
<form method="post" id="updateForm" name="updateForm" action="AdminpagePro.do?st_id=${st_id}" onsubmit="return checkIt()">

<div class="col-sm-6" id='View_area' class="form-group">
			<label for="st_image">사진이미지 업로드</label> <img id="UploadedImg"
				src="<c:url value="/images/${member.st_image}" />" border="0"
				width="300" height="250" onclick="fncProductFile()"> <input
				type="file" id="st_image" name="st_image" value="${member.st_image}"
				onchange="previewImage(this,'View_area'),checkfile()"
				class="form-control">
		</div>
		<div class="col-sm-6">
			<ul class="list-group row">
				<li class="form-group row"><label for="st_name"
					class="control-label col-sm-3">관리자명</label>
				<div class="col-sm-9">
						<input id="st_name" name="st_name" value="${member.st_name}"
							class="form-control" />
					</div></li>
				<li class="form-group row"><label for="st_tel"
					class="control-label col-sm-3">연락처</label>
				<div class="col-sm-9">
						<input id="st_tel" name="st_tel" value="${member.st_tel}"
							class="form-control" />
					</div></li>
				<li class="form-group row"><label for="st_location"
					class="control-label col-sm-3">주소</label>
				<div class="col-sm-9">
						<input id="st_location" name="st_location"
							value="${member.st_location}" class="form-control" />
					</div></li>
				<li class="form-group row"><label for="sign_img"
					class="control-label col-sm-3">사인 등록</label>
				<div class="col-sm-9">
						<input type="file" id="sign_img" name="sign_img"
							value="${member.sign_img}" onchange="checkfile2()"
							class="form-control" />기존 파일 : <a
							href="<c:url value="/images/${member.st_image}" />">${member.sign_img}</a>
					</div></li>
			</ul>
			<div class="row text-center btns">
				<input type="submit" value="수정하기" class="btn btn-warning"> <input
					type="reset" value="취소" class="btn btn-default"> 
			</div>
		</div>
  </form>
</div>