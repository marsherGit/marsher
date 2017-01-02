<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<title>Insert title here</title>
<script>

function checkIt(){
	
	if(!confirm("매장 정보를 수정하시겠습니까?")) {
	return false;
	}
	else
		return true;
}

</script>
<script>
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

</head>

<body>

 
<form method="post" name="updateForm" action="AdminUpdatePro.do?st_id=${st_id}" onsubmit="return checkIt()">
<div> 
 <div class="container text-left" style='position:relative; width: 900px; ' >    
  <div class="row">
    <div class="col-sm-4" id='View_area' style='position:relative; width: 350px; height: 300px; color: black; border: 0px solid black; dispaly: inline; '>
      <label for="st_image">이미지 업로드</label> 
      <img style='cursor:hand' src="/Marsher/images/${member.st_image}" align="absMiddle" border="0" width="300" height="250" onclick="fncProductFile()" id="UploadedImg">
					<input type="file" id="st_image" name="st_image" value="${member.st_image}" onchange="previewImage(this,'View_area'),checkfile()">
						
    </div>
    <div style='width: 500px;' class="col-sm-4"> 
      <table class="table table-bordered">
        <tr>
        <td>매장명</td>
        <td><input type="text" id="st_name" name="st_name" colsapn="3" style = "width:150px; height:18px" value="${member.st_name}"></td>
        </tr>
        <tr>
        <td>연락처</td>
        <td><input type = "text" style = "width:100px; height:18px" name="st_tel" value="${member.st_tel}"></td>
      </tr>
      <tr>
      	<td>주소</td>
        <td colspan = "5"><input type = "text" style = "width:300px; height:18px; align:left;" name="st_location" value="${member.st_location}"></td>
      </tr>    
      
      <tr>
      <td>사인 등록</td>
	  <td><input type="file" id="sign_img" name="sign_img" class="upload-hidden" onchange="checkfile2()" value="${member.sign_img}">기존 파일 : <a href="http://localhost:8088/Marsher/images/${member.sign_img}">${member.sign_img}</a></td>   
      </tr>
      </table> 
     
                                     <input type = "submit" value = "수정하기">
                                     <input type = "button" value = "취소" onclick="javascript:history.back()">
    </div>
   
    </div>
  
</div><br>
 </div>
 


  </form>

</body>

</html>