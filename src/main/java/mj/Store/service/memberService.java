package mj.Store.service;

import java.util.List;



public interface memberService {
	
	public int insert(memberDataBean member);
	public memberDataBean getMember(String st_id);
	public List<memberDataBean> showList();							// ���� ã�� ������ form / ������ ���� List   *
   


}
