function checkIt() {
	var userinput = eval("document.loginForm");
	
	if (!userinput.st_id.value) {
		alert("아이디를 입력하세요.");
		return false;
	}
	if (!userinput.passwd.value) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
} // end checkIt()
