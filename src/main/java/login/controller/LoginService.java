package login.controller;

import java.util.List;

import mj.Store.service.memberDataBean;

public interface LoginService {
	
	public memberDataBean getMember2(String st_id);				    // ���� �Ŵ��� ������������ Form  //������ �������� ���� Form
	public int updateMember(memberDataBean member, String st_id);   // ���� �Ŵ��� ������������ pro   //������ �������� ���� Pro
	
	public List<memberDataBean> showList();							//������ ���� List


}
