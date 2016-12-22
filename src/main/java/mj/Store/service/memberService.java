package mj.Store.service;

import java.util.List;



public interface memberService {
	
	public int insert(memberDataBean member);
	public memberDataBean getMember(String st_id);
	public memberDataBean getMember2(String st_id);
	public List<memberDataBean> showList();							// 매장 찾기 페이지 form / 관리자 매장 List
	
	public List<memberDataBean> showList(String st_id);			//관리자 매장정보수정 form
	
	public int updateMember(memberDataBean member, String st_id); // 매장 매니저 매장정보수정 pro
	public int updateMember2(memberDataBean member);               // 관리자 매장정보수정 pro


}
