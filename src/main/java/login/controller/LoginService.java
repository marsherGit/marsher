package login.controller;

import java.util.List;

import mj.Store.service.memberDataBean;

public interface LoginService {
	
	public memberDataBean getMember2(String st_id);				    // 매장 매니저 매장정보수정 Form  //관리자 매장정보 수정 Form
	public int updateMember(memberDataBean member, String st_id);   // 매장 매니저 매장정보수정 pro   //관리자 매정정보 수정 Pro
	
	public List<memberDataBean> showList();							//관리자 매장 List


}
