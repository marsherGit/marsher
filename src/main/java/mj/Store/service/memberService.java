package mj.Store.service;

import java.util.List;



public interface memberService {
	
	public int insert(memberDataBean member);
	public memberDataBean getMember(String st_id);
	public List<memberDataBean> showList();							// 매장 찾기 페이지 form / 관리자 매장 List   *
   


}
