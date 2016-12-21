function check_form(){
	var st_id = $("#st_id");
	var passwd = $("#passwd");
	var check = true;
	
	if(!st_id){
		alert("id를 입력 해 주세요.");
		return false;
	}
	if(!passwd){
		alert("password를 입력 해 주세요.");
		return false;
	}
	return check;
}