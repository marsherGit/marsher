package mj.Store.service;

import java.util.List;



public interface memberService {
	
	public int insert(memberDataBean member);
	public memberDataBean getMember(String st_id);
	public memberDataBean getMember2(String st_id);
	public List<memberDataBean> showList();							// ���� ã�� ������ form / ������ ���� List
	
	public List<memberDataBean> showList(String st_id);			//������ ������������ form
	
	public int updateMember(memberDataBean member, String st_id); // ���� �Ŵ��� ������������ pro
	public int updateMember2(memberDataBean member);               // ������ ������������ pro


}
